package org.spring.match.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class CityParameterVO implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 城市名
     */
    private String cityName;

    /**
     * 最小系数设置
     */
    private BigDecimal minParameter;

    /**
     * 最大系数设置
     */
    private BigDecimal maxParameter;

}
