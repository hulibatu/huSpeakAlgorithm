package com.algorithm.sort;

/**
 * 选择排序 时间复杂度 O(n^2) 空间复杂度 O(1)
 * <p>
 * 示意图 https://images.morethink.cn/28749720-90304278-7503-11e7-9bc8-e3b56539d8bf.gif
 */
public class SelectionSort {

    public int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
        return array;
    }

}
