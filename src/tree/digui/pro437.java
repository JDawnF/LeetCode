package tree.digui;

import tree.TreeNode;

/**
 * @program: leetcode
 * @author: baichen
 * 路径总和 III
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * <p>
 * 找出路径和等于给定数值的路径总数。
 * <p>
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * 解题思路：
 * 还是跟之前求路径的一样，递归解决
 * 但是要注意：路径不一定以 root 开头，也不一定以 leaf 结尾，但是必须连续。
 **/
public class pro437 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        //不一定是从root开始的，所以后面的左右子树要调用pathSum方法,即分三次，一次是从root开始的，另外两次分别从左右子树开始
        int ret = pathSumStartWithRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        return ret;
    }

    private int pathSumStartWithRoot(TreeNode root, int sum) {
        int ret = 0;
        if (root == null)
            return 0;
        if (root.val == sum)
            ret++;
        ret += pathSumStartWithRoot(root.left, sum - root.val) + pathSumStartWithRoot(root.right, sum - root.val);
        return ret;
    }
}
