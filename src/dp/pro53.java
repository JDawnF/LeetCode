package dp;

/**
 * @program: leetcode
 * @author: baichen
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * 解题思路：
 * 通过动态规划解决，从头到尾遍历每一个数组元素，如果前面元素的和为正，则加上本元素的值继续搜索；
 * 如果前面元素的和为负，则此元素开始新的和计数。整个过程中要不断更新最大值
 **/
public class pro53 {
    public int maxSubArray(int[] nums) {
        // 定义结果为数组中第一个元素
        int res = nums[0];
        int sum = 0;    // 初始化总和为0
        // 遍历数组
        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else
                sum = num;
            res = Math.max(res, sum);
        }
        return res;
    }
}
