import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program: leetcode
 * @author: baichen
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * <p>
 * 三种方法：
 * 1.暴力法
 * 2.滑动窗口法
 * 3.优化的滑动窗口法
 * <p>
 * 如果从索引 i 到j−1 之间的子字符串 sij已经被检查为没有重复字符。
 * 我们只需要检查 s[j]对应的字符是否已经存在于子字符串 sij中。
 * <p>
 * 滑动窗口是数组/字符串问题中常用的抽象概念。 窗口通常是在数组/字符串中由开始和结束索引定义的一系列元素的集合，
 * 即 [i,j)（左闭，右开）。而滑动窗口是可以将两个边界向某一方向“滑动”的窗口。
 * 例如，我们将 [i,j) 向右滑动 1 个元素，则它将变为 [i+1,j+1)（左闭，右开）。
 **/
public class NotGet_pro3 {
//    public int lengthOfLongestSubstring(String s) {
//        int ans = 0;
//        int n = s.length();
//        //1.暴力法
//        //要求出最长子串的长度，所以可以用两个循环
//        //使用 i从0到 n - 1以及 j 从 i+1 到 n 这两个嵌套的循环，
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j <= n; j++) {
//                if (allUnique(s, i, j))
//                    ans = Math.max(ans, j - 1);
//            }
//        }
//        return ans;
//    }

    //判断元素是否为唯一
//    public boolean allUnique(String s, int start, int end) {
//        Set<Character> set = new HashSet<>();
//        for (int i = start; i < end; i++) {
//            char c = s.charAt(i);
//            if (set.contains(c))
//                return false;
//            set.add(c);
//        }
//        return true;
//    }


    //2.滑动窗口法
    //用i,j标识字符串位置
//    public static int lengthOfLongestSubstring(String s) {
//        int n = s.length();
//        int i = 0, j = 0, ans = 0;
//        Set<Character> set = new HashSet<>();
//        while (i < n && j < n) {
//            if (!set.contains(s.charAt(j))) {
//                //先将j对应的字符存入，然后再j+1
//                set.add(s.charAt(j++));
//                ans = Math.max(ans, j - i);
//            } else {
//                //如果有重复元素，不断遍历删除已存入set中的元素，直到把重复元素删掉
//                //i索引也要跟着变
//                set.remove(s.charAt(i++));
//            }
//        }
//        return ans;
//    }

    //3.优化的滑动窗口
//    可以定义字符到索引的映射，而不是使用集合来判断一个字符是否存在。
// 当我们找到重复的字符时，我们可以立即跳过该窗口。
//    如果 s[j] 在 [i,j) 范围内有与j′重复的字符，我们不需要逐渐增加 i 。
// 我们可以直接跳过 [i，j']范围内的所有元素，并将 i 变为 j' + 1.
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        //遍历字符串s
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                //有重复字符的时候更新i的值,返回重复字符对应的索引和i两者之中的最大值
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    //当字符集较小的时候，可以用数组作为直接访问替换map
//int [26] 用于字母 ‘a’ - ‘z’或 ‘A’ - ‘Z’
//int [128] 用于ASCII码
//int [256] 用于扩展ASCII码
//    public int lengthOfLongestSubstring(String s) {
//        int n = s.length(), ans = 0;
//        int[] index = new int[128]; // current index of character
//        // try to extend the range [i, j]
//        for (int j = 0, i = 0; j < n; j++) {
//            i = Math.max(index[s.charAt(j)], i);
//            ans = Math.max(ans, j - i + 1);
//            index[s.charAt(j)] = j + 1;
//        }
//        return ans;
//    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcbad"));
    }
}
