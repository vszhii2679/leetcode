package com.cheese.leetcode.editor.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * 将数据分割成按照一个不断递减的增量序列进行分组排序（组内的排序使用插入排序），当递增量(增量因子为1时候，整个序列作为一个表来处理)
 * <p>
 * 时间复杂度 O(nlogn)
 * <p>
 * 按照下标的一定增量分组，对每组使用插入排序，增量减至1时，算法终止
 *
 * @author sobann
 */
public class ShellSort {

    public static void main(String[] args) {
//        int[] arr = {5, 2, 9, 3, 4};
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        sample(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 增量 gap = arr.length/2
     * 缩小增量 gap = gap/2 ... 1
     * 增量序列 {n/2, (n/2)/2, ..., 1}
     * <p>
     * 增量因子为2时
     * 52934 -> 52939 -> 52539 -> 42539
     * 增量因子为1时
     * 42539 -> 44539 -> 24539 -> 24559 -> 24459 -> 23459
     *
     * @param arr
     */
    public static void sample(int[] arr) {
        int len = arr.length;
        int temp, gap = len >> 1;
        // 最外层循环进行增量因子递减操作
        while (gap > 0) {
            // 中层循环完成组内最值的赋值
            for (int i = gap; i < len; i++) {
                temp = arr[i];
                int preIndex = i - gap;
                // 最内层循环完成组内的插入排序操作，组内元素向前替换(当符合顺序判断条件时)
                while (preIndex >= 0 && arr[preIndex] > temp) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = temp;
            }
            gap = gap >> 1;
        }
    }


}
