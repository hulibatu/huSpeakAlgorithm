package com.algorithm.sort;

/**
 * 冒泡排序 时间复杂度O(n^2) 空间复杂度O(1)
 * <p>
 * 示意图 https://images.morethink.cn/bubble.gif
 */
public class BubbleSort {

    public int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

}
