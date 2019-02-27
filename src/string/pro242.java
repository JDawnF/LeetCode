package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @author: baichen
 * 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 你可以假设字符串只包含小写字母。
 * 解题思路：
 * 其实就是判断两个字符串是否完全相同，因为只有26个字符，所以可以用跟首字母a索引判断，
 **/
public class pro242 {
    public boolean isAnagram(String s, String t) {
        //开辟26个字母空间，初始值都为0
        int[] chars = new int[26];
        //每个字符跟a做索引比较，相当于将每个字符转为对应数字表示，并统计数量
        for (char c : s.toCharArray())
            chars[c - 'a']++;
        //同理，然后每次减去一
        for (char c : t.toCharArray())
            chars[c - 'a']--;
        for (int num : chars)
            if (num != 0)
                return false;
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
//            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            } else {
                map.put(c, map.get(c) - 1);
            }
        }
        for (int num : map.values())
            if (num != 0)
                return false;
        return true;
    }
}
