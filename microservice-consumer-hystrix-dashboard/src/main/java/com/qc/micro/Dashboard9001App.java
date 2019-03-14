package com.qc.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author 蓝少宾
 * @create 2019-03-15 1:07
 */
//调用localhost:9001/hystrix访问
@EnableHystrixDashboard
@SpringBootApplication
public class Dashboard9001App {
    public static void main(String[] args) {
        SpringApplication.run(Dashboard9001App.class,args);
    }
}
