package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @author: baichen
 * 最长和谐子序列
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
 * <p>
 * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
 * <p>
 * 示例 1:
 * 输入: [1,3,2,2,5,2,3,7]
 * 输出: 5
 * 原因: 最长的和谐数组是：[3,2,2,2,3].
 * <p>
 * 解题思路：
 * 和谐序列中最大数和最小数之差正好为 1，应该注意的是序列的元素不一定是数组的连续元素。
 * 可以通过哈希表实现，key为元素的值，value为元素在哈希表中的个数，
 * 因为题目要求的是数组中最大值和最小值的差为1，所以其实就只有两个元素，然后看这两个元素的总和即可
 **/
public class pro594 {
    public static int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            //存入num和num的个数值
            // getOrDefault表示如果key存在，则返回其对应的值，反正返回指定的值，这里指定的值是0
            // 其实返回的值表示这个元素的个数，所以这个map统计其实就是数组中每个元素的个数
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int longest = 0;
        for (int num : map.keySet()) {
            //比较longest和和谐数组中最大值最小值的个数
            if (map.containsKey(num + 1))
                longest = Math.max(longest, map.get(num) + map.get(num + 1));
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 5, 2, 5, 6, 8, 3};
        int a = findLHS(nums);
        System.out.println(a);
    }
}
