package com.river.tcp.login3;

import com.river.intity.User;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class LoginClient {
    public static void main(String[] args) throws IOException {
        // 1.创建一个Socket
        Socket socket = new Socket(InetAddress.getLocalHost(), 8000);
        Scanner input = new Scanner(System.in);

        // 2.发送数据给服务器
        System.out.println("请输入账号：");
        String userId = input.next();
        System.out.println("请输入密码：");
        String password = input.next();
        User user = new User(userId, password);

        OutputStream os = socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(user);

        // 3.接受服务端
        InputStream is = socket.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        String result = dis.readUTF();
        System.out.println(result);


        //
        dis.close();
        oos.close();
        os.close();
        socket.close();
    }
}
