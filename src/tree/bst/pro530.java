package tree.bst;

import tree.TreeNode;

/**
 * @program: leetcode
 * @author: baichen
 * 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
 * 解题思路：
 * 还是先中序遍历二叉搜索树，变成有序数组，然后找出前后两个数差值最小即可
 **/
public class pro530 {
    private int min = Integer.MAX_VALUE;    //存放差值最小的值，跟Integer的最大值相比
    private TreeNode preNode = null;        // 定义一个辅助节点l

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return min;
    }

    // 中序遍历，得到有序数组，再分别比较相邻的两个值
    private void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        // 其实node一定大于preNode
        if (preNode != null) min = Math.min(min, node.val - preNode.val);
        preNode = node;     // 因为变成有序数组了，所以preNode其实就是node的上个值
        inOrder(node.right);
    }
}
