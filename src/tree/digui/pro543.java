package tree.digui;

/**
 * @program: leetcode
 * @author: baichen
 * 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过根结点。注意两结点之间的路径长度是以它们之间边的数目表示。
 * 解题思路：
 * 对于每一个结点，经过它的最长路径的长度 = 它的左子树的最大深度 + 右子树的最大深度,即其左右孩子节点到根节点之和
 **/
public class pro543 {
    private static int max = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    private static int depth(TreeNode root) {
        //递归终止条件
        if (root == null)
            return 0;
        //求节点左右子树的长度
        int leftLength = depth(root.left);
        int rightLength = depth(root.right);
        //最大值是max与左右子树之和中的最大值
        max = Math.max(max, leftLength + rightLength);
        //当有叶子节点的时候，要加一，表示当前节点,比较节点左右子树中较大的一个
        return Math.max(leftLength, rightLength) + 1;
    }

    //             1
    //         /      \
    //        2        3
    //       /\         \
    //      4  5         6
    //        /
    //       7
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n5.left = n7;
        n3.right = n6;
        n7.left=n8;
        System.out.println(diameterOfBinaryTree(n1));
    }
}
