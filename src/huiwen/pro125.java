package huiwen;

/**
 * @program: leetcode
 * @author: baichen
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 * 解题思路：
 * 1、双指针
 * 先转为小写，去掉特殊字符，然后利用ASC码把数字和小写字母找到，并加到新的字符串中
 * 然后对于这个新的字符串，一个指针在前，一个指针在后，依次比较两者是否相等；
 * 2、正则+库函数reverse
 **/
public class pro125 {
    // 超出时间限制
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        String temp = "";
        for (int i = 0; i < chars.length; i++) {
//            去掉特殊字符
            if (((int) chars[i] >= 48 && (int) chars[i] <= 57) || ((int) chars[i] >= 97 && (int) chars[i] <= 122)) {
                temp += chars[i];
            }
        }
        char[] res = temp.toCharArray();
        // 双指针两头
        int i = 0, j = res.length - 1;
        while (i < j) {
            if (res[i] == res[j]) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(String s) {
        s = s.toLowerCase();
        String[] s1 = s.split("[^a-zA-Z0-9]");
        StringBuilder sb = new StringBuilder();
        for (String s2 : s1) {
            sb.append(s2);
        }
        String re = sb.toString();
        s = sb.reverse().toString();
        if (re.equals(s)) return true;
        return false;
    }
}
