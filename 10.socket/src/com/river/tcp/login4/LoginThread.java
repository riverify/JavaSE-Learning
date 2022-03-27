package com.river.tcp.login4;

import com.river.intity.User;

import java.io.*;
import java.net.Socket;

public class LoginThread extends Thread {

    private Socket socket = null;

    public LoginThread(Socket socket) throws IOException {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream is = null;
        ObjectInputStream ois = null;
        DataOutputStream dos = null;
        try {
            // 3.接收客户端的请求数据并输出
            is = socket.getInputStream();
            ois = new ObjectInputStream(is);
            User info = (User) ois.readObject();
            System.out.println("客户端的请求：" + info);

            // 3.5 回应客户端
            OutputStream os = socket.getOutputStream();
            dos = new DataOutputStream(os);
            if (info.getUserId().contains("river") && info.getPassword().length() >= 6) {
                dos.writeUTF("登录成功！");
            }  else {
                dos.writeUTF("账号或密码错误 ");
            }
        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        } finally {
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        // 4.关闭资源

    }
}
