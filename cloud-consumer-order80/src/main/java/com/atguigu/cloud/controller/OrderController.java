package com.atguigu.cloud.controller;

import com.atguigu.cloud.entity.TPayDto;
import com.atguigu.cloud.resp.ResultData;
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

    public static final String PaymentSrv_URL = "http://cloud-payment-service";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/pay/add")
    public ResultData addOrder(TPayDto tPayDto) {
        return restTemplate.postForObject(PaymentSrv_URL + "/pay/add", tPayDto, ResultData.class);
    }

    @GetMapping(value = "/consumer/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id) {
        log.info(id + "!!!!!!!!!!!!!!!!!!!!!!!11");
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/" + id, ResultData.class, id);
    }

    @GetMapping(value = "/consumer/pay/get/info")
    public String getInfoByConsul() {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/info", String.class);
    }

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/discovery")
    public String discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            System.out.println(element);
        }

        List<ServiceInstance> ins = discoveryClient.getInstances("cloud-payment-service");

        for (ServiceInstance el : ins) {
            System.out.println(el.getServiceId() + "\t" + el.getHost() + "\t" + el.getPort() + "\t" + el.getUri());
        }
        return ins.get(0).getServiceId() + ":" + ins.get(0).getServiceId();
    }

}
