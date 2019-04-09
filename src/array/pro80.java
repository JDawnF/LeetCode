package array;

/**
 * @program: leetcode
 * @author: baichen
 * 删除重复元素II
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 示例 1:
 * 给定 nums = [1,1,1,2,2,3],
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 * 你不需要考虑数组中超出新长度后面的元素。
 * 解题思路：
 * 要利用数组默认升序的条件
 * 双指针解决。
 * 另一种解法：利用一些技巧
 **/
public class pro80 {
    public int removeDuplicates(int[] nums) {
        int count = 0;      // 记录删除后数组个数
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int i = 0, j = i;   // 两个指针
        int tempCount = 0;  // 每个重复元素个数
        while (i < nums.length) {
            // j要小于数组长度，每当有重复元素，j就往右移，并且统计重复元素的个数
            if (j < nums.length && nums[i] == nums[j]) {
                j++;
                tempCount++;
            } else {    // 如果元素不相等，就判断重复元素个数是否大于2
                if (tempCount >= 2) {
                    count += 2;     //最多两个重复元素
                    nums[i + 1] = nums[i];  // 记录保留两个重复元素
                    i += 2; // i往右移两位
                } else {    // 没有重复元素,照常移动指针
                    count++;
                    i++;
                }
                if (j >= nums.length)   // 结束循环
                    break;
                nums[i] = nums[j];      // 开始下一轮重复数组的统计
                tempCount = 0;
            }
        }
        return count;
    }

    //解法二：
    public int removeDuplicates2(int[] nums) {
        int i = 0;  // 统计删除后数组元素个数
        for (int n : nums)
            // i<2表示至少存入两个重复元素，n > nums[i - 2]表示只有两个重复元素
            if (i < 2 || n > nums[i - 2])
                // 只有重复元素少于2才赋值
                nums[i++] = n;
        return i;
    }
}
