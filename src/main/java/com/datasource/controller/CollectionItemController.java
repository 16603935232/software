package com.datasource.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.datasource.result.Result;

import com.datasource.dto.CollectionItemDTO;
import com.datasource.vo.CollectionItemVO;
import com.datasource.entity.CollectionItem;
import com.datasource.utils.QueryUtil;
import com.datasource.service.ICollectionItemService;
import com.datasource.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【采集提需-采集项表】控制器层
 *
 * @author shangmingliang
 * @date 2022-12-21
 */
@Slf4j
@Api(tags = {"【采集提需-采集项表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/collection-item")
public class CollectionItemController {

    private final ICollectionItemService  collectionItemService;

    @ApiOperation(value = "采集提需-采集项表列表查询")
    @PostMapping("/list")
    public Result<List<CollectionItemVO>> list(@RequestBody CollectionItemDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(CollectionItemVO.class,collectionItemService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, CollectionItem.class)))));
    }

    @ApiOperation(value = "采集提需-采集项表分页查询")
    @PostMapping("/page")
    public Result<Page<CollectionItemVO>> page(@RequestBody CollectionItemDTO dto) {
        Page<CollectionItem> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<CollectionItem> result = collectionItemService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, CollectionItem.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(CollectionItemVO.class, result));
    }

    @ApiOperation(value = "采集提需-采集项表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody CollectionItemDTO dto) {
        CollectionItem entity = BeanUtil.copyProperties(dto, CollectionItem.class);
        collectionItemService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "采集提需-采集项表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody CollectionItemDTO dto) {
        CollectionItem entity = BeanUtil.copyProperties(dto, CollectionItem.class);
        return Result.ok(collectionItemService.save(entity));
    }

    @ApiOperation(value = "采集提需-采集项表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody CollectionItemDTO dto) {
        CollectionItem entity = BeanUtil.copyProperties(dto, CollectionItem.class);
        return Result.ok(collectionItemService.updateById(entity));
    }

    @ApiOperation(value = "采集提需-采集项表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(collectionItemService.removeById(id));
    }

    @ApiOperation(value = "采集提需-采集项表详情")
    @GetMapping("/{id}")
    public Result<CollectionItemVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(collectionItemService.getById(id), CollectionItemVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(collectionItemService.removeByIds(ids));
    }


}

