package com.datasource.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.datasource.entity.DataPush;
import com.baomidou.mybatisplus.extension.service.IService;
import com.datasource.vo.DataPushVO;
import com.datasource.dto.DataPushDTO;
import java.util.List;

/**
 * 【数据更新情况推送表】代理层
 *
 * @author shangml
 * @date 2023-12-13
 */
public interface IDataPushService extends IService<DataPush> {
}
