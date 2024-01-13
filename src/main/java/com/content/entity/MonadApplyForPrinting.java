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
 * 【申请开印刷委托书】实体类
 *
 * @author sml
 * @date 2023-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("`monad_apply_for_printing`")
public class MonadApplyForPrinting extends Model<MonadApplyForPrinting> {

    @TableId("`id`")
    @ApiModelProperty(value = "主键")
    private Long id;

    @TableField(value = "`manuscript_id`")
    @ApiModelProperty(value = "稿件id")
    private Long manuscriptId;

    @TableField(value = "`enterprise_name`")
    @ApiModelProperty(value = "印刷企业名称")
    private String enterpriseName;

    @TableField(value = "`enterprise_address`")
    @ApiModelProperty(value = "印刷企业地址")
    private String enterpriseAddress;

    @TableField(value = "`edition`")
    @ApiModelProperty(value = "版次")
    private String edition;

    @TableField(value = "`format`")
    @ApiModelProperty(value = "成品规格开本")
    private Integer format;

    @TableField(value = "`word_number`")
    @ApiModelProperty(value = "字数（单位千）")
    private BigDecimal wordNumber;

    @TableField(value = "`page_no`")
    @ApiModelProperty(value = "页数")
    private Integer pageNo;

    @TableField(value = "`current_print_run`")
    @ApiModelProperty(value = "印数")
    private Integer currentPrintRun;

    @TableField(value = "`sheet`")
    @ApiModelProperty(value = "印张")
    private Integer sheet;

    @TableField(value = "`fix_price`")
    @ApiModelProperty(value = "定价")
    private BigDecimal fixPrice;

    @TableField(value = "`editor_author_translator`")
    @ApiModelProperty(value = "编/著/译")
    private String editorAuthorTranslator;

    @TableField(value = "`binding`")
    @ApiModelProperty(value = "装帧")
    private String binding;

    @TableField(value = "`printing_completion_time`")
    @ApiModelProperty(value = "印完日期")
    private LocalDate printingCompletionTime;

    @TableField(value = "`submission_time`")
    @ApiModelProperty(value = "交书日期")
    private LocalDate submissionTime;

    @TableField(value = "`contact`")
    @ApiModelProperty(value = "联系人")
    private String contact;

    @TableField(value = "`telephone`")
    @ApiModelProperty(value = "联系电话")
    private String telephone;

    @TableField(value = "`textbook`")
    @ApiModelProperty(value = "是否为教材：0否，1是")
    private Boolean textbook;

    @TableField(value = "`book_category`")
    @ApiModelProperty(value = "图书分类")
    private String bookCategory;

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
