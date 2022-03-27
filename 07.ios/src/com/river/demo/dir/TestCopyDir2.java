package com.river.demo.dir;

import java.io.*;
import java.util.function.DoubleToIntFunction;

/**
 * 复制文件夹
 * 1.复制一个文件
 * 2.复制一个文件夹下的所有文件
 */
public class TestCopyDir2 {
    public static void main(String[] args) {
        //copyFile("d:/readme.txt", "d:/hello.txt");
        copyDir("d:/zOpenme", "d:/zOpenme2");

    }

    public static void copyDir(String sourceDirName, String destDirName) {
        // 源文件夹必修存在
        File sourceDir = new File(sourceDirName);
        if (!sourceDir.exists()) {
            System.err.println("源文件夹必须存在");
            return;
        }
        // 目的文件夹必须创建
        File destDir = new File(destDirName);
        if (!destDir.exists()) {
            destDir.mkdirs();
        }
        // 复制源文件夹下的所有的文件到目标文件夹
        File[] files = sourceDir.listFiles();
        System.out.println("The source names | is file?");
        for (File file : files) {
            System.out.println(file.getName() + "\t\t\t" + file.isFile());
            // 如果是文件就复制
            if (file.isFile()) {
                copyFile(sourceDirName + "/" + file.getName(), destDirName + "/" + file.getName());
            }
        }
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
