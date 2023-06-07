package com.cheese.leetcode.editor.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 时间复杂度 O(nlogn)
 * 需要额外的空间
 *
 * 对数组进行递归拆分操作，并对拆分后的数组进行合并并生成有序数组
 *
 * @author sobann
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 3, 4};
        int[] sample = sample(arr);
        System.out.println(Arrays.toString(sample));
    }

    /**
     * 归并排序
     * 递归的解法，使用空间换时间
     */
    public static int[] sample(int[] arr) {
        return recursion(arr);
    }


    /**
     * 拆分数组
     * 问题简化: 合并两个有序数组
     *
     * @param arr
     */
    public static int[] recursion(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        // 分段排序
        int mid = arr.length >> 1;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        // 合并两个有序数组
        return merge(recursion(left), recursion(right));
    }


    /**
     * 对两个数组排序并合并
     * 过程就是排序+合并有序数组的算法题~
     * 参考P88  合并两个有序数组
     * <p>
     * 当前可能两个数组并不有序，所以还是需要两个指针来获取符合条件的数据
     *
     * @param left
     * @param right
     * @return
     */
    private static int[] merge(int[] left, int[] right) {
        int[] arr = new int[left.length + right.length];
        // 定义两个指针i 和 j，分别用与遍历数组 left和 right
        for (int index = 0, i = 0, j = 0; index < arr.length; index++) {
            if (i >= left.length) {
                //当i遍历完left时，顺序添加right中的元素
                arr[index] = right[j];
                j++;
            } else if (j >= right.length) {
                // 当i遍历完left时，顺序添加right中的元素
                arr[index] = left[i];
                i++;
            } else if (left[i] < right[j]) {
                // 将left和right当前指针指向的值进行比较，
                arr[index] = left[i];
                i++;
            } else {
                arr[index] = right[j];
                j++;
            }
        }
        return arr;
    }
}
