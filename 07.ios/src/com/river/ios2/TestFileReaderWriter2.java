package com.river.ios2;

import java.io.*;

public class TestFileReaderWriter2 {
    public static void main(String[] args) throws IOException {
        // 1.创建流
        Reader fr = new FileReader("d:/readme.txt");
        Writer fw = new FileWriter("d:/readme2.txt", true);

        // 2.使用流
        // 2.1 定义一个中转站
        char[] cbuf = new char[1024];
        int len = fr.read(cbuf);
        while (len != -1) {
            fw.write(cbuf, 0, len);
            len = fr.read();
        }

        // 3.关闭流
        fr.close();
        fw.close();
    }
}
