package com.river.ios4;

import java.io.*;
import java.util.Date;

public class TestObjectStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //write();
        read();
    }

    public static void write() throws IOException {
//        OutputStream os = new FileOutputStream("d://readme.txt");
//        DataOutputStream dos = new DataOutputStream(os);
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("d:/readme2.txt")));

        oos.writeInt(1);
        oos.writeDouble(1.23);
        oos.writeChar('好');
        oos.writeObject(new Date());
        Student stu = new Student("1", "zhangsan", 19, 98);
        Clazz clazz =  new Clazz(1, "Java001");
        stu.setClazz(clazz);
        oos.writeObject(stu);

        oos.close();
    }

    public static void read() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("d:/readme2.txt")));

        System.out.println(ois.readInt());
        System.out.println(ois.readDouble());
        System.out.println(ois.readChar());
        Object obj = ois.readObject();
        System.out.println(obj);
        System.out.println(ois.readObject().toString());

        ois.close();

    }
}
