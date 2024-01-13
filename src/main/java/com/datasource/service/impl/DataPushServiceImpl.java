package com.datasource.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.datasource.entity.DataPush;
import com.datasource.vo.DataPushVO;
import com.datasource.mapper.DataPushMapper;
import com.datasource.service.IDataPushService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【数据更新情况推送表】实现层
 *
 * @author shangml
 * @date 2023-12-13
 */
@Slf4j
@Service
public class DataPushServiceImpl extends ServiceImpl<DataPushMapper, DataPush> implements IDataPushService {
}
