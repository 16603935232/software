package com.datasource.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 【我的关注表】响应层
 *
 * @author shangml
 * @date 2023-12-06
 */
@Data
@ApiModel(description = "【我的关注表】返回层")
public class MyFocusVO {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "关注类型：0信息源，1细分领域")
    private Integer type;

    @ApiModelProperty(value = "关注id")
    private Long focusId;

    @ApiModelProperty(value = "关注名称")
    private String name;

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

    }
