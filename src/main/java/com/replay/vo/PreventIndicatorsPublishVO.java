package com.replay.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 【预防指标体系发布表】响应层
 *
 * @author haoxiaoming
 * @date 2023-04-26
 */
@Data
@ApiModel(value = "【预防指标体系发布表】返回层")
public class PreventIndicatorsPublishVO {

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "CODE")
    private String code;

    @ApiModelProperty(value = "指标名称")
    private String indicatorsName;

    @ApiModelProperty(value = "指标内涵")
    private String connotation;

    @ApiModelProperty(value = "权重分子")
    private Integer weightNumerator;

    @ApiModelProperty(value = "权重分母")
    private Integer weightDenominator;

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
