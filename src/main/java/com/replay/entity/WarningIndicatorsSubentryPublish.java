package com.replay.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * 【预警分项指标发布表】实体类
 *
 * @author haoxiaoming
 * @date 2023-04-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("`warning_indicators_subentry_publish`")
public class WarningIndicatorsSubentryPublish extends Model<WarningIndicatorsSubentryPublish> {

    @TableId(value = "`id`", type = IdType.AUTO)
    @ApiModelProperty(value = "ID")
    private Long id;

    @TableField(value = "`field_id`")
    @ApiModelProperty(value = "领域ID")
    private Long fieldId;

    @TableField(value = "`feature_id`")
    @ApiModelProperty(value = "差距/威胁ID")
    private Long featureId;

    @TableField(value = "`subentry_id`")
    @ApiModelProperty(value = "分项指标体系ID")
    private Long subentryId;

    @TableField(value = "`subentry_type`")
    @ApiModelProperty(value = "分项指标类型，1差距，2威胁")
    private Integer subentryType;

    @TableField(value = "`subentry_code`")
    @ApiModelProperty(value = "分项指标CODE")
    private String subentryCode;

    @TableField(value = "`subentry_content`")
    @ApiModelProperty(value = "分项指标内容")
    private String subentryContent;

    @TableField(value = "`subentry_score`")
    @ApiModelProperty(value = "分项指标分数")
    private BigDecimal subentryScore;

    @TableField(value = "`sort`")
    @ApiModelProperty(value = "排序")
    private Integer sort;

    @TableField(value = "`status_publish`")
    @ApiModelProperty(value = "发布状态，初始值为1，发布：2，编辑后变成3")
    private Integer statusPublish;

    @TableField(value = "`replay_id`")
    @ApiModelProperty(value = "复盘ID，0为元数据")
    private Long replayId;

    @TableField(value = "`metadata_id`")
    @ApiModelProperty(value = "元数据ID")
    private Long metadataId;

    @TableField(value = "`changed`")
    @ApiModelProperty(value = "是否有变化，0无，1有")
    private Integer changed;

    @TableField(value = "`deleted`", fill = FieldFill.INSERT)
    @TableLogic
    @ApiModelProperty(value = "是否删除，0不删，1删除")
    private Boolean deleted;

    @TableField(value = "`create_user_id`", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建人ID")
    private Long createUserId;

    @TableField(value = "`create_time`", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @TableField(value = "`update_user_id`", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新人ID")
    private Long updateUserId;

    @TableField(value = "`update_time`", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
