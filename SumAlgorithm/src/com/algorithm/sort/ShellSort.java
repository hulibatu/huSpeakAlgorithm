package com.algorithm.sort;

/**
 * 希尔排序 时间复杂度 O(n * log n) 空间复杂度 O(1)
 * <p>
 * 示意图 https://images2015.cnblogs.com/blog/1024555/201611/1024555-20161128110416068-1421707828.png
 */
public class ShellSort {

    public int[] sort(int[] array) {
//        array = sort1(array);
        array = sort2(array);
        return array;
    }

    /**
     * 希尔排序 针对有序序列在插入时采用交换法
     *
     * @param array
     * @return
     */
    private int[] sort1(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int currIndex = i;
                while (currIndex - gap >= 0 && array[currIndex] < array[currIndex - gap]) {
                    // 两两交换
                    int temp = array[currIndex];
                    array[currIndex] = array[currIndex - gap];
                    array[currIndex - gap] = temp;
                    currIndex -= gap;
                }
            }
        }
        return array;
    }

    /**
     * 希尔排序 针对有序序列在插入时采用移动法。
     *
     * @param array
     * @return
     */
    private int[] sort2(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int currIndex = i;
                int temp = array[i];
                if (array[currIndex] < array[currIndex - gap]) {
                    while (currIndex - gap >= 0 && temp < array[currIndex - gap]) {
                        array[currIndex] = array[currIndex - gap];
                        currIndex -= gap;
                    }
                    array[currIndex] = temp;
                }
            }
        }
        return array;
    }

}
