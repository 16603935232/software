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
 * 【研究机构表】实体类
 *
 * @author sml
 * @date 2023-10-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("`institute`")
public class Institute extends Model<Institute> {

    @TableId("`id`")
    @ApiModelProperty(value = "ID")
    private Long id;

    @TableField(value = "`name`")
    @ApiModelProperty(value = "名称")
    private String name;

    @TableField(value = "`area`")
    @ApiModelProperty(value = "地区")
    private String area;

    @TableField(value = "`year`")
    @ApiModelProperty(value = "成立时间")
    private LocalDateTime year;

    @TableField(value = "`nature`")
    @ApiModelProperty(value = "机构性质：0高校、1科研院所、2新型研发机构、3企业")
    private Integer nature;

    @TableField(value = "`official_website`")
    @ApiModelProperty(value = "官网")
    private String officialWebsite;

    @TableField(value = "`official_account`")
    @ApiModelProperty(value = "公众号")
    private String officialAccount;

    @TableField(value = "`type`")
    @ApiModelProperty(value = "主分类")
    private String type;

    @TableField(value = "`status_online`")
    @ApiModelProperty(value = "上线状态，待发布0，已发布：1，重新发布：2")
    private Integer statusOnline;

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
