package com.atguigu.cloud.service;

import com.atguigu.cloud.entity.TPay;

import java.util.List;

public interface PayService {
    public int add(TPay tPay);
    public int delete( Integer id);
    public int update(TPay tPay);

    public TPay getById(Integer id);

    public List<TPay> getAll();
}
