package tree.digui;

import tree.TreeNode;

/**
 * @program: leetcode
 * @author: baichen
 * 题目描述：
 * 合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * <p>
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，
 * 那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 * 解题思路：
 * 通过递归可以解决，首先要分三种情况：两个二叉树都为null，其中一个为null，两个都不为null
 **/
public class pro617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        //接下来三个都是递归终止的条件
        if (t1 == null && t2 == null)
            return null;
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        //合并后的根结点一定是两个二叉树的根结点之和
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        return root;
    }
}
