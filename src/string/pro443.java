package string;

/**
 * @program: leetcode
 * @author: baichen
 * 压缩字符串
 * 给定一组字符，使用原地算法将其压缩。压缩后的长度必须始终小于或等于原数组长度。
 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。在完成原地修改输入数组后，返回数组的新长度。
 * 示例 1：
 * 输入：
 * ["a","a","b","b","c","c","c"]
 * 输出：
 * 返回6，输入数组的前6个字符应该是：["a","2","b","2","c","3"]
 * 说明：
 * "aa"被"a2"替代。"bb"被"b2"替代。"ccc"被"c3"替代。
 * 示例 2：
 * 输入：["a"]
 * 输出：返回1，输入数组的前1个字符应该是：["a"]
 * 说明：没有任何字符串被替代。
 **/
public class pro443 {
    public int compress(char[] chars) {
        // 统计字符重复个数，默认至少1个
        int count = 1;
        int index = 0;    // 统计数组删除后个数
        // 遍历数组
        for (int i = 0; i < chars.length; i++) {
        // 如果数组只有一个元素或者其中一个字符跟它的下一个字符不相等了,就要具体分析此字符个数情况
            if (i + 1 == chars.length || chars[i] != chars[i + 1]) {
                // 先对原数组进行重新赋值,然后index再加一
                chars[index++] = chars[i];
                // 如果个数大于1，则将个数转为字符串
                if (count > 1) {
                    String temp = String.valueOf(count);
                    // 可能个数大于9，所以要遍历字符串,并对相应的位置赋值
                    for (int k = 0; k < temp.length(); k++)
                        chars[index++] = temp.charAt(k);
                }
                count = 1;      // 回归原来的1
            } else
                count++;    // 如果还没遇到前后不等的，继续统计个数
        }
        return index;   // 数组重新赋值的时候会统计个数
    }
}
