package com.ai.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * 【】交互层
 *
 * @author sml
 * @date 2023-10-16
 */
@Data
public class InstitutePaperRelationPublishDTO {

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "研究机构id")
    private Long instituteId;

    @ApiModelProperty(value = "论文ID")
    private Long paperId;

    @ApiModelProperty(value = "论文code")
    private String paperCode;

    @ApiModelProperty(value = "0:没做关联，1做关联了，2：不再做关联")
    private Integer relationState;

    @ApiModelProperty(value = "上线状态：0待发布,1已发布,2重新发布")
    private Integer statusOnline;

    @ApiModelProperty(value = "论文题目")
    private String title;

    @ApiModelProperty(value = "发布时间")
    private LocalDate releaseTime;

    @ApiModelProperty(value = "刊名/会议名")
    private String conferenceName;

    @ApiModelProperty(value = "作者")
    private String author;

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