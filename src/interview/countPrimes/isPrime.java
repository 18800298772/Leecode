package interview.countPrimes;

/**
 * 统计小于n的质数的个数
 *
 * Create by LiShuang on 2020/12/7 20:15
 **/

public class isPrime {
        public static int countPrimes(int n) {
            boolean[] isPrime = new boolean[n + 1];
            int count = 0;
            for(int i = 2; i < n;i++){
                if(isPrime[i] == false){
                    count++;

                    //重点这句
                    for(int j = i + i; j < n; j += i){
                        isPrime[j] = true;
                    }
                }
            }
            return count;
        }

    public static void main(String[] args) {
        System.out.println(countPrimes(100));
    }
}
