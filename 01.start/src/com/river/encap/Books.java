package com.river.encap;

/**
 * 以面向对象的思想，编写自定义类描述图书信息。设定属性包括：书名，作者，出版社名，价格；方法包括：信息介绍
 * 要求：
 * 1) 设置属性的私有访问权限，通过公有的get,set方法实现对属性的访问
 * 2) 限定价格必须大于10，如果无效进行提示
 * 3) 设计构造方法实现对属性赋值
 * 4) 信息介绍方法描述图书所有信息
 * 5) 编写测试类，测试图书类的对象及相关方法（测试数据信息自定）
 */
public class Books {
    //成员变量
    private String bookName;//书名
    private String author;//作者
    private String publisher;//出版社
    private double price;//价格
    //构造方法(无参)
    public Books(){}
    //有参
    public Books(String bookName,String author,String publisher,double price){
        this.bookName=bookName;
        this.author=author;
        this.publisher=publisher;
        setPrice(price);
    }
    //成员方法
    //设值
    public void setBookName(String bookName){
        this.bookName=bookName;
    }
    public void setAuthor(String author){
        this.author=author;
    }
    public void setPublisher(String publisher){
        this.publisher=publisher;
    }
    public void setPrice(double price){
        if (price<=10){
            System.err.println("输入无效的价格");
            return;
        }
        this.price=price;
    }
    //取值
    public String getBookName(){
        return bookName;
    }
    public String getAuthor(){
        return author;
    }
    public String getPublisher(){
        return publisher;
    }
    public double getPrice(){
        return price;
    }
    //显示书籍信息
    public void show(){
        System.out.println("书名："+bookName+"，作者："+author+"，出版社："+publisher+"，价格："+price);
    }
}
