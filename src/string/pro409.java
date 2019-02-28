package string;

/**
 * @program: leetcode
 * @author: baichen
 * 最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 示例 1:
 * 输入:
 * "abccccdd"
 * 输出:
 * 7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * 解题思路：
 * 使用长度为 256 的整型数组来统计每个字符出现的个数，每个字符有偶数个可以用来构成回文字符串。
 * 因为回文字符串最中间的那个字符可以单独出现，所以如果有单独的字符就把它放到最中间。
 * 字母ASCII码A~Za~z区间为（65～122）为此，可以使用128的数组标记每个字母出现的次数。
 **/
public class pro409 {
    public int longestPalindrome(String s) {
        //记录字符串s中每个字符的频率
        int[] freqs = new int[128];
        for (char c : s.toCharArray())
            //记录每个字符的频率
            freqs[c]++;
        int nums = 0;
        for (int num : freqs)
            //回文字符串肯定是有偶数个的
            nums = +(num / 2) * 2;
        //如果小于字符串长度，说明有奇数的，位于中间位置，加一即可
        if (nums < s.length())
            nums++;
        return nums;
    }
}
