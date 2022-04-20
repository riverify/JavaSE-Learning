package com.river.jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 银行转账
 *
 * jdbc中，事务缺省会以一条DML语句为单位自动提交，可能带来很多潜在安全问题
 */
public class TestTransaction {
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
            //System.out.println(conn);
            // 3.创建一个sql命令发送器
            stmt = conn.createStatement();
            // 4.设置事务不自动commit
            conn.setAutoCommit(false);
            // 5.准备一个sql命令，并使用sql命令发送器发送出去，并返回结果
            stmt.executeUpdate("update t_user set money = money + 2000 where userid = 'lisi';");
            stmt.executeUpdate("update t_user set money = money - 2000 where userid = 'zhangsan';");

            // 6.事务成功结束
            conn.commit();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

            //　事务失败结束
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
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
