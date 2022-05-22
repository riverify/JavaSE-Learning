package com.river.test;

import java.sql.*;

public class TestResultSetMetaData {
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
            String sql = "select empno, ename, sal, deptno from EMP";
            rs = stmt.executeQuery(sql);

            // 5.处理结果
            ResultSetMetaData rsmd = rs.getMetaData();
            int count = rsmd.getColumnCount();

            for (int i = 0; i < count; i++) {
                System.out.print(rsmd.getColumnName(i + 1) + "\t");
                System.out.print(rsmd.getColumnType(i + 1) + "\t");
                System.out.print(rsmd.getColumnTypeName(i + 1) + "\t");
                System.out.println(rsmd.getColumnClassName(i + 1));
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
