package linkedlist;

/**
 * @program: leetcode
 * @author: baichen
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。如果，我们将这两个数相加起来，则会返回一个新的链表来表示
 * 它们的和。您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 解题思路：
 * carry表示两数相加可能进1
 **/
public class pro2 {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //虚拟头节点指向第一个节点
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, cur = dummyHead;
        int carry = 0;
        //遍历两个链表
        while (p != null || q != null) {
            // 遍历两个链表的值
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;   //如果进1就赋值给carry
            cur.next = new ListNode(sum % 10);  //两数相加后新增一个节点
            cur = cur.next; //继续指向下一个节点
            if (p!=null)
                p=p.next;
            if (q!=null)
                q=q.next;
        }
        if (carry>0){
            cur.next=new ListNode(carry);
        }
        return dummyHead.next;
    }
}
