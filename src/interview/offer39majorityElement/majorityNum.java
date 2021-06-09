package interview.offer39majorityElement;

/**
 * Create by LiShuang on 2020/12/7 20:21
 **/

public class majorityNum {
        public int majorityElement(int[] nums) {
            int count = 1;
            int maj = nums[0];
            for (int i = 1; i < nums.length; i++) {
                //整点在if部分，如果和maj相同则加1，如果不同这减1，一直到为0个换一个值
                if (maj == nums[i])
                    count++;
                else {
                    count--;
                    if (count == 0) {
                        maj = nums[i + 1];
                    }
                }
            }
            return maj;
        }
}
