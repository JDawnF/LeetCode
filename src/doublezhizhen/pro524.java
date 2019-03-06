package doublezhizhen;

import java.util.List;

/**
 * @program: leetcode
 * @author: baichen
 * 通过删除字母匹配到字典里最长单词
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * <p>
 * 输出:
 * "apple"
 * 说明:
 * <p>
 * 所有输入的字符串只包含小写字母。
 * 字典的大小不会超过 1000。
 * 所有输入的字符串长度不会超过 1000。
 * 解题思路：
 * 创建一个判断列表中的元素是否为字符串中的元素，然后再遍历列表，找出字典顺序最小的，调用创建的方法判断
 * 这里的字典顺序最小是指字符对应的ASCII码最小，注意可以删除一些字符串，所以最长字符换不一定是连续的字符组成
 **/
public class pro524 {
    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        //遍历列表，target表示列表中的值
        for (String target : d) {
            int l1 = longestWord.length(), l2 = target.length();
            //longestWord对应的字符比target小或者两者长度相等时，跳出本次循环，继续下次循环
            if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
                continue;
            }
            if (isValid(s, target)) {
                longestWord = target;
            }
        }
        return longestWord;
    }

    private boolean isValid(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }
}
