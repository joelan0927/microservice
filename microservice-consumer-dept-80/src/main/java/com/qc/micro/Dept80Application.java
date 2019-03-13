package com.qc.micro;

import com.qc.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author 蓝少宾
 * @create 2019-03-13 15:05
 */
@EnableEurekaClient
@SpringBootApplication
@RibbonClient(name = "MICROSERVICE-PROVIDER-DEPT",configuration = MySelfRule.class)//自定义负载均衡算法，在myrule包下
public class Dept80Application {
    public static void main(String[] args) {
        SpringApplication.run(Dept80Application.class,args);
    }
}
