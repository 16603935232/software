package com.datasource.entity;

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
 * 【信源数据统计】实体类
 *
 * @author shangml
 * @date 2023-12-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("`info_source_statistics`")
public class InfoSourceStatistics extends Model<InfoSourceStatistics> {

    @TableId("`id`")
    @ApiModelProperty(value = "主键ID")
    private Long id;

    @TableField(value = "`info_id`")
    @ApiModelProperty(value = "信源ID")
    private Long infoId;

    @TableField(value = "`domain_id`")
    @ApiModelProperty(value = "领域ID")
    private Long domainId;

    @TableField(value = "`data`")
    @ApiModelProperty(value = "累计数据")
    private Long data;

    @TableField(value = "`last_week_data`")
    @ApiModelProperty(value = "上周数据")
    private Long lastWeekData;

    @TableField(value = "`now_month_data`")
    @ApiModelProperty(value = "本月新增")
    private Long nowMonthData;

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
