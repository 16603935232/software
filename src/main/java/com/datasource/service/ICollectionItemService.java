package com.datasource.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.datasource.entity.CollectionItem;
import com.baomidou.mybatisplus.extension.service.IService;
import com.datasource.vo.CollectionItemVO;
import com.datasource.dto.CollectionItemDTO;
import java.util.List;

/**
 * 【采集提需-采集项表】代理层
 *
 * @author shangmingliang
 * @date 2022-12-21
 */
public interface ICollectionItemService extends IService<CollectionItem> {
}
