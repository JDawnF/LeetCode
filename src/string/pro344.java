package string;

/**
 * @Program: pro344
 * @Author: baichen
 * @Description: 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * 示例 1：
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * 解题思路:
 * 1.直接从头到尾交换
 * 2.从首尾向中间交换
 */

public class pro344 {
    public void reverseString(char[] s) {
        char temp;
        int n = s.length;
        for (int i = 0; i < n / 2; i++) {   // 不用遍历全部数组，遍历一半即可
            temp = s[i];
            s[i] = s[n - i - 1];
            s[n - i - 1] = temp;
        }
    }

    public void reverseString2(char[] s) {
        char temp;
        // 左右边界
        int l = 0, r = s.length - 1;
        while (l < r) {
            temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}
