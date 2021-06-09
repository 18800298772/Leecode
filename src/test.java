import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * Create by LiShuang on 2020/11/19 8:48
 **/

public class test {
    public int findRepeatNumber(int[] nums) {
        int Len=nums.length;
        for(int i=0;i<Len;i++) {
            if (nums[i] == nums[nums[i]]) {
                return nums[i];
            } else {
                int tmp = nums[i];
                nums[i] = nums[nums[i]];
                nums[nums[i]] = tmp;
            }
        }
        return -1;
    }

    @Test
    public void test(String[] args) {
        int[] nums=new int[]{2, 3, 1, 0, 2, 5, 3};
        int M=findRepeatNumber(nums);
        System.out.println(M);

    }


}