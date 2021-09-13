package com.algorithm.sort;

import java.util.Arrays;
import java.util.Stack;

/**
 * 快速排序 时间复杂度O(n^2) 空间复杂度O(1)
 * <p>
 * 示例图 https://images.morethink.cn/quick-sort.gif
 * <p>
 * 分治、基准、递归
 * <p>
 * 伪代码：
 * （1）i = L; j = R; 将基准数挖出形成第一个坑a[i]
 * （2）j--，由后向前找比它小的数，找到后挖出此数填前一个坑a[i]中
 * （3）i++，由前向后找比它大的数，找到后也挖出此数填到前一个坑a[j]中
 * （4）再重复执行2，3二步，直到i==j，将基准数填入a[i]中
 */
public class QuickSort {

    public int[] sort(int[] array) {
//        sort1(array, 0, array.length - 1);
//        sort2(array);
        sortThreeWay(array, 0, array.length - 1);
        return array;
    }

    /**
     * 递归
     *
     * @param array
     * @param start
     * @param end
     */
    public void sort1(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        //保存基准的值
        int pivot = array[left];
        while (left < right) {

            //从后向前找到比基准小的元素，插入到基准位置中
            while (left < right && array[right] >= pivot) {
                right--;
            }
            array[left] = array[right];

            //从前往后找到比基准大的元素
            while (left < right && array[left] <= pivot) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = pivot;
        sort1(array, start, left - 1);
        sort1(array, left + 1, end);
    }

    /**
     * 非递归
     *
     * @param array
     */
    public void sort2(int[] array) {
        Stack<Integer> stack = new Stack<Integer>();

        int start = 0;
        int end = array.length - 1;

        stack.push(start);
        stack.push(end);
        while (!stack.isEmpty()) {

            int e = stack.pop();
            int s = stack.pop();

            int pivotIndex = partition(array, s, e);

            if (pivotIndex > s ) {
                stack.push(s);
                stack.push(pivotIndex - 1);
            }

            if (pivotIndex < e && pivotIndex >= 0) {
                stack.push(pivotIndex + 1);
                stack.push(e);
            }

        }
    }

    private int partition(int[] array, int low, int high) {
        if (low >= high) {
            return -1;
        }
        int left = low;
        int right = high;
        int pivot = array[left];
        while (left < right) {
            while (left < right && array[right] >= pivot) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= pivot) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = pivot;
        return left;
    }

    /**
     * 三者取中法
     * <p>
     * 若初始序列按关键码有序或基本有序，退化冒泡排序
     */
    private void sortThreeWay(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = array[low];
        int left = low;
        int middle = low + 1;
        int right = high;

        while (middle <= right) {
            if (array[middle] < pivot) {
                swap(array, middle++, left++);
            } else if (array[middle] > pivot) {
                swap(array, middle, right--);
            } else {
                middle++;
            }
        }
        sortThreeWay(array, low, left - 1);
        sortThreeWay(array, right + 1, high);
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }


}
