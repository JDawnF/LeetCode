package array;

/**
 * @Program: pro136
 * @Author: baichen
 * @Description: 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
 * 找出那个只出现了一次的元素。例如：输入: [2,2,1]    输出: 1
 * 解题思路：
 * 参照剑指41，通过异或解决
 * 位运算——异或运算，只有一个1则结果为1，也即是“有1则1”。
 * 则可以推出：
 * 任何整数和0异或结果是它本身。
 * 一个整数异或它本身结果等于0。
 * 即一个整数异或另一个整数两次结果是它本身。
 */
public class pro136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums)
            res ^= num;
        return res;
    }
}
