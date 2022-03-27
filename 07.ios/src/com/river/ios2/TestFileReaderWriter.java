package com.river.ios2;

import java.io.*;

public class TestFileReaderWriter {
    public static void main(String[] args) throws IOException {
        // 1.创建流
        Reader fr = new FileReader("d:/readme.txt");
        Writer fw = new FileWriter("d:/readme2.txt");

        // 2.使用流
        // 2.1 定义一个中转站
        int n;
        // 2.2 先读一个字符
//        n = fr.read();
//        while (n != -1) {
//            // 输出
//            //System.out.println((char)n);
//            // 写一个字符
//            fw.write(n);
//            // 再读一个字符
//            n = fr.read();
//        }

        // 简化后
        while ((n = fr.read()) != -1) {
            fw.write(n);
        }

        // 3.关闭流
        fr.close();
        fw.close();
    }
}
