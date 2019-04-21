package dp;

/**
 * @program: leetcode
 * @author: baichen
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 解题思路：
 * 1.动态规划
 * 这个问题可以被分解为一些包含最优子结构的子问题，即它的最优解可以从其子问题的最优解来有效地构建，
 * 我们可以使用动态规划来解决这一问题。
 * 第 i阶可以由以下两种方法得到：在第 (i-1)阶后向上爬一阶。在第 (i-2)阶后向上爬2 阶。
 * 所以到达第 i阶的方法总数就是到第(i−1) 阶和第(i−2) 阶的方法数之和。
 * 令 dp[i]表示能到达第 ii 阶的方法总数：
 * dp[i]=dp[i-1]+dp[i-2]
 * 2.递归
 * 把每一步的结果存储在 memo数组之中，每当函数再次被调用，我们就直接从 memo数组返回结果。
 * 在 memo数组的帮助下，我们得到了一个修复的递归树，其大小减少到 nn 。
 * 3. 斐波那契数
 * Fib(n)=Fib(n−1)+Fib(n−2)
 **/
public class pro70 {
    // 动态规划
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }

    // 递归
    public int climbStairs2(int n) {
        if (n == 1) return 1;
        int memo[] = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }

    public int climb_Stairs(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    }

    // 斐波那契数
    public int climbStairs3(int n) {
        if (n == 1) return 1;
        int l1 = 1;
        int l2 = 2;
        for (int i = 3; i <= n; i++) {
            int l3 = l1 + l2;
            l1 = l2;
            l2 = l3;
        }
        return l2;  // 最后是将l3赋值给l2，所以直接返回l2
    }
}
