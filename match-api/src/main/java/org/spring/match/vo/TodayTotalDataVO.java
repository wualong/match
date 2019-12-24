package org.spring.match.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 今日总量数据VO对象
 * @author A_Dragon
 * @since 2019-12-09
 */
@Data
public class TodayTotalDataVO implements Serializable {

    /**
     * 今日订单总量
     */
    private Integer todayOrderAmount = 0;

    /**
     * 今日订单总额
     */
    private Integer todayOrderMoney = 0;

    /**
     * 今日货物数量
     */
    private Integer todayGoodsAmount = 0;



}
