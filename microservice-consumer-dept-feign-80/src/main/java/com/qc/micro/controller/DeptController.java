package com.qc.micro.controller;

import com.qc.micro.api.DeptServiceRemote;
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

    @Autowired
    private DeptServiceRemote deptService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept){
        return deptService.add(dept);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return deptService.get(id);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list(Long id){
        return deptService.list();
    }

    //消费端的服务发现
    @RequestMapping("/consumer/dept/discovery")
    public Object discovery(){

        return deptService.discovery();
    }
}
