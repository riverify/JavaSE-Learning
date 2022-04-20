package com.river.util;

import java.io.*;
import java.util.Properties;

/**
 * 1.  public class Properties extends Hashtable 一种Map，存储键值对
 *
 * 2. key、value 都是String
 *
 * 3. 建议使用setProperty、getProperty，而不是put、get
 *
 * 4.写key-value到属性文件
 *
 *    OutputStream os = new FileOutputStream("d:/jdbc.properties");
 *     prop.store(os, "jdbc connection parameter ");
 *
 * 5.读属性文件中内容都Prop中
 *  InputStream is = new FileInputStream("d:/jdbc.properties");
 *         prop.load(is);
 *
 * 6.读取项目的中属性文件
 * InputStream is = TestProperties.class.getResourceAsStream("/jdbc.properties");
 *         prop.load(is);
 */
public class TestProperties {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        //prop.put("driver", "com.mysql.cj.jdbc.Driver");
        //System.out.println(prop.get("driver"));
        //prop.put(1, new Date().toString());
        //System.out.println(prop.get(1));
//        prop.setProperty("driver", "com.mysql.cj.jdbc.Driver");
//        prop.setProperty("user", "root");
//        prop.setProperty("password", "root");
//        System.out.println(prop.getProperty("driver"));
//        System.out.println(prop);
//        System.out.println(prop.size());

        //写key-value到属性文件
//        OutputStream os = new FileOutputStream("d:/jdbc.properties");
//        prop.store(os, "jdbc connection parameter ");

        System.out.println(prop);
        //读属性文件中内容都Prop中
//        InputStream is = new FileInputStream("d:/jdbc.properties");
//        prop.load(is);

        //读取项目的中属性文件
        InputStream is = TestProperties.class.getResourceAsStream("/jdbc.properties");
        prop.load(is);
        System.out.println(prop);
        System.out.println(prop.getProperty("driver"));

    }
}
