package com.datasource.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 【需求单退回表】响应层
 *
 * @author shangmingliang
 * @date 2023-01-04
 */
@Data
@ApiModel(value = "【需求单退回表】返回层")
public class DemandAssessmentVO {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "需求单id")
    private Long demandId;

    @ApiModelProperty(value = "意见类型：0运营，1技术")
    private Integer type;

    @ApiModelProperty(value = "意见")
    private String opinion;

    @ApiModelProperty(value = "附件")
    private String accessory;

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
