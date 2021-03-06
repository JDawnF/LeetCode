package erfen;

/**
 * @Program: pro278
 * @Author: baichen
 * @Description: 第一个错误的版本
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。
 * 由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中
 * 出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * 示例:
 * 给定 n = 5，并且 version = 4 是第一个错误的版本。
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 * 所以，4 是第一个错误的版本。
 * 解题思路：
 * 通过二分法解决，相当于在寻找小于某个数的最小元素
 * 如果第 m 个版本出错，则表示第一个错误的版本在 [l, m] 之间，令 h = m;
 * 否则第一个错误 的版本在 [m + 1, h] 之间，令 l = m + 1。
 * 因为 h 的赋值表达式为 h = m，因此循环条件为 l < h。
 */
public class pro278 {
    public int firstBadVersion(int n) {
        int l = 0, h = n;
        while (l < h) {
            int mid = l + ((h - l) >> 1);
            if (isBadVersion(mid))
                h = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    //    随意捏造的方法，对应系统的api
    private boolean isBadVersion(int mid) {
        return false;
    }
}
