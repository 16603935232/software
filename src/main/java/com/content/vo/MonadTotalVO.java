package com.content.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 【单据总表】响应层
 *
 * @author sml
 * @date 2023-07-31
 */
@Data
@ApiModel(value = "【单据总表】返回层")
public class MonadTotalVO {

    @ApiModelProperty(value = "单据ID")
    private Long id;

    @ApiModelProperty(value = "单据类型")
    private Integer monadType;

    @ApiModelProperty(value = "审批id")
    private Long approvalId;

    @ApiModelProperty(value = "稿件id")
    private Long manuscriptId;

    @ApiModelProperty(value = "是否当前报告单:0否，1是")
    private Boolean isCurrent;

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
