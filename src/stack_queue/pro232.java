package stack_queue;

import java.util.Stack;

/**
 * @program: leetcode
 * @author: baichen
 *  用栈实现队列
 *  栈是先进后出，队列是先进先出
 *  使用栈实现队列的下列操作：
 *
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 **/
public class pro232 {
    //    /** Initialize your data structure here. */
//    public MyQueue() {
//
//    }
    //定义两个栈，一个进一个出，表示队列的首尾
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        in2out();
        return out.pop();
    }

    public int peek() {
        in2out();
        return out.peek();
    }

    //从一个栈弹出元素到另一个栈，表示队尾取出元素
    private void in2out() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
