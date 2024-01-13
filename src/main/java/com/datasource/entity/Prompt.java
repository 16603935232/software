package com.datasource.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.Version;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.util.Date;


/**
 * 【不再提示表】实体类
 *
 * @author shangml
 * @date 2023-01-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("`prompt`")
public class Prompt extends Model<Prompt> {

    @TableId("`id`")
    @ApiModelProperty(value = "主键")
    private Integer id;

    @TableField(value = "`user_id`")
    @ApiModelProperty(value = "用户id")
    private Long userId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
