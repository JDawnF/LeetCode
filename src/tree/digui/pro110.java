package tree.digui;

/**
 * @program: leetcode
 * @author: baichen
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 **/
public class pro110 {
    private static boolean result = true;

    public static boolean isBalanced(TreeNode root) {
        getDepth(root);
        return result;
    }

    private static int getDepth(TreeNode node) {
        if (node == null)
            return 0;
        //遍历左右子树，找出每个节点左右子树的高度
        //从根结点开始，先遍历一遍根结点及其后端所有左子树节点,
        // 然后在最后一个左叶子结点,比较其左右子节点，因为是叶子结点，所以返回0，然后判断l-r的绝对值
        //然后再一级一级往上遍历
        int l = getDepth(node.left);
        int r = getDepth(node.right);
        //节点的左右子树之差大于1，不是高度平衡树
        if (Math.abs(l - r) > 1)
            result = false;
        return Math.max(l, r) + 1;
    }


}
