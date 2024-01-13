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
 * 【稿件待办事项表】实体类
 *
 * @author sml
 * @date 2023-08-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("`manuscript_event_need`")
public class ManuscriptEventNeed extends Model<ManuscriptEventNeed> {

    @TableId("`id`")
    @ApiModelProperty(value = "主键")
    private Long id;

    @TableField(value = "`manuscript_id`")
    @ApiModelProperty(value = "稿件ID")
    private Long manuscriptId;

    @TableField(value = "`operate_id`")
    @ApiModelProperty(value = "操作ID")
    private Integer operateId;

    @TableField(value = "`dept_id`")
    @ApiModelProperty(value = "部门ID")
    private Long deptId;

    @TableField(value = "`user_id`")
    @ApiModelProperty(value = "待办人ID")
    private Long userId;

    @TableField(value = "`operate_user_id`")
    @ApiModelProperty(value = "操作人ID")
    private Long operateUserId;

    @TableField(value = "`status`")
    @ApiModelProperty(value = "是否完成0否1是")
    private Boolean status;

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
