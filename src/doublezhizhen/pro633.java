package doublezhizhen;

/**
 * @program: leetcode
 * @author: baichen
 * 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 * 示例1:
 * 输入: 5
 * 输出: True
 * 解释: 1 * 1 + 2 * 2 = 5
 * 解题思路：
 * 先获取c的平方根j，然后另一个指针i从0开始，不断加一，i和j的平方和跟c比较，大的话就j-1；小的话就i+1
 **/
public class pro633 {
    public boolean judgeSquareSum(int c) {
        int i = 0;
        int j = (int) Math.sqrt(c);
        while (i <= j) {
            int sum = i * i + j * j;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
