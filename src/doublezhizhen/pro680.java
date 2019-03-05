package doublezhizhen;

/**
 * @program: leetcode
 * @author: baichen
 * 验证回文字符串 Ⅱ
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * 解题思路：
 * 双指针判断对应的两个字符是否相等
 **/
public class pro680 {
    public boolean validPalindrome(String s) {
        int i = -1, j = s.length();
        while (++i < --j) {
            if (s.charAt(i) != s.charAt(j))
                //删除一个元素
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        //遍历字符串，两个指针分别从第一位和最后一位开始遍历，判断对应的字符是否相等
        while (i < j)
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        return true;
    }
}
