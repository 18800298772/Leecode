package interview.leecode01TwoSum;

import java.util.HashMap;

/**
 * Create by LiShuang on 2020/12/7 13:55
 **/

public class twoSum {
    public int[] twosum(int[] nums,int target){
        HashMap hashMap=new HashMap();
        for(int i=0;i<nums.length;i++){
            int least=target-nums[i];
            if(hashMap.containsKey(least)){
                return new int[]{i, (int) hashMap.get(least)};
            }else {
                hashMap.put(nums[i],i);
            }
        }
        System.out.println("无法找到");
        return new int[]{};
    }
}
