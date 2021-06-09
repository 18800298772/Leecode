package DataStructures.SortAlgorithm;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Create by LiShuang on 2021/6/1 15:48
 **/

public class InsertSort {
    public void InsertSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            // 从后往前给给insertVal 找到插入的位置，默认位置在当前位置的前一个
            // 一直向前循环，当arr[insertIndex]>inserVal，说明前面可能还有数比insertVal小
            //arr[insertIndex+1]=arr[insertIndex];是让已经判断过的位置后移，留出一个位置给insertVal插入
            //例如：[-1,3,9,10,7],对于7；将7月前面的[-1,3,9,10]比较，insertIndex=3
            //第一次【-1,3,9,10,10】，arr[3]为预留给7的位置，insertIndex=2
            //第二次【-1,3,9,9,10】，arr[2]为预留给7的位置，insertIndex=1
            //第三次，3>7,3不用后移，7替换arr[2]（insertIndex+1）
            int insertIndex=i-1;
            int inserVal=arr[i];

          while (insertIndex>=0 && arr[insertIndex]>inserVal){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            if(insertIndex+1!=i){
                arr[insertIndex+1]=inserVal;
            }
        }
    }
    @Test
    public void test_max(){
        int[] arr=new int[]{3,-1,9,10,7};
        InsertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
