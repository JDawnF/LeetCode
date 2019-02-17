package linkedlist;

/**
 * @program: leetcode
 * @author: baichen
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 思路：
 * 当访问 A 链表的指针访问到链表尾部时，令它从链表 B 的头部开始访问链表 B；
 * 同样地，当访问 B 链表的指针访问到链表尾部时，令它从链表 A 的头部开始访问链表 A。
 * 这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点。
 **/
public class pro160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /**
         定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部,
         最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
         两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
         **/
        if (headA == null || headB == null)
            return null;
        ListNode preA = headA, preB = headB;
        // 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头,
        // 而第二轮体现在如果pA或pB相交就返回交点, 不相交最后就是null==null
        while (preA != preB) {
            //如果链表A访问完了，就访问链表B;链表B同理
            preA = preA == null ? headB : preA.next;
            preB = preB == null ? headA : preB.next;
        }
        //返回相交的节点，return A或B都行
        return preA;
    }
}
