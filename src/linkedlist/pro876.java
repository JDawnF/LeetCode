package linkedlist;

/**
 * @program: leetcode
 * @author: baichen
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * <p>
 * 解题思路：
 * 快慢指针，当快指针走到末尾，满指针必定在中间节点
 **/
public class pro876 {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
