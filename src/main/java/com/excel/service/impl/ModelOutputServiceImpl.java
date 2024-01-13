package com.excel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.excel.entity.ModelOutput;
import com.excel.vo.ModelOutputVO;
import com.excel.mapper.ModelOutputMapper;
import com.excel.service.IModelOutputService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【模型输出表】实现层
 *
 * @author shangml
 * @date 2023-01-15
 */
@Slf4j
@Service
public class ModelOutputServiceImpl extends ServiceImpl<ModelOutputMapper, ModelOutput> implements IModelOutputService {
}
