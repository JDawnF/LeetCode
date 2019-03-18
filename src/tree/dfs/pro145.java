package tree.dfs;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @program: leetcode
 * @author: baichen
 * 给定一个二叉树，返回它的 后序 遍历。使用迭代实现
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * 解题思路：
 * 前序遍历为 root -> left -> right，后序遍历为 left -> right -> root。
 * 可以修改前序遍历成为 root -> right -> left，那么这个顺序就和后序遍历正好相反。
 **/
public class pro145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if (root==null) return res;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            if (node==null) continue;
            res.add(node.val);
            // 修改前序遍历为先存入左孩子，再存入右孩子
            stack.push(node.left);
            stack.push(node.right);
        }
        Collections.reverse(res);
        return res;
    }
}
