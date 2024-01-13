package com.datasource.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * 【日志表】交互层
 *
 * @author liuzhiyu
 * @date 2023-07-04
 */
@Data
@ApiModel(value = "【日志表】交互层")
public class SysLogDTO {

    @ApiModelProperty(value = "主键Id")
    private Long id;

    @ApiModelProperty(value = "日志类型：系统管理：0 ")
    private Integer type;

    @ApiModelProperty(value = "日志内容")
    private String content;

    @ApiModelProperty(value = "用户id，系统为0")
    private Long userId;

    @ApiModelProperty(value = "部门id")
    private Long deptId;

    @ApiModelProperty(value = "是否删除")
    private Boolean deleted;

    @ApiModelProperty(value = "创建人ID")
    private Long createUserId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新人ID")
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