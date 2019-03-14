package tree;

/**
 * @program: leetcode
 * @author: baichen
 * 另一个树的子树
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 * 解题思路：
 * 递归判断两棵树的值是否相等
 **/
public class pro572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s==null) return false;
        //分别比较两个子树，即s的左右子树跟t的比较
        return isSubtreeWithRoot(s,t)||isSubtreeWithRoot(s.left,t)||isSubtreeWithRoot(s.right,t);
    }

    private boolean isSubtreeWithRoot(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val!=t.val)
            return false;
        return isSubtreeWithRoot(s.left,t.left)||isSubtreeWithRoot(s.right,t.right);
    }
}
