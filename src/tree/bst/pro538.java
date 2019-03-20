package tree.bst;

import tree.TreeNode;

import java.util.Stack;

/**
 * @program: leetcode
 * @author: baichen
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
 * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * 例如：
 * 输入: 二叉搜索树:
 * 5
 * /   \
 * 2     13
 * <p>
 * 输出: 转换为累加树:
 * 18
 * /   \
 * 20   13
 * 解题思路：
 * 因为是二分搜索树，所以右孩子节点是最大的，先遍历右子树，递归实现
 **/
public class pro538 {
    private static int sum = 0;

    public static TreeNode convertBST(TreeNode root) {
        traver(root);
        return root;
    }

    private static void traver(TreeNode node) {
        if (node == null) return;
        // 先递归遍历右子树，此时前面的root先入栈，然后是root.right入栈
        traver(node.right);
        // 下面两行代码相当于遍历根/父节点
        sum += node.val;    // 先加上最后一个右孩子节点的值
        node.val = sum;     // 然后对最后一个右孩子节点进行赋值
        traver(node.left);  // 因为是最后一个右孩子节点，所以如果没有左孩子节点的话就直接返回
    }

    // 非递归实现
    public TreeNode convertBST2(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.add(node);
                node = node.right;
            }
            node = stack.pop();
            sum += node.val;
            node.val = sum;
            if (node.left != null)
                node = node.left;
            else
                node = null;
        }
        return root;
    }
}
