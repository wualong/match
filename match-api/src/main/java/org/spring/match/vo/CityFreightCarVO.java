package org.spring.match.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * c城市货运车型VO对象
 */
@Data
public class CityFreightCarVO implements Serializable {

    /**
     * 车名
     */
    private String carName;

    /**
     * 订单数量
     */
    private Integer orderAmount;

    /**
     * 比率
     */
    private Double radio;



}
