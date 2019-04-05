package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode
 * @author: baichen
 * 给定一个包含n个整数的数组nums和一个目标值target，判断nums中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 注意：
 * 答案中不可以包含重复的四元组。
 * 示例：
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * 解题思路：
 * 思路跟16题差不多，这里还是先对数组排序，然后利用双指针，先确定2个数,
 * 这两个数，一个从开头开始，begin,是外层循环，一个从末尾往前遍历，end,是内层循环(要注意，必须间隔两个数，因为要取4个数)
 * 然后再通过双指针进行遍历取得另外的两个数与确定的2个数相加，他们的和跟target比较
 * 注意，因为得到的不能是重复的四元组，所以可以通过集合来去重
 **/
public class pro18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 集合去重，是List<Integer>的话方便后面直接遍历存入列表
        HashSet<List<Integer>> set = new HashSet<>();
        List<List<Integer>> res = new LinkedList<>();
        // 如果数组只有4个元素的话，直接判断这四个元素之和是否等于target，是就直接返回，否则返回空列表
        if (nums.length == 4) {
            if (nums[0] + nums[1] + nums[2] + nums[3] == target) {
                List<Integer> temp = new LinkedList<>();
                temp.add(nums[0]);
                temp.add(nums[1]);
                temp.add(nums[2]);
                temp.add(nums[3]);
                res.add(temp);
                return res;
            }
            return res;
        }
        Arrays.sort(nums);
//      先确定两个值，这两个值为数组的首尾，因为还会在这中间取两个数，所以这里要减去3
        for (int begin = 0; begin < nums.length - 3; begin++) {
//          这里表示中间取两个数
            for (int end = nums.length - 1; end - begin > 2; end--) {
//              初始化左右两个指针
                int l = begin + 1;
                int r = end - 1;
                while (l < r) {
                    int tempSum = nums[begin] + nums[l] + nums[r] + nums[end];
                    if (tempSum == target) {
                        List<Integer> temp = new LinkedList<>();
                        temp.add(nums[begin]);
                        temp.add(nums[l]);
                        temp.add(nums[r]);
                        temp.add(nums[end]);
                        set.add(temp);  // 去重
                        l++;
                    } else if (tempSum > target)
                        r--;
                    else
                        l++;
                }
            }
        }
        // 遍历集合，返回结果
        for (List<Integer> list : set)
            res.add(list);
        return res;
    }
}
