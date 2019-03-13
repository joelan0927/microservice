package com.qc.micro.controller;

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

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id){
        return deptService.findById(id);
    }

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> list(){
        return deptService.getAll();
    }

    //服务发现--了解即可
    @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        System.out.println(services);
        List<ServiceInstance> list = discoveryClient.getInstances("MICROSERVICE-PROVIDER-DEPT");
        for (ServiceInstance serviceInstance : list) {
            System.out.println(serviceInstance.getServiceId()+"\t"+serviceInstance.getHost()+"\t"+serviceInstance.getPort()+"\t"+serviceInstance.getUri());
        }
        return this.discoveryClient;
    }
}
