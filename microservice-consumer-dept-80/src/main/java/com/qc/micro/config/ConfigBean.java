package com.qc.micro.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.qc.myrule.RandomRule_Joe;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 蓝少宾
 * @create 2019-03-13 14:59
 */
@Configuration
public class ConfigBean {

    @LoadBalanced       //开启负载均衡（后期给Feign集成了）
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    //选择负载均衡的算法（若为显示定义则默认为轮询）
//    @Bean
//    public IRule iRule(){
//
//        //return new RoundRobinRule();轮询算法
//        //return new RetryRule();先轮询，待一个服务宕机了，会先在多次请求后跳过宕机的服务继续轮询
//        //return new RandomRule();//随机负载均衡算法
//    }

    //自定义算法

}
