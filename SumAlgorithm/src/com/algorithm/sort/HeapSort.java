package com.algorithm.sort;

/**
 * 堆排序 时间复杂度O(n*log2n) 空间复杂化度 O(1)
 * <p>
 * 示意图 https://images.morethink.cn/heap_sort_gif.gif
 * <p>
 * 最大堆调整（Max_Heapify）：将堆的末端子节点作调整，使得子节点永远小于父节点
 * 创建最大堆（Build_Max_Heap）：将堆所有数据重新排序
 * 堆排序（HeapSort）：移除位在第一个数据的根节点，并做最大堆调整的递归运算
 */
public class HeapSort {

    public int[] sort(int[] array) {

        for (int i = array.length - 1; i > 0; i--) {
            max_heapify(array, i);
            //堆顶元素(第一个元素)与Kn交换
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
        }

        return array;
    }


    /**
     * 数组 -> 堆
     * <p>
     * 父节点i的左子节点在位置：(2*i+1);
     * 父节点i的右子节点在位置：(2*i+2);
     * 子节点i的父节点在位置：floor((i-1)/2);
     *
     * @param array
     * @param n
     */
    private void max_heapify(int[] array, int n) {
        int child;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            //左子节点位置
            child = 2 * i + 1;
            //右子节点存在且大于左子节点，child变成右子节点
            if (child != n && array[child] < array[child + 1]) {
                child++;
            }
            //交换父节点与左右子节点中的最大值
            if (array[i] < array[child]) {
                int temp = array[i];
                array[i] = array[child];
                array[child] = temp;
            }
        }
    }

}
