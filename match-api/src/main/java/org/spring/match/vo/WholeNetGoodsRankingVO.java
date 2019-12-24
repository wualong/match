package org.spring.match.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class WholeNetGoodsRankingVO implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 一级物品名称
     */
    private String oneGoodsName;

    /**
     * 总量
     */
    private Integer amount;

    /**
     * 比率
     */
    private Double ratio;

}
