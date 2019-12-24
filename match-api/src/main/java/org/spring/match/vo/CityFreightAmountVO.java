package org.spring.match.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 城市货物数量统计
 */
@Data
public class CityFreightAmountVO implements Serializable {

    /**
     * 城市名
     */
    private String cityName;

    /**
     * 货物数量统计
     */
    private Integer goodsAmount;


}
