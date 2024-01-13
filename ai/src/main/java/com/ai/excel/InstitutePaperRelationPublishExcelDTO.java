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
 * 【】交互层
 *
 * @author sml
 * @date 2023-10-16
 */
@Data
public class InstitutePaperRelationPublishExcelDTO implements Serializable {

    @ApiModelProperty(value = "ID")
    @Excel(name = "ID")
    private Long id;

    @ApiModelProperty(value = "研究机构id")
    @Excel(name = "研究机构id")
    private Long instituteId;

    @ApiModelProperty(value = "论文ID")
    @Excel(name = "论文ID")
    private Long paperId;

    @ApiModelProperty(value = "论文code")
    @Excel(name = "论文code")
    private String paperCode;

    @ApiModelProperty(value = "0:没做关联，1做关联了，2：不再做关联")
    @Excel(name = "0:没做关联，1做关联了，2：不再做关联")
    private Integer relationState;

    @ApiModelProperty(value = "上线状态：0待发布,1已发布,2重新发布")
    @Excel(name = "上线状态：0待发布,1已发布,2重新发布")
    private Integer statusOnline;

    @ApiModelProperty(value = "论文题目")
    @Excel(name = "论文题目")
    private String title;

    @ApiModelProperty(value = "发布时间")
    @Excel(name = "发布时间")
    private LocalDate releaseTime;

    @ApiModelProperty(value = "刊名/会议名")
    @Excel(name = "刊名/会议名")
    private String conferenceName;

    @ApiModelProperty(value = "作者")
    @Excel(name = "作者")
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


}