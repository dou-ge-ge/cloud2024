package com.atguigu.cloud.controller;

import com.atguigu.cloud.apis.PayFeignApi;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderCircuitController {

    @Resource
    private PayFeignApi payFeignApi;


    @GetMapping(value="/feign/pay/circuit/{id}")
    @CircuitBreaker(name="cloud-payment-service",fallbackMethod = "myCircyitFallback")
    public String myCircuitBreaker(@PathVariable("id") Integer id){

        return payFeignApi.myCircuit(id);
    }

    public String myCircyitFallback(Throwable t){
        return "系统繁忙！！！！";
    }

}
