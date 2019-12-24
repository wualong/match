package org.spring.match.vo;

import lombok.Data;

@Data
public class HistoryDataAmountVO {
    /**
     * 今日订单总量
     */
    private Integer historyOrderAmount = 0;

    /**
     * 今日订单总额
     */
    private Integer historyOrderMoney = 0;

    /**
     * 今日货物数量
     */
    private Integer historyGoodsAmount = 0;
}
