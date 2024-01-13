package com.content.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.content.entity.BecomeBook;
import com.content.vo.BecomeBookVO;
import com.content.mapper.BecomeBookMapper;
import com.content.service.IBecomeBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【成书表】实现层
 *
 * @author sml
 * @date 2023-08-16
 */
@Slf4j
@Service
public class BecomeBookServiceImpl extends ServiceImpl<BecomeBookMapper, BecomeBook> implements IBecomeBookService {
}
