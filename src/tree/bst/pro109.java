package tree.bst;

import linkedlist.ListNode;
import tree.TreeNode;

/**
 * @program: leetcode
 * @author: baichen
 * 有序链表转换为二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 示例:
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 * 解题思路：
 * 跟上一题类似，重点还是先找出root，root就是链表的中间节点的值，所以先用快慢指针找出中间节点
 * 然后分别构建左右子树
 **/
public class pro109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode preMid = preMid(head);     // 得到中间节点的上个节点
        ListNode mid = preMid.next;         //得到中间节点
        // 断开链表
        preMid.next = null;
        TreeNode root = new TreeNode(mid.val);
        // 分别遍历左右链表
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(mid.next);
        return root;
    }

    // 得到中间节点的上个节点
    private ListNode preMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        ListNode pre = head;
        // 快指针及其next指针不为空
        while (fast != null && fast.next != null) {
            // 慢指针走一步，快指针走两步
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return pre;
    }
}
