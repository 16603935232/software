package com.ai.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * 【研究机构-团队发布表】交互层
 *
 * @author sml
 * @date 2023-10-18
 */
@Data
@ApiModel(value = "【研究机构-团队发布表】交互层")
public class InstituteTeamPublishDTO {

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "研究机构id")
    private Long instituteId;

    @ApiModelProperty(value = "团队名称")
    private String name;

    @ApiModelProperty(value = "团队简介")
    private String introduction;

    @ApiModelProperty(value = "负责人")
    private String head;

    @ApiModelProperty(value = "研究领域")
    private String domain;

    @ApiModelProperty(value = "重大创新成果")
    private String achievement;

    @ApiModelProperty(value = "中外合作情况")
    private String cooperation;

    @ApiModelProperty(value = "团队网页")
    private String officialWebsite;

    @ApiModelProperty(value = "伦理治理：0否，1是")
    private Boolean ethic;

    @ApiModelProperty(value = "是否删除，0不删，1删除")
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