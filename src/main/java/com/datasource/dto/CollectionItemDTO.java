package com.datasource.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * 【采集提需-采集项表】交互层
 *
 * @author shangmingliang
 * @date 2022-12-21
 */
@Data
@ApiModel(value = "【采集提需-采集项表】交互层")
public class CollectionItemDTO {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "需求单编号")
    private Long demandCode;

    @ApiModelProperty(value = "采集类型，0网站，1公众号")
    private Integer collectionType;

    @ApiModelProperty(value = "状态，0暂存，1待分派，2待排期，3采集中，4采集完毕")
    private Integer status;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "采集内容")
    private String collectionContent;

    @ApiModelProperty(value = "采集内容网址")
    private String url;

    @ApiModelProperty(value = "采集内容分类")
    private String contentType;

    @ApiModelProperty(value = "站内检索词")
    private String searchTerm;

    @ApiModelProperty(value = "采集内容开始时间")
    private LocalDateTime startTime;

    @ApiModelProperty(value = "采集内容结束时间")
    private LocalDateTime endTime;

    @ApiModelProperty(value = "采集频率，0每天一次，1每周一次，2每旬一次、3每月一次、4半年一次")
    private Integer frequency;

    @ApiModelProperty(value = "采集方式：0爬虫、1RSS、2第三方")
    private Integer acquisition mode;

    @ApiModelProperty(value = "处理人")
    private String handler;

    @ApiModelProperty(value = "排期开始时间")
    private LocalDateTime scheduleStartTime;

    @ApiModelProperty(value = "排期结束时间")
    private LocalDateTime scheduleEndTime;

    @ApiModelProperty(value = "数据源CODE")
    private String dataSoure;

    @ApiModelProperty(value = "采集完成时间")
    private LocalDateTime collectionCompletionTime;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "是否删除 0否 1是")
    private Long deleted;

    @ApiModelProperty(value = "创建人")
    private Long createUserId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新人")
    private Long updateUserId;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "分页大小")
    private Integer size = 20;

    @ApiModelProperty(value = "当前页")
    private Integer current = 1;

    @ApiModelProperty(value = "排序字段")
    private String sortBy;
}