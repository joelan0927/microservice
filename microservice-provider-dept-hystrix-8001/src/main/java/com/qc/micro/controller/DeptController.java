package com.qc.micro.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.qc.micro.entity.Dept;
import com.qc.micro.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 蓝少宾
 * @create 2019-03-13 14:34
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }

    /**
     * 此方法开启服务熔断机制
     */
    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_get")
    public Dept get(@PathVariable("id") Long id){
        Dept dept = deptService.findById(id);
        if (dept == null){
            throw new RuntimeException("未找到ID:"+id+"对应的信息");
        }
        return dept;
    }

    /**
     * 服务熔断,此实现为强耦合实现，可通过服务降级解耦
     */
    public Dept processHystrix_get(@PathVariable("id") Long id){
        return new Dept().setDeptno(id).setDname("未找到对应的信息").setDb_source("no datasource provider");
    }

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> list(){
        return deptService.getAll();
    }

}
