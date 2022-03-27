package com.river.udp.ask;

import java.io.IOException;
import java.net.*;

public class askClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8888);

        String massage = "你好，在吗？";
        byte[] buf = massage.getBytes();
        InetAddress address = InetAddress.getLocalHost();
        int port = 9999;
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);
        socket.send(packet);

        socket.close();

    }
}
