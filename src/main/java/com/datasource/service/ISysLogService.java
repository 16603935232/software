package com.datasource.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.datasource.entity.SysLog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.datasource.vo.SysLogVO;
import com.datasource.dto.SysLogDTO;
import java.util.List;

/**
 * 【日志表】代理层
 *
 * @author liuzhiyu
 * @date 2023-07-04
 */
public interface ISysLogService extends IService<SysLog> {
}
