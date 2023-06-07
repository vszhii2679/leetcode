package com.cheese.leetcode.editor.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 时间复杂度 O(n^2) 最快 O(n)
 * 稳定
 *
 * 遍历已经排序的序列，找到要插入元素的位置(这个过程中会反复将已排序元素逐步向后挪位，为最新的元素提供插入空间)
 *
 * @author sobann
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 3, 4};
        sample(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 基本
     * 52934 -> 55934 -> 25934 -> 25934 -> 25994 -> 25594 -> 23594 -> 23599 -> 23559 -> 23459
     *
     * @param arr
     */
    public static void sample(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        int current;
        for (int i = 0; i < arr.length - 1; i++) {
            current = arr[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
    }
}
