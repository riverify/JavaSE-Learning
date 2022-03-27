package com.river.basic;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 *  InetSocketAddress 封装了 IP 和 Port
 */
public class TestInetSocketAddress {
    public static void main(String[] args) throws UnknownHostException {
        // create
//        InetSocketAddress isa = new InetSocketAddress("www.longcry.com", 2333);
        InetAddress ia = InetAddress.getByName("www.longcry.com");
        InetSocketAddress isa = new InetSocketAddress(ia, 2333);

        // get
        System.out.println(isa);
    }
}
