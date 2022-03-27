package com.river.udp.ask;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class askServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9999);

        byte[] buf = new byte[128];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);
        System.out.println(new String(packet.getData(), 0, packet.getLength()));
        System.out.println(packet.getLength());
        System.out.println(packet.getAddress());
        System.out.println(packet.getPort());

        socket.close();
    }
}
