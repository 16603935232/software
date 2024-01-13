package com.excel.demo.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.excel.demo.entity.Paper;
import com.excel.demo.mapper.PaperMapper;
import com.excel.demo.service.IPaperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 【论文表】实现层
 *
 * @author carl
 * @date 2022-12-13
 * @company:
 */
@Slf4j
@Service
public class PaperServiceImpl extends ServiceImpl<PaperMapper, Paper> implements IPaperService {

}
