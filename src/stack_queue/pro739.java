package stack_queue;

import java.util.Stack;

/**
 * @program: leetcode
 * @author: baichen
 * 每日温度
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高的天数。
 * 如果之后都不会升高，请输入 0 来代替。
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
 * 你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的都是 [30, 100] 范围内的整数。
 * <p>
 * 思路：
 * 使用栈存放温度数组的索引，遍历数组，如果小于栈顶，则不存入返回的数组
 * 在遍历数组时用栈把数组中的数存起来，如果当前遍历的数比栈顶元素来的大，
 * 说明栈顶元素的下一个比它大的数就是当前元素。
 **/
public class pro739 {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        //返回的结果数组,默认为0
        int[] res = new int[n];
        //存放温度数组对应的索引
        Stack<Integer> stack = new Stack<>();
        for (int curIndex = 0; curIndex < n; curIndex++) {
            //比较数组当前元素的值是否大于栈顶元素的值，如果是则算出两个索引相差的位置
            while (!stack.isEmpty() && T[curIndex] > T[stack.peek()]) {
                //弹出栈顶对应温度数组的索引
                int preIndex = stack.pop();
                //表示当前位置与下一个比其大的位置的索引差
                res[preIndex] = curIndex - preIndex;
            }
            //存放
            stack.add(curIndex);
        }
        return res;
    }
}
