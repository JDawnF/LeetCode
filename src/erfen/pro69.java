package erfen;

/**
 * @Program: pro69
 * @Author: baichen
 * @Description: 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 解题思路：
 * 一个数x的开方sqrt一定在0~x之间，并且满足sqrt == x / sqrt。
 * 可以利用二分查找在 0~ x 之间查找 sqrt。
 * 对于 x = 8，它的开方是 2.82842...，最后应该返回 2 而不是 3。
 * 在循环条件为 l <= h 并且循环退出时，h 总是比 l 小 1，不满足条件才退出
 * 也就是说 h = 2，l = 3，因此最后的返回值应该为 h 而不是 l。
 */
public class pro69 {
    public int mySqrt(int x) {
        if (x <= 1)
            return x;
        int l = 1, h = x;
        while (l <= x) {
            int mid = l + ((x - l) >> 1);
            int sqrt = x / mid;
            if (sqrt == mid) {
                return mid;
            } else if (mid > sqrt) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        // 条件都不满足跳出循环时，返回h
        return h;
    }
}
