package linkedlist;

import java.util.Stack;

/**
 * @program: leetcode
 * @author: baichen
 * 两数相加 II
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 进阶:
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * 示例:
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 * 解题思路：'
 * 因为两个链表是从尾开始相加的，所以可以使用栈来实现，因为栈是先进后出的
 **/
public class pro445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = buildStack(l1);
        Stack<Integer> l2Stack = buildStack(l2);
        ListNode head = new ListNode(-1);       //虚拟头节点
        int carry = 0;  //表示满十进一
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty() || carry != 0) {
            int x = l1Stack.isEmpty() ? 0 : l1Stack.pop();
            int y = l2Stack.isEmpty() ? 0 : l2Stack.pop();
            int sum = x + y + carry;
            ListNode node = new ListNode(sum % 10);     //节点要取余
            node.next = head.next;  //因为链表从尾开始相加的，所以这里从头节点开始一个个插入
            head.next = node;
            carry = sum / 10;   //超过十要向前进一
        }
        return head.next;   //head为虚拟头节点，所以返回head的下一位开始的链表
    }
    //通过链表构建一个栈
    private Stack<Integer> buildStack(ListNode l) {
        Stack<Integer> stack = new Stack<>();
        while (l != null) {
            stack.push(l.val);
            l = l.next;
        }
        return stack;
    }
}
