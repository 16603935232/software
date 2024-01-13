package com.redevelop.entity;

import java.math.BigDecimal;
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
 * 【预警信息发布表】实体类
 *
 * @author liuzhiyu
 * @date 2023-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("`warning_information_publish`")
public class WarningInformationPublish extends Model<WarningInformationPublish> {

    @TableId("`id`")
    @ApiModelProperty(value = "ID")
    private Long id;

    @TableField(value = "`field_id`")
    @ApiModelProperty(value = "领域ID")
    private Long fieldId;

    @TableField(value = "`technology_id`")
    @ApiModelProperty(value = "技术ID")
    private Long technologyId;

    @TableField(value = "`warning_content`")
    @ApiModelProperty(value = "预警内容")
    private String warningContent;

    @TableField(value = "`warning_score`")
    @ApiModelProperty(value = "预警指数")
    private BigDecimal warningScore;

    @TableField(value = "`sort`")
    @ApiModelProperty(value = "排序")
    private Integer sort;

    @TableField(value = "`status_publish`")
    @ApiModelProperty(value = "发布状态，初始值为1，发布：2，编辑后变成3")
    private Integer statusPublish;

    @TableField(value = "`replay_id`")
    @ApiModelProperty(value = "复盘ID，0为元数据")
    private Long replayId;

    @TableField(value = "`metadata_id`")
    @ApiModelProperty(value = "元数据ID")
    private Long metadataId;

    @TableField(value = "`changed`")
    @ApiModelProperty(value = "是否有变化，0无，1有")
    private Integer changed;

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
