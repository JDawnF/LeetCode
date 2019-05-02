package erfen;

/**
 * @Program: pro744
 * @Author: baichen
 * @Description: 寻找比目标字母大的最小字母
 * 给定一个只包含小写字母的有序数组letters 和一个目标字母 target，
 * 寻找有序数组里面比目标字母大的最小字母。
 * 数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z'
 * 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。
 * 示例:
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "a"
 * 输出: "c"
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "c"
 * 输出: "f"
 * 解题思路：
 * 二分查找的变形,返回左边最小的大于target的字符，如果不存在则返回字符数组的第一位
 */
public class pro744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int l = 0;
        int h = n - 1;
        while (l <= h) {
            int mid = l + ((h - l) >> 1);
            if (letters[mid] <= target) {
                l = mid + 1;
            } else {  // letters[mid] > target
                h = mid - 1;
            }
        }
        return l < n ? letters[l] : letters[0];
    }
    // 解法二
    public char nextGreatestLetter2(char[] letters, char target) {
        int n = letters.length;
        int l = 0;
        int h = n - 1;
        while (l <= h) {
            int mid = l + ((h - l) >> 1);
            if (letters[mid] <= target) {
                l = mid + 1;
            } else {  // letters[mid] > target
                if (mid == 0 || letters[mid - 1] <= target) return letters[mid];
                else h = mid - 1;
            }
        }
        return letters[0];
    }
}
