package tree.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: leetcode
 * @author: baichen
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * 解题思路：
 * 一般遇到层次遍历都可以通过队列去实现,先存入根结点，再左子树，右子树
 **/
public class pro102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> res=new ArrayList<>();
        if (root==null) return res;
        queue.add(root);
        // 外层大循环整个树结构
        while (!queue.isEmpty()){
            // 每层都要取队列长度
            int size=queue.size();
            List<Integer> list=new ArrayList<>();   // 存放每一层的列表,要写在下个循环的上面
            while (size>0){ //遍历每一层
                TreeNode node=queue.poll();
                list.add(node.val);
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
                size--;
            }
            res.add(list);
        }
        return res;
    }
}
