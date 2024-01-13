package com.replay.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * 【预防专家建议发布表】交互层
 *
 * @author haoxiaoming
 * @date 2023-04-26
 */
@Data
@ApiModel(value = "【预防专家建议发布表】交互层")
public class PreventSuggestPublishDTO {

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "领域ID")
    private Long fieldId;

    @ApiModelProperty(value = "预防ID")
    private Long preventId;

    @ApiModelProperty(value = "专家建议CODE")
    private String suggestCode;

    @ApiModelProperty(value = "专家姓名")
    private String expertName;

    @ApiModelProperty(value = "专家单位")
    private String expertDepartment;

    @ApiModelProperty(value = "专家职称")
    private String expertPosition;

    @ApiModelProperty(value = "研究领域")
    private String researchField;

    @ApiModelProperty(value = "专家打分")
    private BigDecimal expertScore;

    @ApiModelProperty(value = "专家意见")
    private String expertOpinion;

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