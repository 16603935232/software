package com.content.entity;

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
 * 【稿件状态表】实体类
 *
 * @author sml
 * @date 2023-07-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("`manuscript_status`")
public class ManuscriptStatus extends Model<ManuscriptStatus> {

    @TableId("`id`")
    @ApiModelProperty(value = "主键")
    private Long id;

    @TableField(value = "`manuscript_id`")
    @ApiModelProperty(value = "稿件id")
    private Long manuscriptId;

    @TableField(value = "`status`")
    @ApiModelProperty(value = "状态")
    private Integer status;

    @TableField(value = "`number`")
    @ApiModelProperty(value = "次数")
    private Integer number;

    @TableField(value = "`status_time`")
    @ApiModelProperty(value = "开始时间")
    private LocalDateTime statusTime;

    @TableField(value = "`end_time`")
    @ApiModelProperty(value = "结束时间")
    private LocalDateTime endTime;

    @TableField(value = "`current`")
    @ApiModelProperty(value = "是否为当前状态：0否，1是")
    private Integer current;

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
