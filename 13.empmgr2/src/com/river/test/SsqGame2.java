package com.river.test;


import java.util.Scanner;

/**
 * 迭代2：实现主菜单循环显示和选择
 *
 */
public class SsqGame2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		do{
			System.out.println("");
			System.out.println("*****欢迎进入双色球彩票系统*****");
			System.out.println("\t1.购买彩票");
			System.out.println("\t2.查看开奖");
			System.out.println("\t3.退出");
			System.out.println("***************************");
			System.out.print("请选择菜单：");

			int choice = input.nextInt();
			switch (choice) {
				case 1:
					System.out.println("购买彩票");
					break;
				case 2:
					System.out.println("查看开奖");
					break;
				case 3:
					System.out.println("谢谢使用");
					return;
				default:
					System.out.println("输入错误");
			}
		}while(true);
	}
}
