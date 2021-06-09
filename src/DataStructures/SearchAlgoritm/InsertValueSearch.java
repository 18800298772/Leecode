package DataStructures.SearchAlgoritm;

/**
 * Create by LiShuang on 2021/6/8 22:46
 *插值查找算法类似于二分查找，不同的是插值查找每次从自适应mid处开始查找（key为目标）
 * mid = mid=left+(right-left)*(（findval-arr[left]）/(arr[right]-arr[left]));  ;插值索引
 **/

public class InsertValueSearch {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8,10 , 10 , 10, 10, 10,14,15,16,17,18,19,20 };
        System.out.println(InsertValue(arr,0,arr.length-1,20));
    }
    /**
     *
     * @param arr 数组
     * @param left 左边的索引
     * @param right 右边的索引
     * @param findval 要查找的值
     * @return 如果找到就返回下标，如果没有找到，就返回 -1
     */
    public static int InsertValue(int[] arr,int left,int right,int findval){
        // 当 left > right 时，说明递归整个数组，但是没有找到
        if(left>right || findval<arr[left] || findval>arr[right])return -1;
        //mid = mid=left+(right-left)*(findval-arr[left]/(arr[right]-arr[left]));  ;/*插值索引*/
        int mid=left+(right-left)*((findval-arr[left])/(arr[right]-arr[left]));
        if(arr[mid]>findval) return InsertValue(arr,left,mid-1,findval);
        if(arr[mid]<findval) return InsertValue(arr,mid+1,right,findval);// 向 右递归
        else return mid;
    }
}
