package com.replay.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * 【预测信息发布表】交互层
 *
 * @author haoxiaoming
 * @date 2023-04-26
 */
@Data
@ApiModel(value = "【预测信息发布表】交互层")
public class PredictInformationPublishDTO {

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "领域ID")
    private Long fieldId;

    @ApiModelProperty(value = "预测CODE")
    private String predictCode;

    @ApiModelProperty(value = "预测名称")
    private String predictName;

    @ApiModelProperty(value = "预测内容")
    private String predictContent;

    @ApiModelProperty(value = "预测指标")
    private String predictIndicators;

    @ApiModelProperty(value = "指标简称")
    private String indicatorsAbbreviate;

    @ApiModelProperty(value = "预测指数")
    private BigDecimal predictScore;

    @ApiModelProperty(value = "观测指数")
    private BigDecimal observScore;

    @ApiModelProperty(value = "特征指数")
    private BigDecimal featureScore;

    @ApiModelProperty(value = "难题指数")
    private BigDecimal problemScore;

    @ApiModelProperty(value = "军事斗争内容")
    private String militaryStruggle;

    @ApiModelProperty(value = "科技竞争内容")
    private String technologyCompete;

    @ApiModelProperty(value = "关系,观测ID,逗号分隔")
    private String relation;

    @ApiModelProperty(value = "关系,特征难题ID,逗号分隔")
    private String relationFeature;

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

    @ApiModelProperty(value = "分页大小")
    private Integer size = 20;

    @ApiModelProperty(value = "当前页")
    private Integer current = 1;

    @ApiModelProperty(value = "排序字段")
    private String sortBy;
}