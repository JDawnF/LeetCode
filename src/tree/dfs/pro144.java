package tree.dfs;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: leetcode
 * @author: baichen
 * 给定一个二叉树，返回它的 前序 遍历。通过迭代实现
 * 解题思路：
 * 通过DFS实现，使用栈实现
 **/
public class pro144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return res; //不能返回空，否则会超时
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            res.add(node.val);
            // 先右后左，保证左子树先遍历
            stack.add(root.right);
            stack.add(root.left);
        }
        return res;
    }
}
