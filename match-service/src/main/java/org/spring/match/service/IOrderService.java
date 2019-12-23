package org.spring.match.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.spring.match.entity.OrderMain;
import org.spring.match.vo.*;

import java.util.List;

/**
 *  订单业务接口
 *
 * @author A_Dragon
 * @since 2019-04-26
 */
public interface IOrderService extends IService<OrderMain> {


    /**
     * 获取当前实时热门商品
     * @return CurrentHotGoodsVO 热门商品VO对象
     */
    List<CurrentHotGoodsVO> selectCurrentHotGoods();

    /**
     * 获取全网获取品类的排行
     */
    List<WholeNetGoodsRankingVO> selectWholeNetGoodsRanking();

    /**
     * 获取今日总量数据
     */
    TodayTotalDataVO selectTodayTotalData();

    /**
     * 城市货运金额统计
     */
    List<CityFreightMoneyVO> selectCityFreightMoney();

    /**
     * 城市货运数量统计
     */
    List<CityFreightAmountVO> selectCityFreightAmount();

    /**
     * 城市货运车辆统计
     */
    List<CityFreightCarVO> selectCityFreightCar();

    /**
     * 历史数据统计
     */
    HistoryDataAmountVO selectHistoryAmount();

    /**
     * 近期金额统计
     */
    LatelyMoneyVO selectLatelyMoney();

    /**
     * 创建订单
     */
    void createOrder();

    /**
     * 停止创建订单
     */
    boolean stopCreateOrder();



}
