package com.river.dao.impl;


import com.river.dao.EmployeeDao;
import com.river.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl2 implements EmployeeDao {

    @Override
    public List<Employee> findAll() {
        String driver = "com.mysql.cj.jdbc.Driver";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Employee> list = new ArrayList<>();


        // 加载驱动
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/mydb?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
            String user = "river";
            String password = "20020126";
            Class.forName(driver);

            // 建立数据库连接
            conn = DriverManager.getConnection(url, user, password);

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

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return list;
    }

    @Override
    public Employee findById(int empno) {
        String driver = "com.mysql.cj.jdbc.Driver";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Employee emp = null;

        // 加载驱动
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/mydb?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
            String user = "river";
            String password = "20020126";
            Class.forName(driver);

            // 建立数据库连接
            conn = DriverManager.getConnection(url, user, password);

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

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return emp;
    }

    @Override
    public int save(Employee emp) {
        return 0;
    }

    @Override
    public int update(Employee emp) {
        return 0;
    }

    @Override
    public int delete(int empno) {
        return 0;
    }
}
