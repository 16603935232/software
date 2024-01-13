package com.excel.demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 【论文表】实体类
 *
 * @author carl
 * @date 2022-12-13
 * @company:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("`paper_copy1`")
public class Paper extends Model<Paper> {

    @TableId("`id`")
    @ApiModelProperty(value = "ID")
    private Long id;

    @TableField(value = "`code`")
    @ApiModelProperty(value = "CODE")
    private String code;

    @TableField(value = "`title`")
    @ApiModelProperty(value = "标题")
    private String title;

    @TableField(value = "`author`")
    @ApiModelProperty(value = "作者")
    private String author;

    @TableField(value = "`insrirution`")
    @ApiModelProperty(value = "机构，和企业一个概念")
    private String insrirution;

    @TableField(value = "`source`")
    @ApiModelProperty(value = "论文来源")
    private String source;

    @TableField(value = "`from_url`")
    @ApiModelProperty(value = "原文链接")
    private String fromUrl;

    @TableField(value = "`release_time`")
    @ApiModelProperty(value = "发表时间")
    private LocalDate releaseTime;

    @TableField(value = "`abstracts`")
    @ApiModelProperty(value = "摘要")
    private String abstracts;

    @TableField(value = "`keywords`")
    @ApiModelProperty(value = "关键字")
    private String keywords;

    @TableField(value = "`attachments`")
    @ApiModelProperty(value = "附件-JSON格式包含名称、路径")
    private String attachments;

    @TableField(value = "`ethical_governance`")
    @ApiModelProperty(value = "伦理治理：0:否，1:是")
    private Boolean ethicalGovernance;

    @TableField(value = "`paper_type`")
    @ApiModelProperty(value = "论文类别:1期刊2会议")
    private Integer paperType;

    @TableField(value = "`paper_library`")
    @ApiModelProperty(value = "论文库（1中文库  2外文库")
    private Integer paperLibrary;

    @TableField(value = "`conference_name`")
    @ApiModelProperty(value = "刊名/会议名")
    private String conferenceName;

    @TableField(value = "`doi`")
    @ApiModelProperty(value = "doi")
    private String doi;

    @TableField(value = "`volume`")
    @ApiModelProperty(value = "卷")
    private String volume;

    @TableField(value = "`stage`")
    @ApiModelProperty(value = "期")
    private String stage;

    @TableField(value = "`page_code`")
    @ApiModelProperty(value = "页码")
    private String pageCode;

    @TableField(value = "`conference_addr`")
    @ApiModelProperty(value = "会议地点")
    private String conferenceAddr;

    @TableField(value = "`sponsor`")
    @ApiModelProperty(value = "主办单位")
    private String sponsor;

    @TableField(value = "`technology_type`")
    @ApiModelProperty(value = "技术类别")
    private String technologyType;

    @TableField(value = "`industry_type`")
    @ApiModelProperty(value = "行业类别")
    private String industryType;

    @TableField(value = "`status_online`")
    @ApiModelProperty(value = "0待发布,1已发布，2重新发布")
    private Integer statusOnline;

    @TableField(value = "`deleted`", fill = FieldFill.INSERT)
    @TableLogic(value="0",delval="1")
    @ApiModelProperty(value = "是否删除，0不删，1删除")
    private Boolean deleted;

    @TableField(value = "`create_user_id`", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建人ID")
    private Long createUserId;

    @TableField(value = "`create_time`", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @TableField(value = "`update_user_id`", fill = FieldFill.UPDATE)
    @ApiModelProperty(value = "更新人ID")
    private Long updateUserId;

    @TableField(value = "`update_time`", fill = FieldFill.UPDATE)
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

}
