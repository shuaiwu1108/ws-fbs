package com.shuaiwu.order.entity;

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
@TableName("order_test")
public class OrderTest implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer productId;

    private Integer totalAmount;

    private Integer status;

    @Override
    public String toString() {
        return "OrderTest{" +
            "id = " + id +
            ", productId = " + productId +
            ", totalAmount = " + totalAmount +
            ", status = " + status +
        "}";
    }
}
