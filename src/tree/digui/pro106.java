package tree.digui;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @author: baichen
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 解题思路：
 * 参照105，根据中序和后序遍历特性解决
 **/
public class pro106 {
    // 缓存中序遍历数组每个值对应的索引，主要起辅助作用
    private Map<Integer, Integer> indexForInOrders = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null || postorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++)
            indexForInOrders.put(inorder[i], i);
        return buildCore(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildCore(int[] post, int postL, int postR, int[] in, int inL, int inR) {
        int rootVal = post[postR];
        TreeNode root = new TreeNode(rootVal);
        if (postL == postR) return root;
        int rootIndex = indexForInOrders.get(rootVal);
        int leftLength = rootIndex - inL;
        //后序序列中左子树的最后一个节点
        int leftPostEnd = postL + leftLength - 1;
        if (leftLength > 0)
            root.left = buildCore(post, postL, leftPostEnd, in, inL, rootIndex - 1);
        //右子树非空 postL 和postR是后序数组的结尾和开头，相减就是长度，如果左子树长度小于整个长度
        //那么说明右子树肯定存在。那么对右子树也进行同样的构建树的操作。
        if (leftLength < postR - postL)
            root.right = buildCore(post, leftPostEnd + 1, postR - 1, in, rootIndex + 1, inR);
        return root;
    }
}
