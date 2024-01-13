package com.ai.controller.feign;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ai.result.Result;

import com.ai.dto.InstitutePatentRelationPublishDTO;
import com.ai.vo.InstitutePatentRelationPublishVO;
import com.ai.entity.InstitutePatentRelationPublish;
import com.ai.util.QueryUtils;
import com.ai.service.IInstitutePatentRelationPublishService;
import com.ai.util.MapperUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import com.ai.excel.InstitutePatentRelationPublishExcelDTO;
import com.ai.util.ExcelUtil;
import org.springframework.web.bind.annotation.*;



import java.util.Arrays;
import java.util.List;


/**
 * 【研究机构专利关联表】控制器层
 *
 * @author sml
 * @date 2023-10-16
 */
@Slf4j
@Api(tags = {"【研究机构专利关联表】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/institute-patent-relation-publish")
public class InstitutePatentRelationPublishController {

    private final IInstitutePatentRelationPublishService  institutePatentRelationPublishService;

    @ApiOperation(value = "研究机构专利关联表列表查询")
    @PostMapping("/list")
    public Result<List<InstitutePatentRelationPublishVO>> list(@RequestBody InstitutePatentRelationPublishDTO dto) {
        return Result.ok(MapperUtils.INSTANCE.mapAsList(InstitutePatentRelationPublishVO.class,institutePatentRelationPublishService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, InstitutePatentRelationPublish.class)))));
    }

    @ApiOperation(value = "研究机构专利关联表分页查询")
    @PostMapping("/page")
    public Result<Page<InstitutePatentRelationPublishVO>> page(@RequestBody InstitutePatentRelationPublishDTO dto) {
        Page<InstitutePatentRelationPublish> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<InstitutePatentRelationPublish> result = institutePatentRelationPublishService.page(page, QueryUtils.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, InstitutePatentRelationPublish.class))));
        return Result.ok(MapperUtils.INSTANCE.mapAsPage(InstitutePatentRelationPublishVO.class, result));
    }

    @ApiOperation(value = "研究机构专利关联表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody InstitutePatentRelationPublishDTO dto) {
        InstitutePatentRelationPublish entity = BeanUtil.copyProperties(dto, InstitutePatentRelationPublish.class);
        institutePatentRelationPublishService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "研究机构专利关联表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody InstitutePatentRelationPublishDTO dto) {
        InstitutePatentRelationPublish entity = BeanUtil.copyProperties(dto, InstitutePatentRelationPublish.class);
        return Result.ok(institutePatentRelationPublishService.save(entity));
    }

    @ApiOperation(value = "研究机构专利关联表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody InstitutePatentRelationPublishDTO dto) {
        InstitutePatentRelationPublish entity = BeanUtil.copyProperties(dto, InstitutePatentRelationPublish.class);
        return Result.ok(institutePatentRelationPublishService.updateById(entity));
    }

    @ApiOperation(value = "研究机构专利关联表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(institutePatentRelationPublishService.removeById(id));
    }

    @ApiOperation(value = "研究机构专利关联表详情")
    @GetMapping("/{id}")
    public Result<InstitutePatentRelationPublishVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(institutePatentRelationPublishService.getById(id), InstitutePatentRelationPublishVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(institutePatentRelationPublishService.removeByIds(ids));
    }

    @ApiOperation(value = "研究机构专利关联表-导入Excel")
    @PostMapping("/importExcel")
    public Result<Boolean> importExcel(@RequestParam(value = "file") MultipartFile file){
        return Result.ok(institutePatentRelationPublishService.importExcel(file));
    }

    @ApiOperation(value = "研究机构专利关联表-导出Excel")
    @GetMapping("/downloadExcel")
    public void downloadExcel(@RequestBody List<Long> ids, HttpServletResponse response) {
        List<InstitutePatentRelationPublishExcelDTO> list = institutePatentRelationPublishService.downloadExcel(ids);
        ExcelUtil.downloadExcel(response,list,InstitutePatentRelationPublishExcelDTO.class);
    }

}

