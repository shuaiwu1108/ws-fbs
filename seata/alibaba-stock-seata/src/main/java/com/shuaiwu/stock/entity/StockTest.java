package com.shuaiwu.stock.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author shuaiwu
 * @since 2023-08-28
 */
@Data
@TableName("stock_test")
public class StockTest implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer productId;

    private Integer count;

    @Override
    public String toString() {
        return "StockTest{" +
            "id = " + id +
            ", productId = " + productId +
            ", count = " + count +
        "}";
    }
}
