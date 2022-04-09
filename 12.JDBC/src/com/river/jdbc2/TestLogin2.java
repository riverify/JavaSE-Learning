package com.river.jdbc2;

import entity.Emp;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *  模拟登陆    -- public interface PreparedStatement extends Statement
 *  防止sql注入风险，非字符串拼接，能减少出错，同时速度快
 */
public class TestLogin2 {
    /**
     *  登陆前台
     * @param args
     */
    public static void main(String[] args) {
        // 1.输入用户名和密码
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名");
        String userId = input.next();
        System.out.println("请输入密码");
        String password = input.next();

        // 2.调用后台判断登陆是否成功并返回结果给前台
        User user = login(userId, password);

        // 3.在前台输入结果
        if (user == null) {
            System.out.println("登陆失败");
        } else {
            System.out.println("登陆成功!\n真实姓名：" + user.getRealName() + "\n账户余额："
                    + user.getMoney());
        }
        // 即使密码错误，也能登陆成功
    }

    // 后台
    public static User login(String userId, String pwd) {
        Connection conn = null;
        // Statement stmt = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user2 = null;

        List<Emp> list = new ArrayList<Emp>();

        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://127.0.0.1:3306/mydb?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
            String user = "river";
            String password = "20020126";

            // 1.加载驱动
            Class.forName(driver);

            // 2.和数据库建立连接
            conn = DriverManager.getConnection(url, user, password);

            // 3.准备一个sql命令，并使用sql命令发送器发送出去，并返回结果
            String sql = "select * from t_user where userid = ? and password = ?"; // ? 占位

            // 4.创建一个sql命令发送器
            //stmt = conn.createStatement();
            pstmt = conn.prepareStatement(sql);

            //rs = stmt.executeQuery(sql);
            pstmt.setString(1, userId);
            pstmt.setString(2, pwd);
            rs = pstmt.executeQuery();

            // 5.处理结果(将ResultSet的结果数据封装到Ｌist之中)
            if (rs.next()) {
                // 获取结果
                String realName = rs.getString("REALNAME");
                double money = rs.getDouble("MONEY");
                // 将当前各个字段封装到User对象之中
                user2 = new User(userId, realName, pwd, money);
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
                if (pstmt != null) {
                    pstmt.close();
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
        return user2;
    }

}
