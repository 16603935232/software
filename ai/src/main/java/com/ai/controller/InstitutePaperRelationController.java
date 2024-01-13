package com.ai.controller.feign;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ai.result.Result;

import com.ai.dto.InstitutePaperRelationDTO;
import com.ai.vo.InstitutePaperRelationVO;
import com.ai.entity.InstitutePaperRelation;
import com.ai.util.QueryUtils;
import com.ai.service.IInstitutePaperRelationService;
import com.ai.util.MapperUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import com.ai.excel.InstitutePaperRelationExcelDTO;
import com.ai.util.ExcelUtil;
import org.springframework.web.bind.annotation.*;



import java.util.Arrays;
import java.util.List;


/**
 * 【】控制器层
 *
 * @author sml
 * @date 2023-10-16
 */
@Slf4j
@Api(tags = {"【】模块Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/institute-paper-relation")
public class InstitutePaperRelationController {

    private final IInstitutePaperRelationService  institutePaperRelationService;

    @ApiOperation(value = "列表查询")
    @PostMapping("/list")
    public Result<List<InstitutePaperRelationVO>> list(@RequestBody InstitutePaperRelationDTO dto) {
        return Result.ok(MapperUtils.INSTANCE.mapAsList(InstitutePaperRelationVO.class,institutePaperRelationService.list(Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, InstitutePaperRelation.class)))));
    }

    @ApiOperation(value = "分页查询")
    @PostMapping("/page")
    public Result<Page<InstitutePaperRelationVO>> page(@RequestBody InstitutePaperRelationDTO dto) {
        Page<InstitutePaperRelation> page = new Page<>(dto.getCurrent(), dto.getSize());
        Page<InstitutePaperRelation> result = institutePaperRelationService.page(page, QueryUtils.dynamicSort(dto.getSortBy(), Wrappers.query(BeanUtil.copyProperties(dto, InstitutePaperRelation.class))));
        return Result.ok(MapperUtils.INSTANCE.mapAsPage(InstitutePaperRelationVO.class, result));
    }

    @ApiOperation(value = "添加,并获取ID")
    @PostMapping("/insertReturnId")
    public Result<Long> insertReturnId(@RequestBody InstitutePaperRelationDTO dto) {
        InstitutePaperRelation entity = BeanUtil.copyProperties(dto, InstitutePaperRelation.class);
        institutePaperRelationService.save(entity);
        return Result.ok(entity.getId());
    }

    @ApiOperation(value = "添加")
    @PostMapping
    public Result<Boolean> insert(@RequestBody InstitutePaperRelationDTO dto) {
        InstitutePaperRelation entity = BeanUtil.copyProperties(dto, InstitutePaperRelation.class);
        return Result.ok(institutePaperRelationService.save(entity));
    }

    @ApiOperation(value = "更新")
    @PutMapping
    public Result<Boolean> update(@RequestBody InstitutePaperRelationDTO dto) {
        InstitutePaperRelation entity = BeanUtil.copyProperties(dto, InstitutePaperRelation.class);
        return Result.ok(institutePaperRelationService.updateById(entity));
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        return Result.ok(institutePaperRelationService.removeById(id));
    }

    @ApiOperation(value = "详情")
    @GetMapping("/{id}")
    public Result<InstitutePaperRelationVO> detail(@PathVariable("id") Long id) {
        return Result.ok(BeanUtil.copyProperties(institutePaperRelationService.getById(id), InstitutePaperRelationVO.class));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids){
        return Result.ok(institutePaperRelationService.removeByIds(ids));
    }

    @ApiOperation(value = "-导入Excel")
    @PostMapping("/importExcel")
    public Result<Boolean> importExcel(@RequestParam(value = "file") MultipartFile file){
        return Result.ok(institutePaperRelationService.importExcel(file));
    }

    @ApiOperation(value = "-导出Excel")
    @GetMapping("/downloadExcel")
    public void downloadExcel(@RequestBody List<Long> ids, HttpServletResponse response) {
        List<InstitutePaperRelationExcelDTO> list = institutePaperRelationService.downloadExcel(ids);
        ExcelUtil.downloadExcel(response,list,InstitutePaperRelationExcelDTO.class);
    }

}

