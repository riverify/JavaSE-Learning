package com.river.ios5;

import java.io.*;

/**
 * 字符流 输出流 包装流
 * servlet中会遇到此类
 */
public class TestPrintWriter {
    public static void main(String[] args) throws Exception {
        // 1. create stream
        BufferedReader bf = new BufferedReader(new FileReader("d:/readme.txt"));
        //BufferedWriter bw = new BufferedWriter(new FileWriter("d:/readme2.txt"));
        PrintWriter pw = new PrintWriter("d:/readme2.txt");

        // 2. use stream
        String str = bf.readLine();
        while (str != null) {
            System.out.println(str);
            pw.println(str);
            str = bf.readLine();
        }

        // 3. close stream
        bf.close();
        pw.close();
    }
}
