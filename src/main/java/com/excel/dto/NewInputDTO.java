package com.excel.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * 【新增产业能耗设定输入表】交互层
 *
 * @author shangml
 * @date 2023-01-15
 */
@Data
@ApiModel(value = "【新增产业能耗设定输入表】交互层")
public class NewInputDTO {

    @ApiModelProperty(value = "注解")
    private Integer id;

    @ApiModelProperty(value = "模型方案id")
    private Integer modelOutputId;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "产品编码")
    private String productCode;

    @ApiModelProperty(value = "产业类型：0发展计划产业，1已发展产业，2未发展产业")
    private String industryType;

    @ApiModelProperty(value = "预计建成时间")
    private LocalDate scheduledTime;

    @ApiModelProperty(value = "预计产量")
    private BigDecimal yield;

    @ApiModelProperty(value = "产量单位")
    private String yieldUnit;

    @ApiModelProperty(value = "能效水平")
    private String efficiency;

    @ApiModelProperty(value = "预计能耗（万tce）")
    private String energyConsumption;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "分页大小")
    private Integer size = 20;

    @ApiModelProperty(value = "当前页")
    private Integer current = 1;

    @ApiModelProperty(value = "排序字段")
    private String sortBy;
}