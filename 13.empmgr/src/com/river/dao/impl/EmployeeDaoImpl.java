package com.river.dao.impl;


import com.river.dao.EmployeeDao;
import com.river.entity.Employee;
import com.river.util.DBUtil;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public List<Employee> findAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Employee> list = new ArrayList<>();


        // 加载驱动
        try {
            conn = DBUtil.getConnection();
            // 创建sql命令发射器
            stmt = conn.createStatement();

            // 准备好sql语句，通过sql命令发射器发送给数据库，并得到结果
            String sql = "select * from EMP";
            rs = stmt.executeQuery(sql);

            // 处理结果
            while (rs.next()) {
                int empno = rs.getInt("empno");
                String ename = rs.getString("ename");
                String job = rs.getString("job");
                int mgr = rs.getInt("mgr");
                Date hireDate = rs.getDate("hiredate");
                double sal = rs.getDouble("sal");
                double comm = rs.getDouble("comm");
                int depton = rs.getInt("deptno");

                Employee emp = new Employee(empno, ename, job, mgr, hireDate, sal, comm, depton);

                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            DBUtil.closeAll(rs, stmt, conn);
        }


        return list;
    }

    @Override
    public Employee findById(int empno) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Employee emp = null;

        // 加载驱动
        try {
            conn = DBUtil.getConnection();

            stmt = conn.createStatement();
            String sql = "select * from EMP where empno = " + empno;
            rs = stmt.executeQuery(sql);

            // 处理结果
            if (rs.next()) {
                String ename = rs.getString("ename");
                String job = rs.getString("job");
                int mgr = rs.getInt("mgr");
                Date hireDate = rs.getDate("hiredate");
                double sal = rs.getDouble("sal");
                double comm = rs.getDouble("comm");
                int depton = rs.getInt("deptno");

                emp = new Employee(empno, ename, job, mgr, hireDate, sal, comm, depton);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            DBUtil.closeAll(rs, stmt, conn);
        }
        return emp;
    }

    @Override
    public int save(Employee emp) {

        String sql = "insert into EMP values(null, ?, ?, ?, ?, ?, ?, ?)";
        Object[] params = {emp.getEname(), emp.getJob(), emp.getMgr(), new java.sql.Date(emp.getHireDate().getTime()),
                emp.getSal(), emp.getComm(), emp.getDeptno()};
        return DBUtil.executeUpdate(sql, params);
    }

    @Override
    public int update(Employee emp) {
        String sql = "update EMP set job = ?, sal = ?, deptno = ? where empno = ?";
        Object[] params = {emp.getJob(), emp.getSal(), emp.getDeptno(), emp.getEmpno()};
        return DBUtil.executeUpdate(sql, params);
    }

    @Override
    public int delete(int empno) {
        String sql = "delete from EMP where empno = ?";
        Object[] params = {empno};
        return DBUtil.executeUpdate(sql, params);
    }
}
