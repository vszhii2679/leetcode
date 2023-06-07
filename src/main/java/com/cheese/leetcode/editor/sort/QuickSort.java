package com.cheese.leetcode.editor.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 时间复杂度 O(nlogn)
 *
 * @author sobann
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 3, 4};
//        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        sample(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void sample(int[] arr) {
        recursion(arr, 0, arr.length - 1);
    }

    /**
     * 快速排序
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public static void recursion(int[] arr, int low, int high) {
        if (low < high) {
            // 获取划分数组的位置
            int pivotIndex = partition(arr, low, high);
            // 左子数组递归调用
            recursion(arr, low, pivotIndex - 1);
            // 右子数组递归调用
            recursion(arr, pivotIndex + 1, high);
        }
    }

    /**
     * 取数组末端元素作为中心元素，遍历范围内的元素，
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public static int partition(int[] arr, int low, int high) {
        // 取最后一个元素作为中心元素
        int pivot = arr[high];
        // 定义指向比中心元素大的指针，首先指向第一个元素
        int pointer = low;
        // 遍历数组中的所有元素，将比中心元素大的放在右边，比中心元素小的放在左边
        for (int i = low; i < high; i++) {
            if (arr[i] <= pivot) {
                // 将比中心元素小的元素和指针指向的元素交换位置
                // 如果第一个元素比中心元素小，这里就是自己和自己交换位置，指针和索引都向下步进
                swap(arr, i, pointer);
                pointer++;
            }
        }
        // 将中心元素和指针指向的元素交换位置
        swap(arr, pointer, high);
        return pointer;
    }

    /**
     * 元素交换
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     */
    private static void swap(int[] arr, int startIndex, int endIndex) {
        int temp = arr[startIndex];
        arr[startIndex] = arr[endIndex];
        arr[endIndex] = temp;
    }
}
