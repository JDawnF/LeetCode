package tree.bfs;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: leetcode
 * @author: baichen
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层次遍历为：
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 * 解题思路：
 * 其实跟之前的遍历是一样的，只是这次先遍历后存入列表，然后再倒序输出
 **/
public class pro107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();   // 按顺序存放每行数据的列表
        List<Integer> tempList = new ArrayList<>(); // 每一行暂存的列表
        if (root == null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int toBePrint = 1;//这一层要打印的节点
        int nextLevelCount = 0;//下一层需要打印节点
        while (queue.isEmpty() == false)//队列不为空
        {
            TreeNode temp = queue.poll();//出队
            tempList.add(temp.val);//把需要的val保存下来
            toBePrint--;//每出队一个，这层要打印的节点数就减少一个
            if (temp.left != null) {
                queue.add(temp.left);//入队，先入先出，所以左子树先打印
                nextLevelCount++;//统计下一层节点
            }
            if (temp.right != null) {
                queue.add(temp.right);//和上面类似
                nextLevelCount++;
            }
            if (toBePrint == 0)//当这一层节点打印完了
            {
                list.add(new ArrayList<>(tempList));//把这一行的结果保存
                tempList.clear();   // 将列表清空，每个列表相当于存入一行
                toBePrint = nextLevelCount;//下一层打印的节点，进行赋值
                nextLevelCount = 0;//下下层节点初始值置位0，准备开始计数
            }
        }
        List<List<Integer>> result = new ArrayList<>();//新建一个数组
        for (int i = list.size() - 1; i >= 0; i--)
            result.add(list.get(i));//逆序添加
        return result;
    }
}
