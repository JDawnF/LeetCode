package array;

/**
 * @Program: pro75
 * @Author: baichen
 * @Description: 颜色分类(荷兰国旗问题)
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，
 * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * 示例:
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 解题思路：
 * 荷兰国旗问题，三路快排思想，只需遍历一遍数组即可,通过指针将数组划分为三个区域，
 * 左边区域(即0区域，p0)，当前区域(cur)，右边区域(即2区域，p2)
 * 沿着数组移动 cur指针，若nums[cur] = 0，则将其与 nums[p0]互换；
 * 若 nums[cur] = 2 ，则与 nums[p2]互换。
 * <p>
 * 先初始化左边界和当前位置为0，右边界为数组长度-1，然后判断当前位置的值，不断改变左右边界区域
 */
public class pro75 {
    public void sortColors(int[] nums) {
        int l = 0, cur = 0;
        int r = nums.length - 1;
        int tmp;
        while (cur < r) {
            if (nums[cur] == 0)
                // 交换并扩大左边区域
                swap(nums, l++, cur++);
            else if (nums[cur] == 2)
                // 交换并减小右边区域，因为此时交换后的cur是未扫描的，所以不用++
                swap(nums, cur, r--);
            else
                cur++;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
