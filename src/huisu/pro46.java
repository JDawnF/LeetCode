package huisu;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @author: baichen
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * 解题思路：
 * 回溯法，要注意数组中元素是不重复的
 **/
public class pro46 {
    // time:O(n!*n) space:O(n)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        helper(res, new ArrayList<>(), nums);
        return res;
    }
    // 遍历数组，存入列表
    private void helper(List<List<Integer>> res, ArrayList<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        // 每次都判断数组中的元素是否存在，存在则跳过
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) continue; // O(n)
            list.add(nums[i]);
            helper(res, list, nums);    // 递归存入数组中的所有元素
            list.remove(list.size() - 1);   // 每次存完之后就清空数组
        }
    }

    // time:O(n!) space:O(n)
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        helper2(res, 0, nums);
        return res;
    }

    /**
     * @param res       返回的结果
     * @param start     起始位置
     * @param nums      数组
     * 辅助函数，每次都交换数组中的位置
     */
    // 去掉上面helper中的if判断，变成O(n!)
    private void helper2(List<List<Integer>> res, int start, int[] nums) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums)
                list.add(num);
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            helper2(res, start + 1, nums);
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
