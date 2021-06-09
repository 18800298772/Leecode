package interview.maxSubArray;

/**
 * 数组最大连续子序列和
 * 给定一个数组，其中元素可正可负，求其中最大连续子序列的和。
 * Create by LiShuang on 2020/12/7 13:52
 *
 * sum[i] = max{sum[i-1]+a[i],a[i]}.
 **/

public class Maxsum_location {
    public static void main(String[] args) {
        int[] array = {2, -2, -3, -4, 1};
        if (array.length == 0)
            System.out.println(0);
        else {
            int temp = array[0];
            int num = array[0];;
            for (int i = 1; i < array.length; i++) {
                if (temp >= 0)
                    temp += array[i];
                else
                    temp = array[i];
                if (temp > num)
                    num = temp;
            }
            System.out.println(num);
        }
    }
}
