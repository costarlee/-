package com.xaut.caseday1;

import java.util.Random;
import java.util.Scanner;

public class CaseDemo7 {
    public static void main(String[] args) {
        System.out.println("双色球（福利彩票）抽奖程序。6个红色号码+1个蓝色号码");
        //定义一个数组 存放用户选择的号码
        int[] userNumber = new int[7];
        //利用循环 记录用户选择的号码
        Scanner sc = new Scanner(System.in);
        //提示用户输入红色号码
        for (int i = 0; i < userNumber.length - 1; i++) {
            System.out.println("请输入第"+(i + 1)+"个号码：（1~33）");
            userNumber[i] = sc.nextInt();
        }
        //用户输入蓝色号码
        System.out.println("请输入蓝色号码：（1~16）");
        userNumber[userNumber.length-1] = sc.nextInt();

        //打印用户选择的号码
        System.out.println("你选择的一组号码是：");
        printArray(userNumber);

        //打印中奖号码
        System.out.println("中奖号码是：");
        int[] luckyNumber = luckyNumber();
        printArray(luckyNumber);

        //判断中将类型
        judge(userNumber,luckyNumber);
    }

    //判断中将类型
    public static void judge(int[] userNumber,int[] luckyNumber){
        //红球中奖的个数
        int redCount = 0;
        for (int i = 0; i < userNumber.length-1; i++) {
            for (int j = 0; j < luckyNumber.length-1; j++) {
                if(userNumber[i] == luckyNumber[j]){
                    redCount ++ ;
                    break;
                }
            }
        }
        //判断蓝球中奖的个数
        int blueCount = userNumber[userNumber.length-1] == luckyNumber[luckyNumber.length-1] ? 1:0;
        //判断奖型
        if(blueCount == 1 && redCount < 3){
            System.out.println("恭喜你获得六等奖，奖金5元。");
        }else if(redCount == 4 || redCount == 3 && blueCount == 1){
            System.out.println("恭喜你获得五等奖，奖金10元。");
        }else if(redCount == 5 || redCount == 4 && blueCount == 1){
            System.out.println("恭喜你获得四等奖，奖金200元。");
        }else if(redCount == 5 && blueCount == 1){
            System.out.println("恭喜你获得三等奖，奖金3000元。");
        }else if(redCount == 6 && blueCount == 0){
            System.out.println("恭喜你获得二等奖，奖金500W元。");
        }else if(redCount == 6 && blueCount == 1){
            System.out.println("恭喜你获得一等奖，奖金1000W元。");
        }else {
            System.out.println("感谢你对福利事业作出的巨大贡献！");
        }
    }
    //编写方法 生成中奖号码
    public static int[] luckyNumber(){
        //生成6个红色号码
        int[] luckyNumber = new int[7];
        Random r = new Random();
        for (int i = 0; i < luckyNumber.length - 1; i++) {
            luckyNumber[i] = r.nextInt(1,34);
            for (int j = 0; j < i; j++) {
                if(luckyNumber[i] == luckyNumber[j]){
                    i -=1;
                    break;
                }
            }
        }
        //生成蓝色号码
        luckyNumber[luckyNumber.length-1] = r.nextInt(1,17);
        //返回生成的中奖号码
        return luckyNumber;
    }

    //打印数组方法
    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i == arr.length - 1 ? arr[i] : arr[i] + ",");
        }
        System.out.println();
    }

}
