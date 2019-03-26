package tree.bst;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @author: baichen
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 假定 BST 有如下定义：
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 * <p>
 * 1
 * \
 * 2
 * /
 * 2
 * 返回[2].
 * 提示：如果众数超过1个，不需考虑输出顺序
 * 解题思路：
 * 答案可能不止一个，也就是有多个值出现的次数一样多。所以是返回的是一个整型数组
 * 可以通过中序遍历解决，将二叉搜索树通过中序遍历变成有序列表，因为这样子可以排除节点太分散，
 * 集中相近的节点为前后的节点,然后在遍历的过程中比较前后两个节点的值是否相等
 * 如果相等则将记录的变量数量加一，否则则赋值为1；然后比较记录的值与最大的值
 * 如果当前记录的值大于最大值，则更新最大值，并清空列表，然后添加当前节点的值
 * 如果两者相等，则添加当前节点的值即可，做下轮继续比较
 **/
public class pro501 {
    private int curCount = 1;       // 记录每次数的频率
    private int maxCount = 1;       // 记录最大的频率
    private TreeNode preNode = null;    // 辅助节点，作为当前节点的上个节点

    public int[] findMode(TreeNode root) {
        // 存放众数最大频率的列表
        List<Integer> maxCountNums = new ArrayList<>();
        inOrder(root, maxCountNums);    // 中序遍历
        int[] res = new int[maxCountNums.size()];   // 新建一个众数最大频率的数组
        int i = 0;
        // 遍历最大频率的列表，存入众数最大频率的数组
        for (int num : maxCountNums) {
            res[i++] = num;     // 先赋值给数组res，然后索引再加一
        }
        return res;
    }

    private void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inOrder(node.left, list);   // 遍历左子树
        // 如果上个节点不为空，则比较上个节点与当前节点的值是否相等，记录当前数的频率
        if (preNode != null) {
            if (preNode.val == node.val)
                curCount++;
            else
                curCount = 1;
        }
        if (curCount > maxCount) {
            maxCount = curCount;
            list.clear();   // 清空列表
            list.add(node.val);     // 添加目前最大频率的值
        } else if (curCount == maxCount)    // 如果跟频率相等，那么可能存在多个数频率相等
            list.add(node.val);
        preNode = node;
        inOrder(node.right, list);
    }
}
