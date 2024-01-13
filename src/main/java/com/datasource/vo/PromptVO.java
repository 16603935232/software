package com.datasource.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 【不再提示表】响应层
 *
 * @author shangml
 * @date 2023-01-31
 */
@Data
@ApiModel(value = "【不再提示表】返回层")
public class PromptVO {

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    }
