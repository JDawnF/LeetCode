package doublezhizhen;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @program: leetcode
 * @author: baichen
 * 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "holle"
 * 解题思路：
 * 使用双指针，一个从第一个字符开始，一个从最后一个字符开始，遍历字符串，记录元音字母的位置，然后交换
 **/
public class pro345 {
    private final static HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        char[] res = new char[s.length()];
        while (i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!vowels.contains(ci)) {
                //先用i再i+1
                res[i++] = ci;
            } else if (!vowels.contains(cj)) {
                res[j--] = cj;
            } else {
                res[i++] = cj;
                res[j--] = ci;
            }
        }
        return new String(res);
    }
}
