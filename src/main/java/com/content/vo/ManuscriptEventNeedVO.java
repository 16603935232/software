package com.content.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 【稿件待办事项表】响应层
 *
 * @author sml
 * @date 2023-08-09
 */
@Data
@ApiModel(value = "【稿件待办事项表】返回层")
public class ManuscriptEventNeedVO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "稿件ID")
    private Long manuscriptId;

    @ApiModelProperty(value = "操作ID")
    private Integer operateId;

    @ApiModelProperty(value = "部门ID")
    private Long deptId;

    @ApiModelProperty(value = "待办人ID")
    private Long userId;

    @ApiModelProperty(value = "操作人ID")
    private Long operateUserId;

    @ApiModelProperty(value = "是否完成0否1是")
    private Boolean status;

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
