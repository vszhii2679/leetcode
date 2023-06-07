package com.cheese.leetcode.editor.sort;

import java.util.Arrays;

/**
 * 默写
 *
 * @author sobann
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 3, 4};
//        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        quick(arr);
        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(merge(arr)));
    }


    /**
     * 希尔排序
     * O(nlogn)
     * 一个不断递减的增量序列，
     *
     * @param arr
     */
    public static void shell(int[] arr) {
        int len = arr.length;
        int gap = len >> 1, temp;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = arr[i];
                int preIndex = i - gap;
                //内部使用插入排序
                while (preIndex >= 0 && arr[preIndex] > temp) {
                    //向后移动
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex = preIndex - gap;
                }
                // 单次循环结束完，将最值放到最前
                arr[preIndex + gap] = temp;
            }
            gap = gap >> 1;
        }
    }

    /**
     * 插入排序
     * 逐步将已排序元素向后移动，为最新的元素提供空间
     *
     * @param arr
     */
    public static void insert(int[] arr) {
        int len = arr.length;
        int temp;
        for (int i = 0; i < len - 1; i++) {
            temp = arr[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && arr[preIndex] > temp) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = temp;
        }
    }

    /**
     * 冒泡排序
     * 相邻两个元素比较
     *
     * @param arr
     */
    public static void bubble(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int swap = 0;
            for (int j = 0; j < len - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap++;
                }
            }
            if (swap == 0) {
                return;
            }
        }
    }

    /**
     * 选择排序
     * 一次循环找到最小值的角标，然后交换位置
     *
     * @param arr
     */
    public static void select(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int smallIndex = i;
            for (int j = i; j < len; j++) {
                if (arr[smallIndex] > arr[j]) {
                    smallIndex = j;
                }
            }
            //交换i和j的顺序
            int temp = arr[i];
            arr[i] = arr[smallIndex];
            arr[smallIndex] = temp;
        }
    }

    /**
     * 归并排序
     * 将数组分成两个同样大小的子序列进行比较，合并两个数组
     * 空间换时间
     *
     * @param arr
     */
    public static int[] merge(int[] arr) {
        int len = arr.length;
        int mid = len >> 1;
        if (mid == 0) {
            return arr;
        }
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, len);
        return mergeSub(merge(left), merge(right));
    }

    private static int[] mergeSub(int[] left, int[] right) {
        int[] arr = new int[left.length + right.length];
        int m = 0, n = 0, index = 0;
        while (m < left.length || n < right.length) {
            if (m >= left.length) {
                arr[index] = right[n];
                n++;
            } else if (n >= right.length) {
                arr[index] = left[m];
                m++;
            } else if (left[m] < right[n]) {
                arr[index] = left[m];
                m++;
            } else {
                arr[index] = right[n];
                n++;
            }
            index++;
        }
        return arr;
    }


    /**
     * 快速排序
     * <p>
     * 选取一个中心元素，遍历序列，将小于中心元素的放在左边，大于中心元素的放在右边
     * 快排是冒泡的升级版，但是不是判断相邻位置 添加了基准元素 + 两个指针
     *
     * @param arr
     */
    public static void quick(int[] arr) {
        quick(arr, 0, arr.length - 1);
    }

    private static void quick(int[] arr, int low, int high) {
        if (low < high) {
            // partition是最少可以确认的元素的位置
            int partition = partition(arr, low, high);
            quick(arr, low, partition - 1);
            quick(arr, partition + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int pointer = low;
        for (int i = low; i < high; i++) {
            if (arr[i] <= pivot) {
                // 交换元素的位置，若pointer和i同时步进，就是自身给自身赋值
                int temp = arr[pointer];
                arr[pointer] = arr[i];
                arr[i] = temp;
                pointer++;
            }
        }
        int temp = arr[pointer];
        arr[pointer] = arr[high];
        arr[high] = temp;
        return pointer;
    }
}



