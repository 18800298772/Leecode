package DataStructures.SortAlgorithm;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Create by LiShuang on 2021/6/1 15:36
 * 选择排序（select sorting）也是一种简单的排序方法。它的基本思想是：
 * 第一次从arr[0]~arr[n-1]中选取最小值，与arr[0]交换，
 * 第二次从arr[1]~arr[n-1]中选取最小值，与arr[1]交换，
 * 第三次从arr[2]~arr[n-1]中选取最小值，与arr[2]交换，…，
 * 第i次从arr[i-1]~arr[n-1]中选取最小值，与arr[i-1]交换，…,
 * 第n-1次从arr[n-2]~arr[n-1]中选取最小值，与arr[n-2]交换，
 * 总共通过n-1次，得到一个按排序码从小到大排列的有序序列。
 **/

public class SelectSort {
    public void SelectSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int minIndex=i;
            int min=arr[i];
            //找到每个循环中的最小值
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<min){
                    minIndex=j;
                    min=arr[j];
                }
            }
            //最小值和arr[i]交换
            if(minIndex!=i){
                arr[minIndex]=arr[i];
                arr[i]=min;
            }
        }
    }
    @Test
    public void test_max(){
        int[] arr=new int[]{3,-1,9,10,7};
        SelectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
