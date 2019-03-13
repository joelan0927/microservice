package com.qc.micro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author 蓝少宾
 * @create 2019-03-13 13:40
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept implements Serializable {
    private Long    deptno;     //主键
    private String  dname;      //部门名称
    private String  db_source;  //数据源（微服务可以有自己独立的数据源）
}
