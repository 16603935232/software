package com.replay_collection.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 【监测源】响应层
 *
 * @author sml
 * @date 2023-03-23
 */
@Data
@ApiModel(value = "【监测源】返回层")
public class MonitoringSourceVO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "类型：0网站、1公众号")
    private Integer sourceType;

    @ApiModelProperty(value = "唯一标识")
    private String code;

    @ApiModelProperty(value = "监测源名称")
    private String sourceName;

    @ApiModelProperty(value = "微信号")
    private String source;

    @ApiModelProperty(value = "简介")
    private String introduction;

    @ApiModelProperty(value = "采集开始日期")
    private LocalDate startTime;

    @ApiModelProperty(value = "采集终止日期")
    private LocalDate endTime;

    @ApiModelProperty(value = "采集状态：0采集中、1已暂停、2告警")
    private Integer status;

    @ApiModelProperty(value = "语种：0中文、1外文")
    private Integer language;

    @ApiModelProperty(value = "数据更新频率：每日、每周")
    private Integer frequency;

    @ApiModelProperty(value = "数据采集总数")
    private Integer totalData;

    @ApiModelProperty(value = "最近采集数据量")
    private Integer lastUpdatedQuantity;

    @ApiModelProperty(value = "日均更新量")
    private Integer dailyRenewal;

    @ApiModelProperty(value = "国别")
    private String country;

    @ApiModelProperty(value = "领域")
    private String domain;

    @ApiModelProperty(value = "质量")
    private String quality;

    @ApiModelProperty(value = "网址")
    private String url;

    @ApiModelProperty(value = "运营机构")
    private String operatingAgency;

    @ApiModelProperty(value = "栏目名")
    private String channelName;

    @ApiModelProperty(value = "栏目链接")
    private String channelUrl;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "是否删除 0否 1是")
    private Boolean deleted;

    @ApiModelProperty(value = "创建人")
    private Long createUserId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新人")
    private Long updateUserId;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    }
