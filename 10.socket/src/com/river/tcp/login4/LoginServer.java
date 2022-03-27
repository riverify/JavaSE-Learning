package com.river.tcp.login4;

import com.river.intity.User;
import sun.rmi.runtime.Log;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 1.创建一个ServerSocket
        ServerSocket serverSocket = new ServerSocket(8000);
        int i = 1;

        while (true) {
            // 2.使用ServerSocket在指定端口监听
            Socket socket = serverSocket.accept(); // 请求不到，在此监听，请求到达返回一个ServerSocket，执行后续代码

            new LoginThread(socket).start();

            InetAddress ia = socket.getInetAddress();
            System.out.println("第个" + (i++) + "请求，来自" + ia);
        }







    }
}
