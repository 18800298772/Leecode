package SwordToOffer.Easy.offer01findRepeatNumber;

import org.testng.annotations.Test;

/**
 * Create by LiShuang on 2021/5/30 22:04
 * 找出数组中重复的数字。
 * 原地交换
 **/

public class offer01 {
    public int findRepeatNumber(int[] nums) {
        int Len=nums.length;
        for(int i=0;i<Len;i++) {
            if(i==nums[i])
                continue;
            if (nums[nums[i]]==nums[i]) {
                return nums[i];
            }
            int tmp = nums[nums[i]];
            nums[nums[i]] = nums[i];
            nums[i] = tmp;
        }
        return -1;
    }

    @Test
    public void test() {
        int[] nums=new int[]{0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int M=findRepeatNumber(nums);
        System.out.println(M);
    }

}
