package com.river.ios2;

import java.io.*;

public class TestFileReaderWriter3 {
    public static void main(String[] args) {
        Reader fr = null;
        Writer fw = null;
        try {
            // 1.创建流
            fr = new FileReader("d:/readme.txt");
            fw = new FileWriter("d:/readme2.txt", true);

            // 2.使用流
            // 2.1 定义一个中转站
            char[] cbuf = new char[1024];
            int len = fr.read(cbuf);
            while (len != -1) {
                fw.write(cbuf, 0, len);
                len = fr.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 3.关闭流, 都要关闭 分别捕获
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
