package com.content.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 【成书表】响应层
 *
 * @author sml
 * @date 2023-08-16
 */
@Data
@ApiModel(value = "【成书表】返回层")
public class BecomeBookVO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "稿件id")
    private Long manuscriptId;

    @ApiModelProperty(value = "版芯尺寸：行")
    private Integer row;

    @ApiModelProperty(value = "版芯尺寸：字")
    private Integer word;

    @ApiModelProperty(value = "成品规格：开本")
    private Integer format;

    @ApiModelProperty(value = "成品规格长")
    private Integer productSizeLength;

    @ApiModelProperty(value = "成品规格宽")
    private Integer productSizeWidth;

    @ApiModelProperty(value = "印张")
    private BigDecimal sheet;

    @ApiModelProperty(value = "彩插")
    private String colorInsert;

    @ApiModelProperty(value = "图书版面字数")
    private BigDecimal bookLayoutWordNumber;

    @ApiModelProperty(value = "图书版权页字数")
    private BigDecimal wordNumber;

    @ApiModelProperty(value = "联合审稿人")
    private String jointReviewer;

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
