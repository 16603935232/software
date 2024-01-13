package com.content.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 【申请开印刷委托书】响应层
 *
 * @author sml
 * @date 2023-08-14
 */
@Data
@ApiModel(value = "【申请开印刷委托书】返回层")
public class MonadApplyForPrintingVO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "稿件id")
    private Long manuscriptId;

    @ApiModelProperty(value = "印刷企业名称")
    private String enterpriseName;

    @ApiModelProperty(value = "印刷企业地址")
    private String enterpriseAddress;

    @ApiModelProperty(value = "版次")
    private String edition;

    @ApiModelProperty(value = "成品规格开本")
    private Integer format;

    @ApiModelProperty(value = "字数（单位千）")
    private BigDecimal wordNumber;

    @ApiModelProperty(value = "页数")
    private Integer pageNo;

    @ApiModelProperty(value = "印数")
    private Integer currentPrintRun;

    @ApiModelProperty(value = "印张")
    private Integer sheet;

    @ApiModelProperty(value = "定价")
    private BigDecimal fixPrice;

    @ApiModelProperty(value = "编/著/译")
    private String editorAuthorTranslator;

    @ApiModelProperty(value = "装帧")
    private String binding;

    @ApiModelProperty(value = "印完日期")
    private LocalDate printingCompletionTime;

    @ApiModelProperty(value = "交书日期")
    private LocalDate submissionTime;

    @ApiModelProperty(value = "联系人")
    private String contact;

    @ApiModelProperty(value = "联系电话")
    private String telephone;

    @ApiModelProperty(value = "是否为教材：0否，1是")
    private Boolean textbook;

    @ApiModelProperty(value = "图书分类")
    private String bookCategory;

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
