package org.spring.match.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class SecondGoodsVO implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 以及物品父类id
     */
    private Long parentId;

    /**
     * 商品名
     */
    private String goodsName;

    /**
     * 货物价格
     */
    private BigDecimal goodsPrice;


}
