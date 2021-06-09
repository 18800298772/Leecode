package SwordToOffer.Easy;

import java.util.Arrays;
import java.util.HashSet;


//Created By ***Ls*** 2020-11-12
//剑指 Offer 03. 数组中重复的数字
//找出数组中重复的数字。
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
//
//示例 1：
//输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3
//


public class findRepeatNumber {
    public static void main(String[] args) {
        Solution solution=new Solution();
        solution.findRepeat_Best(new int[]{2, 3, 1, 0, 2, 5, 3});
    }
}

class Solution{
    //暴力法
    //时间o(n^n)
    //空间o(n)
    public int findRepeat(int[] nums){
        int N;
        int R=-1;
        for(int i=0;i<nums.length-1;i++){
            N=nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(N==nums[j]){
                    R=N;
                    return R;
                }
            }
        }
        return R;
    }

    //哈希表
    //时间o(n)
    //空间o(n)
    public int findRepeat2(int[] nums){
        HashSet hashSet=new HashSet();   //初始化哈希表
        for (int i=0;i<nums.length;i++){
            if(hashSet.contains(nums[i])){      //判断当前元素是否已经存在
                return nums[i];  //如果存在说明重复则返回
            }
            hashSet.add(nums[i]);   //如果不存在则添加
        }
        return -1;
    }

    //数组代替哈希表
    //时间o(n)
    //空间o(n)
    //重新建立一个数组，将原数组的值作为索引，如果新数组中该位置没有存入新值，则说明这个索引值没有出现过
    //反之，如果改位的值已经不是-1，则说明该位置的索引已经出现过，也就是说明这个值是重复的
    public int findRepeat3(int[] nums){
        int[] tmp =new int[nums.length];
        Arrays.fill(tmp,-1);
        for (int i=0;i<nums.length;i++){
            if (tmp[nums[i]]!=-1){
                return nums[i];
            }
            //
            tmp[nums[i]]=1;
        }
        return -1;
    }

    //先看sort方法。
    //如果i=nums[i]，则说明该索引的元素已经与索引相同
    // 如果i！=nums[i]，说明元素与索引不相同，需要交换，但是如果交换的时候发现那个位置已经有了一个相同的值，则说明这个值重复了。
    //举个例子，一个家（索引）只有一个小孩儿（元素），元素要和家相同，如果不相同则需要交换，
    // 如果一个小孩儿要回家发现他家里已经有一个和家相同的小孩儿则说明小孩儿是一样的
    public int findRepeat_Best(int[] nums){
        for (int i=0;i<nums.length;i++){
            while (i!=nums[i]){
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                //元素交换
                int n=nums[i];
                nums[i]=nums[nums[i]];
                nums[nums[i]]=n;
            }
        }
        return -1;
    }
    //元素排序：使得该元素的索引与元素值相同，nums[0]=0,nums[1]=1,nums[2]=2....
    // 如果元素不等于元素索引，则将该元素与该元素的索引位置的元素交换
    public void sort(int[] nums){
        for (int i=0;i<nums.length;i++){
            while (i!=nums[i])
            {
                //元素交换
                int n=nums[i];
                nums[i]=nums[nums[i]];
                nums[nums[i]]=n;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
