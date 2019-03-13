package com.qc.micro.service;

import com.qc.micro.entity.Dept;

import java.util.List;

/**
 * @author 蓝少宾
 * @create 2019-03-13 14:26
 */
public interface DeptService {

    public boolean addDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> getAll();
}
