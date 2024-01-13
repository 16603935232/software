package com.ai.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 【研究机构资讯关联表】响应层
 *
 * @author sml
 * @date 2023-10-16
 */
@Data
@ApiModel(value = "【研究机构资讯关联表】返回层")
public class InstituteInformationRelationVO {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "研究机构id")
    private Long instituteId;

    @ApiModelProperty(value = "资讯ID")
    private Long informationId;

    @ApiModelProperty(value = "资讯code")
    private String informationCode;

    @ApiModelProperty(value = "0:没做关联，1做关联了，2：不再做关联")
    private Integer relationState;

    @ApiModelProperty(value = "上线状态：0待发布,1已发布,2重新发布")
    private Integer statusOnline;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "发布时间")
    private LocalDateTime publishTime;

    @ApiModelProperty(value = "来源")
    private String source;

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
