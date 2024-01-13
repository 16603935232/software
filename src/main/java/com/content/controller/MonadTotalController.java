package com.content.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.content.result.Result;

import com.content.dto.MonadTotalDTO;
import com.content.vo.MonadTotalVO;
import com.content.entity.MonadTotal;
import com.content.utils.QueryUtil;
import com.content.service.IMonadTotalService;
import com.content.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【单据总表】控制器层
 *
 * @author sml
 * @date 2023-07-31
 */
@Slf4j
@Api(tags = {"【单据总表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/monad-total")
public class MonadTotalController {

    private final IMonadTotalService  monadTotalService;

    @ApiOperation(value = "单据总表列表查询")
    @PostMapping("/list")
    public Result<List<MonadTotalVO>> list(@RequestBody MonadTotalDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(MonadTotalVO.class,monadTotalService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, MonadTotal.class)))));
    }

    @ApiOperation(value = "单据总表分页查询")
    @PostMapping("/page")
    public Result<Page<MonadTotalVO>> page(@RequestBody MonadTotalDTO dto) {
        Page<MonadTotal> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<MonadTotal> result = monadTotalService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, MonadTotal.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(MonadTotalVO.class, result));
    }

    @ApiOperation(value = "单据总表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody MonadTotalDTO dto) {
        MonadTotal entity = BeanUtil.copyProperties(dto, MonadTotal.class);
        monadTotalService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "单据总表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody MonadTotalDTO dto) {
        MonadTotal entity = BeanUtil.copyProperties(dto, MonadTotal.class);
        return Result.ok(monadTotalService.save(entity));
    }

    @ApiOperation(value = "单据总表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody MonadTotalDTO dto) {
        MonadTotal entity = BeanUtil.copyProperties(dto, MonadTotal.class);
        return Result.ok(monadTotalService.updateById(entity));
    }

    @ApiOperation(value = "单据总表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(monadTotalService.removeById(id));
    }

    @ApiOperation(value = "单据总表详情")
    @GetMapping("/{id}")
    public Result<MonadTotalVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(monadTotalService.getById(id), MonadTotalVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(monadTotalService.removeByIds(ids));
    }


}

