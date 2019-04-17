package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @author: baichen
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * 解题思路：
 * 1.回溯法
 * 只有在知道序列仍然保持有效时才添加 '(' or ')',可以通过跟踪到目前为止放置的左括号和右括号的数目来做到这一点，
 * 如果还剩一个位置，可以开始放一个左括号。 如果它不超过左括号的数量，我们可以放一个右括号。
 * 2.闭合数
 * 思路:
 * 为了枚举某些内容，我们通常希望将其表示为更容易计算的不相交子集的总和。
 * 考虑有效括号序列 S 的闭包数：至少存在index> = 0，使得 S[0], S[1], ..., S[2*index+1]是有效的。
 * 显然，每个括号序列都有一个唯一的闭包号。 我们可以尝试单独列举它们。
 * 算法:
 * 对于每个闭合数 c，我们知道起始和结束括号必定位于索引 0 和 2*c + 1。
 * 然后两者间的 2*c 个元素一定是有效序列，其余元素一定是有效序列。
 **/
public class pro22 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max) {
        // 递归终止条件，存入每次组合而成的括号
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }
        // 分别存入左右括号,统计左右括号个数
        if (open < max)
            backtrack(ans, cur + "(", open + 1, close, max);
        // 右边括号小于左边的时候再回溯
        if (close < open)
            backtrack(ans, cur + ")", open, close + 1, max);
    }
    // 解法二
    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left: generateParenthesis2(c))
                    for (String right: generateParenthesis2(n-1-c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }
}
