package com.river.util;

import java.sql.*;

/**
 * 数据库访问工具类
 * 避免了代码重复，也利于代码的修改
 */
public abstract class DBUtil2 {
    private DBUtil2(){

    }

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection(){
        String driver ="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://127.0.0.1:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
        String user = "root";
        String password = "root";
        Connection conn = null;
        try {
            //1.加载驱动
            Class.forName(driver);
            //2.建立和数据库的连接
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;

    }

    /**
     * 关闭各种资源
     */
    public static void closeAll(ResultSet rs, Statement stmt, Connection conn){
        try {
            if(rs!=null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(stmt != null){
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 完成DML操作：insert、update和delete
     * @param sql
     * @param params
     * @return
     */
    public static int executeUpdate(String sql,Object [] params) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs =  null;
        int n = 0;//添加失败
        try {
            //2.建立和数据库的连接
            conn = DBUtil2.getConnection();
            //3.创建一个SQL命令发送器

            pstmt = conn.prepareStatement(sql);
            //4.准备好SQL语句，通过SQL命令发送器发送给数据库，并得到结果
            for (int i = 0; i <params.length ; i++) {
                pstmt.setObject(i+1, params[i]);
            }
            n = pstmt.executeUpdate();
            //System.out.println(n);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6.关闭资源
            DBUtil2.closeAll(rs, pstmt, conn);
        }
        return n;
    }

}
