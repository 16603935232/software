package com.excel.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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
 * 【模型输出表】实体类
 *
 * @author shangml
 * @date 2023-01-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("`model_output`")
public class ModelOutput extends Model<ModelOutput> {

    @TableId(value = "`id`", type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    private Integer id;

    @TableField(value = "`area_name`")
    @ApiModelProperty(value = "区域名称")
    private String areaName;

    @TableField(value = "`area_code`")
    @ApiModelProperty(value = "区域编码")
    private String areaCode;

    @TableField(value = "`plan_name`")
    @ApiModelProperty(value = "方案名称")
    private String planName;

    @TableField(value = "`data_type`")
    @ApiModelProperty(value = "数据类型：0能耗量，1产值，2增加值")
    private Integer dataType;

    @TableField(value = "`new_value`")
    @ApiModelProperty(value = "新增产业预测值")
    private BigDecimal newValue;

    @TableField(value = "`stock_value`")
    @ApiModelProperty(value = "存量产业预测值")
    private BigDecimal stockValue;

    @TableField(value = "`actual_value`")
    @ApiModelProperty(value = "实际值")
    private BigDecimal actualValue;

    @TableField(value = "`gdp_rate`")
    @ApiModelProperty(value = "预计GDP年均增速（%）")
    private String gdpRate;

    @TableField(value = "`estimated_energy_consumption

e`")
    @ApiModelProperty(value = "预计2030年能耗量（万tce）")
    private BigDecimal estimatedEnergyConsumption

e;

    @TableField(value = "`projected_carbon_emissions`")
    @ApiModelProperty(value = "预计2030年碳排放量")
    private BigDecimal projectedCarbonEmissions;

    @TableField(value = "`create_time`")
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @TableField(value = "`update_time`")
    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
