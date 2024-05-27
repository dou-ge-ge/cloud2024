package com.atguigu.cloud.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TPayDto implements Serializable {
    /**
     * Id
     */
    @TableField("id")
    private Integer id;

    /**
     * 支付单号
     */
    @TableField("pay_no")
    private String payNo;

    /**
     * 订单号
     */
    @TableField("order_no")
    private String orderNo;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 交易金额
     */
    @TableField("amount")
    private BigDecimal amount;

    /**
     * 删除标志
     */
    @TableField("deleted")
    private Integer deleted;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;


}
