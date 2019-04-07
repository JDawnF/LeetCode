package doublezhizhen;

import linkedlist.ListNode;

/**
 * @program: leetcode
 * @author: baichen
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * 解题思路：
 * 首先遍历链表计算链表的长度length,然后用k去对length取余，余数是A，
 * A就是链表需要向右移动的位置，余数是A也就是需要把链表末尾的A个节点移动到链表头部；
 * 这里的话需要找到倒数第A个节点，也就是使用双指针，一个fast一个slow，fast先走A步，
 * 然后fast与slow一起走，当fast走到链表的末尾（fast.next = null）,
 * 那么slow就走到了倒数第(A+1)个节点
 * 然后就是旋转，slow的下一个节点是旋转后的头结点，保存下来以后，
 * 注意把slow.next = null(因为slow是旋转后的末尾节点），fast的节点需要进行连接head，
 * 因为旋转了，fast.next = head;(这样把前后两部分链表拼接起来）
 **/
public class pro61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        int length = 0;
        ListNode temp = head;
        // 统计链表长度
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        k = k % length;
        // 如果k为0，表明整个链表翻转，最后还是原来的链表
        if (k == 0)
            return head;
        // 定义两个指针，从链表头开始
        ListNode slow = head;
        ListNode fast = head;
        // fast指针先走k步
        for (int i = 0; i < k; i++)
            fast = fast.next;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // 从slow指针的下个节点开始翻转,slow的下一个节点是旋转后的头结点,需要先保存
        ListNode resHead = slow.next;
        slow.next = null;
        // fast的节点需要进行连接head，因为旋转了,fast这个节点到了前面了，
        // fast.next = head;(这样把前后两部分链表拼接起来)
        fast.next = head;
        return resHead;
    }
}
