package com.river.ios5;

import com.river.ios4.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;

/**
 * 输出流 包装类 字节流
 */
public class TestPrintStream {
    public static void main(String[] args) throws FileNotFoundException {
//        System.out.println("Hello Java");
//        System.out.println(3);
//        System.out.println(3.14);
//        System.out.println('学');
//        System.out.println(true);
//        System.out.println("river");
//        System.out.println(new Date());
//        System.out.println(new Student("1", "Zhangsan", 19, 98));
        //PrintStream ps = System.out;
        //PrintStream ps = System.err;
        PrintStream ps = new PrintStream("D:/readme3.txt");
        ps.println("Hello Java");
        ps.println(3);
        ps.println(3.14);
        ps.println('学');
        ps.println(true);
        ps.println("river");
        ps.println(new Date());
        ps.println(new Student("1", "Zhangsan", 19, 98));

    }
}
