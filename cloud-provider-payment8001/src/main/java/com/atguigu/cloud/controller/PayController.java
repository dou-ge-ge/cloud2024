package com.atguigu.cloud.controller;

import com.atguigu.cloud.entity.TPay;
import com.atguigu.cloud.entity.TPayDto;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@Tag(name = "支付微服务模块", description = "支付增删改查")
public class PayController {

    @Resource
    private PayService payService;

    @PostMapping(value = "/pay/add")
    @Operation(summary = "新增", description = "新增支付流水")
    public ResultData<String> addPay(@RequestBody TPay tPay) {
        int i = payService.add(tPay);
        return ResultData.success("插入成功:" + i);
    }

    @DeleteMapping(value = "/pay/del/{id}")
    public ResultData<String> deletePay(@PathVariable("id") Integer id) {
        int i = payService.delete(id);
        return ResultData.success("删除成功:" + i);
    }

    @PostMapping(value = "/pay/upd")
    public ResultData<String> updatePay(@RequestBody TPayDto tPayDto) {
        TPay tPay = new TPay();
        BeanUtils.copyProperties(tPayDto, tPay);
        int i = payService.update(tPay);
        return ResultData.success("更新成功:" + i);
    }

    @GetMapping(value = "/pay/get/{id}")
    public ResultData<TPay> getById(@PathVariable("id") Integer id) {
//        try {
//            TimeUnit.SECONDS.sleep(62);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        log.info(String.valueOf(id) + "*********");
        return ResultData.success(payService.getById(id));
    }

    @GetMapping(value = "/pay/getAll")
    public ResultData<List<TPay>> getAll() {
        return ResultData.success(payService.getAll());
    }

    @Value("${server.port}")
    private String prot;

    @GetMapping(value = "/pay/get/info")
    public String getInfoByConsul(@Value("${atguigu.info}") String atGuiguInfo) {
        return "atGuiguInfo:" + atGuiguInfo + " prot:" + prot;
    }
}
