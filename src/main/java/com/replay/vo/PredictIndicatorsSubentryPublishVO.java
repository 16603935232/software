package com.replay.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 【预测分项指标发布表】响应层
 *
 * @author haoxiaoming
 * @date 2023-04-26
 */
@Data
@ApiModel(value = "【预测分项指标发布表】返回层")
public class PredictIndicatorsSubentryPublishVO {

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "领域ID")
    private Long fieldId;

    @ApiModelProperty(value = "特征/难题ID")
    private Long featureId;

    @ApiModelProperty(value = "分项指标体系ID")
    private Long subentryId;

    @ApiModelProperty(value = "分项指标类型，1特征，2难题")
    private Integer subentryType;

    @ApiModelProperty(value = "分项指标CODE")
    private String subentryCode;

    @ApiModelProperty(value = "分项指标内容")
    private String subentryContent;

    @ApiModelProperty(value = "分项指标分数")
    private BigDecimal subentryScore;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "发布状态，初始值为1，发布：2，编辑后变成3")
    private Integer statusPublish;

    @ApiModelProperty(value = "复盘ID，0为元数据")
    private Long replayId;

    @ApiModelProperty(value = "元数据ID")
    private Long metadataId;

    @ApiModelProperty(value = "是否有变化，0无，1有")
    private Integer changed;

    @ApiModelProperty(value = "是否删除，0不删，1删除")
    private Boolean deleted;

    @ApiModelProperty(value = "创建人ID")
    private Long createUserId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新人ID")
    private Long updateUserId;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    }
