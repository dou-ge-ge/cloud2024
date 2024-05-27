package com.atguigu.cloud.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 支付交易表
 * </p>
 *
 * @author kashim
 * @since 2024-05-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_pay")
public class TPay extends Model<TPay> {

    private static final long serialVersionUID = 1L;

    /**
     * Id
     */
    @TableId(value = "id", type = IdType.INPUT)
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


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
