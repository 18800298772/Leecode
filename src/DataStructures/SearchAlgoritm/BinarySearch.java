package DataStructures.SearchAlgoritm;

import java.util.ArrayList;

/**
 * Create by LiShuang on 2021/6/8 21:53
 * //注意：使用二分查找的前提是 该数组是有序的.
 **/

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8,10 , 10 , 10, 10, 10,14,15,16,17,18,19,20 };
        System.out.println(Binary(arr,0,arr.length-1,5));
        //返回所有下标
        ArrayList result=Binary_list(arr,0,arr.length-1,10);
        System.out.println(result);
    }
    /**
     *
     * @param arr 数组
     * @param left 左边的索引
     * @param right 右边的索引
     * @param findval 要查找的值
     * @return 如果找到就返回下标，如果没有找到，就返回 -1
     */
    public static int Binary(int[] arr,int left,int right,int findval){
        // 当 left > right 时，说明递归整个数组，但是没有找到
        if(left>right || findval<arr[left] || findval>arr[right])return -1;
        int mid=(left+right)/2;
        if(arr[mid]>findval) return Binary(arr,left,mid-1,findval);
        if(arr[mid]<findval) return Binary(arr,mid+1,right,findval);// 向 右递归
        else return mid;
    }


//     * 有多个相同的数值时，如何将所有的数值都查找到，比如这里的 1000
//            *
//            * 思路分析
//	 * 1. 在找到mid 索引值，不要马上返回
//	 * 2. 向mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
//	 * 3. 向mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
//	 * 4. 将Arraylist返回
    public static ArrayList Binary_list(int[] arr,int left,int right,int findval){
        // 当 left > right 时，说明递归整个数组，但是没有找到
        if(left>right)return new ArrayList();
        int mid=(left+right)/2;
        if(arr[mid]>findval) return Binary_list(arr,left,mid-1,findval);
        if(arr[mid]<findval) return Binary_list(arr,mid+1,right,findval);// 向 右递归
        else {
            //			 * 思路分析
//			 * 1. 在找到mid 索引值，不要马上返回
//			 * 2. 向mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
//			 * 3. 向mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
//			 * 4. 将Arraylist返回
            ArrayList result=new ArrayList();
            result.add(mid);
            //向mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
            for(int temp=mid-1;temp>0;temp--){
                if(arr[temp]!=findval)break;
                result.add(temp);
            }
            //向mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
            for(int temp=mid+1;temp<arr.length-1;temp++){
                if(arr[temp]!=findval)break;
                result.add(temp);
            }
            return result;
        }
    }
}
