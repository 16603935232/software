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
 * 【采集提需-采集项表】实体类
 *
 * @author shangmingliang
 * @date 2022-12-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("`collection_item`")
public class CollectionItem extends Model<CollectionItem> {

    @TableId("`id`")
    @ApiModelProperty(value = "主键id")
    private Long id;

    @TableField(value = "`demand_code`")
    @ApiModelProperty(value = "需求单编号")
    private Long demandCode;

    @TableField(value = "`collection_type`")
    @ApiModelProperty(value = "采集类型，0网站，1公众号")
    private Integer collectionType;

    @TableField(value = "`status`")
    @ApiModelProperty(value = "状态，0暂存，1待分派，2待排期，3采集中，4采集完毕")
    private Integer status;

    @TableField(value = "`name`")
    @ApiModelProperty(value = "名称")
    private String name;

    @TableField(value = "`collection_content`")
    @ApiModelProperty(value = "采集内容")
    private String collectionContent;

    @TableField(value = "`url`")
    @ApiModelProperty(value = "采集内容网址")
    private String url;

    @TableField(value = "`content_type`")
    @ApiModelProperty(value = "采集内容分类")
    private String contentType;

    @TableField(value = "`search_term`")
    @ApiModelProperty(value = "站内检索词")
    private String searchTerm;

    @TableField(value = "`start_time`")
    @ApiModelProperty(value = "采集内容开始时间")
    private LocalDateTime startTime;

    @TableField(value = "`end_time`")
    @ApiModelProperty(value = "采集内容结束时间")
    private LocalDateTime endTime;

    @TableField(value = "`frequency`")
    @ApiModelProperty(value = "采集频率，0每天一次，1每周一次，2每旬一次、3每月一次、4半年一次")
    private Integer frequency;

    @TableField(value = "`acquisition mode`")
    @ApiModelProperty(value = "采集方式：0爬虫、1RSS、2第三方")
    private Integer acquisition mode;

    @TableField(value = "`handler`")
    @ApiModelProperty(value = "处理人")
    private String handler;

    @TableField(value = "`schedule_start_time`")
    @ApiModelProperty(value = "排期开始时间")
    private LocalDateTime scheduleStartTime;

    @TableField(value = "`schedule_end_time`")
    @ApiModelProperty(value = "排期结束时间")
    private LocalDateTime scheduleEndTime;

    @TableField(value = "`data_soure`")
    @ApiModelProperty(value = "数据源CODE")
    private String dataSoure;

    @TableField(value = "`collection_completion_time`")
    @ApiModelProperty(value = "采集完成时间")
    private LocalDateTime collectionCompletionTime;

    @TableField(value = "`remark`")
    @ApiModelProperty(value = "备注")
    private String remark;

    @TableField(value = "`deleted`", fill = FieldFill.INSERT)
    @TableLogic
    @ApiModelProperty(value = "是否删除 0否 1是")
    private Long deleted;

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
