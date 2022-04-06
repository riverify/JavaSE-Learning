package com.river.jdbc;

import java.sql.*;

public class TestSelect {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://127.0.0.1:3306/mydb?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
            String user = "river";
            String password = "20020126";

            // 1.加载驱动
            Class.forName(driver);
            
            // 2.和数据库建立连接
            conn = DriverManager.getConnection(url, user, password);
            System.out.println(conn);
            
            // 3.创建一个sql命令发送器
            stmt = conn.createStatement();
            
            // 4.准备一个sql命令，并使用sql命令发送器发送出去，并返回结果
            String sql = "select * from EMP";
            rs = stmt.executeQuery(sql);

            // 5.处理结果
            System.out.println("编号\t\t姓名\t\t岗位\t\t上级\t\t入职时间\t\t薪水\t\t补助\t\t部门编号");
            while (rs.next()) {
                // 获取当前行各列数据
//                int empon = rs.getInt(1);
//                String ename = rs.getString(2);
//                String job = rs.getString(3);
//                int mgr = rs.getInt(4);
//                Date hireDate = rs.getDate(5);
//                double sal = rs.getDouble(6);
//                double comm = rs.getDouble(7);
//                int depno = rs.getInt(8);
                int empon = rs.getInt("empno");
                String ename = rs.getString("ename");
                String job = rs.getString("job");
                int mgr = rs.getInt(4);
                Date hireDate = rs.getDate(5);
                double sal = rs.getDouble(6);
                double comm = rs.getDouble(7);
                int depno = rs.getInt(8);
                // 输出当前行各列数据
                System.out.println(empon + "\t" + ename + "\t" + job + "\t" + mgr + "\t" + hireDate + "\t" + sal + "\t"
                                    + comm + "\t" + depno + "\t");
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 6.关闭资源
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
    }
}
