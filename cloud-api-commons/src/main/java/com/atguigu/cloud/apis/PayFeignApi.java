package com.atguigu.cloud.apis;

import com.atguigu.cloud.entity.TPay;
import com.atguigu.cloud.resp.ResultData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="cloud-payment-service")
public interface PayFeignApi {

    @GetMapping(value = "/pay/get/{id}")
    public ResultData<TPay> getById(@PathVariable("id") Integer id);

    /**
     * 自动支持负载均衡
     * @return
     */
    @GetMapping(value = "/pay/get/info")
    public String mylb();

}
