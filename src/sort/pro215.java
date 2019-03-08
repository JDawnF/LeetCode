package sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @program: leetcode
 * @author: baichen
 * 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，
 * 而不是第 k 个不同的元素。
 * 有多种不同的实现方法
 **/
public class pro215 {
    //库方法排序，时间复杂度 O(NlogN)，空间复杂度 O(1)
    public int findKthLargest(int[] nums, int k) {
        //从小到大排序
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    //堆排序，时间复杂度 O(NlogK)，空间复杂度 O(K)。
    public static int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();//小顶堆,堆顶都是最小的元素
        for (int num : nums) {
            queue.add(num);
            // 维护堆的大小为 K，队列的size超过K就去掉堆顶元素，最后剩下前K大元素，此时堆顶是第K大元素
            if (queue.size() > k)
                queue.poll();
        }
        return queue.peek();
    }

    //快速选择 ：时间复杂度 O(N)，空间复杂度 O(1)
    public int findKthLargest3(int[] nums, int k) {
        k = nums.length - k;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            } else if (j < k) {
                l = j + 1;
            } else {
                h = j - 1;
            }
        }
        return nums[k];
    }

    private int partition(int[] a, int l, int h) {
        int i = l, j = h + 1;
        while (true) {
            while (a[++i] < a[l] && i < h) ;
            while (a[--j] > a[l] && j > l) ;
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, l, j);
        return j;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 1, 5, 7, 3, 9, 6, 8};
        findKthLargest2(nums, 3);
    }
}
