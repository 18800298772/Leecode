package interview.sortAlgorithm;

import java.util.Arrays;

/**
 * Create by LiShuang on 2020/12/7 9:51
 *
 * 一、稳定性:
 * 　   稳定：冒泡排序、插入排序、归并排序和基数排序
 * 　　不稳定：选择排序、快速排序、希尔排序、堆排序
 * 二、平均时间复杂度
 * 　　O(n^2):直接插入排序，简单选择排序，冒泡排序。
 * 　　在数据规模较小时（9W内），直接插入排序，简单选择排序差不多。当数据较大时，冒泡排序算法的时间代价最高。性能为O(n^2)的算法基本上是相邻元素进行比较，基本上都是稳定的。
 * 　　O(nlogn):快速排序，归并排序，希尔排序，堆排序。
 * 　　其中，快排是最好的， 其次是归并和希尔，堆排序在数据量很大时效果明显。
 **/

public class SortAlgorithm {




}
//堆排序
class heapSort{
    public static void heapSort(int[] a){
        int len=a.length;
        //循环建堆
        for(int i=0;i<len-1;i++){
            //建堆
            buildMaxHeap(a,len-1-i);
            //交换堆顶和最后一个元素
            swap(a,0,len-1-i);
        }
    }
    //交换方法
    private static void swap(int[] data, int i, int j) {
        int tmp=data[i];
        data[i]=data[j];
        data[j]=tmp;
    }
    //对data数组从0到lastIndex建大顶堆
    private static void buildMaxHeap(int[] data, int lastIndex) {
        //从lastIndex处节点（最后一个节点）的父节点开始
        for(int i=(lastIndex-1)/2;i>=0;i--){
            //k保存正在判断的节点
            int k=i;
            //如果当前k节点的子节点存在
            while(k*2+1<=lastIndex){
                //k节点的左子节点的索引
                int biggerIndex=2*k+1;
                //如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if(biggerIndex<lastIndex){
                    //若果右子节点的值较大
                    if(data[biggerIndex]<data[biggerIndex+1]){
                        //biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }
                //如果k节点的值小于其较大的子节点的值
                if(data[k]<data[biggerIndex]){
                    //交换他们
                    swap(data,k,biggerIndex);
                    //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k=biggerIndex;
                }else{
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr=new int[]{3,7,2,4,6,3};
        heapSort(arr);
    }
}

class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low >= high) {
            return;
        }
        i = low;
        j = high;
        //temp就是基准位
        temp = arr[low];

        while (i < j) {
            //先看右边，依次往左递减,找到小于temp的数
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增，找到大于temp的数
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
    }


    public static void main(String[] args) {
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}

