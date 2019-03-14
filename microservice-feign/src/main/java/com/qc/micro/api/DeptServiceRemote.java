package com.qc.micro.api;

import com.qc.micro.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author 蓝少宾
 * @create 2019-03-14 0:25
 */
//使用服务降级
@FeignClient(value = "MICROSERVICE-PROVIDER-DEPT",fallbackFactory = DeptServiceFallbackFactory.class)
public interface DeptServiceRemote {

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept);

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id);

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> list();

    @RequestMapping("/consumer/dept/discovery")
    public Object discovery();
}
