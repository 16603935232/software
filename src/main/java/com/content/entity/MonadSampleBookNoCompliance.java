package com.content.entity;

import java.math.BigDecimal;
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
 * 【样书上交不达标说明单】实体类
 *
 * @author sml
 * @date 2023-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("`monad_sample_book_no_compliance`")
public class MonadSampleBookNoCompliance extends Model<MonadSampleBookNoCompliance> {

    @TableId("`id`")
    @ApiModelProperty(value = "主键")
    private Long id;

    @TableField(value = "`manuscript_id`")
    @ApiModelProperty(value = "稿件id")
    private Long manuscriptId;

    @TableField(value = "`publish_type`")
    @ApiModelProperty(value = "出版类型")
    private String publishType;

    @TableField(value = "`plan_publish_time`")
    @ApiModelProperty(value = "计划出版时间")
    private LocalDate planPublishTime;

    @TableField(value = "`current_publication_progress`")
    @ApiModelProperty(value = "目前出版进度")
    private String currentPublicationProgress;

    @TableField(value = "`subsidy_payable`")
    @ApiModelProperty(value = "应到补贴款")
    private BigDecimal subsidyPayable;

    @TableField(value = "`subsidy_actual`")
    @ApiModelProperty(value = "实到补贴款")
    private BigDecimal subsidyActual;

    @TableField(value = "`expected_payment_arrival_time`")
    @ApiModelProperty(value = "预计补贴到款时间")
    private LocalDate expectedPaymentArrivalTime;

    @TableField(value = "`reason_submission`")
    @ApiModelProperty(value = "提前申请原因")
    private String reasonSubmission;

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
