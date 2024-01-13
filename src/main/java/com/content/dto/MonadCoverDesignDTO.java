package com.content.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * 【封面设计通知单】交互层
 *
 * @author sml
 * @date 2023-08-03
 */
@Data
@ApiModel(value = "【封面设计通知单】交互层")
public class MonadCoverDesignDTO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "编/著/译")
    private String compilationAndTranslation;

    @ApiModelProperty(value = "字数")
    private BigDecimal numberOfWords;

    @ApiModelProperty(value = "开本")
    private Integer format;

    @ApiModelProperty(value = "成品尺寸：宽（单位mm）")
    private Integer wide;

    @ApiModelProperty(value = "成品尺寸：长（单位mm）")
    private Integer length;

    @ApiModelProperty(value = "出版日期")
    private LocalDate publicationTime;

    @ApiModelProperty(value = "建议一稿交稿日期")
    private LocalDate suggestedTime;

    @ApiModelProperty(value = "包装工艺：0布面精装、1纸面精装、2简精装、3平装亚膜、4平装不压膜")
    private Integer packageProcess;

    @ApiModelProperty(value = "亚膜：0光膜，1亚光膜")
    private Integer mattLamination;

    @ApiModelProperty(value = "是否勒口：0不带勒口、1勒口宽度")
    private Boolean flap;

    @ApiModelProperty(value = "勒口宽度（单位mm）")
    private Integer flapWidth;

    @ApiModelProperty(value = "是否含腰封：0不含腰封、1含腰封")
    private Boolean girdle;

    @ApiModelProperty(value = "特殊工艺")
    private String specialProcess;

    @ApiModelProperty(value = "是否丛书：0非丛书、1丛书首本、2丛书非首本")
    private Integer series;

    @ApiModelProperty(value = "读者群体")
    private String readerGroup;

    @ApiModelProperty(value = "图书性质：0专业类（偏严肃）、1专业类（偏活泼）、2科普类（偏严肃）、3科普类（偏活泼）")
    private String nature;

    @ApiModelProperty(value = "色彩：0单色、1双色、2四色")
    private Integer layoutColor;

    @ApiModelProperty(value = "设计禁忌")
    private String designTaboos;

    @ApiModelProperty(value = "设计单位：0社内创意中心、1社外单位")
    private Integer designUnits;

    @ApiModelProperty(value = "社外单位id")
    private Long cooperativeUnitId;

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