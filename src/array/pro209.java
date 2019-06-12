package array;

/**
 * @Program: pro209
 * @Author: baichen
 * @Description: 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的
 * 连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * 示例:
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 解题思路：
 * 定义两个指针left和right，分别记录子数组的左右的边界位置。
 * <p>
 * （1）让right向右移，直到子数组和大于等于给定值或者right达到数组末尾；
 * <p>
 * （2）更新最短距离，将left像右移一位,sum减去移去的值；
 * <p>
 * （3）重复（1）（2）步骤，直到right到达末尾，且left到达临界位置
 */
public class pro209 {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0, l = 0, r = -1, res = nums.length - 1;
        while (l < nums.length) {
            if (r + 1 < nums.length && sum < s)
                sum += nums[++r];
            else
                sum -= nums[l++];
            if (sum >= s)
                res = Math.min(res, r - l + 1);
        }
        if (res == nums.length + 1)
            return 0;
        return res;
    }
    // 滑动窗口
    public int minSubArrayLen2(int s, int[] nums) {
        int i = 0;
        int sum = 0;
        int len = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= s) {
                len = len == 0 ? j - i + 1 : Math.min(len, j - i + 1);
                sum -= nums[i++];
            }
        }
        return len;
    }
}
