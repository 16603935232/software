package com.excel.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 【模型输出表】响应层
 *
 * @author shangml
 * @date 2023-01-15
 */
@Data
@ApiModel(value = "【模型输出表】返回层")
public class ModelOutputVO {

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "区域名称")
    private String areaName;

    @ApiModelProperty(value = "区域编码")
    private String areaCode;

    @ApiModelProperty(value = "方案名称")
    private String planName;

    @ApiModelProperty(value = "数据类型：0能耗量，1产值，2增加值")
    private Integer dataType;

    @ApiModelProperty(value = "新增产业预测值")
    private BigDecimal newValue;

    @ApiModelProperty(value = "存量产业预测值")
    private BigDecimal stockValue;

    @ApiModelProperty(value = "实际值")
    private BigDecimal actualValue;

    @ApiModelProperty(value = "预计GDP年均增速（%）")
    private String gdpRate;

    @ApiModelProperty(value = "预计2030年能耗量（万tce）")
    private BigDecimal estimatedEnergyConsumption

e;

    @ApiModelProperty(value = "预计2030年碳排放量")
    private BigDecimal projectedCarbonEmissions;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;

    }
