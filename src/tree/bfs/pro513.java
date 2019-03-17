package tree.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcode
 * @author: baichen
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 * 解题思路：
 * 通过BFS实现，注意要先存入右子树，因为队列是先进先出的，而且会先弹出父节点做判断是否还有孩子节点
 **/
public class pro513 {
    public static int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            // 父节点为空后，应该先存入右孩子节点，应该后面遍历二叉树的时候会先弹出右子树节点
            if (root.right != null) queue.add(root.right);
            if (root.left != null) queue.add(root.left);
        }
        return root.val;
    }
}
