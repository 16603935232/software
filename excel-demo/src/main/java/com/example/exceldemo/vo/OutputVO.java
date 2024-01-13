package com.example.exceldemo.vo;

import com.example.exceldemo.entity.ModelOutput;
import com.example.exceldemo.entity.NewInput;
import com.example.exceldemo.entity.StockInput;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author shangml
 */
@ApiModel("输入数据dto对象")
@Data
@Accessors(chain = true)
public class OutputVO {

    @ApiModelProperty(value = "区域名称")
    @NotEmpty(message = "区域名称不能为空")
    private String areaName;

    @ApiModelProperty(value = "区域编码")
    @NotEmpty(message = "区域编码不能为空")
    private String areaCode;

    @ApiModelProperty(value = "方案名称")
    @NotEmpty(message = "方案名称不能为空")
    private String planName;

    @ApiModelProperty(value = "新增产业能耗设定输入对象集合")
    @NotNull(message = "新增产业能耗设定输入对象集合不能为空")
    private List<NewInput> newInputList;

    @ApiModelProperty("存量产业能耗设定输入对象集合")
    @NotNull(message = "存量产业能耗设定输入对象集合不能为空")
    private List<StockInput> stockInputList;

    @NotNull(message = "存量产业能耗设定输入对象集合不能为空")
    @ApiModelProperty("模型输出对象集合不能为空")
    private List<ModelOutput> modelOutputList;
}
