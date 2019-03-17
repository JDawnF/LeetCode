package tree.digui;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcode
 * @author: baichen
 * 翻转一棵二叉树。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * 解题思路：
 * 通过递归实现,或层序遍历二叉树，翻转每个节点
 **/
public class pro226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        // 后面的操作会改变 left 指针，因此先保存下来
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }

    //层序遍历，翻转每个节点及其左右子树,通过一个辅助的队列实现，先进先出
    public TreeNode invertTree2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return null;
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count > 0) {
                TreeNode node = queue.poll();   //弹出队尾元素
                TreeNode left = node.left;
                node.left = node.right;
                node.right = left;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                count--;
            }
        }
        return root;
    }
}
