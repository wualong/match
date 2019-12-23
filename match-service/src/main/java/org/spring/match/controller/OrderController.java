package org.spring.match.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring.match.dto.RData;
import org.spring.match.service.IOrderService;
import org.spring.match.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 订单控制层
 * @author A_Dragon
 * @since 2019-12-12
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService iOrderService;

    /**
     * 搜索当时热门货物品类
     * @return RData
     * @since 2019-12-16
     */
    @GetMapping("/selectCurrentHotGoods")
    public RData<List<CurrentHotGoodsVO>> selectCurrentHotGoods() {
        try {
            List<CurrentHotGoodsVO> currentHotGoodsVOList = iOrderService.selectCurrentHotGoods();
            return RData.okData(currentHotGoodsVOList);
        } catch (Exception e) {
            log.info(e.getMessage());
            return RData.fail(null);
        }
    }

    /**
     * 全网货运品类排行
     * @return RData
     * @since 2019-12-16
     */
    @GetMapping("/selectWholeNetGoodsRanking")
    public RData<List<WholeNetGoodsRankingVO>> selectWholeNetGoodsRanking() {
        try {
            List<WholeNetGoodsRankingVO> WholeNetGoodsRankingVOList = iOrderService.selectWholeNetGoodsRanking();
            return RData.okData(WholeNetGoodsRankingVOList);
        } catch (Exception e) {
            log.info(e.getMessage());
            return RData.fail(null);
        }
    }

    /**
     * 搜索今日订单总量数据
     * @return RData
     * @since 2019-12-16
     */
    @GetMapping("/selectTodayTotalData")
    public RData<TodayTotalDataVO> selectTodayTotalData() {
        try {
            TodayTotalDataVO todayTotalDataVO = iOrderService.selectTodayTotalData();
            return RData.okData(todayTotalDataVO);
        } catch (Exception e) {
            log.info(e.getMessage());
            return RData.fail(null);
        }
    }

    /**
     * 城市货运金额统计
     * @return RData
     * @since 2019-12-16
     */
    @GetMapping("/selectCityFreightMoney")
    public RData<List<CityFreightMoneyVO>> selectCityFreightMoney() {
        try {
            List<CityFreightMoneyVO> cityFreightMoneyVOS = iOrderService.selectCityFreightMoney();
            return RData.okData(cityFreightMoneyVOS);
        } catch (Exception e) {
            log.info(e.getMessage());
            return RData.fail(null);
        }
    }

    /**
     * 城市货物数量统计
     * @return RData
     * @since 2019-12-16
     */
    @GetMapping("/selectCityFreightAmount")
    public RData<List<CityFreightAmountVO>> selectCityFreightAmount() {
        try {
            List<CityFreightAmountVO> cityFreightAmountVOS = iOrderService.selectCityFreightAmount();
            return RData.okData(cityFreightAmountVOS);
        } catch (Exception e) {
            log.info(e.getMessage());
            return RData.fail(null);
        }
    }

    /**
     * 全网货运车辆统计
     * @return RData
     * @since 2019-12-16
     */
    @GetMapping("/selectCityFreightCar")
    public RData<List<CityFreightCarVO>> selectCityFreightCar() {
        try {
            List<CityFreightCarVO> cityFreightCarVOS = iOrderService.selectCityFreightCar();
            return RData.okData(cityFreightCarVOS);
        } catch (Exception e) {
            log.info(e.getMessage());
            return RData.fail(null);
        }
    }

    /**
     * 历史数据总量
     * @return RData
     * @since 2019-12-16
     */
    @GetMapping("/selectHistoryAmount")
    public RData<HistoryDataAmountVO> selectHistoryAmount() {
        try {
            HistoryDataAmountVO historyDataAmountVO = iOrderService.selectHistoryAmount();
            return RData.okData(historyDataAmountVO);
        } catch (Exception e) {
            log.info(e.getMessage());
            return RData.fail(null);
        }
    }

    /**
     * 近期订单金额统计
     * @return RData
     * @since 2019-12-16
     */
    @GetMapping("/selectLatelyMoney")
    public RData<LatelyMoneyVO> selectLatelyMoney() {
        try {
            LatelyMoneyVO latelyMoneyVO = iOrderService.selectLatelyMoney();
            return RData.okData(latelyMoneyVO);
        } catch (Exception e) {
            log.info(e.getMessage());
            return RData.fail(null);
        }
    }


}
