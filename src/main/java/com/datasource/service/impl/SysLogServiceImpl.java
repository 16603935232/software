package com.datasource.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.datasource.entity.SysLog;
import com.datasource.vo.SysLogVO;
import com.datasource.mapper.SysLogMapper;
import com.datasource.service.ISysLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【日志表】实现层
 *
 * @author liuzhiyu
 * @date 2023-07-04
 */
@Slf4j
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements ISysLogService {
}
