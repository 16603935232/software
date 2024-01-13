package com.content.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * 【部门表】交互层
 *
 * @author lzy
 * @date 2023-08-03
 */
@Data
@ApiModel(value = "【部门表】交互层")
public class SysDeptDTO {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "组织编号")
    private String deptNo;

    @ApiModelProperty(value = "部门名称")
    private String deptName;

    @ApiModelProperty(value = "父级部门id：0：顶级")
    private Long parentId;

    @ApiModelProperty(value = "父级id路径，id前后为{}，用逗号分隔")
    private String ancestor;

    @ApiModelProperty(value = "单位：0，部门所在层级：1,2,3,4,5")
    private Integer level;

    @ApiModelProperty(value = "当前层级排序")
    private Integer orderNum;

    @ApiModelProperty(value = "单位id")
    private Long unitId;

    @ApiModelProperty(value = "说明")
    private String description;

    @ApiModelProperty(value = "是否选中：0：否 1：是")
    private Integer isSelected;

    @ApiModelProperty(value = "是否提交样书：0：否 1：是")
    private Boolean isSubmitSample;

    @ApiModelProperty(value = "是否启用：0：启用；1：禁用")
    private Boolean status;

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