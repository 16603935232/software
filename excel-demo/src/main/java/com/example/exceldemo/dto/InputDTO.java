package com.example.exceldemo.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.example.exceldemo.entity.NewInput;
import com.example.exceldemo.entity.StockInput;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author shangml
 */
@ApiModel("输入数据dto对象")
@Data
@Accessors(chain = true)
public class InputDTO {

    @ApiModelProperty(value = "新增产业能耗设定输入对象集合")
    @NotNull(message = "新增产业能耗设定输入对象集合不能为空")
    private List<NewInput> newInputList;

    @ApiModelProperty("存量产业能耗设定输入对象集合")
    @NotNull(message = "存量产业能耗设定输入对象集合不能为空")
    private List<StockInput> stockInputList;
}
