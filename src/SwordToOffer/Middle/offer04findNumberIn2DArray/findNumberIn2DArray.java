package SwordToOffer.Middle.offer04findNumberIn2DArray;

import org.testng.annotations.Test;

/**
 * Create by LiShuang on 2021/6/1 22:58
 * 二维数组的查找
 **/

public class findNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //从二维数组的右上角开始查找。如果当前元素等于目标值，则返回 true。如果当前元素大于目标值，则移到左边一列（j--）。如果当前元素小于目标值，则移到下边一行(i++)。
        if(matrix==null||matrix.length==0 || matrix[0].length==0) return false;
        int n=matrix.length;
        int m=matrix[0].length;
        if(target<matrix[0][0] || target>matrix[n-1][m-1]) return false;
        for(int i=0,j=m-1;i<n && j>=0;){
            if(matrix[i][j]==target) return true;
            if(matrix[i][j]>target) j--;
            else i++;
        }
        return false;
    }

    @Test
    public void test(){
        int[][] arrs={{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int targte=5;
        boolean Flag=findNumberIn2DArray(arrs,targte);
        System.out.println(Flag);
    }
}
