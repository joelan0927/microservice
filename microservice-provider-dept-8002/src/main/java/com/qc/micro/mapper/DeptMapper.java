package com.qc.micro.mapper;

import com.qc.micro.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 蓝少宾
 * @create 2019-03-13 14:17
 */
@Mapper
public interface DeptMapper {

    public boolean insertDept(Dept dept);

    public Dept selectById(Long id);

    public List<Dept> selectAll();
}
