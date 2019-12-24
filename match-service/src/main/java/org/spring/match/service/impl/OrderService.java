package org.spring.match.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.spring.match.entity.CarModel;
import org.spring.match.entity.CityParameter;
import org.spring.match.entity.OrderMain;
import org.spring.match.entity.SecondGoods;
import org.spring.match.mapper.CarModelMapper;
import org.spring.match.mapper.CityParameterMapper;
import org.spring.match.mapper.OrderMapper;
import org.spring.match.mapper.SecondGoodsMapper;
import org.spring.match.service.IOrderService;
import org.spring.match.util.CommonUtil;
import org.spring.match.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  订单服务实现类
 *
 * @author A_Dragon
 * @since 2019-04-26
 */
@Service
public class OrderService extends ServiceImpl<OrderMapper, OrderMain> implements IOrderService {


    /**
     *  注入redisTemplate
     */
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /**
     *  注入城市mapper层
     */
    @Autowired
    private CityParameterMapper cityParameterMapper;

    /**
     *  注入城市二级货物mapper层
     */
    @Autowired
    private SecondGoodsMapper secondGoodsMapper;

    /**
     *  注入城市二级货物mapper层
     */
    @Autowired
    private CarModelMapper carModelMapper;



    /**
     * 查询当前热门商品业务实现
     * @return List<CurrentHotGoodsVO>
     * @since 2019-12-13
     */
    @Override
    public List<CurrentHotGoodsVO> selectCurrentHotGoods() {
        OrderMain orderMain = new OrderMain();
        orderMain.setIsDeleted(0);
        Double allAmount = Double.valueOf(baseMapper.selectCount(new QueryWrapper<>(orderMain)));
        List<CurrentHotGoodsVO> currentHotGoodsVOList = baseMapper.selectCurrentHotGoods();
        for (int i = 0; i < currentHotGoodsVOList.size() ; i++) {
            CurrentHotGoodsVO currentHotGoodsVO = currentHotGoodsVOList.get(i);
            Double radio = Double.valueOf(currentHotGoodsVO.getAmount()*1.00 / allAmount);
            currentHotGoodsVO.setRatio(radio);
        }
        return currentHotGoodsVOList;
    }


    /**
     * 获取全网获取品类的排行
     * @return List<WholeNetGoodsRankingVO>
     * @since 2019-12-13
     */
    @Override
    public List<WholeNetGoodsRankingVO> selectWholeNetGoodsRanking() {
        OrderMain orderMain = new OrderMain();
        orderMain.setIsDeleted(0);
        Double allAmount = Double.valueOf(baseMapper.selectCount(new QueryWrapper<>(orderMain)));
        List<WholeNetGoodsRankingVO> wholeNetGoodsRankingVOList = baseMapper.selectWholeNetGoodsRanking();
        for (int i = 0; i < wholeNetGoodsRankingVOList.size() ; i++) {
            WholeNetGoodsRankingVO woleNetGoodsRankingVO = wholeNetGoodsRankingVOList.get(i);
            Double radio = Double.valueOf(woleNetGoodsRankingVO.getAmount()*1.00 / allAmount);
            woleNetGoodsRankingVO.setRatio(radio);
        }
        return wholeNetGoodsRankingVOList;
    }


    /**
     * 获取今日总量数据
     * @return TodayTotalDataVO
     * @since 2019-12-13
     */
    @Override
    public TodayTotalDataVO selectTodayTotalData() {
        TodayTotalDataVO todayTotalDataVO = new TodayTotalDataVO();
        OrderMain orderMain = new OrderMain();
        orderMain.setIsDeleted(0);
        String dateTime = CommonUtil.date2Str(CommonUtil.DATE_SDF);
        Integer allAmount = baseMapper.getTodayOrderTotal(dateTime);
        if(allAmount==0){
            return todayTotalDataVO;
        }
        todayTotalDataVO.setTodayOrderAmount(allAmount);
        todayTotalDataVO.setTodayOrderMoney(allAmount*CommonUtil.randomGetOrderMoney(18,22));
        todayTotalDataVO.setTodayGoodsAmount(allAmount*3);
        return todayTotalDataVO;
    }

    /**
     * 城市货运金额统计
     * @return List<CityFreightMoneyVO>
     * @since 2019-12-13
     */
    @Override
    public List<CityFreightMoneyVO> selectCityFreightMoney() {
        List<CityFreightMoneyVO> cityFreightMoneyVOS = baseMapper.selectCityFreightMoney();
        return cityFreightMoneyVOS;
    }

    /**
     * 城市货运数量统计
     */
    @Override
    public List<CityFreightAmountVO> selectCityFreightAmount() {
        return null;
    }

    /**
     * 城市货运车辆统计
     */
    @Override
    public List<CityFreightCarVO> selectCityFreightCar() {
        OrderMain orderMain = new OrderMain();
        orderMain.setIsDeleted(0);
        Double allAmount = Double.valueOf(baseMapper.selectCount(new QueryWrapper<>(orderMain)));
        List<CityFreightCarVO> cityFreightCarVOList = baseMapper.selectCityFreightCar();
        for (int i = 0; i < cityFreightCarVOList.size() ; i++) {
            CityFreightCarVO cityFreightCarVO = cityFreightCarVOList.get(i);
            Double radio = Double.valueOf(cityFreightCarVO.getOrderAmount()*1.00 / allAmount);
            cityFreightCarVO.setRadio(radio);
        }
        return cityFreightCarVOList;
    }

    /**
     * 历史数据统计
     */
    @Override
    public HistoryDataAmountVO selectHistoryAmount() {
        HistoryDataAmountVO historyDataAmountVO = new HistoryDataAmountVO();
        String dateTime = CommonUtil.date2Str(CommonUtil.DATE_SDF);
        Integer allAmount =  baseMapper.selectHistoryAmount(dateTime);
        if(allAmount==0){
            return historyDataAmountVO;
        }
        historyDataAmountVO.setHistoryOrderAmount(allAmount);
        historyDataAmountVO.setHistoryOrderMoney(allAmount*CommonUtil.randomGetOrderMoney(18,22));
        historyDataAmountVO.setHistoryGoodsAmount(allAmount*3);
        return historyDataAmountVO;
    }

    /**
     * 近期金额统计
     */
    @Override
    public LatelyMoneyVO selectLatelyMoney() {
        return null;
    }

    /**
     * 根据城市系数生成订单
     * @param
     * @return
     * @since 2019-12-13
     */
    @Override
    public synchronized void createOrder() {
        // 查询城市参数list集合
        CityParameter cityParameter = new CityParameter();
        cityParameter.setIsDeleted(0);
        List<CityParameter> cityParameters = cityParameterMapper.selectList(new QueryWrapper<>(cityParameter));
        for (int i = 0; i < cityParameters.size(); i++) {
            // 获取城市最低、最高系数参数
            CityParameter cityParameterSet = cityParameters.get(i);
            Double minParameter = Double.valueOf(String.valueOf(cityParameterSet.getMinParameter()));
            Double maxParameter = Double.valueOf(String.valueOf(cityParameterSet.getMaxParameter()));
            Double randomCoefficient = CommonUtil.getRandomCoefficient(minParameter, maxParameter);
            // 从redis中获取累加结果
            String redisCodeKey = CommonUtil.CITY_KEY + cityParameterSet.getId();
            String cacheCodeValue = redisTemplate.opsForValue().get(redisCodeKey);
            System.out.println("存之前：==="+cityParameterSet.getCityName()+"--"+cacheCodeValue);
            // 如果获取不到值，则存入
            if(cacheCodeValue == null){
                redisTemplate.opsForValue().set(redisCodeKey,String.valueOf(randomCoefficient));
                continue;
            }
            Double result = Double.valueOf(cacheCodeValue) + randomCoefficient;
            // 如果满足大于等于1条件，生成1条订单,并置0
            if (result>=1){
                OrderMain order = getOrderMessage(cityParameterSet);
                System.out.println("订单详情："+cityParameterSet.getCityName()+"::::"+order.toString());
                boolean flag = this.save(order);
                redisTemplate.opsForValue().set(redisCodeKey,"0.00");
                continue;
            }
            redisTemplate.opsForValue().set(redisCodeKey,String.valueOf(result));
        }

    }

    /**
     * 停止创建订单
     */
    @Override
    public boolean stopCreateOrder() {
        List<TableRowsMessage> allTableRowCountList = baseMapper.getAllTableRowCount();
        Integer allCount = 0;
        for (TableRowsMessage tableRowsMessage:allTableRowCountList){
            System.out.println(tableRowsMessage.toString());
            allCount += tableRowsMessage.getTableRows();
        }
        if(allCount>=100000){
            return true;
        }
        return false;
    }

    /**
     * 获取订单数据
     * @param cityParameter
     * @return
     */
    private OrderMain getOrderMessage(CityParameter cityParameter){
        OrderMain orderMain = new OrderMain();
        SecondGoods secondGoods = secondGoodsMapper.randomGetSecondGoods();
        CarModel carModel = carModelMapper.randomCarModel();
        orderMain.setCityId(cityParameter.getId());
        orderMain.setOneGoodsId(secondGoods.getParentId());
        orderMain.setTwoGoodsId(secondGoods.getId());
        orderMain.setOrderMoney(secondGoods.getGoodsPrice());
        orderMain.setMotorcycleTypeId(carModel.getId());
        return orderMain;
    }


}
