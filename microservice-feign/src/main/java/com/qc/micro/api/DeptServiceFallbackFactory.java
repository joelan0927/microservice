package com.qc.micro.api;

import com.qc.micro.api.DeptServiceRemote;
import com.qc.micro.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 蓝少宾
 * @create 2019-03-14 23:31
 */
//服务降级机制，可以替代服务熔断，更加解耦
@Component
public class DeptServiceFallbackFactory implements FallbackFactory<DeptServiceRemote> {
    @Override
    public DeptServiceRemote create(Throwable cause) {
        return new DeptServiceRemote() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long id) {
                return new Dept().setDeptno(id).setDname("未找到对应的信息,进行服务降级！").setDb_source("no this database in mysql");
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public Object discovery() {
                return null;
            }
        };
    }
}
