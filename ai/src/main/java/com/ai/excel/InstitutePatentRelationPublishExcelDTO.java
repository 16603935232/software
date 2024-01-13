package com.ai.excel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * 【研究机构专利关联表】交互层
 *
 * @author sml
 * @date 2023-10-16
 */
@Data
@ApiModel(value = "【研究机构专利关联表】交互层")
public class InstitutePatentRelationPublishExcelDTO implements Serializable {

    @ApiModelProperty(value = "ID")
    @Excel(name = "ID")
    private Long id;

    @ApiModelProperty(value = "研究机构id")
    @Excel(name = "研究机构id")
    private Long instituteId;

    @ApiModelProperty(value = "专利ID")
    @Excel(name = "专利ID")
    private Long patentId;

    @ApiModelProperty(value = "系统专利code")
    @Excel(name = "系统专利code")
    private String patentCode;

    @ApiModelProperty(value = "0:没做关联，1做关联了，2：不再做关联")
    @Excel(name = "0:没做关联，1做关联了，2：不再做关联")
    private Integer relationState;

    @ApiModelProperty(value = "上线状态：0待发布,1已发布,2重新发布")
    @Excel(name = "上线状态：0待发布,1已发布,2重新发布")
    private Integer statusOnline;

    @ApiModelProperty(value = "专利名称")
    @Excel(name = "专利名称")
    private String patentName;

    @ApiModelProperty(value = "IPC分类号")
    @Excel(name = "IPC分类号")
    private String ipcCodes;

    @ApiModelProperty(value = "申请人")
    @Excel(name = "申请人")
    private String applyName;

    @ApiModelProperty(value = "申请日期")
    @Excel(name = "申请日期")
    private LocalDate applyTime;

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