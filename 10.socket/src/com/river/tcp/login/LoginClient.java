package com.river.tcp.login;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class LoginClient {
    public static void main(String[] args) throws IOException {
        // 1.创建一个Socket
        Socket socket = new Socket(InetAddress.getLocalHost(), 8800);

        // 2.发送数据给服务器
        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeUTF("Shit Java");

        //
        dos.close();
        os.close();
        socket.close();
    }
}
