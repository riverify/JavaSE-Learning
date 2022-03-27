package com.river.tcp.login2;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class LoginClient {
    public static void main(String[] args) throws IOException {
        // 1.创建一个Socket
        Socket socket = new Socket(InetAddress.getLocalHost(), 8000);

        // 2.发送数据给服务器
        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeUTF("Shit Java");

        // 3.接受服务端
        InputStream is = socket.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        String result = dis.readUTF();
        System.out.println(result);


        //
        dis.close();
        dos.close();
        os.close();
        socket.close();
    }
}
