package org.spring.match.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class CityFreightMoneyVO implements Serializable {

    /**
     * 城市名
     */
    private String cityName;

    /**
     * 金额总额
     */
    private BigDecimal moneyAmount;

}
