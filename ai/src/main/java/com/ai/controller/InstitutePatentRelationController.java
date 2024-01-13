package com.ai.controller.feign;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ai.result.Result;

import com.ai.dto.InstitutePatentRelationDTO;
import com.ai.vo.InstitutePatentRelationVO;
import com.ai.entity.InstitutePatentRelation;
import com.ai.util.QueryUtils;
import com.ai.service.IInstitutePatentRelationService;
import com.ai.util.MapperUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import com.ai.excel.InstitutePatentRelationExcelDTO;
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
@RequestMapping("/institute-patent-relation")
public class InstitutePatentRelationController {

    private final IInstitutePatentRelationService  institutePatentRelationService;

    @ApiOperation(value = "研究机构专利关联表列表查询")
    @PostMapping("/list")
    public Result<List<InstitutePatentRelationVO>> list(@RequestBody InstitutePatentRelationDTO dto) {
        return Result.ok(MapperUtils.INSTANCE.mapAsList(InstitutePatentRelationVO.class,institutePatentRelationService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, InstitutePatentRelation.class)))));
    }

    @ApiOperation(value = "研究机构专利关联表分页查询")
    @PostMapping("/page")
    public Result<Page<InstitutePatentRelationVO>> page(@RequestBody InstitutePatentRelationDTO dto) {
        Page<InstitutePatentRelation> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<InstitutePatentRelation> result = institutePatentRelationService.page(page, QueryUtils.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, InstitutePatentRelation.class))));
        return Result.ok(MapperUtils.INSTANCE.mapAsPage(InstitutePatentRelationVO.class, result));
    }

    @ApiOperation(value = "研究机构专利关联表添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody InstitutePatentRelationDTO dto) {
        InstitutePatentRelation entity = BeanUtil.copyProperties(dto, InstitutePatentRelation.class);
        institutePatentRelationService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "研究机构专利关联表添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody InstitutePatentRelationDTO dto) {
        InstitutePatentRelation entity = BeanUtil.copyProperties(dto, InstitutePatentRelation.class);
        return Result.ok(institutePatentRelationService.save(entity));
    }

    @ApiOperation(value = "研究机构专利关联表更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody InstitutePatentRelationDTO dto) {
        InstitutePatentRelation entity = BeanUtil.copyProperties(dto, InstitutePatentRelation.class);
        return Result.ok(institutePatentRelationService.updateById(entity));
    }

    @ApiOperation(value = "研究机构专利关联表删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(institutePatentRelationService.removeById(id));
    }

    @ApiOperation(value = "研究机构专利关联表详情")
    @GetMapping("/{id}")
    public Result<InstitutePatentRelationVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(institutePatentRelationService.getById(id), InstitutePatentRelationVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(institutePatentRelationService.removeByIds(ids));
    }

    @ApiOperation(value = "研究机构专利关联表-导入Excel")
    @PostMapping("/importExcel")
    public Result<Boolean> importExcel(@RequestParam(value = "file") MultipartFile file){
        return Result.ok(institutePatentRelationService.importExcel(file));
    }

    @ApiOperation(value = "研究机构专利关联表-导出Excel")
    @GetMapping("/downloadExcel")
    public void downloadExcel(@RequestBody List<Long> ids, HttpServletResponse response) {
        List<InstitutePatentRelationExcelDTO> list = institutePatentRelationService.downloadExcel(ids);
        ExcelUtil.downloadExcel(response,list,InstitutePatentRelationExcelDTO.class);
    }

}

