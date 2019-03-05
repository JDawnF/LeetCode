package doublezhizhen;

/**
 * @program: leetcode
 * @author: baichen
 * 合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 * 解题思路：
 * 两个都为有序数组，需要从尾开始遍历，否则在 nums1 上归并得到的值会覆盖还未进行归并比较的值。
 * 从尾遍历的话，大的数要放在后面
 **/
public class pro88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //定义两个数组的索引长度
        int index1 = m - 1, index2 = n - 1;
        int mergeIndex = m + n - 1;     //定义合并后数组索引的长度
        while (index1 >= 0 || index2 >= 0) {    //遍历条件是两个数组至少其中一个不为空
            if (index1 < 0) {   //数组一为空，遍历数组而
                nums1[mergeIndex--] = nums2[index2--];
            } else if (index2 < 0) {
                nums1[mergeIndex--] = nums1[index1--];
            } else if (nums1[index1] > nums2[index2]) {//数组都不为空，大的数在后面，所以先遍历数组一
                nums1[mergeIndex--] = nums1[index1--];
            } else {
                nums1[mergeIndex--] = nums2[index2--];
            }
        }
    }
}
