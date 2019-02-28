package string;

/**
 * @program: leetcode
 * @author: baichen
 * 同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * <p>
 * 解题思路：
 * 判断两个字符串同个位置上的字符是否一样
 **/
public class pro205 {
    public boolean isIsomorphic(String s, String t) {
        //开辟两个数组保存两个字符串中每个字符对应的索引,记录位置
        int[] pre = new int[256];
        int[] next = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (pre[sc] != next[tc])
                return false;
            //记录位置
            pre[sc] = i + 1;
            next[tc] = i + 1;
        }
        return true;
    }
}
