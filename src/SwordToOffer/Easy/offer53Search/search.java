package SwordToOffer.Easy.offer53Search;

/**
 * Create by LiShuang on 2020/12/10 16:09
 * 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 **/

public class search {
    //方法1：
    // 1.先通过二分法找到其中一个target的序列
    //2.分别向前和向后遍历找到属于等于target的元素
    public static int search(int[] nums, int target) {
        int len=nums.length;
        if(len==0 || nums[0]>target || nums[len-1]<target){
            return 0;
        }
        int a=0,b=len,c=(a+b)/2,count=0;
        // 1.先通过二分法找到其中一个target的序列
        while (nums[c]!=target && a<b-1){
            if(nums[c]<target){
                a=c;
            }else {
                b=c;
            }
            c=(a+b)/2;
        }
        if(a>=b){
            return 0;
        }
        //2.分别向前和向后遍历找到属于等于target的元素
        if(nums[c]==target){
          count++;
        }
        int m=c+1;
        while (m<len && nums[m]==target){
            count++;
            m++;
        }
        m=c-1;
        while (m>=0 && nums[m]==target)
        {
            count++;
            m--;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums={5,7,8,8,4,1,2};
        System.out.println(search1(nums,2));
    }

    //方法2：
    // 1.找到大于target的元素的最小序列
    //例如：nums = [5,7,7,8,8,10], target = 8
    //helper(nums, target) - helper(nums, target - 1)：>8的第一个元素下标- >7的第一个元素下标:5-3
    public static int search1(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }
    static int helper(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= tar) i = m + 1;
            else j = m - 1;
        }
        return i;
    }

}
