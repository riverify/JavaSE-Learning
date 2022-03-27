package com.river.ios3;

import java.io.*;

/**
 * 1. 只需要关闭高层流即可
 * 2. 何时将输出缓冲区的内容写入硬盘
 *    a.输出缓冲区满（刷新 flush）
 *    b.close()会刷新
 *    c.手动 flush()
 */
public class TestBufferedStream2 {
    public static void main(String[] args) throws IOException {
//        InputStream fis = new FileInputStream("d:/Work/jdk api 1.8_google.CHM");
//        OutputStream fos = new FileOutputStream("d:/Work/jdk api 1.8_google2.CHM");
//        BufferedInputStream bis = new BufferedInputStream(fis);
//        BufferedOutputStream bos = new BufferedOutputStream(fos);

        BufferedInputStream bis =
                new BufferedInputStream(new FileInputStream("d:/Work/jdk api 1.8_google.CHM"));
        BufferedOutputStream bos =
                new BufferedOutputStream(new FileOutputStream("d:/Work/jdk api 1.8_google2.CHM"));

        // 2.使用流
        // 2.1 准备一个中转站(一个字节)
        byte[] buf = new byte[1024];
        int len = bis.read(buf); // read 读源文件一个字节
        while (len != -1) {// 读到了数据,文件没到末尾
            // 写一个字节
            bos.write(buf, 0, len);
            // 再读一个字节
            len = bis.read();
        }

        // 3.关闭流
        bis.close();
        bos.close();
//        fis.close();
//        fos.close();
    }
}
