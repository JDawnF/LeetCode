package tree.digui;

/**
 * @program: leetcode
 * @author: baichen
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 解题思路：
 * 分别递归遍历其左右节点/子树
 **/
public class pro104 {
    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        //分别比较左右子树，找出最大的一颗，然后每次返回后都会加一
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
