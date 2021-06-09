package SwordToOffer.Easy.Offer10;

import java.util.ArrayList;

/**
 * Create by LiShuang on 2020/11/21 20:20
 * 斐波那契数列
 **/

public class Fibonacci {
    public static int fib(int n) {
        int Fi=1000000007;
        int fib=0;
        int f1=1;
        int f2=0;


        if(n<0){
            System.out.println("Wrong Num");
        }else
        if(n==0){
            fib=f2;
        }else if (n==1){
           fib=f1;
        }else {
            for(int i=2;i<=n;i++){
                fib=(f1+f2)%Fi;
                f2=f1;
                f1=fib;
            }
        }
        return fib;
    }

    public static void main(String[] args) {
        System.out.println(fib(5));
    }
}
