package com.algorithm.sort;

/**
 * 归并排序 时间复杂度O(n*log2n) 空间复杂度O(n)
 * <p>
 * 示意图 https://images.morethink.cn/merging-sort.gif
 * <p>
 * 分解：将序列每次折半拆分
 * 合并：将划分后的序列段两两排序合并
 */
public class MergeSort {

    private int[] aux;

    public int[] sort(int[] array) {
        aux = new int[array.length];
        sort(array, 0, array.length - 1);
        return array;
    }

    private void sort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        sort(array, low, mid);
        sort(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    /**
     * 该方法先将所有元素复制到aux[]中，然后在归并会a[]中。方法咋归并时(第二个for循环)
     * 进行了4个条件判断：
     * - 左半边用尽(取右半边的元素)
     * - 右半边用尽(取左半边的元素)
     * - 右半边的当前元素小于左半边的当前元素(取右半边的元素)
     * - 右半边的当前元素大于等于左半边的当前元素(取左半边的元素)
     *
     * @param array
     * @param low
     * @param mid
     * @param high
     */
    private void merge(int[] array, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            aux[k] = array[k];
        }
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                array[k] = aux[j++];
            } else if (j > high) {
                array[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                array[k] = aux[j++];
            } else {
                array[k] = aux[i++];
            }
        }
    }


}
