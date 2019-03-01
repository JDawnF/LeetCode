package string;

/**
 * @program: leetcode
 * @author: baichen
 * 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 *
 * 示例 1:
 *
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 示例 2:
 *
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 *
 * 解题思路：
 * 从字符串的某一位开始，尝试着去扩展子字符串。
 **/
public class pro647_NotGet {
    int count=0;
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            extendSubstrings(s, i, i);     // 奇数长度
            extendSubstrings(s, i, i + 1); // 偶数长度
        }
        return count;
    }
    private void extendSubstrings(String s, int start, int end) {
        while (start>=0&&end<s.length()&&s.charAt(start)==s.charAt(end)){
            start--;
            end++;
            count++;
        }
    }
}
