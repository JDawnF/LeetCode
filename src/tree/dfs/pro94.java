package tree.dfs;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: leetcode
 * @author: baichen
 * 给定一个二叉树，返回它的中序 遍历。迭代
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * 输出: [1,3,2]
 * 解题思路：
 * 中序遍历是left->root->right，所以按顺序遍历即可
 **/
public class pro94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if (root==null) return res; //放在创建栈上面，一旦为null就返回，节省空间
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur = root;    //当前节点，从根结点开始
        // 先遍历左子树，再遍历根，最后是右子树
        while (cur != null || !stack.isEmpty()) {
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;   //放入父节点之后，放入左孩子节点
            }
            TreeNode node=stack.pop();  // 弹出父节点
            res.add(node.val);
            cur=node.right; //存入右孩子节点
        }
        return res;
    }
}
