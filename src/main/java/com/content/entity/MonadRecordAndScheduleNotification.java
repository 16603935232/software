package com.content.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
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
 * 【录排通知单】实体类
 *
 * @author sml
 * @date 2023-08-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("`monad_record_and_schedule_notification`")
public class MonadRecordAndScheduleNotification extends Model<MonadRecordAndScheduleNotification> {

    @TableId("`id`")
    @ApiModelProperty(value = "主键")
    private Long id;

    @TableField(value = "`manuscript_id`")
    @ApiModelProperty(value = "稿件id")
    private Long manuscriptId;

    @TableField(value = "`type`")
    @ApiModelProperty(value = "书稿类别：0新书稿，1修订改版，2补充内容，3其他")
    private Integer type;

    @TableField(value = "`electronic_manuscript`")
    @ApiModelProperty(value = "电子稿")
    private Integer electronicManuscript;

    @TableField(value = "`manuscript_editor`")
    @ApiModelProperty(value = "发稿编辑")
    private String manuscriptEditor;

    @TableField(value = "`planned_publication_time`")
    @ApiModelProperty(value = "计划出版时间")
    private LocalDate plannedPublicationTime;

    @TableField(value = "`required_preliminary _completion_time`")
    @ApiModelProperty(value = "要求初排完时间")
    private LocalDateTime requiredPreliminary CompletionTime;

    @TableField(value = "`format`")
    @ApiModelProperty(value = "成品规格：开本")
    private Integer format;

    @TableField(value = "`wide`")
    @ApiModelProperty(value = "成品规格：宽（单位mm）")
    private Integer wide;

    @TableField(value = "`length`")
    @ApiModelProperty(value = "成品规格：长（单位mm）")
    private Integer length;

    @TableField(value = "`word`")
    @ApiModelProperty(value = "版芯尺寸：字")
    private Integer word;

    @TableField(value = "`row`")
    @ApiModelProperty(value = "版芯尺寸：行")
    private Integer row;

    @TableField(value = "`last_page_number`")
    @ApiModelProperty(value = "原稿尾页页码")
    private Integer lastPageNumber;

    @TableField(value = "`layout_color`")
    @ApiModelProperty(value = "排版色数：0黑白、1双色、2四色")
    private Integer layoutColor;

    @TableField(value = "`original_image`")
    @ApiModelProperty(value = "原稿图：0彩色照片，1彩色线条图、2黑白照片、黑白线条图")
    private String originalImage;

    @TableField(value = "`sheet_number`")
    @ApiModelProperty(value = "张数")
    private String sheetNumber;

    @TableField(value = "`typographic_units`")
    @ApiModelProperty(value = "排版单位：0社内创意中心、1社外单位")
    private Integer typographicUnits;

    @TableField(value = "`cooperative_unit_id`")
    @ApiModelProperty(value = "社外单位id")
    private Long cooperativeUnitId;

    @TableField(value = "`price`")
    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @TableField(value = "`layout_design_requirements`")
    @ApiModelProperty(value = "版式设计要求：0同《xx》书、1另有设计样，见附件、2请录排公司设计后再改")
    private Integer layoutDesignRequirements;

    @TableField(value = "`sides_number`")
    @ApiModelProperty(value = "彩色插页面数")
    private Integer sidesNumber;

    @TableField(value = "`color_insert_production unit`")
    @ApiModelProperty(value = "彩色插页制作单位")
    private String colorInsertProduction unit;

    @TableField(value = "`cover_production_unit`")
    @ApiModelProperty(value = "封面制作单位")
    private String coverProductionUnit;

    @TableField(value = "`remark`")
    @ApiModelProperty(value = "备注")
    private String remark;

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
