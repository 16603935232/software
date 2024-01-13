package com.content.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 【终审报告单】响应层
 *
 * @author sml
 * @date 2023-08-08
 */
@Data
@ApiModel(value = "【终审报告单】返回层")
public class MonadLastInstanceVO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "稿件id")
    private Long manuscriptId;

    @ApiModelProperty(value = "全稿字数（单位万）")
    private BigDecimal wordNumber;

    @ApiModelProperty(value = "终审人ids")
    private String approvalIds;

    @ApiModelProperty(value = "稿件中尚存在的主要问题")
    private String mainIssues;

    @ApiModelProperty(value = "建议和措施")
    private String suggestionsAndMeasures;

    @ApiModelProperty(value = "对一二审建议")
    private String suggestions;

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
