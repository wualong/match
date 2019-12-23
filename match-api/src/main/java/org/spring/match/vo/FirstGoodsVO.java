package org.spring.match.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class FirstGoodsVO implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 商品名
     */
    private String goodsName;


}
