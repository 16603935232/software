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
 * 【成书表】实体类
 *
 * @author sml
 * @date 2023-08-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("`become_book`")
public class BecomeBook extends Model<BecomeBook> {

    @TableId("`id`")
    @ApiModelProperty(value = "主键")
    private Long id;

    @TableField(value = "`manuscript_id`")
    @ApiModelProperty(value = "稿件id")
    private Long manuscriptId;

    @TableField(value = "`row`")
    @ApiModelProperty(value = "版芯尺寸：行")
    private Integer row;

    @TableField(value = "`word`")
    @ApiModelProperty(value = "版芯尺寸：字")
    private Integer word;

    @TableField(value = "`format`")
    @ApiModelProperty(value = "成品规格：开本")
    private Integer format;

    @TableField(value = "`product_size_length`")
    @ApiModelProperty(value = "成品规格长")
    private Integer productSizeLength;

    @TableField(value = "`product_size_width`")
    @ApiModelProperty(value = "成品规格宽")
    private Integer productSizeWidth;

    @TableField(value = "`sheet`")
    @ApiModelProperty(value = "印张")
    private BigDecimal sheet;

    @TableField(value = "`color_insert`")
    @ApiModelProperty(value = "彩插")
    private String colorInsert;

    @TableField(value = "`book_layout_word_number`")
    @ApiModelProperty(value = "图书版面字数")
    private BigDecimal bookLayoutWordNumber;

    @TableField(value = "`word_number`")
    @ApiModelProperty(value = "图书版权页字数")
    private BigDecimal wordNumber;

    @TableField(value = "`joint_reviewer`")
    @ApiModelProperty(value = "联合审稿人")
    private String jointReviewer;

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
