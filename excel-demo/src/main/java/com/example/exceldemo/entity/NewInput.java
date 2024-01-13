package com.example.exceldemo.entity;

import java.math.BigDecimal;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.util.Date;


/**
 * 【新增产业能耗设定输入表】实体类
 *
 * @author shangml
 * @date 2023-01-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("`new_input`")
public class NewInput extends Model<NewInput> {

    @TableId(value = "`id`", type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    private Integer id;

    @TableField(value = "`plan_code`")
    @ApiModelProperty(value = "方案编码")
    private Long planCode;

    @TableField(value = "`product_name`")
    @ApiModelProperty(value = "产品名称")
    private String productName;

    @TableField(value = "`product_code`")
    @ApiModelProperty(value = "产品编码")
    private String productCode;

    @TableField(value = "`developed`")
    @ApiModelProperty(value = "是否为计划发展产业：0否，1是")
    private Integer developed;

    @TableField(value = "`scheduled_time`")
    @ApiModelProperty(value = "预计建成时间")
    private LocalDate scheduledTime;

    @TableField(value = "`yield`")
    @ApiModelProperty(value = "预计产量")
    private BigDecimal yield;

    @TableField(value = "`yield_unit`")
    @ApiModelProperty(value = "产量单位")
    private String yieldUnit;

    @TableField(value = "`efficiency`")
    @ApiModelProperty(value = "能效水平")
    private String efficiency;

    @TableField(value = "`energy_consumption`")
    @ApiModelProperty(value = "预计能耗（万tce）")
    private String energyConsumption;

    @TableField(value = "`create_time`")
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @TableField(value = "`update_time`")
    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;

    @TableField(exist = false)
    @ApiModelProperty(value = "产业类型：0计划发展产业，1已发展产业，2未发展产业")
    private Integer industryType;

    @ApiModelProperty(value = "预计建成时间年份")
    @TableField(exist = false)
    private Integer year;
}
