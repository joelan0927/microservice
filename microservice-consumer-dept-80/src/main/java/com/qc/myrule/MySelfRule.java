package com.qc.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 蓝少宾
 * @create 2019-03-13 23:19
 */
//自定义Ribbon负载均衡算法，此处默认返回官方的，可以自行结合官方源码进行改造（源码在github上）
//自定义Ribbon算法不能将类放在主启动类下面，可以给每个工程进行特殊定制
@Configuration
public class MySelfRule {

    @Bean
    public IRule iRule(){
        return new RandomRule_Joe();
    }
}
