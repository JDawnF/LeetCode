package erfen;

/**
 * @Program: pro153
 * @Author: baichen
 * @Description: 寻找旋转排序数组中的最小值
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。请找出其中最小的元素。
 * 你可以假设数组中不存在重复元素。
 * 示例 1:
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 解题思路：
 * 通过二分法解决，注意旋转点
 */
public class pro153 {
    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1, res = nums[0];
        // 没有翻转点的递增数组或者只有一个元素的数组的时候
        if (nums[l] <= nums[h]) return res;
        while (l <= h) {
            int mid = l + ((h - l) >> 1);
            if (nums[mid] > nums[mid + 1]) {    // 当中点刚好是翻转点的时候
                return nums[mid + 1];
            } else {    // 当中点在翻转点右边时，右边界往翻转点靠近，所以mid-1
                if (nums[mid] < nums[l])
                    h = mid - 1;
                else    // 当中点在翻转点左边时，左边界往翻转点靠近，所以mid+1
                    l = mid + 1;
            }
        }
        return nums[0];
    }
}
