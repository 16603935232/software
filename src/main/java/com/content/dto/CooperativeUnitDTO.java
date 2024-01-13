package com.content.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * 【合作单位表】交互层
 *
 * @author sml
 * @date 2023-08-03
 */
@Data
@ApiModel(value = "【合作单位表】交互层")
public class CooperativeUnitDTO {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "单位名称")
    private String unitName;

    @ApiModelProperty(value = "合作类型：0：印刷 1：设计 2：录排 3：校对 4：设计")
    private Integer type;

    @ApiModelProperty(value = "所在地")
    private String location;

    @ApiModelProperty(value = "联系人")
    private String liasion;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "联系方式")
    private String phone;

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