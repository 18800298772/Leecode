package DataStructures.SortAlgorithm;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Create by LiShuang on 2021/6/1 20:35
 *
 **/

public class QuickSort{
    //这个不太对
    public void QuickSort_2(int[] arr,int left,int right){
        int l=left;
        int r=right;
        int pivot=arr[(left+right)/2];
        int temp=0;
        //让比pivot小的到左边，大的放右边
        while (l<r){
            //在pivot左边一直找到大于pivot的值
            while (arr[l]<pivot){
                l+=1;
            }
            //在pivot右边一直找到小于pivot的值
            while (arr[r]>pivot){
                r-=1;
            }
            //如果l >= r说明pivot 的左右两的值，已经按照左边全部是小于等于pivot值，右边全部是大于等于pivot值
            if(l>=r){
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
            if(arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
            if(arr[r] == pivot) {
                l += 1;
            }
            // 如果 l == r, 必须l++, r--, 否则为出现栈溢出
            if (l == r) {
                l += 1;
                r -= 1;
            }
            //向左递归
            if(left < r) {
                QuickSort(arr, left, r);
            }
            //向右递归
            if(right > l) {
                QuickSort(arr, l, right);
            }
        }
    }
    //这个是正确的
    public void QuickSort(int[] arr,int low, int high){
        //low=high时说明只有一个元素，不用排序
        if(low>=high){
            return;
        }
        //左边
        int l=low;
        //右边
        int r=high;
        int tmp=arr[low];//第一个数作为基准
        while (l<r){
            //右边开始找，找到第一个小于tmp的值，一直到左边指针处
            while (tmp<=arr[r] && r>l){
                r--;
            }
            //再从左边开始找，找到第一个大于tmp的值，一直到右边指针处
            while (arr[l]<=tmp && l<r){
                l++;
            }
            //如果左边大于右边则交换
            if(arr[l]>arr[r]){
                int t=arr[r];
                arr[r]=arr[l];
                arr[l]=t;
            }
        }
        //此循环的结尾一定是l=r;而且因为先从右边开始找最小值，所以最后l=r处的值一定是比基准值小的，所以将l=r处于基准值交换
        arr[low]=arr[l];
        arr[l]=tmp;
        //截止这里，在arr里，l=r处是基准值，左边都小于基准值，右边都大于基准值
        //以r划分左右两边
        //
        QuickSort(arr,low,l-1);
        QuickSort(arr,l+1,high);
    }
    @Test
    public void test(){
        int[] arr = {-9,78,0,3,70, -1,900, 4561};
        QuickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
