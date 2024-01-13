package com.content-backend.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * 【稿件简表】交互层
 *
 * @author sml
 * @date 2023-07-28
 */
@Data
@ApiModel(value = "【稿件简表】交互层")
public class ManuscriptBriefDTO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "稿件名称")
    private String name;

    @ApiModelProperty(value = "作者")
    private String author;

    @ApiModelProperty(value = "所属部门")
    private Integer deptId;

    @ApiModelProperty(value = "开始时间")
    private LocalDateTime startTime;

    @ApiModelProperty(value = "归档时间")
    private LocalDateTime endTime;

    @ApiModelProperty(value = "策划编辑")
    private Integer planningEditor;

    @ApiModelProperty(value = "责任编辑")
    private String responsibleEditor;

    @ApiModelProperty(value = "发稿编号")
    private String publicationNumber;

    @ApiModelProperty(value = "选题编号")
    private String topicNumber;

    @ApiModelProperty(value = "终止原因")
    private String causeOfTermination;

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

    @ApiModelProperty(value = "分页大小")
    private Integer size = 20;

    @ApiModelProperty(value = "当前页")
    private Integer current = 1;

    @ApiModelProperty(value = "排序字段")
    private String sortBy;
}