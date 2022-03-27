package com.river.oops;

import javax.swing.*;

public class Computer {
    //成员变量  静态特征
    String cpu;//处理器
    String gpu;//显卡
    String motherBoard;//主板
    String memory;//内存
    //构造方法  完成一些初始化操作
    public Computer(){
        System.out.println("------Computer------");
    }
    //构造方法的重载
    //进行一些初始化操作
    public Computer(String cpu,String gpu,String motherBoard,String memory){
        this.cpu=cpu;
        this.gpu=gpu;
        this.motherBoard=motherBoard;
        this.memory=memory;  //局部变量和成员变量重名，局部变量优先级高,this修饰成员变量
    }
    //成员方法  动态行为
    public void start(){
        System.out.println("------starting------");
    }
    public void show(){
        System.out.println("CPU="+cpu+",GPU="+gpu+",Motherboard="+motherBoard+",Memory="+memory);
    }
    public void stop(){
        System.out.println("------stopping------");
    }

    public static void main(String[] args) {
        //创建一个计算机
        Computer computer=new Computer();
        //操作属性
        computer.cpu="11代酷睿i5";
        computer.gpu="锐炬核显";
        computer.motherBoard="联想";
        computer.memory="LPDDR5 4299 16G";
        //执行方法
        computer.start();
        computer.show();
        computer.stop();

        Computer computer2=new Computer("11代酷睿i5","锐炬核显","联想","LPDDR5 4299 16G");
//        computer.cpu="11代酷睿i5";
//        computer.gpu="锐炬核显";
//        computer.motherBoard="联想";
//        computer.memory="LPDDR5 4299 16G";
        computer.start();
        computer.show();
        computer.stop();
    }
}
