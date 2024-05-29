package com.atguigu.cloud;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.atguigu.cloud.mapper")
public class Main8001 {

public static void main(String[] args) {
    SpringApplication.run(Main8001.class,args);
}
}