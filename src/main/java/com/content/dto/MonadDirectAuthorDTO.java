package com.content.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * 【直送作者通知单】交互层
 *
 * @author sml
 * @date 2023-08-07
 */
@Data
@ApiModel(value = "【直送作者通知单】交互层")
public class MonadDirectAuthorDTO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "册数")
    private Integer copies;

    @ApiModelProperty(value = "收书作者")
    private String receivingAuthor;

    @ApiModelProperty(value = "要求到货时间")
    private LocalDate requiredDeliveryTime;

    @ApiModelProperty(value = "联系电话")
    private String telephone;

    @ApiModelProperty(value = "邮编")
    private String postalCode;

    @ApiModelProperty(value = "收货地址")
    private String deliveryAddress;

    @ApiModelProperty(value = "购书方式：0补贴出版社 赠送、1扣稿费 汇款")
    private Integer buyBookWay;

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