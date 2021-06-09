package SwordToOffer.Easy.offer11;

/**
 *
 *
 * Create by LiShuang on 2020/11/21 20:37
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *
 **/

public class numWays {
    public int numWays(int n) {
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
}
