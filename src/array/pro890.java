package array;

/**
 * @program: leetcode
 * @author: baichen
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 解题思路：
 * 要考虑两种情况，一种是数组中的数字都是9,比如999，这时候数组长度需要+1；首位置位1，后几位置位0。
 * 另一种是情况是不全是9，那么加1的话，比如说个位是9，那么就把个位变为0，同时下一位加1，就是通过
 * 判断每一位是不是9来结束这个判断（从个位到最高位依次+1，直到不是9就结束循环）
 **/
public class pro890 {
    public int[] plusOne(int[] digits) {
        // flag是判断数组元素是不是全是9的标识
        boolean flag = true;
        for (int i = 0; i < digits.length; i++) {
            // 只要数据有一个不是9，即改变flag变量，并跳出循环
            if (digits[i] != 9) {
                flag = false;
                break;
            }
        }
        if (flag) { // 如果flag为true，表明全是9，直接new一个新数组，首位为1，其他都为0
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        } else {    // 不全是9
            for (int i = digits.length - 1; i >= 0; i--) {
                // 先判断最后一位是否为9，注意这里是从数组的最后开始的，所以判断的是末位
                if (digits[i] != 9) {
                    digits[i] += 1; // 如果不是9直接最后一位加一，并跳出循环
                    break;
                } else
                    digits[i] = 0;  // 否则则最后一位赋值为0，在下一轮循环中，前一位加一
            }
        }
        return digits;
    }
}
