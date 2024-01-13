package com.content.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.content.result.Result;

import com.content.dto.MonadSampleBookNoComplianceDTO;
import com.content.vo.MonadSampleBookNoComplianceVO;
import com.content.entity.MonadSampleBookNoCompliance;
import com.content.utils.QueryUtil;
import com.content.service.IMonadSampleBookNoComplianceService;
import com.content.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;


/**
 * 【样书上交不达标说明单】控制器层
 *
 * @author sml
 * @date 2023-08-14
 */
@Slf4j
@Api(tags = {"【样书上交不达标说明单】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/monad-sample-book-no-compliance")
public class MonadSampleBookNoComplianceController {

    private final IMonadSampleBookNoComplianceService  monadSampleBookNoComplianceService;

    @ApiOperation(value = "样书上交不达标说明单列表查询")
    @PostMapping("/list")
    public Result<List<MonadSampleBookNoComplianceVO>> list(@RequestBody MonadSampleBookNoComplianceDTO dto) {
        return Result.ok(MapperUtil.INSTANCE.mapAsList(MonadSampleBookNoComplianceVO.class,monadSampleBookNoComplianceService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, MonadSampleBookNoCompliance.class)))));
    }

    @ApiOperation(value = "样书上交不达标说明单分页查询")
    @PostMapping("/page")
    public Result<Page<MonadSampleBookNoComplianceVO>> page(@RequestBody MonadSampleBookNoComplianceDTO dto) {
        Page<MonadSampleBookNoCompliance> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<MonadSampleBookNoCompliance> result = monadSampleBookNoComplianceService.page(page, QueryUtil.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, MonadSampleBookNoCompliance.class))));
        return Result.ok(MapperUtil.INSTANCE.mapAsPage(MonadSampleBookNoComplianceVO.class, result));
    }

    @ApiOperation(value = "样书上交不达标说明单添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody MonadSampleBookNoComplianceDTO dto) {
        MonadSampleBookNoCompliance entity = BeanUtil.copyProperties(dto, MonadSampleBookNoCompliance.class);
        monadSampleBookNoComplianceService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "样书上交不达标说明单添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody MonadSampleBookNoComplianceDTO dto) {
        MonadSampleBookNoCompliance entity = BeanUtil.copyProperties(dto, MonadSampleBookNoCompliance.class);
        return Result.ok(monadSampleBookNoComplianceService.save(entity));
    }

    @ApiOperation(value = "样书上交不达标说明单更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody MonadSampleBookNoComplianceDTO dto) {
        MonadSampleBookNoCompliance entity = BeanUtil.copyProperties(dto, MonadSampleBookNoCompliance.class);
        return Result.ok(monadSampleBookNoComplianceService.updateById(entity));
    }

    @ApiOperation(value = "样书上交不达标说明单删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(monadSampleBookNoComplianceService.removeById(id));
    }

    @ApiOperation(value = "样书上交不达标说明单详情")
    @GetMapping("/{id}")
    public Result<MonadSampleBookNoComplianceVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(monadSampleBookNoComplianceService.getById(id), MonadSampleBookNoComplianceVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(monadSampleBookNoComplianceService.removeByIds(ids));
    }


}

