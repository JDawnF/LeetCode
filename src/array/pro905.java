package array;

/**
 * @program: leetcode
 * @author: baichen
 * 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
 * 你可以返回满足此条件的任何数组作为答案。
 * 示例：
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 * 提示：
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 * 解题思路：
 * 1、不使用额外空间：
 * 定义两个指针，一个是数组的开头，一个是数组的结尾，然后直接比较三种三种情况：
 * 1、两者需要交换：小指针对应的元素为奇数，大指针对应的元素为偶数，所以需要交换，并且小指针要加一，大指针要减一
 * 2、小指针对应的元素是偶数，小指针加一
 * 3、大指针对应的元素是奇数，大指针直接减一
 * 2、额外的空间：
 * 直接重新创建一个大小跟A一样的数组，然后判断奇偶数，对应赋值
 **/
public class pro905 {
    public int[] sortArrayByParity(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 == 1 && A[j] % 2 == 0) {
                int p = A[i];
                A[i] = A[j];
                A[j] = p;
                i++;
                j--;
            } else if (A[i] % 2 == 0) {
                i++;
            } else if (A[j] % 2 == 1) {
                j--;
            }
        }
        return A;
    }

    public int[] sortArrayByParity2(int[] A) {
        int i = 0, j = A.length - 1;
        int[] res = new int[A.length];
        for (int k = 0; k < A.length; k++) {
            if (A[k] % 2 == 0) {
                res[i] = A[k];
                i++;
            } else {
                res[j] = A[k];
                j--;
            }
        }
        return res;
    }
}
