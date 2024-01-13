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
 * 【封面设计通知单】实体类
 *
 * @author sml
 * @date 2023-08-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("`monad_cover_design`")
public class MonadCoverDesign extends Model<MonadCoverDesign> {

    @TableId("`id`")
    @ApiModelProperty(value = "主键")
    private Long id;

    @TableField(value = "`compilation_and_Translation`")
    @ApiModelProperty(value = "编/著/译")
    private String compilationAndTranslation;

    @TableField(value = "`number_of_words`")
    @ApiModelProperty(value = "字数")
    private BigDecimal numberOfWords;

    @TableField(value = "`format`")
    @ApiModelProperty(value = "开本")
    private Integer format;

    @TableField(value = "`wide`")
    @ApiModelProperty(value = "成品尺寸：宽（单位mm）")
    private Integer wide;

    @TableField(value = "`length`")
    @ApiModelProperty(value = "成品尺寸：长（单位mm）")
    private Integer length;

    @TableField(value = "`publication_time`")
    @ApiModelProperty(value = "出版日期")
    private LocalDate publicationTime;

    @TableField(value = "`suggested_time`")
    @ApiModelProperty(value = "建议一稿交稿日期")
    private LocalDate suggestedTime;

    @TableField(value = "`package_process`")
    @ApiModelProperty(value = "包装工艺：0布面精装、1纸面精装、2简精装、3平装亚膜、4平装不压膜")
    private Integer packageProcess;

    @TableField(value = "`matt_lamination`")
    @ApiModelProperty(value = "亚膜：0光膜，1亚光膜")
    private Integer mattLamination;

    @TableField(value = "`flap`")
    @ApiModelProperty(value = "是否勒口：0不带勒口、1勒口宽度")
    private Boolean flap;

    @TableField(value = "`flap_width`")
    @ApiModelProperty(value = "勒口宽度（单位mm）")
    private Integer flapWidth;

    @TableField(value = "`girdle`")
    @ApiModelProperty(value = "是否含腰封：0不含腰封、1含腰封")
    private Boolean girdle;

    @TableField(value = "`special_process`")
    @ApiModelProperty(value = "特殊工艺")
    private String specialProcess;

    @TableField(value = "`series`")
    @ApiModelProperty(value = "是否丛书：0非丛书、1丛书首本、2丛书非首本")
    private Integer series;

    @TableField(value = "`reader_group`")
    @ApiModelProperty(value = "读者群体")
    private String readerGroup;

    @TableField(value = "`nature`")
    @ApiModelProperty(value = "图书性质：0专业类（偏严肃）、1专业类（偏活泼）、2科普类（偏严肃）、3科普类（偏活泼）")
    private String nature;

    @TableField(value = "`layout_color`")
    @ApiModelProperty(value = "色彩：0单色、1双色、2四色")
    private Integer layoutColor;

    @TableField(value = "`design_taboos`")
    @ApiModelProperty(value = "设计禁忌")
    private String designTaboos;

    @TableField(value = "`design_units`")
    @ApiModelProperty(value = "设计单位：0社内创意中心、1社外单位")
    private Integer designUnits;

    @TableField(value = "`cooperative_unit_id`")
    @ApiModelProperty(value = "社外单位id")
    private Long cooperativeUnitId;

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
