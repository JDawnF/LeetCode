package tree.digui;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @author: baichen
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 解题思路：
 * 通过前序数组，找到根结点，根据存入的HashMap，找到根结点对应的位置，计算出左子树的长度
 * 通过递归分别构建左右子树
 **/
public class pro105 {
    // 缓存中序遍历数组每个值对应的索引，主要起辅助作用
    private Map<Integer, Integer> indexForInOrders = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 遍历中序数组，存入HashM
        for (int i = 0; i < inorder.length; i++)
            indexForInOrders.put(inorder[i], i);
        return reConstructBinaryTree(preorder, 0, preorder.length - 1, 0);
    }

    /**
     * @param pre  前序数组
     * @param preL 前序数组左边界
     * @param preR 前序数组右边界
     * @param inL  中序数组左边界
     * @return
     */
    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR)
            return null;
        TreeNode root = new TreeNode(pre[preL]);
        int rootIndex = indexForInOrders.get(root.val);
        //根结点对应的位置减去中序数组的左边界得到左子树长度
        int leftTreeSize = rootIndex - inL;
        // 根结点已经计算出来了，所以pre要加一
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        // 这里的边界要根据前序数组中根结点为基准去判断
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }
}
