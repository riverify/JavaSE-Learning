package com.river.util;

import java.sql.*;

/**
 *  数据库工具类
 *  避免代码重复
 */
public abstract class DBUtil2 {
    private DBUtil2() {
    }


    /**
     * 获取数据库的连接
     * @return
     */
    public static Connection getConnection() {
        Connection conn = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/mydb?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
        String user = "river";
        String password = "20020126";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 建立数据库连接
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭所有资源
     */
    public static void closeAll(ResultSet rs, Statement stmt, Connection conn) {
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

    /**
     * DML Update insert delete
     * @param sql
     * @param params
     * @return
     */
    public static int executeUpdate(String sql, Object[] params) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int n = 0; // 添加失败

        // 加载驱动
        try {
            conn = DBUtil2.getConnection();
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            n = pstmt.executeUpdate();

            // 处理结果
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            DBUtil2.closeAll(rs, pstmt, conn);
        }
        return n;
    }
}
