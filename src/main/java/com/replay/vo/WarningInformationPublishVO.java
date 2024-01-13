package com.replay.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 【预警信息发布表】响应层
 *
 * @author haoxiaoming
 * @date 2023-04-26
 */
@Data
@ApiModel(value = "【预警信息发布表】返回层")
public class WarningInformationPublishVO {

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "领域ID")
    private Long fieldId;

    @ApiModelProperty(value = "预警CODE")
    private String warningCode;

    @ApiModelProperty(value = "预警名称")
    private String warningName;

    @ApiModelProperty(value = "预警内容")
    private String warningContent;

    @ApiModelProperty(value = "预警指标")
    private String warningIndicators;

    @ApiModelProperty(value = "指标简称")
    private String indicatorsAbbreviate;

    @ApiModelProperty(value = "预警指数")
    private BigDecimal warningScore;

    @ApiModelProperty(value = "预测指数")
    private BigDecimal predictScore;

    @ApiModelProperty(value = "差距指数")
    private BigDecimal disparityScore;

    @ApiModelProperty(value = "威胁指数")
    private BigDecimal threatenScore;

    @ApiModelProperty(value = "作战想定内容")
    private String scenarioContent;

    @ApiModelProperty(value = "关系,预测ID,逗号分隔")
    private String relation;

    @ApiModelProperty(value = "关系,差距威胁ID,逗号分隔")
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

    }
