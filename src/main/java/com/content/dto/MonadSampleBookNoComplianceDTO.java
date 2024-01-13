package com.content.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * 【样书上交不达标说明单】交互层
 *
 * @author sml
 * @date 2023-08-14
 */
@Data
@ApiModel(value = "【样书上交不达标说明单】交互层")
public class MonadSampleBookNoComplianceDTO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "稿件id")
    private Long manuscriptId;

    @ApiModelProperty(value = "出版类型")
    private String publishType;

    @ApiModelProperty(value = "计划出版时间")
    private LocalDate planPublishTime;

    @ApiModelProperty(value = "目前出版进度")
    private String currentPublicationProgress;

    @ApiModelProperty(value = "应到补贴款")
    private BigDecimal subsidyPayable;

    @ApiModelProperty(value = "实到补贴款")
    private BigDecimal subsidyActual;

    @ApiModelProperty(value = "预计补贴到款时间")
    private LocalDate expectedPaymentArrivalTime;

    @ApiModelProperty(value = "提前申请原因")
    private String reasonSubmission;

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

    @ApiModelProperty(value = "分页大小")
    private Integer size = 20;

    @ApiModelProperty(value = "当前页")
    private Integer current = 1;

    @ApiModelProperty(value = "排序字段")
    private String sortBy;
}