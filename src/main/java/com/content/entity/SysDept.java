package com.content.entity;

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
 * 【部门表】实体类
 *
 * @author lzy
 * @date 2023-08-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("`sys_dept`")
public class SysDept extends Model<SysDept> {

    @TableId(value = "`id`", type = IdType.AUTO)
    @ApiModelProperty(value = "主键id")
    private Long id;

    @TableField(value = "`dept_no`")
    @ApiModelProperty(value = "组织编号")
    private String deptNo;

    @TableField(value = "`dept_name`")
    @ApiModelProperty(value = "部门名称")
    private String deptName;

    @TableField(value = "`parent_id`")
    @ApiModelProperty(value = "父级部门id：0：顶级")
    private Long parentId;

    @TableField(value = "`ancestor`")
    @ApiModelProperty(value = "父级id路径，id前后为{}，用逗号分隔")
    private String ancestor;

    @TableField(value = "`level`")
    @ApiModelProperty(value = "单位：0，部门所在层级：1,2,3,4,5")
    private Integer level;

    @TableField(value = "`order_num`")
    @ApiModelProperty(value = "当前层级排序")
    private Integer orderNum;

    @TableField(value = "`unit_id`")
    @ApiModelProperty(value = "单位id")
    private Long unitId;

    @TableField(value = "`description`")
    @ApiModelProperty(value = "说明")
    private String description;

    @TableField(value = "`is_selected`")
    @ApiModelProperty(value = "是否选中：0：否 1：是")
    private Integer isSelected;

    @TableField(value = "`is_submit_sample`")
    @ApiModelProperty(value = "是否提交样书：0：否 1：是")
    private Boolean isSubmitSample;

    @TableField(value = "`status`")
    @ApiModelProperty(value = "是否启用：0：启用；1：禁用")
    private Boolean status;

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
