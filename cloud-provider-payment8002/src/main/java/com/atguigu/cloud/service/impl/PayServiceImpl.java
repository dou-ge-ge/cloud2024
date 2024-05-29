package com.atguigu.cloud.service.impl;

import com.atguigu.cloud.entity.TPay;
import com.atguigu.cloud.mapper.TPayMapper;
import com.atguigu.cloud.service.PayService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PayServiceImpl implements PayService {
    @Resource
    private TPayMapper payMapper;

    @Override
    public int add(TPay tPay) {
        return payMapper.insert(tPay);
    }

    @Override
    public int delete( Integer id) {
        return payMapper.deleteById(id);
    }

    @Override
    public int update(TPay tPay) {
        return payMapper.updateById(tPay);
    }

    @Override
    public TPay getById(Integer id) {
        return payMapper.selectById(id);
    }

    @Override
    public List<TPay> getAll() {
        Wrapper<TPay> wrapper = new QueryWrapper<>();
        return payMapper.selectList(wrapper);
    }
}
