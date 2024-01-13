package com.ai.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 【研究机构表】响应层
 *
 * @author sml
 * @date 2023-10-16
 */
@Data
@ApiModel(description = "【研究机构表】返回层")
public class InstituteVO {

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "地区")
    private String area;

    @ApiModelProperty(value = "成立时间")
    private LocalDateTime year;

    @ApiModelProperty(value = "机构性质：0高校、1科研院所、2新型研发机构、3企业")
    private Integer nature;

    @ApiModelProperty(value = "官网")
    private String officialWebsite;

    @ApiModelProperty(value = "公众号")
    private String officialAccount;

    @ApiModelProperty(value = "主分类")
    private String type;

    @ApiModelProperty(value = "上线状态，待发布0，已发布：1，重新发布：2")
    private Integer statusOnline;

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

    }
