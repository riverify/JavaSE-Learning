package com.river.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 *  InetAdress 封装了 IP 地址
 */
public class TestInetAddress {
    public static void main(String[] args) throws UnknownHostException {
        // 获取IP地址
//        InetAddress ia = InetAddress.getLocalHost();
        InetAddress ia = InetAddress.getByName("www.longcry.com");
        // 操作IP地址
        System.out.println(ia);
        System.out.println(ia.getHostAddress());
        System.out.println(ia.getHostName());
        System.out.println(Arrays.toString(ia.getAddress()));
    }
}
