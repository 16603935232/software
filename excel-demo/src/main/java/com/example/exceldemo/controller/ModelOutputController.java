package com.example.exceldemo.controller;

import com.example.exceldemo.dto.InputDTO;
import com.example.exceldemo.entity.ModelOutput;
import com.example.exceldemo.result.Result;
import com.example.exceldemo.service.IModelOutputService;
import com.example.exceldemo.vo.OutputVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


/**
 * 【模型输出表】控制器层
 *
 * @author shangml
 * @date 2023-01-15
 */
@Slf4j
@Api(tags = {"【模型输出表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/model-output")
public class ModelOutputController {

    private final IModelOutputService modelOutputService;

    @ApiOperation(value = "模型计算")
    @PostMapping("/call")
    public Result<OutputVO> call(@RequestBody InputDTO dto) throws IOException {
        return modelOutputService.call(dto);
    }

    @ApiOperation(value = "查询方案")
    @PostMapping("/selectPlan")
    public Result<OutputVO> selectPlan(@RequestBody ModelOutput modelOutput) {
        return Result.ok(modelOutputService.selectPlan(modelOutput));
    }

    @ApiOperation(value = "保存方案")
    @PostMapping("/savePlan")
    public Result<Boolean> savePlan(@Validated @RequestBody OutputVO vo) {
        return Result.ok(modelOutputService.savePlan(vo));
    }
}

