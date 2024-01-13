package com.datasource.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.Version;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.util.Date;


/**
 * 【采集提需表】实体类
 *
 * @author haoxiaoming
 * @date 2022-12-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("`acquisition_demand`")
public class AcquisitionDemand extends Model<AcquisitionDemand> {

    @TableId("`id`")
    @ApiModelProperty(value = "主键id")
    private Long id;

    @TableField(value = "`user_id`")
    @ApiModelProperty(value = "用户id")
    private Long userId;

    @TableField(value = "`demand_code`")
    @ApiModelProperty(value = "需求单编号")
    private String demandCode;

    @TableField(value = "`collect_title`")
    @ApiModelProperty(value = "采集标题")
    private String collectTitle;

    @TableField(value = "`status`")
    @ApiModelProperty(value = "0暂存，1待认领，2待运维评估，3待技术评估，4待采集，5待交付，6退回，7需求待确认，8待验收，9验收通过，10需求已确认，11已完结")
    private Integer status;

    @TableField(value = "`assessors_id`")
    @ApiModelProperty(value = "当前评估人id")
    private Long assessorsId;

    @TableField(value = "`requirement_description`")
    @ApiModelProperty(value = "需求描述")
    private String requirementDescription;

    @TableField(value = "`start_time`")
    @ApiModelProperty(value = "采集需求开始时间")
    private LocalDateTime startTime;

    @TableField(value = "`end_time`")
    @ApiModelProperty(value = "采集需求结束时间")
    private LocalDateTime endTime;

    @TableField(value = "`goal`")
    @ApiModelProperty(value = "数据应用目的")
    private String goal;

    @TableField(value = "`data_source`")
    @ApiModelProperty(value = "数据源")
    private String dataSource;

    @TableField(value = "`expected_delivery_time`")
    @ApiModelProperty(value = "期望交付时间")
    private LocalDateTime expectedDeliveryTime;

    @TableField(value = "`data_format`")
    @ApiModelProperty(value = "数据格式要求")
    private String dataFormat;

    @TableField(value = "`applied_range`")
    @ApiModelProperty(value = "0平台内共享，1个人私有")
    private Integer appliedRange;

    @TableField(value = "`other_instructions`")
    @ApiModelProperty(value = "其他说明")
    private String otherInstructions;

    @TableField(value = "`deleted`", fill = FieldFill.INSERT)
    @TableLogic
    @ApiModelProperty(value = "是否删除 0否 1是")
    private Long deleted;

    @TableField(value = "`create_user_id`", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建人")
    private Long createUserId;

    @TableField(value = "`create_time`", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @TableField(value = "`update_user_id`", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新人")
    private Long updateUserId;

    @TableField(value = "`update_time`", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
