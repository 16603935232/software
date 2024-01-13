package com.ai.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
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
 * 【研究机构专利关联表】实体类
 *
 * @author sml
 * @date 2023-10-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("`institute_patent_relation`")
public class InstitutePatentRelation extends Model<InstitutePatentRelation> {

    @TableId("`id`")
    @ApiModelProperty(value = "ID")
    private Long id;

    @TableField(value = "`institute_id`")
    @ApiModelProperty(value = "研究机构id")
    private Long instituteId;

    @TableField(value = "`patent_id`")
    @ApiModelProperty(value = "专利ID")
    private Long patentId;

    @TableField(value = "`patent_code`")
    @ApiModelProperty(value = "系统专利code")
    private String patentCode;

    @TableField(value = "`relation_state`")
    @ApiModelProperty(value = "0:没做关联，1做关联了，2：不再做关联")
    private Integer relationState;

    @TableField(value = "`status_online`")
    @ApiModelProperty(value = "上线状态：0待发布,1已发布,2重新发布")
    private Integer statusOnline;

    @TableField(value = "`patent_name`")
    @ApiModelProperty(value = "专利名称")
    private String patentName;

    @TableField(value = "`ipc_codes`")
    @ApiModelProperty(value = "IPC分类号")
    private String ipcCodes;

    @TableField(value = "`apply_name`")
    @ApiModelProperty(value = "申请人")
    private String applyName;

    @TableField(value = "`apply_time`")
    @ApiModelProperty(value = "申请日期")
    private LocalDate applyTime;

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
