package sort;

import java.util.Arrays;

/**
 * @program: leetcode
 * @author: baichen
 * 数组中的第K个最大元素
 **/
public class pro215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
