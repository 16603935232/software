package com.content.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 【初审/复审/终审报告单】响应层
 *
 * @author sml
 * @date 2023-08-01
 */
@Data
@ApiModel(value = "【初审/复审/终审报告单】返回层")
public class MonadPreliminaryVO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "单据id")
    private Long monadId;

    @ApiModelProperty(value = "单据类型：0初审报告单，1复审报告单，2终审报告单")
    private Integer monadType;

    @ApiModelProperty(value = "审批ids")
    private String approvalIds;

    @ApiModelProperty(value = "稿件id")
    private Long manuscriptId;

    @ApiModelProperty(value = "全稿字数（单位万）")
    private BigDecimal wordNumber;

    @ApiModelProperty(value = "稿件内容和特点")
    private String contentCharacteristics;

    @ApiModelProperty(value = "读者对象")
    private String audience;

    @ApiModelProperty(value = "社会和经济效益分析")
    private String socialAndEconomicBenefitAnalysis;

    @ApiModelProperty(value = "已经解决的主要问题和措施")
    private String mainProblemsAndMeasuresSolved;

    @ApiModelProperty(value = "尚未解决的问题及建议措施")
    private String unresolvedIssuesAndSuggestedMeasures;

    @ApiModelProperty(value = "稿面质量和结论")
    private String qualityAndConclusion;

    @ApiModelProperty(value = "文件集合")
    private String fileList;

    @ApiModelProperty(value = "是否删除 0否 1是")
    private Boolean deleted;

    @ApiModelProperty(value = "创建人")
    private Long createUserId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新人")
    private Long updateUserId;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    }
