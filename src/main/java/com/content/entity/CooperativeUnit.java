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
 * 【合作单位表】实体类
 *
 * @author sml
 * @date 2023-08-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("`cooperative_unit`")
public class CooperativeUnit extends Model<CooperativeUnit> {

    @TableId("`id`")
    @ApiModelProperty(value = "主键id")
    private Long id;

    @TableField(value = "`unit_name`")
    @ApiModelProperty(value = "单位名称")
    private String unitName;

    @TableField(value = "`type`")
    @ApiModelProperty(value = "合作类型：0：印刷 1：设计 2：录排 3：校对 4：设计")
    private Integer type;

    @TableField(value = "`location`")
    @ApiModelProperty(value = "所在地")
    private String location;

    @TableField(value = "`liasion`")
    @ApiModelProperty(value = "联系人")
    private String liasion;

    @TableField(value = "`email`")
    @ApiModelProperty(value = "邮箱")
    private String email;

    @TableField(value = "`phone`")
    @ApiModelProperty(value = "联系方式")
    private String phone;

    @TableField(value = "`deleted`", fill = FieldFill.INSERT)
    @TableLogic
    @ApiModelProperty(value = "是否删除")
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
