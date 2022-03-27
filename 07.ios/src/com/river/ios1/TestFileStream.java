package com.river.ios1;

import java.io.*;

/**
 * 使用 FileInputStream 和 FileOutputStream 实现文件的复制
 */
public class TestFileStream {
    public static void main(String[] args) throws IOException {
        // 1.创建流
//        File file = new File("D:/readme.txt");
//        InputStream fis = new FileInputStream(file);
//        File file2 = new File("D:/readme2.txt");
//        OutputStream fos = new FileOutputStream(file2);

//        InputStream fis = new FileInputStream(new File("d:\\readme.txt"));
//        OutputStream fos = new FileOutputStream((new File("d:/readme.txt")));

//        InputStream fis = new FileInputStream("d:\\readme.txt");
//        OutputStream fos = new FileOutputStream("d:/readme.txt");

        InputStream fis = new FileInputStream("d:/Work/jdk api 1.8_google.CHM");
        OutputStream fos = new FileOutputStream("d:/Work/jdk api 1.8_google2.CHM");

        // 2.使用流
        // 2.1 准备一个中转站(一个字节)
        int n;
        n = fis.read(); // read 读源文件一个字节
        while (n != -1) {// 读到了数据,文件没到末尾
            // 写一个字节
            fos.write(n);
            // 再读一个字节
            n = fis.read();
        }

        // 3.关闭流
        fis.close();
        fos.close();
    }
}
