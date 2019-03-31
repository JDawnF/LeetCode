package tree.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: leetcode
 * @author: baichen
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 示例:
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 * <p>
 *    1            <---
 *  /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 * 解题思路：
 * 与之前二叉树的层次遍历类似的，该问题需要用到队列,建立一个queue
 * 遍历每层的节点时，把下一层的节点都存入到queue中
 * 每当开始新一层节点的遍历之前，先把新一层最后一个节点值存到结果中
 **/
public class pro199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();   // 左子树先存进去，所以先弹出左子树
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                // 每次都只有最右边的元素存入，所以弹出左子树后只剩下一个，每次都是判断上层的元素个数
                if (size == 1) res.add(node.val);
                size--;
            }
        }
        return res;
    }
}
