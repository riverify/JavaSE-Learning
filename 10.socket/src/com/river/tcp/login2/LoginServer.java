package com.river.tcp.login2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {
    public static void main(String[] args) throws IOException {
        // 1.创建一个ServerSocket
        ServerSocket serverSocket = new ServerSocket(8000);

        // 2.使用ServerSocket在指定端口监听
        Socket socket = serverSocket.accept(); // 请求不到，在此监听，请求到达返回一个ServerSocket，执行后续代码

        // 3.接收客户端的请求数据并输出
        InputStream is = socket.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        String info = dis.readUTF();
        System.out.println(info);

        // 3.5 回应客户端
        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeUTF("I think so");

        // 4.关闭资源
        dos.close();
        dis.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}
