package com.redevelop.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * 【预警分项指标表】交互层
 *
 * @author liuzhiyu
 * @date 2023-04-27
 */
@Data
@ApiModel(value = "【预警分项指标表】交互层")
public class WarningSubentryDTO {

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "领域ID")
    private Long fieldId;

    @ApiModelProperty(value = "技术ID")
    private Long technologyId;

    @ApiModelProperty(value = "预警ID")
    private Long warningId;

    @ApiModelProperty(value = "分项指标体系ID")
    private Long subentryId;

    @ApiModelProperty(value = "分项指标内容")
    private String subentryContent;

    @ApiModelProperty(value = "分项指标分数")
    private BigDecimal subentryScore;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "发布状态，初始值为1，发布：2，编辑后变成3")
    private Integer statusPublish;

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