package doublezhizhen;

/**
 * @program: leetcode
 * @author: baichen
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle
 * 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。
 * 这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * 解题思路：
 * 使用双指针解决
 * 先遍历haystack字符串，找到与needle开头字符然后记录下来这个位置i,
 * 然后j=i+1依次与needle进行比较，看每个字符是否相等，相等就继续比较下一个字符，
 * 直到找到不相等的字符，那么这次比较久结束，如果都相等直接返回i；
 * 接下来就是haystack字符串i进行+1，然后再重复上述过程。
 * 或者直接库函数：return haystack.indexOf(needle);
 **/
public class pro28 {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        // 将两个字符串转换为字符数组
        char[] chars1 = haystack.toCharArray();
        char[] chars2 = needle.toCharArray();
        // 遍历大的字符串
        for (int i = 0; i < chars1.length; i++) {
            // 找到大字符串中与小字符串第一个字符相等的字符，进入在大字符串中查找小字符串
            if (chars1[i] == chars2[0]) {
                // 定义两个指针
                int j = i + 1;
                int k = 1;
                for (k = 1; k < chars2.length && j < chars1.length; k++) {
                    if (chars2[k] == chars1[j]) {
                        j++;    // 继续遍历大字符串
                    } else
                        break;
                }
                // 表明找到小字符串
                if (k == chars2.length)
                    return i;
            }
        }
        return -1;
    }
}
