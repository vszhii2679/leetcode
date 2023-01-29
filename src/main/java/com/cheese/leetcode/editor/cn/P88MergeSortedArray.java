package com.cheese.leetcode.editor.cn;

import java.util.Arrays;

/*
Java：合并两个有序数组
------------------------
//给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。 
//
// 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。 
//
// 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并
//的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
//解释：需要合并 [1,2,3] 和 [2,5,6] 。
//合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
//解释：需要合并 [1] 和 [] 。
//合并结果是 [1] 。
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0], m = 0, nums2 = [1], n = 1
//输出：[1]
//解释：需要合并的数组是 [] 和 [1] 。
//合并结果是 [1] 。
//注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -10⁹ <= nums1[i], nums2[j] <= 10⁹ 
// 
//
// 
//
// 进阶：你可以设计实现一个时间复杂度为 O(m + n) 的算法解决此问题吗？ 
//
// 👍 1705 👎 0

 */
public class P88MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new P88MergeSortedArray().new Solution();
        // TO TEST
        solution.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //考察：数组 指针
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            merge_(nums1, m, nums2, n);
        }

        /**
         * 解题思路：通过两个数组和两个指针 来确认最小值，并根据已确认的最小值对相应数组的指针进行位移，单次循环中两个指针的和只会加1
         * <p>
         * 最优解
         *
         * @param nums1
         * @param m
         * @param nums2
         * @param n
         */
        public void merge_(int[] nums1, int m, int[] nums2, int n) {
            int p = 0;
            int q = 0;
            int cur;
            int[] sorted = new int[m + n];
            //两个数组必须都遍历完 循环才结束
            while (p < m || q < n) {
                if (p == m) {
                    //当nums1遍历完时 顺序拼接nums2的元素
                    cur = nums2[q];
                    q++;
                } else if (q == n) {
                    //当nums2遍历完时 顺序拼接nums1的元素
                    cur = nums1[p];
                    p++;
                } else if (nums1[p] < nums2[q]) {
                    //循环条件已经限制了 p == m 故后续的0不会进行比较
                    cur = nums1[p];
                    p++;
                } else {
                    cur = nums2[q];
                    q++;
                }
                //经历一次循环后，p += 1 或 q += 1 ，所以当前设置的偏移量为 p + q - 1,
                sorted[p + q - 1] = cur;
            }
            //对所以上每一个数据进行赋值
            for (int i = 0; i < m + n; i++) {
                nums1[i] = sorted[i];
            }
        }

        /**
         * 先合并 再排序
         *
         * @param nums1
         * @param m
         * @param nums2
         * @param n
         */
        public void merge_1(int[] nums1, int m, int[] nums2, int n) {
            //合并 并排序
            for (int i = 0; i != n; i++) {
                nums1[i + m] = nums2[i];
            }
            Arrays.sort(nums1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
