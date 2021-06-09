package Leetcode07;

public class twoSum {
    public  int[] sum(int[] nums, int target) {

        int N=nums.length;
        int[] result = new int[N];
        int F=0;
        for (int i=0;i<=N-2;i++){
            for (int j=i+1;j<=N-1;j++){
                if(nums[i]+nums[j]==target){
                    result= new int[]{i, j};
                    F=1;
                }
                if(F==1)break;
            }
            if(F==1)break;
        }
        return result;
    }
     //根据题解修改
    public int[] sum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two solution");
    }

}



