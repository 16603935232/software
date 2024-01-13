package com.content.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.content.result.Result;

import com.content.dto.MonadCoverDesignDTO;
import com.content.vo.MonadCoverDesignVO;
import com.content.entity.MonadCoverDesign;
import com.content.utils.QueryUtil;
import com.content.service.IMonadCoverDesignService;
import com.content.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【封面设计通知单】控制器层
 *
 * @author sml
 * @date 2023-08-03
 */
@Slf4j
@Api(tags = {"【封面设计通知单】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/monad-cover-design")
public class MonadCoverDesignController {

    private final IMonadCoverDesignService  monadCoverDesignService;

    @ApiOperation(value = "封面设计通知单列表查询")
    @PostMapping("/list")
    public Result<List<MonadCoverDesignVO>> list(@RequestBody MonadCoverDesignDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(MonadCoverDesignVO.class,monadCoverDesignService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, MonadCoverDesign.class)))));
    }

    @ApiOperation(value = "封面设计通知单分页查询")
    @PostMapping("/page")
    public Result<Page<MonadCoverDesignVO>> page(@RequestBody MonadCoverDesignDTO dto) {
        Page<MonadCoverDesign> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<MonadCoverDesign> result = monadCoverDesignService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, MonadCoverDesign.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(MonadCoverDesignVO.class, result));
    }

    @ApiOperation(value = "封面设计通知单添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody MonadCoverDesignDTO dto) {
        MonadCoverDesign entity = BeanUtil.copyProperties(dto, MonadCoverDesign.class);
        monadCoverDesignService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "封面设计通知单添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody MonadCoverDesignDTO dto) {
        MonadCoverDesign entity = BeanUtil.copyProperties(dto, MonadCoverDesign.class);
        return Result.ok(monadCoverDesignService.save(entity));
    }

    @ApiOperation(value = "封面设计通知单更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody MonadCoverDesignDTO dto) {
        MonadCoverDesign entity = BeanUtil.copyProperties(dto, MonadCoverDesign.class);
        return Result.ok(monadCoverDesignService.updateById(entity));
    }

    @ApiOperation(value = "封面设计通知单删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(monadCoverDesignService.removeById(id));
    }

    @ApiOperation(value = "封面设计通知单详情")
    @GetMapping("/{id}")
    public Result<MonadCoverDesignVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(monadCoverDesignService.getById(id), MonadCoverDesignVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(monadCoverDesignService.removeByIds(ids));
    }


}

