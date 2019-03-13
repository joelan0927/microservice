package com.qc.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author 蓝少宾
 * @create 2019-03-13 15:05
 */
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.qc.micro")
@SpringBootApplication
public class DeptFeign80Application {
    public static void main(String[] args) {
        SpringApplication.run(DeptFeign80Application.class, args);
    }
}
