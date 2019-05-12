package erfen;

/**
 * @Program: pro34
 * @Author: baichen
 * @Description: 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 解题思路：
 * 先通过二分法找到等于target的元素最左边位置,然后找到小于target+1的最大元素的位置
 */
public class pro34 {
    public int[] searchRange(int[] nums, int target) {
        int first = binarySearch(nums, target);
        // 计算小于target的最大元素的最右边位置，即等于目标数的元素的下一个位置
        int last = binarySearch(nums, target + 1) - 1;
        // 要对first进行判断
        if (first == nums.length || nums[first] != target)
            return new int[]{-1, -1};
        else    // 要取两者中大的值
            return new int[]{first, Math.max(first, last)};
    }

    // 二分查找，当target存在时，找到的是等于target的最小重复元素
    // 当target不存在时，找到的是小于target的最大元素的最右边位置
    private int binarySearch(int[] nums, int target) {
        int l = 0, h = nums.length; // h要等于数组的长度，因为找到最右边元素
        while (l < h) {
            int mid = l + ((h - l) >> 1);
            if (nums[mid] >= target)
                h = mid;    // 同理，mid不减一
            else
                l = mid + 1;
        }
        return l;
    }
}
