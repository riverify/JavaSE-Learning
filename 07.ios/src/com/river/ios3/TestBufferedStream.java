package com.river.ios3;

import java.io.*;


public class TestBufferedStream {
    public static void main(String[] args) throws IOException {
        InputStream fis = new FileInputStream("d:/Work/jdk api 1.8_google.CHM");
        OutputStream fos = new FileOutputStream("d:/Work/jdk api 1.8_google2.CHM");
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        // 2.使用流
        // 2.1 准备一个中转站(一个字节)
        int n;
        n = bis.read(); // read 读源文件一个字节
        while (n != -1) {// 读到了数据,文件没到末尾
            // 写一个字节
            bos.write(n);
            // 再读一个字节
            n = bis.read();
        }

        // 3.关闭流
        bis.close();
        bos.close();
//        fis.close();
//        fos.close();
    }
}
