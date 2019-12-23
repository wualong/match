package org.spring.match.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @ProjectName: match
 * @ClassName: TableRowsMessage
 * @Author: A_Dragon
 * @Description: 获取所有表数据的记录vo对象
 * @Date: 2019/12/22 21:13
 * @Version: 1.0
 */
@Data
public class TableRowsMessage implements Serializable {

    /**
     * 表名
     */
    private String tableName;

    /**
     * 表行数
     */
    private Integer tableRows;
}
