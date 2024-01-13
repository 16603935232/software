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
 * 【预警信息发布表】实体类
 *
 * @author haoxiaoming
 * @date 2023-04-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("`warning_information_publish`")
public class WarningInformationPublish extends Model<WarningInformationPublish> {

    @TableId(value = "`id`", type = IdType.AUTO)
    @ApiModelProperty(value = "ID")
    private Long id;

    @TableField(value = "`field_id`")
    @ApiModelProperty(value = "领域ID")
    private Long fieldId;

    @TableField(value = "`warning_code`")
    @ApiModelProperty(value = "预警CODE")
    private String warningCode;

    @TableField(value = "`warning_name`")
    @ApiModelProperty(value = "预警名称")
    private String warningName;

    @TableField(value = "`warning_content`")
    @ApiModelProperty(value = "预警内容")
    private String warningContent;

    @TableField(value = "`warning_indicators`")
    @ApiModelProperty(value = "预警指标")
    private String warningIndicators;

    @TableField(value = "`indicators_abbreviate`")
    @ApiModelProperty(value = "指标简称")
    private String indicatorsAbbreviate;

    @TableField(value = "`warning_score`")
    @ApiModelProperty(value = "预警指数")
    private BigDecimal warningScore;

    @TableField(value = "`predict_score`")
    @ApiModelProperty(value = "预测指数")
    private BigDecimal predictScore;

    @TableField(value = "`disparity_score`")
    @ApiModelProperty(value = "差距指数")
    private BigDecimal disparityScore;

    @TableField(value = "`threaten_score`")
    @ApiModelProperty(value = "威胁指数")
    private BigDecimal threatenScore;

    @TableField(value = "`scenario_content`")
    @ApiModelProperty(value = "作战想定内容")
    private String scenarioContent;

    @TableField(value = "`relation`")
    @ApiModelProperty(value = "关系,预测ID,逗号分隔")
    private String relation;

    @TableField(value = "`relation_feature`")
    @ApiModelProperty(value = "关系,差距威胁ID,逗号分隔")
    private String relationFeature;

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
