package com.river.ios3;

import java.io.*;

public class TestBufferedReaderWriter {
    public static void main(String[] args) throws IOException {
        // 1. create stream
        BufferedReader bf = new BufferedReader(new FileReader("d:/readme.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("d:/readme2.txt"));

        // 2. use stream
        String str = bf.readLine();
        while (str != null) {
            System.out.println(str);
            bw.write(str);
            bw.newLine(); // 换行
            str = bf.readLine();
        }

        // 3. close stream
        bf.close();
        bw.close();
    }
}
