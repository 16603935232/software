package com.datasource.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 【信源数据统计】响应层
 *
 * @author shangml
 * @date 2023-12-06
 */
@Data
@ApiModel(description = "【信源数据统计】返回层")
public class InfoSourceStatisticsVO {

    @ApiModelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty(value = "信源ID")
    private Long infoId;

    @ApiModelProperty(value = "领域ID")
    private Long domainId;

    @ApiModelProperty(value = "累计数据")
    private Long data;

    @ApiModelProperty(value = "上周数据")
    private Long lastWeekData;

    @ApiModelProperty(value = "本月新增")
    private Long nowMonthData;

    @ApiModelProperty(value = "是否删除")
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
