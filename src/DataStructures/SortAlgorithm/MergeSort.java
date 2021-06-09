package DataStructures.SortAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Create by LiShuang on 2021/6/8 10:59
 *归并排序
 **/

public class MergeSort {
    public static void main(String[] args) {
        int[] arr={8,4,5,7,1,3,2,6,2,0,234};
        int[] temp=new int[arr.length];//归并排序需要一个额外的空间
        mergesort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }
    //分解
    public static void mergesort(int[] arr,int left,int right,int[] temp){
        if(left<right){
            int mid=(left+right)/2;
            //向左递归分解
            mergesort(arr,left,mid,temp);
            //向右递归分解
            mergesort(arr,mid+1,right,temp);
            //到合并
            marge(arr,left,mid,right,temp);
        }
    }

    /**
     *
     * @param arr 原始数组
     * @param left 左边有序序列的初始索引
     * @param mid  中间索引
     * @param right 右边索引
     * @param temp 中转数组
     */
    //合并
    public static void marge(int[] arr, int left, int mid, int right, int[] temp){
        int i=left;
        int j=mid+1; //右边有序序列的初始索引
        int t=0;//temp 数组的当前索引
        //先把左右两边的数据（有序）按规则填充到temp,直到左右有一边处理完毕，
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t]=arr[i];
                i+=1;
            }else{
                temp[t]=arr[j];
                j+=1;
            }
            t+=1;
        }
        // 剩余一方的数据一次填充到temp
        while (i<=mid){
            temp[t]=arr[i];
            t+=1;
            i+=1;
        }
        while (j<=right){
            temp[t]=arr[j];
            t+=1;
            j+=1;
        }
        //temp拷贝到arr，并不是每次都拷贝8个
        t=0;
        int templeft=left;
        System.out.println("templeft="+templeft+"\tright="+right);
        while (templeft<=right){ //templeft==0,right=1 //
            arr[templeft]=temp[t];
            t+=1;
            templeft+=1;
        }
    }
}
