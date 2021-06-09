package interview.Leecode15threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create by LiShuang on 2020/12/7 14:16
 *三数之和
 *给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 **/

public class ThreeSum {
//    固定三个指针中最左（最小）数字的指针 i，双指针 j，k 分设在数组索引 (i+1, nums.length-1) 两端，
//    通过双指针交替向中间移动，记录 nums[i] + nums[j] + nums[k] == 0 时的nums组合：
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> List = new ArrayList<List<Integer>>();
        if(nums.length < 3) return List;
        Arrays.sort(nums); // 进行排序
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] > 0) break; // nums[i]大于0，则三数之和大于0，所以结束跳出
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去掉重复
            for(int j=i+1,k=nums.length-1;j < k;){
                int He = nums[i] + nums[j] + nums[k];
                if(He == 0){
                    List.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while (j<k && nums[j] == nums[j+1]) j++; // 去掉左重复
                    while (j<k && nums[k] == nums[k-1]) k--; // 去掉右重复
                    j++; k--;
                }
                else if (He < 0) j++;
                else if (He > 0) k--;
            }
        }
        return List;
    }




}
