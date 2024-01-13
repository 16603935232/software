package com.ai.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * 【研究机构资讯关联表】实体类
 *
 * @author sml
 * @date 2023-10-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("`institute_information_relation`")
public class InstituteInformationRelation extends Model<InstituteInformationRelation> {

    @TableId(value = "`id`", type = IdType.AUTO)
    @ApiModelProperty(value = "主键id")
    private Long id;

    @TableField(value = "`institute_id`")
    @ApiModelProperty(value = "研究机构id")
    private Long instituteId;

    @TableField(value = "`information_id`")
    @ApiModelProperty(value = "资讯ID")
    private Long informationId;

    @TableField(value = "`information_code`")
    @ApiModelProperty(value = "资讯code")
    private String informationCode;

    @TableField(value = "`relation_state`")
    @ApiModelProperty(value = "0:没做关联，1做关联了，2：不再做关联")
    private Integer relationState;

    @TableField(value = "`status_online`")
    @ApiModelProperty(value = "上线状态：0待发布,1已发布,2重新发布")
    private Integer statusOnline;

    @TableField(value = "`title`")
    @ApiModelProperty(value = "标题")
    private String title;

    @TableField(value = "`publish_time`")
    @ApiModelProperty(value = "发布时间")
    private LocalDateTime publishTime;

    @TableField(value = "`source`")
    @ApiModelProperty(value = "来源")
    private String source;

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
