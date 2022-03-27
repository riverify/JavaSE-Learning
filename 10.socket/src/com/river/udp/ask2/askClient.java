package com.river.udp.ask2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class askClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8888);

        String massage = "你好，在吗？";
        byte[] buf = massage.getBytes();
        InetAddress address = InetAddress.getLocalHost();
        int port = 9999;
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);
        socket.send(packet);


        byte[] buf2 = new byte[128];
        DatagramPacket packet2 = new DatagramPacket(buf2, buf2.length);
        socket.receive(packet2);

        System.out.println(new String(packet2.getData(), 0, packet2.getLength()));

        socket.close();

    }
}
