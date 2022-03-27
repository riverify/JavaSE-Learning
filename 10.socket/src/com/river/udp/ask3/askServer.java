package com.river.udp.ask3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;


public class askServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9999);
        Scanner input = new Scanner(System.in);

        while (true) {
            byte[] buf = new byte[128];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            String result = new String(packet.getData(), 0, packet.getLength());
            System.out.println("用户:" + result);
//            System.out.println(packet.getLength());
//            System.out.println(packet.getAddress());
//            System.out.println(packet.getPort());

            if ("bye".equals(result)) {
                break;
            }

            String str = input.nextLine();

            byte[] buf2 = str.getBytes();
            DatagramPacket packet2 = new DatagramPacket(buf2, buf2.length, packet.getAddress(), packet.getPort());
            socket.send(packet2);
        }



        socket.close();
    }
}
