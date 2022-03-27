package com.river.demo.dir;

import java.io.*;

/**
 * 复制文件夹
 * 1.复制一个文件
 */
public class TestCopyDir1 {
    public static void main(String[] args) {
        copyFile("d:/readme.txt", "d:/hello.txt");

    }

    public static void copyFile(String sourceName, String destName) {
        // 创建流
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            InputStream fis = new FileInputStream(sourceName);
            bis = new BufferedInputStream(fis);
            OutputStream fos = new FileOutputStream(destName);
            bos = new BufferedOutputStream(fos);

            // 文件的复制
            // 准备一个中转站
            byte[] buf = new byte[1024];
            // 读一个字节到中转站，把读到的长度赋给len（应对读到非一个字节的情况）
            int len = bis.read(buf);
            while (len != -1) {
                // 写一个字节到目的文件
                bos.write(buf, 0, len);
                // 再读下一个字节到buf中转站中
                len = bis.read(buf);
            }



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
