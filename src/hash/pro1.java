package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @author: baichen
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 解题思路：
 * 可以先对数组进行排序，然后使用双指针方法或者二分查找方法。
 * 这样做的时间复杂度为 O(NlogN)，空间复杂度为 O(1)。
 *
 * 用 HashMap 存储数组元素和索引的映射，在访问到 nums[i] 时，
 * 判断 HashMap 中是否存在 target - nums[i]，
 * 如果存在说明 target - nums[i] 所在的索引和 i 就是要找的两个数。
 * 该方法的时间复杂度为 O(N)，空间复杂度为 O(N)，使用空间来换取时间。
 **/
public class pro1 {
    public int[] twoSum(int[] nums, int target) {
        if (nums==null||nums.length<0){
            throw new IllegalArgumentException("Array is illegal");
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int b = target - nums[i];
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            //存放两个数加起来等于target的元素
            map.put(b, i);
        }
        throw new IllegalArgumentException("no solution.");
    }
}
