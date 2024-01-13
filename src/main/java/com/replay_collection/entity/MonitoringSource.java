package com.replay_collection.entity;

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
 * 【监测源】实体类
 *
 * @author sml
 * @date 2023-03-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("`monitoring_source`")
public class MonitoringSource extends Model<MonitoringSource> {

    @TableId("`id`")
    @ApiModelProperty(value = "主键")
    private Long id;

    @TableField(value = "`source_type`")
    @ApiModelProperty(value = "类型：0网站、1公众号")
    private Integer sourceType;

    @TableField(value = "`code`")
    @ApiModelProperty(value = "唯一标识")
    private String code;

    @TableField(value = "`source_name`")
    @ApiModelProperty(value = "监测源名称")
    private String sourceName;

    @TableField(value = "`source`")
    @ApiModelProperty(value = "微信号")
    private String source;

    @TableField(value = "`introduction`")
    @ApiModelProperty(value = "简介")
    private String introduction;

    @TableField(value = "`start_time`")
    @ApiModelProperty(value = "采集开始日期")
    private LocalDate startTime;

    @TableField(value = "`end_time`")
    @ApiModelProperty(value = "采集终止日期")
    private LocalDate endTime;

    @TableField(value = "`status`")
    @ApiModelProperty(value = "采集状态：0采集中、1已暂停、2告警")
    private Integer status;

    @TableField(value = "`language`")
    @ApiModelProperty(value = "语种：0中文、1外文")
    private Integer language;

    @TableField(value = "`frequency`")
    @ApiModelProperty(value = "数据更新频率：每日、每周")
    private Integer frequency;

    @TableField(value = "`total_data`")
    @ApiModelProperty(value = "数据采集总数")
    private Integer totalData;

    @TableField(value = "`last_updated_quantity`")
    @ApiModelProperty(value = "最近采集数据量")
    private Integer lastUpdatedQuantity;

    @TableField(value = "`daily_renewal`")
    @ApiModelProperty(value = "日均更新量")
    private Integer dailyRenewal;

    @TableField(value = "`country`")
    @ApiModelProperty(value = "国别")
    private String country;

    @TableField(value = "`domain`")
    @ApiModelProperty(value = "领域")
    private String domain;

    @TableField(value = "`quality`")
    @ApiModelProperty(value = "质量")
    private String quality;

    @TableField(value = "`url`")
    @ApiModelProperty(value = "网址")
    private String url;

    @TableField(value = "`operating_agency`")
    @ApiModelProperty(value = "运营机构")
    private String operatingAgency;

    @TableField(value = "`channel_name`")
    @ApiModelProperty(value = "栏目名")
    private String channelName;

    @TableField(value = "`channel_url`")
    @ApiModelProperty(value = "栏目链接")
    private String channelUrl;

    @TableField(value = "`remark`")
    @ApiModelProperty(value = "备注")
    private String remark;

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
