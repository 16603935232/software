package com.content-backend.entity;

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
 * 【稿件简表】实体类
 *
 * @author sml
 * @date 2023-07-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("`manuscript_brief`")
public class ManuscriptBrief extends Model<ManuscriptBrief> {

    @TableId("`id`")
    @ApiModelProperty(value = "主键")
    private Long id;

    @TableField(value = "`name`")
    @ApiModelProperty(value = "稿件名称")
    private String name;

    @TableField(value = "`author`")
    @ApiModelProperty(value = "作者")
    private String author;

    @TableField(value = "`dept_id`")
    @ApiModelProperty(value = "所属部门")
    private Integer deptId;

    @TableField(value = "`start_time`")
    @ApiModelProperty(value = "开始时间")
    private LocalDateTime startTime;

    @TableField(value = "`end_time`")
    @ApiModelProperty(value = "归档时间")
    private LocalDateTime endTime;

    @TableField(value = "`planning_editor`")
    @ApiModelProperty(value = "策划编辑")
    private Integer planningEditor;

    @TableField(value = "`responsible_editor`")
    @ApiModelProperty(value = "责任编辑")
    private String responsibleEditor;

    @TableField(value = "`publication_number`")
    @ApiModelProperty(value = "发稿编号")
    private String publicationNumber;

    @TableField(value = "`topic_number`")
    @ApiModelProperty(value = "选题编号")
    private String topicNumber;

    @TableField(value = "`cause_of_termination`")
    @ApiModelProperty(value = "终止原因")
    private String causeOfTermination;

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
