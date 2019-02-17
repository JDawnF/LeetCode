package linkedlist;

/**
 * @program: leetcode
 * @author: baichen
 * 两两交换链表中的节点
 * 如：给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 思路：
 * 新建一个虚拟头节点node，指向head,然后新建一个节点prev，将node赋值给prev
 * 两个节点l1,l2交换：l1的next指向l2的下个节点，l2的next指向l1，node的next指向l2
 * 然后prev节点移到交换后的l1位置，继续下一轮的交换
 **/
public class pro24 {
    public ListNode swapPairs(ListNode head) {
        //新建虚拟头节点
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode prev = node;
        while (prev.next != null && prev.next.next != null) {
            ListNode l1 = prev.next, l2 = prev.next.next;
            ListNode next = l2.next;
            l1.next = l2.next;
            l2.next = l1;
            prev.next = l2;
            prev = l1;
        }
        return node.next;
    }
}
