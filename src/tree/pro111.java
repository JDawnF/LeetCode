package tree;

/**
 * @program: leetcode
 * @author: baichen
 * 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最小深度  2.
 * 解题思路：
 * 递归计算左右子树的深度
 **/
public class pro111 {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        //左右子树中有一颗为空
        if (left == 0 || right == 0)
            return left + right + 1;
        return Math.min(left, right) + 1;
    }
}
