package com.content.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.content.result.Result;

import com.content.dto.MonadDirectAuthorDTO;
import com.content.vo.MonadDirectAuthorVO;
import com.content.entity.MonadDirectAuthor;
import com.content.utils.QueryUtil;
import com.content.service.IMonadDirectAuthorService;
import com.content.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【直送作者通知单】控制器层
 *
 * @author sml
 * @date 2023-08-07
 */
@Slf4j
@Api(tags = {"【直送作者通知单】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/monad-direct-author")
public class MonadDirectAuthorController {

    private final IMonadDirectAuthorService  monadDirectAuthorService;

    @ApiOperation(value = "直送作者通知单列表查询")
    @PostMapping("/list")
    public Result<List<MonadDirectAuthorVO>> list(@RequestBody MonadDirectAuthorDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(MonadDirectAuthorVO.class,monadDirectAuthorService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, MonadDirectAuthor.class)))));
    }

    @ApiOperation(value = "直送作者通知单分页查询")
    @PostMapping("/page")
    public Result<Page<MonadDirectAuthorVO>> page(@RequestBody MonadDirectAuthorDTO dto) {
        Page<MonadDirectAuthor> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<MonadDirectAuthor> result = monadDirectAuthorService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, MonadDirectAuthor.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(MonadDirectAuthorVO.class, result));
    }

    @ApiOperation(value = "直送作者通知单添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody MonadDirectAuthorDTO dto) {
        MonadDirectAuthor entity = BeanUtil.copyProperties(dto, MonadDirectAuthor.class);
        monadDirectAuthorService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "直送作者通知单添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody MonadDirectAuthorDTO dto) {
        MonadDirectAuthor entity = BeanUtil.copyProperties(dto, MonadDirectAuthor.class);
        return Result.ok(monadDirectAuthorService.save(entity));
    }

    @ApiOperation(value = "直送作者通知单更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody MonadDirectAuthorDTO dto) {
        MonadDirectAuthor entity = BeanUtil.copyProperties(dto, MonadDirectAuthor.class);
        return Result.ok(monadDirectAuthorService.updateById(entity));
    }

    @ApiOperation(value = "直送作者通知单删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(monadDirectAuthorService.removeById(id));
    }

    @ApiOperation(value = "直送作者通知单详情")
    @GetMapping("/{id}")
    public Result<MonadDirectAuthorVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(monadDirectAuthorService.getById(id), MonadDirectAuthorVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(monadDirectAuthorService.removeByIds(ids));
    }


}

