package stack_queue;

import java.util.Stack;

/**
 * @program: leetcode
 * @author: baichen
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：左括号必须用相同类型的右括号闭合。左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 **/
public class pro20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            //获取字符串的每个字符
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                //获取栈顶元素
                char topChar = stack.pop();
                if (topChar == '(' && c != ')')
                    return false;
                if (topChar == '[' && c != ']')
                    return false;
                if (topChar == '{' && c != '}')
                    return false;
            }
        }
        return stack.isEmpty(); //判断栈是否为空,如果是空的话则匹配成功
    }
}
