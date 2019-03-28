package array;

/**
 * @program: leetcode
 * @author: baichen
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 * 示例 1:
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 * 解题思路：
 * 直接遍历数组，用一个变量记录每段连续1的个数，然后取最大值
 **/
public class pro485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, cur = 0;
        for (int num : nums) {
            cur = num == 0 ? 0 : cur + 1;
            max = Math.max(max, cur);
        }
        return max;
    }

//    解法二，原理一样
    public int findMaxConsecutiveOnes2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = 0, cur = 0;
        for (int num : nums) {
            if (num == 1) {
                cur++;
            } else {
                max = max > cur ? max : cur;
                cur = 0;
            }
        }
        return max > cur ? max : cur;
    }
}
