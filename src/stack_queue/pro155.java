package stack_queue;


import java.util.Stack;

/**
 * @program: leetcode
 * @author: baichen
 * 最小栈
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * <p>
 * 思路：
 * 利用两个栈实现，一个栈存入指定的值，最小栈每次入栈的时候先跟min这个变量比较大小，存入两者中的最小值
 * 弹出的话就弹出普通栈的值，弹出最小值的时候就弹出最小栈的值
 **/
public class pro155 {
    class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;
        private int min;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
            min = Integer.MAX_VALUE;  //设置为Integer类型的最大值,第一次插入时先跟最大值比较
        }

        public void push(int x) {
            stack.add(x);
            min = Math.min(min, x);
            //每次插入的都是大于或等于原有的值,因为栈是后进先出的，所以栈顶元素一定是最小值
            minStack.add(min);
        }

        public void pop() {
            stack.pop();
            minStack.pop();
            //如果最小栈为空，则将min设置为Integer类型的最大值，否则设置为栈顶元素
            min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
        }

        public int top() {
            //peek查看栈顶元素
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
