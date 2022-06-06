package com.river.util;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 数据库访问工具类
 * 避免了代码重复，也利于代码的修改
 */
public abstract class DBUtil {
    //定义一个日志记录器
    private static final Logger logger = Logger.getLogger(DBUtil.class.getName());

    //在合适的位置使用日志记录器来记录日志

    private DBUtil() {

    }

    static String driver;
    static String url;
    static String user;
    static String password;

    static {
        //创建Properties对象
        Properties prop = new Properties();
        //读取属性文件
        InputStream is = DBUtil.class.getResourceAsStream("/jdbc.properties");
        try {
            prop.load(is);
            logger.info("正确的读取了jdbc.properties:" + prop);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("读取jdbc.properties文件出错：" + e);
        }
        //根据key获取values
        driver = prop.getProperty("driver");
        url = prop.getProperty("url");
        user = prop.getProperty("user");
        password = prop.getProperty("pwd");
    }

    /**
     * 获取数据库连接
     *
     * @return
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            //1.加载驱动
            Class.forName(driver);
            //2.建立和数据库的连接
            conn = DriverManager.getConnection(url, user, password);
            logger.info("获取了数据库连接：" + conn);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("建立数据库连接失败：" + e);
        }
        return conn;

    }

    /**
     * 关闭各种资源
     */
    public static void closeAll(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
                logger.debug("关闭结果集成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (stmt != null) {
                stmt.close();
                logger.debug("关闭Statement成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (conn != null) {
                conn.close();
                logger.debug("关闭了数据库连接");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 完成DML操作：insert、update和delete
     *
     * @param sql
     * @param params
     * @return
     */
    public static int executeUpdate(String sql, Object[] params) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int n = 0;//添加失败
        try {
            //2.建立和数据库的连接
            conn = DBUtil.getConnection();
            //3.创建一个SQL命令发送器

            pstmt = conn.prepareStatement(sql);
            //4.准备好SQL语句，通过SQL命令发送器发送给数据库，并得到结果
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            n = pstmt.executeUpdate();
            //System.out.println(n);

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("执行DML操作失败：" + e);
        } finally {
            //6.关闭资源
            DBUtil.closeAll(rs, pstmt, conn);
        }
        return n;
    }

}
