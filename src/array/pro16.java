package array;

import java.util.Arrays;

/**
 * @program: leetcode
 * @author: baichen
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
 * 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * 解题思路：
 * 先排列数组，然后利用双指针解决，排列数组是为了后面可以使用双指针，当三个数的和跟target相比的时候，
 * 大小不一可以进行一些调整.
 * 先确定一个数，然后另外两个数根据两个指针进行调整
 **/
public class pro16 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3)
            return nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        // 最接近的三数之和
        int closestSum = nums[0] + nums[1] + nums[2];
        // 因为是从第一个数开始作为确定的数，所以这里要减去2
        for (int i = 0; i < nums.length - 2; i++) {
            // 定义左右两个指针
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                // 临时的三数之和
                int tempSum = nums[l] + nums[r] + nums[i];
                // 分别比较closestSum和tempSum与target两者之差
                if (Math.abs(tempSum - target) < Math.abs(closestSum - target))
                    closestSum = tempSum;
                // 判断tempSum和target的差值进行指针的移动
                if (tempSum > target) {
                    r--;
                } else if (tempSum < target) {
                    l++;
                } else
                    // tempSum和target相等即最接近了
                    return target;
            }
        }
        return closestSum;
    }
}
