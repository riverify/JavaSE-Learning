package com.river.ios5;

import java.io.*;

/**
 *  转换流 字节流-->字符流  （ OutputStreamWriter
 *
 *  func:读取来自键盘的一行行数据，写进文件中
 *
 *  设计模式：适配器模式
 */
public class TestInputStreamReader {
    public static void main(String[] args) throws Exception {
        // 1. create stream
        InputStream is = System.in;
        Reader reader = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(reader);
//        BufferedWriter bw = new BufferedWriter(new FileWriter("d:/readme2.txt"));
        PrintWriter pw = new PrintWriter("d:/readme2.txt");

        // 2. use stream
        String str = br.readLine();
        while (!"bye".equals(str)) {
            System.out.println(str);
            pw.println(str);
            str = br.readLine();
        }

        // 3. close stream
        br.close();
        pw.close();
    }
}
