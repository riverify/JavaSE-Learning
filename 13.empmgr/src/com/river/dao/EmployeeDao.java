package com.river.dao;

import com.river.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    /**
     *  查询所有员工信息
     * @return 员工信息列表
     */
    public List<Employee> findAll();

    /**
     * 查询指定编号的员工
     * @param empno 员工编号
     * @return 员工类
     */
    public Employee findById(int empno);

    /**
     * 添加员工
     * @param emp　员工类
     * @return 成功回１
     */
    public int save(Employee emp);

    /**
     * 修改员工信息
     * @param emp　员工类
     * @return 成功回１
     */
    public int update(Employee emp);

    /**
     * 删除指定员工编号的员工
     * @param empno 需要删除的员工编号
     * @return 成功回１
     */
    public int delete(int empno);
}
