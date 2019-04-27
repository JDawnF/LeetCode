package array;

/**
 * @Program: pro169
 * @Author: baichen
 * @Description: 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于n/2的元素。
 * 解题思路：
 * 从第一个数开始count=1，遇到相同的就加1，遇到不同的就减1，减到0就重新换个数开始计数
 */
public class pro169 {
    public int majorityElement(int[] nums) {
        int count = 0;
        int maj = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) maj = nums[i];
            if (nums[i] == maj) count++;
            else
                count--;
        }
        return count;
    }
}
