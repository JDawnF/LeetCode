package tree.bst;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @program: leetcode
 * @author: baichen
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * 解题思路：
 * 先中序遍历得到一个有序的数组，然后再通过双指针查找,注意是两个元素，所以不用判断根节点的值了
 * 注意不能分别遍历左右子树了，因为有可能这两个元素分别在左右子树上
 * 或者设置一个HashSet，然后通过先确定一个元素，然后看k减去这个元素的值是否存在于这个HashSet里
 * 存在则返回true，不存在则返回false
 **/
public class pro653 {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        // 定义两个指针
        int i = 0, j = list.size() - 1;
        // 双指针遍历
        while (i < j) {
            int sum = list.get(i) + list.get(j);
            if (sum == k) return true;
            if (sum < k)
                i++;
            else
                j--;
        }
        return false;
    }


    /**
     * 中序遍历
     *
     * @param root 根节点
     * @param list 存放元素的列表
     */
    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    //    第二种解法
    public boolean findTarget2(TreeNode root, int k) {
        HashSet<Integer> set=new HashSet<>();
        return dfs(root,set,k);
    }
    public boolean dfs(TreeNode root, HashSet<Integer> set, int k) {
        if (root==null) return false;
        if (set.contains(k-root.val)) return true;
        set.add(root.val);
        return dfs(root.left,set,k)||dfs(root.right,set,k);
    }

}
