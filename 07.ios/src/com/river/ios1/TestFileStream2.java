package com.river.ios1;

import java.io.*;

/**
 * 使用 FileInputStream 和 FileOutputStream 实现文件的复制
 */
public class TestFileStream2 {
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
        byte[] buf = new byte[1024];
        int len = fis.read(buf); // 使用输入流读取文件，将内容填到buf字节数组中，返回的是真正读取的的字节数
        while (len != -1) {// 读到了数据,文件没到末尾
            // 将字节数组的内容写入目的文件
            fos.write(buf, 0, len);
            // 再读一个字节
            len = fis.read(buf);
        }

        // 3.关闭流
        fis.close();
        fos.close();
    }
}
