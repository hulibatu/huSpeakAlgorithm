package com.algorithm.sort;

import java.util.Arrays;

public class SortMain {

    // 堆排序 集合
    private static int[] array2 = {91, 60, 96, 13, 35, 65, 46, 65, 10, 30, 20, 31, 77, 81, 82};

    public static void main(String[] args) {

        /**
         * 插入排序
         */
        // 直接插入
//        InsertSort insertSort = new InsertSort();
//        System.out.println("插入排序 {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48}: \n"
//                + Arrays.toString(insertSort.sort(new int[]{3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48})));

        // 希尔排序
//        ShellSort shellSort = new ShellSort();
//        System.out.println("希尔排序 {8, 9, 1, 7, 2, 3, 5, 4, 6, 0}: \n"
//                + Arrays.toString(shellSort.sort(new int[]{8, 9, 1, 7, 2, 3, 5, 4, 6, 0})));

        /**
         * 选择排序
         */
        // 直接选择
//        SelectionSort selectionSort = new SelectionSort();
//        System.out.println("选择排序 {8, 9, 1, 7, 2, 3, 5, 4, 6, 0}: \n"
//                + Arrays.toString(selectionSort.sort(new int[]{8, 9, 1, 7, 2, 3, 5, 4, 6, 0})));

        // 堆排序
//        HeapSort heapSort = new HeapSort();
//        System.out.println("堆排序 {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48}: \n"
//                + Arrays.toString(heapSort.sort(new int[]{3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48})));

        /**
         * 交换排序
         */
        // 冒泡排序
//        BubbleSort bubbleSort = new BubbleSort();
//        System.out.println("冒泡排序 {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48}: \n"
//                + Arrays.toString(bubbleSort.sort(new int[]{3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48})));

        // 快速排序
//        QuickSort quickSort = new QuickSort();
//        System.out.println("快速排序 {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48}: \n"
//                + Arrays.toString(quickSort.sort(new int[]{3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48})));

        /**
         * Other排序
         */
        // 归并排序
//        MergeSort mergeSort = new MergeSort();
//        System.out.println("归并排序 {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48}: \n"
//                + Arrays.toString(mergeSort.sort(new int[]{3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48})));

        // 基数排序
        RadixSort radixSort = new RadixSort();
        System.out.println("基数排序 {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48}: \n"
                + Arrays.toString(radixSort.sort(new int[]{3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48})));
    }

}
