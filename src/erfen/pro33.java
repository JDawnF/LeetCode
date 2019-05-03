package erfen;

/**
 * @Program: pro33
 * @Author: baichen
 * @Description: 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 解题思路：
 * 先拆分为两个数组，通过二分查找解决
 */
public class pro33 {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    /**
     * @param nums   带查找数组
     * @param low    左边界
     * @param high   右边界
     * @param target 目标值
     * @return 目标值对应的数组索引
     */
    private int search(int[] nums, int low, int high, int target) {
        if (low > high) return -1;
        int mid = low + ((high - low) >> 1);
        if (nums[mid] == target) return mid;
        // 中间的数比最右边界小，说明是右边的数组
        if (nums[mid] < nums[high]) {
            // 目标值小于最右边的数据，并且大于等于中间数，在右边的数组遍历，要从mid查起
            if (nums[mid] < target && target <= nums[high])
                return search(nums, mid + 1, high, target);
            else
                // nums[mid]>=target&&target>nums[high]，要在左边数组中查
                return search(nums, low, mid - 1, target);
        } else {    //在左边的数组中查找,要从左边界查起
            if (nums[low] <= target && target < nums[mid])
                return search(nums, low, mid - 1, target);
            else
                // 左边界大于target，并且target大于nums[mid]
                return search(nums, mid + 1, high, target);
        }
    }
}
