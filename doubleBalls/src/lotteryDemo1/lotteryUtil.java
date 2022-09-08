package lotteryDemo1;

import java.util.Arrays;
import java.util.Scanner;

public class lotteryUtil {
    /* 一等奖	中6+1	高等奖奖金的75%与奖池奖金之和除以中奖注数
     -------------------------------------------------------
       二等奖	中6+0	高等奖奖金的25%除以中奖注数
     -------------------------------------------------------
       三等奖	中5+1	3000元
     -------------------------------------------------------
       四等奖	中5+0	200元
                中4+1
     -------------------------------------------------------
       五等奖	中4+0	10元
                中3+1
     -------------------------------------------------------
       六等奖	中2+1	5元
                中1+1
                中0+1
     */

    /**
     * 查看购买的号码和开奖号码，对比是否中奖
     * @param lucky 开奖数组
     * @param lottery 购买的数组
     * @return 返回中的钱
     */
    public static int lotteryWin(int[] lucky,int[] lottery){
        // 判断前六位有几位相同
        int red=0;
        int money=0;
        for (int y = 0; y < 6; y++) {
            for (int i = y; i < 6; i++) {
                if (lucky[y] == lottery[i]) {
                    red++;
                }
            }
        }
        int blue=lucky[6]==lottery[6]?1:0;  //11	13	14	19	26	28	蓝:	4
        int y=1;
        for (int a : lottery
        ) {
            if (y == 1) {
                System.out.print("红:" + "\t");
            }
            if (y == 7) {
                System.out.print("蓝:" + "\t");
            }
            System.out.print(a + "\t");
            y++;
        }
        // 如果中奖，flag立马变成false，防止多次重复开奖
        boolean flag=true;
        if (red==6&&blue==1){
            money=5000000;
            System.out.println("一等奖 ￥500万");
            flag=false;
        }
        if (red==6&&blue==0&&flag){
            money=1250000;
            System.out.println("二等奖 ￥125万");
            flag=false;
        }
        if ((red==5&&blue==1)&&flag){
            money=3000;
            System.out.println("三等奖 ￥3000");
            flag=false;
        }
        if ((red==5||(blue+red)==5)&&flag){
            money=200;
            System.out.println("四等奖 ￥200");
            flag=false;
        }
        if ((red==4||(blue+red)==4)&&flag){
            money=10;
            System.out.println("五等奖 ￥10");
            flag=false;
        }
        if ((blue==1&&(blue+red<4))&&flag){
            money=5;
            System.out.println("六等奖 ￥5");
            flag=false;
        }
        if ((red<4&&blue==0)&&flag){
            System.out.println("未中奖");
        }
        return money;
    }

     /**
     * 手动选择双色球号码 6个红球 1个蓝球 红球1~33 蓝球1~16
     * @return 返回一组用户输入的双色球号码
     */
    public static int[] manualPick(){
        Scanner sc = new Scanner(System.in);
        int[] ballsR=new int[6];
        int pickBall;
        for (int i = 0; i < 6; i++) {
            System.out.println("请输入第"+(i+1)+"个红球号码（1~33）：");
            pickBall=sc.nextInt();
            while (judge(ballsR,pickBall)){
                System.out.println("输入的第"+(i+1)+"个红球不符合规范（有重复或者不在1~33之内）");
                pickBall= sc.nextInt();
            }
            ballsR[i]=pickBall;
        }
        // 升序前6个号码
        Arrays.sort(ballsR);
        // 将红球数组放入总数组
        int[] ballsA=new int[7];
        System.arraycopy(ballsR,0,ballsA,0,6);
        System.out.print("请输入蓝球号码（1~16）：");
        int blueball=sc.nextInt();
        while (blueball<1 || blueball>16){
            System.out.println("输入的蓝球号码不符合规范（1~16）");
            blueball= sc.nextInt();
        }
        ballsA[6]=blueball; // 输入蓝球
        System.out.println("正在排序您输入的号码... ...");
        return ballsA;
    }

    /**
     *  生成一个随机双色球数组，双色球号码符合中国双色球规则
     * @return 返回一组双色球数组
     */
    public static int[] randomPick(){
        // 创建红球数组
        int[] arr=new int[6];
        // 生成随机数1~33
        int redBall=(int)(Math.random()*33+1);
        for (int i = 0; i < 6; i++) {
            // 掉用judge方法，如果重复，则重新生成随机数
            while (judge(arr,redBall)){
                redBall=(int)(Math.random()*33+1);
            }
            // 将不重复的随机数录入数组
            arr[i]=redBall;
        }
        // 升序红球数组
        Arrays.sort(arr);
        // 将红球数组放入总数组
        int[] arrA=new int[7];
        System.arraycopy(arr,0,arrA,0,6);
        // 生成随机数1~16，并赋给数组的最后一位
        arrA[6]=(int)(Math.random()*16+1);
        // 返回该数组
        return arrA;
    }

    /**
     * 判断一个指定整型数组中是否含有给定元素
     * @param arr 指定的整型数组
     * @param a 给定的元素
     * @return 如果含有该元素，返回true，否则返回false
     */
    public static boolean judge(int[] arr,int a) {
        boolean flag=false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == a || a<1 || a>33) {
                flag=true;
            }
        }
        return flag;
    }

}
