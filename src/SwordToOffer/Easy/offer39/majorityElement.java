package SwordToOffer.Easy.offer39;

import java.util.*;

/**
 * Create by LiShuang on 2020/11/26 21:08
 **/

public class majorityElement {
    public static int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap();
        int M=nums.length/2;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])>M){
                return nums[i];
            }
        }
        return 0;
    }
    public static int majorityElement2(int[] nums){
        int it=0,value=0;
        for(int num:nums){
            if(value==0){
                it=num;
            }
            if(num==it){
                value++;
            }else {
                value--;
            }
        }
        return it;
    }
    public static void main(String[] args) {
        int[] Nums={1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(majorityElement(Nums));
    }

}
