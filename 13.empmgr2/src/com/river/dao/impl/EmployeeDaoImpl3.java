package com.river.dao.impl;

import com.river.dao.EmployeeDao;
import com.river.entity.Employee;
import com.river.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl3 implements EmployeeDao {

    @Override
    public List<Employee> findAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs =  null;
        List<Employee> list = new ArrayList<>();
        try {
            //2.建立和数据库的连接
            conn = DBUtil.getConnection();
            //3.创建一个SQL命令发送器
            stmt = conn.createStatement();
            //4.准备好SQL语句，通过SQL命令发送器发送给数据库，并得到结果
            String sql = "select * from emp";
            rs = stmt.executeQuery(sql);
            // 5.处理结果（封装到List中）
            while(rs.next()){
                //1.将当前行的各列的值取出来
                int empno = rs.getInt("empno");
                String ename = rs.getString("ename");
                String job = rs.getString("job");
                int mgr = rs.getInt("mgr");
                Date hireDate = rs.getDate("hiredate");
                double sal = rs.getDouble("sal");
                double comm = rs.getDouble("comm");
                int deptno = rs.getInt("deptno");
                //2.将当前行的各列的取出来的值封装到一个Employee对象中
                Employee emp = new Employee(empno,ename,job,mgr,hireDate,sal,comm,deptno);
                //3.将Employee对象添加到list中
                list.add(emp);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6.关闭资源
            DBUtil.closeAll(rs, stmt, conn);
        }
        return list;
    }

    @Override
    public Employee findById(int empno) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs =  null;
        Employee emp = null;//查询不到
        try {
            //2.建立和数据库的连接
            conn = DBUtil.getConnection();
            //3.创建一个SQL命令发送器
            stmt = conn.createStatement();
            //4.准备好SQL语句，通过SQL命令发送器发送给数据库，并得到结果
            String sql = "select * from emp where  empno ="+empno;
            rs = stmt.executeQuery(sql);
            // 5.处理结果（封装到List中）
            if(rs.next()){
                //1.将当前行的各列的值取出来
                //int empno = rs.getInt("empno");
                String ename = rs.getString("ename");
                String job = rs.getString("job");
                int mgr = rs.getInt("mgr");
                Date hireDate = rs.getDate("hiredate");
                double sal = rs.getDouble("sal");
                double comm = rs.getDouble("comm");
                int deptno = rs.getInt("deptno");
                //2.将当前行的各列的取出来的值封装到一个Employee对象中
                emp = new Employee(empno,ename,job,mgr,hireDate,sal,comm,deptno);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6.关闭资源
            DBUtil.closeAll(rs, stmt, conn);
        }
        return emp;
    }

    @Override
    public int save(Employee emp) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs =  null;
        int n = 0;//添加失败
        try {
            //2.建立和数据库的连接
            conn = DBUtil.getConnection();
            //3.创建一个SQL命令发送器
            String sql = "insert into emp values(null,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            //4.准备好SQL语句，通过SQL命令发送器发送给数据库，并得到结果
            pstmt.setString(1, emp.getEname());
            pstmt.setString(2, emp.getJob());
            pstmt.setInt(3, emp.getMgr());
            // Found:java.util.Date, required :java.sql.Date
            /*
                java.sql.Date/Time/Timestamp extends java.util.Date

                java.sql.Date yyyyMMdd
                java.sql.Time hhmmss
                java.sql.Timestamp yyyyMMddhhmmss 更精确

            java.sql.Date sdate = new java.sql.Date(emp.getHireDate().getTime())

             */
            pstmt.setDate(4, new Date(emp.getHireDate().getTime()));
            pstmt.setDouble(5, emp.getSal());
            pstmt.setDouble(6, emp.getComm());
            pstmt.setInt(7, emp.getDeptno());
            n = pstmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6.关闭资源
            DBUtil.closeAll(rs, pstmt, conn);
        }
        return n;
    }

    @Override
    public int update(Employee emp) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs =  null;
        int n = 0;//添加失败
        try {
            //2.建立和数据库的连接
            conn = DBUtil.getConnection();
            //3.创建一个SQL命令发送器
            String sql = "update emp set job =?,sal = ?,deptno = ? where empno=?";
            pstmt = conn.prepareStatement(sql);
            //4.准备好SQL语句，通过SQL命令发送器发送给数据库，并得到结果

            pstmt.setString(1, emp.getJob());
            pstmt.setDouble(2, emp.getSal());
            pstmt.setInt(3, emp.getDeptno());
            pstmt.setInt(4, emp.getEmpno());

            n = pstmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6.关闭资源
            DBUtil.closeAll(rs, pstmt, conn);
        }
        return n;
    }

    @Override
    public int delete(int empno) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs =  null;
        int n = 0;//添加失败
        try {
            //2.建立和数据库的连接
            conn = DBUtil.getConnection();
            //3.创建一个SQL命令发送器
            String sql = "delete from emp where empno = ?";
            pstmt = conn.prepareStatement(sql);
            //4.准备好SQL语句，通过SQL命令发送器发送给数据库，并得到结果
            pstmt.setInt(1, empno);
            n = pstmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6.关闭资源
            DBUtil.closeAll(rs, pstmt, conn);
        }
        return n;
    }
}
