/**
 * @program: leetcode
 * @author: baichen
 * 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 **/
public class pro19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //fast指向head节点
        ListNode fast = head;
        //去掉前面n个节点，指向第n+1个节点，如这里去掉了1,2两个节点
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        //slow节点指向head节点
        ListNode slow = head;
        //遍历第n+1的节点到最后,如这里只剩下3个
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //删掉第n个元素
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        ListNode.printList(root);
        root = removeNthFromEnd(root, 2);
        ListNode.printList(root);
        ListNode root1 = new ListNode(1);
        root1=removeNthFromEnd(root1,1);
        ListNode.printList(root1);
    }
}
