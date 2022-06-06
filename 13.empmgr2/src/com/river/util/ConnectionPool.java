package com.river.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * 连接池
 */
public class ConnectionPool {
    /**
     * 存放多个数据库连接（空闲的）
     * 获取连接：出队  删除  删除第一个
     * 关闭连接：入队  添加  添加到末尾
     * 建议使用LinkedList
     */
    private static final LinkedList<Connection> list = new LinkedList<Connection>();

    /**
     * 第一次加载类的实现执行一次，就执行这一次:建立多个数据库连接放入到LinkedList中
     */
    static {
        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            //1.加载驱动
            Class.forName(driver);

            for (int i = 0; i < 10; i++) {
                //2.建立和数据库的连接
                Connection conn = newConnection();
                list.addLast(conn);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 创建一个新的链接
     *
     * @return
     */
    private static Connection newConnection() {
        String url = "jdbc:mysql://127.0.0.1:3306/mydb?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
        String user = "river";
        String password = "20020126";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;

    }

    /**
     * 从连接池中获取连接
     * 如果有空闲的连接，直接返回
     * 如果没有空闲的连接，直接新创建一个物理连接
     *
     * @return
     */
    public static Connection getConnection() {
        if (list.size() > 0) {
            return list.removeFirst();
        } else {
            return newConnection();
        }
    }

    /**
     * 数据库连接使用完毕，放回连接池
     */
    public static void returnConnection(Connection conn) {
        if (list.size() < 10) {
            list.addLast(conn);
        } else { //如果连接池满，直接物理关闭
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        /*
        Connection conn = getConnection(); //1
        System.out.println(conn);
        System.out.println(getConnection());//2
        System.out.println(getConnection());//3
        returnConnection(conn);
        System.out.println(getConnection());//4
        System.out.println(getConnection());//5
        System.out.println(getConnection());//6
        System.out.println(getConnection());//7
        System.out.println(getConnection());//8
        System.out.println(getConnection());//9
        System.out.println(getConnection());//10
        System.out.println(getConnection());// 11 !!!!!

         */
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            //DBUtil.getConnection();
            Connection conn = ConnectionPool.getConnection();
            ConnectionPool.returnConnection(conn);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

    }

}
