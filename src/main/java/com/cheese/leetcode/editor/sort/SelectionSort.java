package com.cheese.leetcode.editor.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 时间复杂度 O(n^2)
 *
 * 不稳定
 *
 * 对未完成排序的部分找最值，然后添加到已完成排序的部分
 *
 * @author sobann
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 3, 4};
        sample(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 基础
     * 52934 -> 25934 -> 23954 -> 23459 -> 23459
     *
     * @param arr
     */
    public static void sample(int[] arr) {
        if (arr.length == 0) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int middleIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[middleIndex]) {
                    // 一次循环找到最小数的角标
                    middleIndex = j;
                }
            }
            // 交换i与middleIndex的数据
            int swap = arr[i];
            arr[i] = arr[middleIndex];
            arr[middleIndex] = swap;
        }
    }

}
