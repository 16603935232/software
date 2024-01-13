package com.ai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ai.entity.InstitutePublish;
import com.ai.vo.InstitutePublishVO;
import com.ai.mapper.InstitutePublishMapper;
import com.ai.service.IInstitutePublishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 【研究机构-发布表】实现层
 *
 * @author sml
 * @date 2023-10-16
 */
@Slf4j
@Service
public class InstitutePublishServiceImpl extends ServiceImpl<InstitutePublishMapper, InstitutePublish> implements IInstitutePublishService {
}
