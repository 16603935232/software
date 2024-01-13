package com.content.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.Version;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.util.Date;


/**
 * 【初审/复审/终审报告单】实体类
 *
 * @author sml
 * @date 2023-08-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("`monad_preliminary`")
public class MonadPreliminary extends Model<MonadPreliminary> {

    @TableId("`id`")
    @ApiModelProperty(value = "主键")
    private Long id;

    @TableField(value = "`monad_id`")
    @ApiModelProperty(value = "单据id")
    private Long monadId;

    @TableField(value = "`monad_type`")
    @ApiModelProperty(value = "单据类型：0初审报告单，1复审报告单，2终审报告单")
    private Integer monadType;

    @TableField(value = "`approval_ids`")
    @ApiModelProperty(value = "审批ids")
    private String approvalIds;

    @TableField(value = "`manuscript_id`")
    @ApiModelProperty(value = "稿件id")
    private Long manuscriptId;

    @TableField(value = "`word_number`")
    @ApiModelProperty(value = "全稿字数（单位万）")
    private BigDecimal wordNumber;

    @TableField(value = "`content_characteristics`")
    @ApiModelProperty(value = "稿件内容和特点")
    private String contentCharacteristics;

    @TableField(value = "`audience`")
    @ApiModelProperty(value = "读者对象")
    private String audience;

    @TableField(value = "`social_and_economic_benefit_analysis`")
    @ApiModelProperty(value = "社会和经济效益分析")
    private String socialAndEconomicBenefitAnalysis;

    @TableField(value = "`main_problems_and_measures_solved`")
    @ApiModelProperty(value = "已经解决的主要问题和措施")
    private String mainProblemsAndMeasuresSolved;

    @TableField(value = "`unresolved_issues_and_suggested_measures`")
    @ApiModelProperty(value = "尚未解决的问题及建议措施")
    private String unresolvedIssuesAndSuggestedMeasures;

    @TableField(value = "`quality_and_conclusion`")
    @ApiModelProperty(value = "稿面质量和结论")
    private String qualityAndConclusion;

    @TableField(value = "`file_list`")
    @ApiModelProperty(value = "文件集合")
    private String fileList;

    @TableField(value = "`deleted`", fill = FieldFill.INSERT)
    @TableLogic
    @ApiModelProperty(value = "是否删除 0否 1是")
    private Boolean deleted;

    @TableField(value = "`create_user_id`", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建人")
    private Long createUserId;

    @TableField(value = "`create_time`", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @TableField(value = "`update_user_id`", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新人")
    private Long updateUserId;

    @TableField(value = "`update_time`", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
