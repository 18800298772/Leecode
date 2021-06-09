package DataStructures.SortAlgorithm;

import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Create by LiShuang on 2021/6/1 14:56
 * 冒泡排序
 * 冒泡排序（Bubble Sorting）的基本思想是：通过对待
 * 排序序列从前向后（从下标较小的元素开始）,依次比较
 * 相邻元素的值，若发现逆序则交换，使值较大
 * 的元素逐渐从前移向后部，就象水底下的气泡一样逐渐
 * 向上冒。
 **/


public class BubbleSort {
    //冒泡排序正向排序
    public void BubbleSort_max(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }
    }
    //冒泡排序逆向排序
    public void BubbleSort_min(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]<arr[j+1]){
                    int tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }
    }

    //冒泡排序的优化：如果某一次循环时没有任何交换则说明已经排序完成
    public void BubbleSort_optimize(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            //标志此次循环有无交换
            Boolean Flag=false;
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                    Flag=true;
                }
            }
            if(!Flag)break;
        }
    }

    @Test
    public void test_max(){
        int[] arr=new int[]{3,-1,9,10,7};
        BubbleSort_max(arr);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void test_min() {
        int[] arr=new int[]{3,-1,9,10,7};
        BubbleSort_min(arr);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void test_optimize(){
        int[] arr=new int[]{3,-1,9,10,7};
        BubbleSort_optimize(arr);
        System.out.println(Arrays.toString(arr));
    }
    @Test(description = "测试优化后的时间复杂度")
    public void test_optimize_2(){
        int[] arr=new int[8000000];
        for(int i=0;i<8000000;i++){
            arr[i]=(int)Math.random()*8000000;
        }
        Date date1=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(date1));

        BubbleSort_optimize(arr);

        Date date2=new Date();
        System.out.println(simpleDateFormat.format(date2));
    }
}
