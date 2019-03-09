package linkedlist;


/**
 * @program: leetcode
 * @author: baichen
 * 请判断一个链表是否为回文链表。
 * 解题思路：
 * 1.先通过快慢指针找到链表中点，将链表分为两部分
 * 2.反转另一段链表
 * 3.判断反转后的链表跟上一段是否相等
 **/
public class pro234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 偶数节点，让 slow 指向下一个节点,因为上面的fast是从head的下个节点开始的，所以这里slow要指向slow的next的节点
        if (fast != null) slow = slow.next;
        cut(head, slow);                     // 切成两个链表
        return isEqual(head, reverse(slow));
    }

    private void cut(ListNode head, ListNode cutNode) {
        while (head.next != cutNode) {
            head = head.next;
        }
        head.next = null;
    }

    //使用迭代法反转链表
    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        //因为每次循环都会给nextNode重新赋值为head.next，所以最后一个节点head为null，这里就判断head是否为空
        while (head!= null) {
            ListNode nextNode = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;    //交换位置，继续反转
        }
        return newHead;
    }

    //判断两个链表是否相等
    private boolean isEqual(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }
}
