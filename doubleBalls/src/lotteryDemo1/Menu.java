package lotteryDemo1;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 自选投注的号码数组
        int doubleBalls1[][] = new int[0][0];
        // 机选投注的号码数组
        int doubleBalls2[][] = new int[0][0];
        // 合并后的号码数组
        int finalLottery[][] = new int[0][0];
        // 开奖的号码数组
        int luckyLottery[]=new int[0];
        // 对两种模式下的双色球进行计数
        int times1=0,times2=0;

        o1:while(true){
        System.out.println("欢迎使用双色球系统，官方网站www.zhongnmlgb.com");
        System.out.println("*------------请输入菜单选项------------*");
        System.out.println("*            1:购买双色球（￥2一注）    *");
        System.out.println("*            2:查看已购买的双色球       *");
        System.out.println("*            3:进行开奖               *");
        System.out.println("*            4:查看中奖               *");
        System.out.println("*            5:退出系统               *");
        System.out.println("*------------------------------------*");
        System.out.println("请输入选项");
        short option= sc.nextShort();
            switch (option){
                case 1:
                    // 进入二级菜单，选择投注模式
                     o2:while (true){
                         System.out.println("*------------请输入投注模式------------*");
                         if (times1>0){
                             System.out.println("*       自选投注已经选择，请勿再次选择     *");
                         }else System.out.println("*             1:自选号码              *");
                         if (times2>0){
                             System.out.println("*       机选投注已经选择，请勿再次选择     *");
                         }else System.out.println("*             2:机选号码              *");
                         System.out.println("*------------按3以返回主菜单------------*");
                         System.out.println("*------------------------------------*");
                         short method= sc.nextShort();
                         switch (method){
                             case 1:
                                 // 判断是否已经自选过，若是，则不予再次自选
                                 if (times1>0){
                                     System.out.println("请勿重复自选投注");
                                     break o2;
                                 }else {
                                     System.out.println("请选择自选号码的投注次数（￥2一注）：");
                                     // 从键盘录入投注次数
                                     int t1 = sc.nextInt();
                                     // 更改数组的第一维数，使之与投注次数相匹配
                                     doubleBalls1 = new int[t1][];
                                     // 循环给每次投注的号码赋值
                                     for (int i = 0; i < t1; i++) {
                                         System.out.println("第" + (i + 1) + "次投注号码：");
                                         // 利用lottUtil的manualPick方法给一注号码赋值
                                         doubleBalls1[i] = lotteryUtil.manualPick();
                                         // 记一次数
                                         times1++;
                                         // 合并两种模式的数组
                                         finalLottery = arrayUtil.combine2DArrays(doubleBalls1, doubleBalls2, times1, 7, times2, 7);
                                     }
                                     // 提示购买成功
                                     System.out.println("您成功购买了"+(times1)+"注彩票");
                                 }
                                 // 退到一级菜单
                                 break o2;
                             case 2:
                                 // 判断是否已经机选过，若是，则不予再次机选
                                 if (times2>0){
                                     System.out.println("请勿重复机选投注");
                                     break o2;
                                 }else {
                                     System.out.println("请选择机选号码的投注次数：");
                                     int t2 = sc.nextInt();
                                     // 更改数组的第一维数，使之与投注次数相匹配
                                     doubleBalls2 = new int[t2][];
                                     // 循环给每次机选投注的号码赋值
                                     for (int i = 0; i < t2; i++) {
                                         System.out.println("正在为您购买"+(i+1)+"注彩票");
                                         // 利用lottUtil的randomPick方法自动随机给一注号码赋值
                                         doubleBalls2[i] = lotteryUtil.randomPick();
                                         // 记一次数
                                         times2++;
                                         // 合并两种模式的数组
                                         finalLottery = arrayUtil.combine2DArrays(doubleBalls1, doubleBalls2, times1, 7, times2, 7);
                                     }
                                     // 提示购买成功
                                     System.out.println("您成功购买了"+(times2)+"注彩票");
                                     // 退到一级菜单
                                     break o2;
                                 }
                             case 3:
                                 break o2;
                             default:
                                 System.out.println("选择有误，请重新选择投注模式");
                                 break;
                         }

                     }
                     break;

                case 2:
                    // 查看已选购的双色球
                    // 判断是否购买，购买了才能查看
                    if (finalLottery.length==0){
                        System.out.println("请先购买双色球再来查看号码！");
                    }
                    else {
                        for (int i = 0; i < finalLottery.length; i++) {
                            int y = 1;
                            for (int a : finalLottery[i]
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
                            System.out.println();
                        }
                    }
                    break;
                case 3:
                    // 运行开奖代码
                    if (finalLottery.length==0){
                        System.out.println("您还没有购买双色球，请购买后再查看开奖");
                    }
                    else if (luckyLottery.length==0){
                        System.out.println("本期开奖号码是：");
                        luckyLottery=lotteryUtil.randomPick();
                        int count=1;
                        for (int a : luckyLottery
                        ) {
                            if (count == 1) {
                                System.out.print("红:" + "\t");
                            }
                            if (count == 7) {
                                System.out.print("蓝:" + "\t");
                            }
                            System.out.print(a + "\t");
                            count++;
                        }
                        System.out.println("祝君中奖！");
                    }
                    else {
                        int count=1;
                        for (int a : luckyLottery
                        ) {
                            if (count == 1) {
                                System.out.print("红:" + "\t");
                            }
                            if (count == 7) {
                                System.out.print("蓝:" + "\t");
                            }
                            System.out.print(a + "\t");
                            count++;
                        }
                        System.out.println("祝君中奖！");
                    }
                    break;
                case 4:
                    // 先查看是否买了并开奖了，再查看是否中奖
                    if (luckyLottery.length==0||finalLottery.length==0) {
                        System.out.println("请先购买并且开奖后再来兑奖");
                        break;
                    }
                    else {
                        int earn=0;
                        for (int i = 0; i < finalLottery.length; i++) {
                            earn+=lotteryUtil.lotteryWin(luckyLottery, finalLottery[i]);
                        }
                        System.out.println("您一共花费"+(finalLottery.length*2)+"￥，中奖获得了￥"+earn);
                        if ((finalLottery.length)>earn){
                            System.out.println("你亏损了￥"+((finalLottery.length*2)-earn));
                        }else System.out.println("你竟然赚了￥"+(earn-(finalLottery.length*2)));
                    }
                    break o1;
                case 5:
                    System.out.println("成功退出系统!");
                    break o1;
                default:
                    System.out.println("选项有误，请重新选择");
                    break;
            }
        }
        sc.close();
    }
}
