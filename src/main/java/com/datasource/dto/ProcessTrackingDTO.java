package com.datasource.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * 【过程跟踪表】交互层
 *
 * @author shangmingliang
 * @date 2022-12-21
 */
@Data
@ApiModel(value = "【过程跟踪表】交互层")
public class ProcessTrackingDTO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "需求单编号")
    private String demandCode;

    @ApiModelProperty(value = "操作用户id")
    private Long userId;

    @ApiModelProperty(value = "操作类型")
    private Integer type;

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