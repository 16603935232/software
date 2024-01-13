package com.datasource.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.datasource.entity.CollectionItem;
import com.datasource.vo.CollectionItemVO;
import com.datasource.mapper.CollectionItemMapper;
import com.datasource.service.ICollectionItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【采集提需-采集项表】实现层
 *
 * @author shangmingliang
 * @date 2022-12-21
 */
@Slf4j
@Service
public class CollectionItemServiceImpl extends ServiceImpl<CollectionItemMapper, CollectionItem> implements ICollectionItemService {
}
