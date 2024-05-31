package com.atguigu.cloud.controller;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.atguigu.cloud.apis.PayFeignApi;
import com.atguigu.cloud.entity.TPayDto;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.resp.ReturnCodeEnum;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@RestController
public class OrderController {
    //    public static final String PaymentSrv_URL = "http://localhost:8001";
    @Resource
    private PayFeignApi payFeignApi;


    @GetMapping(value = "/feign/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id) {
        log.info("feign！！！！");
        ResultData resultData = null;
        try {
            System.out.println("调用开始---" + DateUtil.now());
            resultData = payFeignApi.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("调用结束---" + DateUtil.now());
            resultData = ResultData.fail(ReturnCodeEnum.HTTP_ERROR_500.getCode(), e.getMessage());
        }
        return resultData;
    }

    @GetMapping(value = "/feign/pay/get/info")
    public String getInfoByConsul() {
        return payFeignApi.mylb();
    }

}
