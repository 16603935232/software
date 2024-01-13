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
 * 【需求单退回表】实体类
 *
 * @author shangmingliang
 * @date 2023-01-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("`demand_assessment`")
public class DemandAssessment extends Model<DemandAssessment> {

    @TableId("`id`")
    @ApiModelProperty(value = "主键id")
    private Long id;

    @TableField(value = "`demand_id`")
    @ApiModelProperty(value = "需求单id")
    private Long demandId;

    @TableField(value = "`type`")
    @ApiModelProperty(value = "意见类型：0运营，1技术")
    private Integer type;

    @TableField(value = "`opinion`")
    @ApiModelProperty(value = "意见")
    private String opinion;

    @TableField(value = "`accessory`")
    @ApiModelProperty(value = "附件")
    private String accessory;

    @TableField(value = "`deleted`", fill = FieldFill.INSERT)
    @TableLogic
    @ApiModelProperty(value = "是否删除 0否 1是")
    private Boolean deleted;

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
