package com.qc.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 蓝少宾
 * @create 2019-03-13 16:01
 */
@EnableEurekaServer
@SpringBootApplication
public class Eureka7001App {
    public static void main(String[] args) {
        SpringApplication.run(Eureka7001App.class,args);
    }
}
