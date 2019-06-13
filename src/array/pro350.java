package array;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * @Program: pro350
 * @Author: baichen
 * @Description: 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 解题思路：
 * 题意即返回的结果中，每个元素出现的个数跟他们交集出现的个数一样，所以类比249题，这里还需要
 * 统计元素出现的次数，所以可以通过一个Map类型的集合来实现
 */
public class pro350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 统计元素及其个数
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        // 先统计其中一个数组
        for (int num : nums1) {
            if (!treeMap.containsKey(num))
                treeMap.put(num, 1);
            else
                treeMap.put(num, treeMap.get(num) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        // 遍历另一个数组，因为出现的次数要与其一样，所以直接通过个数判断
        for (int num : nums2) {
            if (treeMap.containsKey(num)) {
                list.add(num);
                treeMap.put(num, treeMap.get(num) - 1);
                // 如果次数为0，直接移除元素
                if (treeMap.get(num) == 0)
                    treeMap.remove(num);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
