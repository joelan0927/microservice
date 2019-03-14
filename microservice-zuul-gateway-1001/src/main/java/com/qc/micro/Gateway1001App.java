package com.qc.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author 蓝少宾
 * @create 2019-03-15 1:46
 */
//路由需要将自己注册到eureka，然后再到eureka中去找其他服务
@EnableZuulProxy
@SpringBootApplication
public class Gateway1001App {
    public static void main(String[] args) {
        SpringApplication.run(Gateway1001App.class,args);
    }
}
