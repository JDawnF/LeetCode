package stack_queue;

import java.util.Arrays;
import java.util.Stack;

/**
 * @program: leetcode
 * @author: baichen
 * 下一个更大元素 II
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），
 * 输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，
 * 这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
 * 如果不存在，则输出 -1。
 * <p>
 * 解题思路：
 * 跟739的差不多，只不过这一题存的是元素，739存的是距离
 * 还是通过一个栈，存放数组对应的索引值，注意要遍历的数组是循环数组，所以在循环里面要有2倍数组长度
 **/
public class pro503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        //初始化返回的数组，先全部赋值为-1
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            //循环数组，i可能大于n,当前数
            int num = nums[i % n];
            //当前数大于栈顶索引对应的数组的值，则存入返回的数组中
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                res[stack.pop()] = num;
            }
            //栈存放数组对应的所有索引
            if (i < n)
                stack.push(i);
        }
        return res;
    }
}
