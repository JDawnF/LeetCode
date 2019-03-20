package bst;

import tree.TreeNode;

/**
 * @program: leetcode
 * @author: baichen
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
 * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * 例如：
 * 输入: 二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 * 解题思路：
 * 因为是二分搜索树，所以右孩子节点是最大的，先遍历右子树，递归实现
 **/
public class pro538 {
    private int sum=0;
    public TreeNode convertBST(TreeNode root) {
        traver(root);
        return root;
    }
    private void traver(TreeNode node) {
        if (node==null) return;
        traver(node.right);
        sum+=node.val;
        node.val=sum;
        traver(node.left);
    }
}
