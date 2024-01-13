package com.datasource.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.Version;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
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
 * 【数据更新情况推送表】实体类
 *
 * @author shangml
 * @date 2023-12-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("`data_push`")
public class DataPush extends Model<DataPush> {

    @TableId("`id`")
    @ApiModelProperty(value = "主键ID")
    private Long id;

    @TableField(value = "`push`")
    @ApiModelProperty(value = "是否推送：0否，1是")
    private Boolean push;

    @TableField(value = "`frequency`")
    @ApiModelProperty(value = "推送频率：0每周，1每月")
    private Integer frequency;

    @TableField(value = "`email`")
    @ApiModelProperty(value = "邮箱")
    private String email;

    @TableField(value = "`create_user_id`", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建人ID")
    private Long createUserId;

    @TableField(value = "`create_time`", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @TableField(value = "`update_user_id`", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新人ID")
    private Long updateUserId;

    @TableField(value = "`update_time`", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
