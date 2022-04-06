package com.river.jdbc2;

import java.util.Scanner;

/**
 *  模拟登陆
 */
public class TestLogin {
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

        // 3.在前台输入结果

    }

    public void login(String userId, String password) {

    }

}
