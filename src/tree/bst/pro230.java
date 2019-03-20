package tree.bst;

import tree.TreeNode;

/**
 * @program: leetcode
 * @author: baichen
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 1
 * 解题思路：
 * 中序遍历解法实现:
 * 因为是二分搜索树，是已经排好序的，左结点<父节点<右孩子节点，
 * 然后要找出第k小个元素，所以从左子树开始遍历
 * 递归实现:
 * 通过递归统计最小的元素，当达到目标个数是返回。同样，因为左子树比较小，所以先算左子树的个数，再跟k比较
 **/
public class pro230 {
    // 中序遍历
    private int cnt = 0;
    private int val;

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return val;
    }

    private void inOrder(TreeNode node, int k) {
        if (node == null) return;
        inOrder(node.left, k);
        cnt++;
        if (cnt == k) {
            val = node.val;
            return;
        }
        inOrder(node.right, k);
    }

    //递归实现
    public int kthSmallest2(TreeNode root, int k) {
        int leftLength = count(root.left);
        // 当左子树个数是k-1的时候，说明k就是root节点
        if (leftLength == k - 1) return root.val;
        // 当左子树个数大于k-1的时候，说明k在左子树中，继续遍历左子树即可
        if (leftLength > k - 1) return kthSmallest2(root.left, k);
        // 如果上面两种情况都不成立，说明k在右子树中,但是要排除掉左子树的所有元素
        return kthSmallest2(root.right, k - leftLength - 1);
    }

    private int count(TreeNode node) {
        if (node == null) return 0;
        return 1 + count(node.left) + count(node.right);
    }
}
