package com.qc.micro.controller;

import com.qc.micro.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author 蓝少宾
 * @create 2019-03-13 15:04
 */
//此工程为使用Feign来实现远程调用并进行负载均衡
@RestController
public class DeptController {

    //使用了Ribbon之后就可以通过负载均衡访问服务了
    private static final String REST_URL_PREFIX="http://MICROSERVICE-PROVIDER-DEPT";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept){
        Boolean bool = restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
        return bool;
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        Dept dept = restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
        return dept;
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list(Long id){
        List<Dept> depts = restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
        return depts;
    }

    //消费端的服务发现
    @RequestMapping("/consumer/dept/discovery")
    public Object discovery(){

        Object object = restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
        return object;
    }
}
