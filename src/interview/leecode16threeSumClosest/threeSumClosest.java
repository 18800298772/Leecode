package interview.leecode16threeSumClosest;

import java.util.Arrays;

/**
 * Create by LiShuang on 2020/12/7 14:21
 *最接近的三数之和
 *
 * 找到三个元素之和最接近目标值的情况
 *
 **/

public class threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        // 这个不用去重，直接找到最小值即可。
        Arrays.sort(nums); // 仍然需要先排序
        int minSum = nums[0] + nums[1] + nums[2];
        for (int  i= 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int curSum = nums[i] + nums[j] + nums[k];
                if (Math.abs(curSum - target) < Math.abs(minSum - target)) {
                    minSum = curSum;
                }
                if (curSum > target) {
                    k--;
                }else if (curSum == target) {
                    return curSum;
                }else{
                    j++;
                }
            }
        }
        return minSum;
    }
}
