package com.example.exceldemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.exceldemo.dto.InputDTO;
import com.example.exceldemo.entity.ModelOutput;
import com.example.exceldemo.result.Result;
import com.example.exceldemo.vo.OutputVO;

import java.io.IOException;

/**
 * 【模型输出表】代理层
 *
 * @author shangml
 * @date 2023-01-15
 */
public interface IModelOutputService extends IService<ModelOutput> {

    /**
     * 模型计算
     * @param dto
     * @return
     * @throws IOException
     */
    Result<OutputVO> call(InputDTO dto) throws IOException;

    /**
     * 保存方案
     * @param vo
     * @return
     */
    Boolean savePlan(OutputVO vo);

    /**
     * 查询方案
     * @param modelOutput
     * @return
     */
    OutputVO selectPlan(ModelOutput modelOutput);
}
