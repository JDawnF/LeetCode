package dp;

/**
 * @Program: pro121
 * @Author: baichen
 * @Description: 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * 解题思路：
 * 1、暴力法
 * 2、动态规划
 * 找出截止当前位置的最小值和截至当前位置的最大值，记录两者之差，保留最大的差值。
 */
public class pro121 {
    // 暴力法
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > max)
                    max = profit;
            }
        }
        return max;
    }

    // dp
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int profit = 0;     // 记录收益值
        int low = prices[0];    // 记录最小值
        for (int i = 0; i < prices.length; i++) {
            low = Math.min(low, prices[i]);     // 记录每次的最小值
            profit = Math.max(profit, prices[i] - low); // 记录每次的最大差值
        }
        return profit;
    }
}
