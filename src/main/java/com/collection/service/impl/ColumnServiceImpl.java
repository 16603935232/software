package com.collection.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.collection.entity.Column;
import com.collection.vo.ColumnVO;
import com.collection.mapper.ColumnMapper;
import com.collection.service.IColumnService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【栏目表】实现层
 *
 * @author lzy
 * @date 2023-04-06
 */
@Slf4j
@Service
public class ColumnServiceImpl extends ServiceImpl<ColumnMapper, Column> implements IColumnService {
}
