package com.algorithm.sort;

/**
 * 插入排序 时间复杂度 O(n^2) 空间复杂度 O(1)
 * <p>
 * 示意图 https://images.morethink.cn/28749729-ca072084-7503-11e7-881c-92aa915ce369.gif
 * <p>
 * 描述
 * <p>
 * 1.第1个元素 默认排序
 * 2.取下一个元素，从后向前扫描，前面的元素已排序
 * 3.curr > before --> next | curr < before ---> 替换
 * 4.重复 2-3 直到遍历结束
 */
public class InsertSort {

    public int[] sort(int[] array) {
        array = sort1(array);
//        array = sort2(array);
//        array = sort3(array);
        return array;
    }

    /**
     * 插入法
     *
     * @param array
     * @return
     */
    private int[] sort1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        return array;
    }

    /**
     * 平移法
     *
     * @param array
     * @return
     */
    private int[] sort2(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int curr = array[i];
            int j;
            for (j = i; j > 0 && curr < array[j - 1]; j--) {
                array[j] = array[j - 1];
            }
            array[j] = curr;
        }
        return array;
    }

    /**
     * 二分查找排序
     * <p>
     * 比较操作 代价比 交换操作 大，可以使用二分查找法减少 比较操作
     *
     * @param array
     * @return
     */
    private int[] sort3(int[] array) {

        for (int i = 1; i < array.length; i++) {

            int startIndex = 0;
            int endIndex = i - 1;
            int curr = array[i];

            // 二分查找未知
            while (startIndex <= endIndex) {
                int midIndex = (startIndex + endIndex) / 2;
                if (curr < array[midIndex]) {
                    endIndex = midIndex - 1;
                } else {
                    startIndex = midIndex + 1;
                }
            }

            for (int j = i - 1; j >= startIndex; j--) {
                array[j + 1] = array[j];
            }

            array[startIndex] = curr;

        }
        return array;
    }


}
