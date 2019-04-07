package array;

/**
 * @program: leetcode
 * @author: baichen
 * 移除数组中的元素
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 示例 1:
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * 注意这五个元素可为任意顺序。
 * 你不需要考虑数组中超出新长度后面的元素。
 * 解题思路：
 * 同26，还是通过双指针解决，一个指针统计删除后数组的长度，另一个指针遍历数组
 * 解法二
 * 一个指针是数组长度，开始统计删除后的数组长度，另一个指针是遍历数组
 * 当当前元素等于val的时候，当前元素与最后一位元素交换，并释放最后一个元素。这实际上使数组的大小减少1。
 **/
public class pro27 {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; i < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    // 解法二
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else
                i++;
        }
        return n;
    }
}
