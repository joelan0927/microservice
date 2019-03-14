package com.qc.micro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 蓝少宾
 * @create 2019-03-13 14:16
 */
@SpringBootApplication
@EnableEurekaClient//本服务启动后会自动注册进eureka
@EnableDiscoveryClient//服务发现
@EnableCircuitBreaker//开启熔断器
public class DeptHystrix8001Application {
    public static void main(String[] args) {
        SpringApplication.run(DeptHystrix8001Application.class,args);
    }
}