package tree;

/**
 * @program: leetcode
 * @author: baichen
 * 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 解题思路：
 * 比较两个节点的值是否相等，递归解决
 **/
public class pro101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val)
            return false;
        // 比较分别比较子树的左右，右左
        return isSymmetric(s.left, t.right) && isSymmetric(s.right, t.left);
    }
}
