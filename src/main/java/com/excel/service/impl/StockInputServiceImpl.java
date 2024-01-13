package com.excel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.excel.entity.StockInput;
import com.excel.vo.StockInputVO;
import com.excel.mapper.StockInputMapper;
import com.excel.service.IStockInputService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【新增产业能耗设定输入表】实现层
 *
 * @author shangml
 * @date 2023-01-15
 */
@Slf4j
@Service
public class StockInputServiceImpl extends ServiceImpl<StockInputMapper, StockInput> implements IStockInputService {
}
