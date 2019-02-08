import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @author: baichen
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
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
