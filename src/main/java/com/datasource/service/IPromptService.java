package com.datasource.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.datasource.entity.Prompt;
import com.baomidou.mybatisplus.extension.service.IService;
import com.datasource.vo.PromptVO;
import com.datasource.dto.PromptDTO;
import java.util.List;

/**
 * 【不再提示表】代理层
 *
 * @author shangml
 * @date 2023-01-31
 */
public interface IPromptService extends IService<Prompt> {
}
