package com.content.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.Version;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.util.Date;


/**
 * 【直送作者通知单】实体类
 *
 * @author sml
 * @date 2023-08-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("`monad_direct_author`")
public class MonadDirectAuthor extends Model<MonadDirectAuthor> {

    @TableId("`id`")
    @ApiModelProperty(value = "主键")
    private Long id;

    @TableField(value = "`copies`")
    @ApiModelProperty(value = "册数")
    private Integer copies;

    @TableField(value = "`receiving_author`")
    @ApiModelProperty(value = "收书作者")
    private String receivingAuthor;

    @TableField(value = "`required_delivery_time`")
    @ApiModelProperty(value = "要求到货时间")
    private LocalDate requiredDeliveryTime;

    @TableField(value = "`telephone`")
    @ApiModelProperty(value = "联系电话")
    private String telephone;

    @TableField(value = "`postal_code`")
    @ApiModelProperty(value = "邮编")
    private String postalCode;

    @TableField(value = "`delivery_address`")
    @ApiModelProperty(value = "收货地址")
    private String deliveryAddress;

    @TableField(value = "`buy_book_way`")
    @ApiModelProperty(value = "购书方式：0补贴出版社 赠送、1扣稿费 汇款")
    private Integer buyBookWay;

    @TableField(value = "`deleted`", fill = FieldFill.INSERT)
    @TableLogic
    @ApiModelProperty(value = "是否删除 0否 1是")
    private Boolean deleted;

    @TableField(value = "`create_user_id`", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建人")
    private Long createUserId;

    @TableField(value = "`create_time`", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @TableField(value = "`update_user_id`", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新人")
    private Long updateUserId;

    @TableField(value = "`update_time`", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
