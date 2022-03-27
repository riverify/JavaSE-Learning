package com.river.tcp.login3;

import com.river.intity.User;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 1.创建一个ServerSocket
        ServerSocket serverSocket = new ServerSocket(8000);

        // 2.使用ServerSocket在指定端口监听
        Socket socket = serverSocket.accept(); // 请求不到，在此监听，请求到达返回一个ServerSocket，执行后续代码

        // 3.接收客户端的请求数据并输出
        InputStream is = socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        User info = (User) ois.readObject();
        System.out.println("客户端的请求：" + info);

        // 3.5 回应客户端
        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        if (info.getUserId().contains("river") && info.getPassword().length() >= 6) {
            dos.writeUTF("登录成功！");
        }  else {
            dos.writeUTF("账号或密码错误 ");
        }


        // 4.关闭资源
        dos.close();
        ois.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}
