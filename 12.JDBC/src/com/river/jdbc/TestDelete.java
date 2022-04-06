package com.river.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDelete {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        
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
            String sql = "delete from DEPT where deptno = 50";
            int n = stmt.executeUpdate(sql);
            
            // 5.处理结果
            if (n > 0) {
                System.out.println("成功");
            } else {
                System.out.println("失败");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 6.关闭资源
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
