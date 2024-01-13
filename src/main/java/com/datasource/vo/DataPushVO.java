package com.datasource.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 【数据更新情况推送表】响应层
 *
 * @author shangml
 * @date 2023-12-13
 */
@Data
@ApiModel(description = "【数据更新情况推送表】返回层")
public class DataPushVO {

    @ApiModelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty(value = "是否推送：0否，1是")
    private Boolean push;

    @ApiModelProperty(value = "推送频率：0每周，1每月")
    private Integer frequency;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "创建人ID")
    private Long createUserId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新人ID")
    private Long updateUserId;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    }
