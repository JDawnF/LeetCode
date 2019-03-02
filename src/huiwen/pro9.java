package huiwen;

/**
 * @program: leetcode
 * @author: baichen
 * 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 解题思路：
 * 不能简单将数字反转，可能会越界。所以可以判断一半的数字，是否与前面的一半相同
 **/
public class pro9 {
    public boolean isPalindrome(int x) {
        if (x == 0)
            return true;
        if (x % 10 == 0 || x < 0)
            return false;
        int num = 0;
        while (num < x) {
            //反转x的一半
            num = num * 10 + x % 10;
            x = x / 10;
        }
        // 当数字长度为奇数时，我们可以通过 num/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，num = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == num || x == num / 10;

    }
}
