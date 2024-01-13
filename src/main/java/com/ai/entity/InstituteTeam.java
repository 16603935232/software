package com.ai.entity;

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
 * 【研究机构-团队】实体类
 *
 * @author sml
 * @date 2023-10-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("`institute_team`")
public class InstituteTeam extends Model<InstituteTeam> {

    @TableId("`id`")
    @ApiModelProperty(value = "ID")
    private Long id;

    @TableField(value = "`institute_id`")
    @ApiModelProperty(value = "研究机构id")
    private Integer instituteId;

    @TableField(value = "`name`")
    @ApiModelProperty(value = "团队名称")
    private String name;

    @TableField(value = "`introduction`")
    @ApiModelProperty(value = "团队简介")
    private String introduction;

    @TableField(value = "`head`")
    @ApiModelProperty(value = "负责人")
    private String head;

    @TableField(value = "`domain`")
    @ApiModelProperty(value = "研究领域")
    private String domain;

    @TableField(value = "`achievement`")
    @ApiModelProperty(value = "重大创新成果")
    private String achievement;

    @TableField(value = "`cooperation`")
    @ApiModelProperty(value = "中外合作情况")
    private String cooperation;

    @TableField(value = "`official_website`")
    @ApiModelProperty(value = "团队网页")
    private String officialWebsite;

    @TableField(value = "`ethic`")
    @ApiModelProperty(value = "伦理治理：0否，1是")
    private Boolean ethic;

    @TableField(value = "`deleted`", fill = FieldFill.INSERT)
    @TableLogic
    @ApiModelProperty(value = "是否删除，0不删，1删除")
    private Boolean deleted;

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
