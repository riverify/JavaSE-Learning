package com.river.ios4;

import java.io.*;

public class TestDataStream {
    public static void main(String[] args) throws IOException {
        //write();
        read();
    }

    public static void write() throws IOException {
//        OutputStream os = new FileOutputStream("d://readme.txt");
//        DataOutputStream dos = new DataOutputStream(os);
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("d:/readme2.txt")));

        dos.writeInt(1);
        dos.writeDouble(1.23);
        dos.writeChar('好');

        dos.close();
    }

    public static void read() throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("d:/readme2.txt"));

        System.out.println(dis.readInt());
        System.out.println(dis.readDouble());
        System.out.println(dis.readChar());

        dis.close();

    }
}
