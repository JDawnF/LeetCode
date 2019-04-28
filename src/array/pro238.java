package array;

/**
 * @Program: pro238
 * @Author: baichen
 * @Description: 除自身以外数组的乘积
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * 示例:
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * 解题思路：
 * 寻找规律，将每因子分为两种部分，左半部分和右半部分。
 * 先计算左半部分的乘积，把结果存储到返回值中；
 * 然后循环计算右半部分的乘积，不需要额外的存储空间。
 * 即先从左到右遍历数组，然后再从右到左遍历一遍
 */
public class pro238 {
    public int[] productExceptSelf(int[] nums) {
        int left = 1;
        int right = 1;
        // 返回的结果数组
        int[] res = new int[nums.length];
        // 先从左到右乘以原数组的元素
        for (int i = 0; i < nums.length; i++) {
            res[i] = left;
            left *= nums[i];
        }
        // 再从右到左乘以原数组的元素
        for (int j = nums.length - 1; j >= 0; j--) {
            res[j] *= right;
            right *= nums[j];
        }
        return res;
    }
}
