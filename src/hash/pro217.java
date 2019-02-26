package hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program: leetcode
 * @author: baichen
 * 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 **/
public class pro217 {
    //使用hashmap实现
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (int n : map.values())
            if (n > 1)
                return true;
        return false;
    }

    //使用set实现
    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        //如果有重复元素，则会比数组的短
        return set.size() < nums.length;
    }
}
