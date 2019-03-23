package tree.bst;

import tree.TreeNode;

/**
 * @program: leetcode
 * @author: baichen
 * 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 示例:给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 * 解题思路：
 * 注意数组是有序的，其实就是 二叉树中序遍历的逆过程，先求出数组的中间元素，作为root，然后再分别遍历左右子树
 **/
public class pro108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return nums == null ? null : getBST(nums, 0, nums.length - 1);
    }

    // 构造搜索二叉树
    private TreeNode getBST(int[] nums, int startIndex, int endIndex) {
        if (startIndex > endIndex)
            return null;
        int midIndex = (startIndex + endIndex) / 2;
        TreeNode root = new TreeNode(nums[midIndex]);
        root.left = getBST(nums, startIndex, midIndex - 1);
        root.right = getBST(nums, midIndex + 1, endIndex);
        return root;
    }
}
