package com.content.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.content.result.Result;

import com.content.dto.MonadLastInstanceDTO;
import com.content.vo.MonadLastInstanceVO;
import com.content.entity.MonadLastInstance;
import com.content.utils.QueryUtil;
import com.content.service.IMonadLastInstanceService;
import com.content.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【终审报告单】控制器层
 *
 * @author sml
 * @date 2023-08-08
 */
@Slf4j
@Api(tags = {"【终审报告单】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/monad-last-instance")
public class MonadLastInstanceController {

    private final IMonadLastInstanceService  monadLastInstanceService;

    @ApiOperation(value = "终审报告单列表查询")
    @PostMapping("/list")
    public Result<List<MonadLastInstanceVO>> list(@RequestBody MonadLastInstanceDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(MonadLastInstanceVO.class,monadLastInstanceService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, MonadLastInstance.class)))));
    }

    @ApiOperation(value = "终审报告单分页查询")
    @PostMapping("/page")
    public Result<Page<MonadLastInstanceVO>> page(@RequestBody MonadLastInstanceDTO dto) {
        Page<MonadLastInstance> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<MonadLastInstance> result = monadLastInstanceService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, MonadLastInstance.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(MonadLastInstanceVO.class, result));
    }

    @ApiOperation(value = "终审报告单添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody MonadLastInstanceDTO dto) {
        MonadLastInstance entity = BeanUtil.copyProperties(dto, MonadLastInstance.class);
        monadLastInstanceService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "终审报告单添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody MonadLastInstanceDTO dto) {
        MonadLastInstance entity = BeanUtil.copyProperties(dto, MonadLastInstance.class);
        return Result.ok(monadLastInstanceService.save(entity));
    }

    @ApiOperation(value = "终审报告单更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody MonadLastInstanceDTO dto) {
        MonadLastInstance entity = BeanUtil.copyProperties(dto, MonadLastInstance.class);
        return Result.ok(monadLastInstanceService.updateById(entity));
    }

    @ApiOperation(value = "终审报告单删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(monadLastInstanceService.removeById(id));
    }

    @ApiOperation(value = "终审报告单详情")
    @GetMapping("/{id}")
    public Result<MonadLastInstanceVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(monadLastInstanceService.getById(id), MonadLastInstanceVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(monadLastInstanceService.removeByIds(ids));
    }


}

