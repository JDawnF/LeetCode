package tree.digui;

/**
 * @program: leetcode
 * @author: baichen
 * 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * s = "leetcode"
 * 返回 0.
 * <p>
 * s = "loveleetcode",
 * 返回 2.
 * 只考虑小写字母。
 * <p>
 * 解题思路：
 * 可以不使用树结构来实现映射，可以直接设置包含 26个 元素的数组，
 * 对数组中每一位表示某一个字符对应的频率即可；
 * 索引为 0 的位置表示 a ，索引为 1 的位置表示 b ，以此类推。
 **/
public class pro387 {
    public int firstUniqChar(String s) {
        // 开辟一个26个空间的数组,这个数组初始值都为0
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++)
            //与a做参照对比，表示第n个索引，即可知道是哪个字母,统计s这个字符串中字母对应的频率
            freq[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++)
            if (freq[s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
}
