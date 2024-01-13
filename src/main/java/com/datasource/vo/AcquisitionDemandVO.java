package com.datasource.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 【采集提需表】响应层
 *
 * @author haoxiaoming
 * @date 2022-12-21
 */
@Data
@ApiModel(value = "【采集提需表】返回层")
public class AcquisitionDemandVO {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "需求单编号")
    private String demandCode;

    @ApiModelProperty(value = "采集标题")
    private String collectTitle;

    @ApiModelProperty(value = "0暂存，1待认领，2待运维评估，3待技术评估，4待采集，5待交付，6退回，7需求待确认，8待验收，9验收通过，10需求已确认，11已完结")
    private Integer status;

    @ApiModelProperty(value = "当前评估人id")
    private Long assessorsId;

    @ApiModelProperty(value = "需求描述")
    private String requirementDescription;

    @ApiModelProperty(value = "采集需求开始时间")
    private LocalDateTime startTime;

    @ApiModelProperty(value = "采集需求结束时间")
    private LocalDateTime endTime;

    @ApiModelProperty(value = "数据应用目的")
    private String goal;

    @ApiModelProperty(value = "数据源")
    private String dataSource;

    @ApiModelProperty(value = "期望交付时间")
    private LocalDateTime expectedDeliveryTime;

    @ApiModelProperty(value = "数据格式要求")
    private String dataFormat;

    @ApiModelProperty(value = "0平台内共享，1个人私有")
    private Integer appliedRange;

    @ApiModelProperty(value = "其他说明")
    private String otherInstructions;

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

    }
