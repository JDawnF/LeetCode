package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Program: pro219
 * @Author: baichen
 * @Description: 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * 示例 1:
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * 解题思路：
 * 通过map解决,判断两个索引之差不超过k,或者直接两个for循环比较
 */
public class pro219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                if (Math.abs(i - map.get(nums[i])) <= k)
                    return true;
            map.put(nums[i], i);
        }
        return false;
    }
}








