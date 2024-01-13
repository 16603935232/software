package com.collection.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 【栏目表】响应层
 *
 * @author lzy
 * @date 2023-04-06
 */
@Data
@ApiModel(value = "【栏目表】返回层")
public class ColumnVO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "监测源id")
    private Long sourceId;

    @ApiModelProperty(value = "栏目名")
    private String name;

    @ApiModelProperty(value = "url")
    private String url;

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
