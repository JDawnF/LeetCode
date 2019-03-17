package tree.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: leetcode
 * @author: baichen
 * 利用BFS遍历二叉树，通常使用一个队列实现
 * 层次遍历使用 BFS 实现，利用的就是 BFS 一层一层遍历的特性
 **/
public class Bfs_tree {
    // 给定一个根结点，通过BFS遍历二叉树
    public List<TreeNode> Bfs_tree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<TreeNode> res = new ArrayList<>();
        if (root == null) return null;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                res.add(node);
            }
        }
        return res;
    }
}
