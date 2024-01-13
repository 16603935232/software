package com.content.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * 【录排通知单】交互层
 *
 * @author sml
 * @date 2023-08-02
 */
@Data
@ApiModel(value = "【录排通知单】交互层")
public class MonadRecordAndScheduleNotificationDTO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "稿件id")
    private Long manuscriptId;

    @ApiModelProperty(value = "书稿类别：0新书稿，1修订改版，2补充内容，3其他")
    private Integer type;

    @ApiModelProperty(value = "电子稿")
    private Integer electronicManuscript;

    @ApiModelProperty(value = "发稿编辑")
    private String manuscriptEditor;

    @ApiModelProperty(value = "计划出版时间")
    private LocalDate plannedPublicationTime;

    @ApiModelProperty(value = "要求初排完时间")
    private LocalDateTime requiredPreliminary CompletionTime;

    @ApiModelProperty(value = "成品规格：开本")
    private Integer format;

    @ApiModelProperty(value = "成品规格：宽（单位mm）")
    private Integer wide;

    @ApiModelProperty(value = "成品规格：长（单位mm）")
    private Integer length;

    @ApiModelProperty(value = "版芯尺寸：字")
    private Integer word;

    @ApiModelProperty(value = "版芯尺寸：行")
    private Integer row;

    @ApiModelProperty(value = "原稿尾页页码")
    private Integer lastPageNumber;

    @ApiModelProperty(value = "排版色数：0黑白、1双色、2四色")
    private Integer layoutColor;

    @ApiModelProperty(value = "原稿图：0彩色照片，1彩色线条图、2黑白照片、黑白线条图")
    private String originalImage;

    @ApiModelProperty(value = "张数")
    private String sheetNumber;

    @ApiModelProperty(value = "排版单位：0社内创意中心、1社外单位")
    private Integer typographicUnits;

    @ApiModelProperty(value = "社外单位id")
    private Long cooperativeUnitId;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "版式设计要求：0同《xx》书、1另有设计样，见附件、2请录排公司设计后再改")
    private Integer layoutDesignRequirements;

    @ApiModelProperty(value = "彩色插页面数")
    private Integer sidesNumber;

    @ApiModelProperty(value = "彩色插页制作单位")
    private String colorInsertProduction unit;

    @ApiModelProperty(value = "封面制作单位")
    private String coverProductionUnit;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "文件集合")
    private String fileList;

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

    @ApiModelProperty(value = "分页大小")
    private Integer size = 20;

    @ApiModelProperty(value = "当前页")
    private Integer current = 1;

    @ApiModelProperty(value = "排序字段")
    private String sortBy;
}