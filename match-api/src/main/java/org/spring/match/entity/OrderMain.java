package org.spring.match.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 订单实体类
 * @author A_Dragon
 * @since 2019-12-09
 */
@Data
public class OrderMain implements Serializable {

    /**
     * id
     */
    @TableId(value = "id",type = IdType.ID_WORKER)
    private Long id;

    /**
     * 城市名
     */
    private Long cityId;

    /**
     * 一类物品类型
     */
    private Long oneGoodsId;

    /**
     * 二类物品类型
     */
    private Long twoGoodsId;

    /**
     * 总量
     */
    private Integer orderAmount;

    /**
     * 订单数量
     */
    private BigDecimal orderMoney;

    /**
     * 车型
     */
    private Long motorcycleTypeId;

    /**
     * 订单日期
     */
    private LocalDateTime orderDatetime;
    /**
     * 是否删除
     */
    private Integer isDeleted;

    /**
     * 备用字段一
     */
    private String tmpOne;

    /**
     * 备用字段二
     */
    private String tmpTwo;

    /**
     * 备用字段三
     */
    private String tmpThree;

}
