package array;

/**
 * @program: leetcode
 * @author: baichen
 * 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * 示例 1:
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 要求：
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 * 解题思路：
 * 1.二分法,要注意可能是多个重复的值
 * 2.双指针法，类似于找链表是否闭环
 * 快慢指针思想, fast 和 slow 是指针, nums[slow] 表示取指针对应的元素
 * 注意 nums 数组中的数字都是在 1 到 n 之间的(在数组中进行游走不会越界),
 * 因为有重复数字的出现, 所以这个游走必然是成环的, 环的入口就是重复的元素,
 * 即按照寻找链表环入口的思路来做
 **/
public class pro287NotGet {
    //    二分查找法
    public int findDuplicate(int[] nums) {
        // 初始左右边界
        int l = 1, r = nums.length - 1;
        while (l <= r) {
            // 防止变量溢出，要这么写
            int mid = l + (r - l) / 2;
            int cur = 0;
            for (int i = 0; i < nums.length; i++) {
                // 先找到数组中比中间索引小或等于的元素的个数
                if (nums[i] <= mid) cur++;
            }
            // 比较上面的个数与中间索引
            if (cur > mid) r = mid - 1;
            else l = mid + 1;
        }
        return l;
    }

    //    快慢指针，即双指针,把数组当成链表即可
    public int findDuplicate2(int[] nums) {
        // 定义两个指针
        int slow = nums[0], fast = nums[nums[0]];
        // 快慢遍历
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        // 常规遍历
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
