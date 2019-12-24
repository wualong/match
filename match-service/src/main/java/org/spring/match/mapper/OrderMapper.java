package org.spring.match.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.spring.match.entity.OrderMain;
import org.spring.match.vo.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *  订单Mapper 接口
 *
 * @author hydosky
 * @since 2019-04-24
 */
@Repository
public interface OrderMapper extends BaseMapper<OrderMain> {

    /**
     * 查询当前热门物品
     * @return List<CurrentHotGoodsVO>
     */
    List<CurrentHotGoodsVO> selectCurrentHotGoods();

    /**
     * 查询全网物品排行
     * @return List<CurrentHotGoodsVO>
     */
    List<WholeNetGoodsRankingVO> selectWholeNetGoodsRanking();

    /**
     * 获取今日订单数量
     * @return Integer
     */
    Integer getTodayOrderTotal(@Param("dateTime") String dateTime);

    /**
     * 城市货运金额统计 CityFreightMoneyVO
     * @return
     */
    List<CityFreightMoneyVO> selectCityFreightMoney();

    /**
     * 城市货运数量统计
     */
//    List<CityFreightAmountVO> selectCityFreightAmount();

    /**
     * 城市货运车辆统计
     */
    List<CityFreightCarVO> selectCityFreightCar();

    /**
     * 历史数据统计
     */
    Integer selectHistoryAmount(@Param("dateTime") String dateTime);

    /**
     * 获取所有表数据的行数
     * @return
     */
    List<TableRowsMessage> getAllTableRowCount();
}
