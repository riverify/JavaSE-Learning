package com.river.dao;

import com.river.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    /**
     * 查询所有员工
     * @return
     */
    List<Employee> findAll();

    /**
     * 查询指定编号的员工
     * @param empno
     * @return
     */
    Employee findById(int empno);

    /**
     * 添加员工
     * @param emp
     * @return
     */
    int save(Employee emp);

    /**
     * 修改员工信息
     * @param emp
     * @return
     */
    int update(Employee emp);

    /**
     *  删除指定编号的员工
     * @param empno
     * @return
     */
    int  delete(int empno);

}
