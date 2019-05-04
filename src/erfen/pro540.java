package erfen;

/**
 * @Program: pro540
 * @Author: baichen
 * @Description: 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 * 示例 1:
 * 输入: [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。
 * 解题思路：
 * 注意是有序数组，题目要求O(log n)，所以可以根据二分法思想来解决，位运算是O(n)
 * 因为数组中除了一个元素只出现一次，其他元素都会出现两次，是偶次数，所以令index为唯一数
 * 在数组中的位置。如果 m 为偶数，并且m + 1< index，说明m在唯一数的左边，所以都是小于
 * 唯一数的，因为m位置上的数会出现两次，那么nums[m] == nums[m + 1];
 * m + 1 >= index，那么 nums[m] != nums[m + 1]。
 * 从上面的规律可以知道，如果 nums[m] == nums[m + 1]，那么 index 所在的数组位置为
 * [m + 2, h]，此时令 l = m + 2;如果 nums[m] != nums[m + 1]，那么index所在的数组位置
 * 为[l,m]，此时令h = m。因为h的赋值表达式为h=m，那么循环条件也就只能使用l<h这种形式。
 */
public class pro540 {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + ((h - l) >> 1);
            if (m % 2 == 1)
                // 保证 l/h/m 都在偶数位，使得查找区间大小一直都是奇数
                m--;
            // 说明m+1<index,即唯一数在右边
            if (nums[m] == nums[m + 1])
                l = m + 2;
            else    // m+1>=index,目标数在m的左边，所以右边界要等于m
                h = m;
        }
        // 返回左边界，因为是递增的数，找到最小的值
        return nums[l];
    }
}
