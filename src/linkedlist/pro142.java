package linkedlist;

import java.util.HashMap;

/**
 * @program: leetcode
 * @author: baichen
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 * 解题思路：
 * 注意返回的是节点，可以通过快慢指针解决
 * 1.使用额外空间的思路
 * 就是使用一个hashmap，去遍历一遍链表，每遍历一个链表，如果不存在这个节点，那么就插入hashmap，
 * 如果存在，说明这个节点已经插入了，那么这个节点就是重复的节点，为啥重复了，就是环的入口节点了。
 * 2.不使用额外空间的思路
 * 使用快慢指针，快指针每次走两步，慢指针每次走一步，如果快慢指针相遇说明有环；
 * 有环以后，需要寻找环入口节点，已经找到了一个环的中的节点，利用这个节点，去往下遍历，由于是环，
 * 所以这个节点肯定会和自身相遇，相遇以后，记录相遇过程中走的步数，就是环的长度
 * 知道环的长度以后，然后再利用快慢指针的思想，快指针先走环长度，然后快慢指针再一起走，
 * 这样因为快指针先走了环的长度，当两者相遇肯定是环的入口节点相遇
 * （因为快慢指针肯定会进入环里面，而由于快指针先走了环的长度，所以也就是一个周期，
 * 所以只要进入环，那么这两个指针必然相遇）
 **/
public class pro142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        // 定义快慢两个指针
        ListNode fast = head, slow = head;
        // 快指针先遍历一遍链表，此时满指针指向链表中间位置，如果中途两者相遇，说明入口在中间之前
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        if (fast == null || fast.next == null) return null;
        fast = head;    // 快指针回到head节点，重新遍历找到两者入口
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    // 通过HashMap解决
    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) return null;
        HashMap<ListNode, Integer> map = new HashMap<>();
        // 通过HashMap统计链表节点出现的次数，如果重复即HashMap包含了
        while (head != null) {
            if (!map.containsKey(head)) {
                map.put(head, 1);
                head = head.next;
            } else
                return head;
        }
        return null;
    }
}
