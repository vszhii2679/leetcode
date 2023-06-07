package com.cheese.leetcode.editor.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 时间复杂度 O(n^2) 最快 O(n)
 * 稳定
 *
 * 相邻元素按照大小顺序要求交换位置
 *
 * @author sobann
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 3, 4};
//        simple(arr);
//        xor(arr);
        occurSwap(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 基础冒泡
     *
     */
    public static void sample(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
               if (arr[j + 1] < arr[j]) {
                  int swap = arr[j + 1];
                   arr[j + 1] = arr[j];
                   arr[j] = swap;
               }
            }
        }
    }

    /**
     * 异或 不使用额外变量空间
     *
     */
    public static void xor(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    arr[j] = arr[j] ^ arr[j + 1];
                    // arr[j + 1] = arr[j] ^ arr[j + 1] ^ arr[j + 1] = arr[j]
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    // arr[j] = arr[j] ^ arr[j + 1] ^ arr[j] = arr[j + 1]
                    arr[j] = arr[j] ^ arr[j + 1];
                }
            }
        }
    }


    /**
     * 循环中是否发生了交换，并不是所有的循环都交换了元素的位置
     * 可能在某个循环完成时 排序就已经完成
     *
     */
    public static void occurSwap(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            // 记录单循环中交换的次数
            int swapCount = 0;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    arr[j] = arr[j] ^ arr[j + 1];
                    // arr[j + 1] = arr[j] ^ arr[j + 1] ^ arr[j + 1] = arr[j]
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    // arr[j] = arr[j] ^ arr[j + 1] ^ arr[j] = arr[j + 1]
                    arr[j] = arr[j] ^ arr[j + 1];
                    swapCount ++;
                }
            }
            // 单次循环中没有发生交换，已经完成排序，无需后续循环
            if (swapCount == 0) {
                return;
            }
        }
    }


}
