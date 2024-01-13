package com.content.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.content.entity.MonadDirectAuthor;
import com.content.vo.MonadDirectAuthorVO;
import com.content.mapper.MonadDirectAuthorMapper;
import com.content.service.IMonadDirectAuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【直送作者通知单】实现层
 *
 * @author sml
 * @date 2023-08-07
 */
@Slf4j
@Service
public class MonadDirectAuthorServiceImpl extends ServiceImpl<MonadDirectAuthorMapper, MonadDirectAuthor> implements IMonadDirectAuthorService {
}
