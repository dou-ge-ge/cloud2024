package com.atguigu.cloud.repository.impl;

import com.atguigu.cloud.entity.TPay;
import com.atguigu.cloud.mapper.TPayMapper;
import com.atguigu.cloud.repository.TPayRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 支付交易表 服务实现类
 * </p>
 *
 * @author dou-ge-ge
 * @since 2024-09-06
 */
@Service
public class TPayRepositoryImpl extends ServiceImpl<TPayMapper, TPay> implements TPayRepository {

}
