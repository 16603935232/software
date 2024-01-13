package com.content.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.content.result.Result;

import com.content.dto.MonadApplyForPrintingDTO;
import com.content.vo.MonadApplyForPrintingVO;
import com.content.entity.MonadApplyForPrinting;
import com.content.utils.QueryUtil;
import com.content.service.IMonadApplyForPrintingService;
import com.content.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【申请开印刷委托书】控制器层
 *
 * @author sml
 * @date 2023-08-14
 */
@Slf4j
@Api(tags = {"【申请开印刷委托书】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/monad-apply-for-printing")
public class MonadApplyForPrintingController {

    private final IMonadApplyForPrintingService  monadApplyForPrintingService;

    @ApiOperation(value = "申请开印刷委托书列表查询")
    @PostMapping("/list")
    public Result<List<MonadApplyForPrintingVO>> list(@RequestBody MonadApplyForPrintingDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(MonadApplyForPrintingVO.class,monadApplyForPrintingService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, MonadApplyForPrinting.class)))));
    }

    @ApiOperation(value = "申请开印刷委托书分页查询")
    @PostMapping("/page")
    public Result<Page<MonadApplyForPrintingVO>> page(@RequestBody MonadApplyForPrintingDTO dto) {
        Page<MonadApplyForPrinting> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<MonadApplyForPrinting> result = monadApplyForPrintingService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, MonadApplyForPrinting.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(MonadApplyForPrintingVO.class, result));
    }

    @ApiOperation(value = "申请开印刷委托书添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody MonadApplyForPrintingDTO dto) {
        MonadApplyForPrinting entity = BeanUtil.copyProperties(dto, MonadApplyForPrinting.class);
        monadApplyForPrintingService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "申请开印刷委托书添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody MonadApplyForPrintingDTO dto) {
        MonadApplyForPrinting entity = BeanUtil.copyProperties(dto, MonadApplyForPrinting.class);
        return Result.ok(monadApplyForPrintingService.save(entity));
    }

    @ApiOperation(value = "申请开印刷委托书更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody MonadApplyForPrintingDTO dto) {
        MonadApplyForPrinting entity = BeanUtil.copyProperties(dto, MonadApplyForPrinting.class);
        return Result.ok(monadApplyForPrintingService.updateById(entity));
    }

    @ApiOperation(value = "申请开印刷委托书删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(monadApplyForPrintingService.removeById(id));
    }

    @ApiOperation(value = "申请开印刷委托书详情")
    @GetMapping("/{id}")
    public Result<MonadApplyForPrintingVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(monadApplyForPrintingService.getById(id), MonadApplyForPrintingVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(monadApplyForPrintingService.removeByIds(ids));
    }


}

