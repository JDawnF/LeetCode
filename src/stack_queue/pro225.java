package stack_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcode
 * @author: baichen
 * 用队列实现栈
 * 使用队列实现栈的下列操作：
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 *
 * 思路：
 * 在将一个元素 x 插入队列时，为了维护原来的后进先出顺序，
 * 需要让 x 插入队列首部。而队列的默认插入顺序是队列尾部，
 * 因此在将 x 插入队列尾部之后，需要让除了 x 之外的所有元素出队列，再入队列。
 * 因为队首取元素，队尾进元素
 **/
public class pro225 {
    class MyStack {
        private Queue<Integer> queue;
        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            queue=new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queue.add(x);
            int size=queue.size();
            while (size-->1){
                //取出x之前的所有元素并重新插入队列
                queue.add(queue.poll());
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return queue.remove();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return queue.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
