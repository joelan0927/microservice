package com.qc.micro.service.impl;

import com.qc.micro.entity.Dept;
import com.qc.micro.mapper.DeptMapper;
import com.qc.micro.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 蓝少宾
 * @create 2019-03-13 14:27
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public boolean addDept(Dept dept) {
        return deptMapper.insertDept(dept);
    }

    @Override
    public Dept findById(Long id) {
        return deptMapper.selectById(id);
    }

    @Override
    public List<Dept> getAll() {
        return deptMapper.selectAll();
    }
}
