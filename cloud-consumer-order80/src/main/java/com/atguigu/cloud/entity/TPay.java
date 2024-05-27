package com.atguigu.cloud.entity;

//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.annotation.TableField;
//import com.baomidou.mybatisplus.annotation.TableId;
//import com.baomidou.mybatisplus.annotation.TableName;
//import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 支付交易表
 * </p>
 *
 * @author kashim
 * @since 2024-05-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
//@TableName("t_pay")
@Schema(title = "支付交易表实体类")
public class TPay {

    private static final long serialVersionUID = 1L;

    /**
     * Id
     */
//    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 支付单号
     */
    @Schema(title = "支付单号")
    private String payNo;

    /**
     * 订单号
     */
    @Schema(title = "订单号")
    private String orderNo;

    /**
     * 用户ID
     */
    @Schema(title = "用户ID")
    private Integer userId;

    /**
     * 交易金额
     */
    @Schema(title = "交易金额")
    private BigDecimal amount;

    /**
     * 删除标志
     */
    @Schema(title = "删除标志")
    private Integer deleted;

    /**
     * 创建时间
     */
    @Schema(title = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @Schema(title = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;


//    @Override
//    protected Serializable pkVal() {
//        return null;
//    }

}
