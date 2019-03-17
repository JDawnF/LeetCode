package tree.dfs;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: leetcode
 * @author: baichen
 * 层次遍历使用 BFS 实现，利用的就是 BFS 一层一层遍历的特性；而前序、中序、后序遍历利用了 DFS 实现。
 *
 * 前序、中序、后序遍只是在对节点访问的顺序有一点不同，其它都相同。
 * DFS 遍历二叉树分成前中后序遍历。通过栈实现。
 **/
public class DFS_Tree {
    public List<TreeNode> Dfs_tree(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        List<TreeNode> res=new ArrayList<>();
        if(root==null) return null;
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            res.add(node);
            if (node.right != null) stack.add(node.right);
            if (node.left != null) stack.add(node.left);
        }
        return res;
    }
}
