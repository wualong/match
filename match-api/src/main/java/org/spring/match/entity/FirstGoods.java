package org.spring.match.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 一级货物类别实体类
 * @author A_Dragon
 * @since 2019-12-09
 */
@Data
public class FirstGoods implements Serializable {

    /**
     * id
     */
    @TableId(value = "id",type = IdType.ID_WORKER)
    private Long id;

    /**
     * 商品名
     */
    private String goodsName;
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
