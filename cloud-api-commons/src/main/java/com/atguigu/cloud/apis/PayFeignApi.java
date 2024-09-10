package com.atguigu.cloud.apis;

import cn.hutool.core.util.IdUtil;
import com.atguigu.cloud.entity.TPay;
import com.atguigu.cloud.resp.ResultData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value="cloud-gateway")
public interface PayFeignApi {

    @GetMapping(value = "/pay/get/{id}")
    public ResultData<TPay> getById(@PathVariable("id") Integer id);

    /**
     * 自动支持负载均衡
     * @return
     */
    @GetMapping(value = "/pay/get/info")
    public String mylb();

    @GetMapping(value = "/pay/circuit/{id}")
    public String myCircuit(@PathVariable("id") Integer id);

    @GetMapping(value = "/pay/getAllData")
    public ResultData<List<TPay>> getAllData() ;

    @GetMapping(value = "/pay/gateway/info")
    public ResultData<String> getGatewayInfo();
}
