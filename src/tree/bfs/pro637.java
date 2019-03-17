package tree.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: leetcode
 * @author: baichen
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * 示例 1:
 * 输入:
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 输出: [3, 14.5, 11]
 * 解释:
 * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
 * 注意：节点值的范围在32位有符号整数范围内。
 * 解题思路：
 * 使用 BFS 进行层次遍历。不需要使用两个队列来分别存储当前层的节点和下一层的节点，
 * 因为在开始遍历一层的节点时，当前队列中的节点数就是当前层的节点数，只要控制遍历这么多节点数，
 * 就能保证这次遍历的都是当前层的节点。
 * 创建一个队列来保存、维护和遍历每一层的节点，所以要注意左右子树的添加和队首的弹出
 **/
public class pro637 {
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);    // 添加一整棵树
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();   //弹出一整棵树
                sum += node.val;
                // 弹出父节点之后，将其左右子树存入队列,然后继续遍历同层节点
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            // 每层遍历完之后都计算平均值
            res.add(sum / size);
        }
        return res;
    }
}
