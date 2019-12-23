package org.spring.match.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class CurrentHotGoodsVO implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 二级物品名称
     */
    private String secondGoodsName;

    /**
     * 总量
     */
    private Integer amount;

    /**
     * 比率
     */
    private Double ratio;

}
