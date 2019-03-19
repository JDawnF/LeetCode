package bst;

import tree.TreeNode;

/**
 * @program: leetcode
 * @author: baichen
 * 修剪二叉搜索树
 * 给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。通过修剪二叉搜索树，
 * 使得所有节点的值在[L, R]中 (R>=L) 。你可能需要改变树的根节点，
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。
 * 示例 1:
 * 输入:
 * 1
 * / \
 * 0   2
 * <p>
 * L = 1
 * R = 2
 * <p>
 * 输出:
 * 1
 * \
 * 2
 * <p>
 * 解题思路：
 * 递归解决，先比较root跟L和R直接的比值
 **/
public class pro669 {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        if (root.val > R) return trimBST(root.left, L, R);
        if (root.val < L) return trimBST(root.right, L, R);
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
