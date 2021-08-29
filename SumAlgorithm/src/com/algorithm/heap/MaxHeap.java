package com.algorithm.heap;

public class MaxHeap {

    // 堆的物理结构，使用数组来实现
    public int[] heap;
    // 容量
    private int capacity = 16;
    // 节点数量
    private int count;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.heap = new int[capacity + 1];
    }

    /**
     * 大顶堆的向上调整算法(添加结点点的时候调用)
     * 第N个节点的 父结点 index = (n -1) / 2
     *
     * @param startIndex 调整结点起始位置
     */
    private void onAdjustUp(int startIndex) {

        int value = heap[startIndex];

        int currIndex = startIndex;
        // 当前结点的父节点
        int parentIndex = (currIndex - 1) / 2;

        while (currIndex > 0) {
            int parentValue = heap[parentIndex];
            if (parentValue > value) {
                break;
            } else {
                heap[currIndex] = parentValue;
                heap[parentIndex] = value;
                currIndex = parentIndex;
                parentIndex = (currIndex - 1) / 2;
            }
        }

        if (currIndex != startIndex) {
            heap[currIndex] = value;
        }


    }

    /**
     * 大顶堆向下调整算法(删除结点的时候调用)
     * 第N个节点的 左孩子 index = 2n+1 ，右孩子 index = 2n+2
     * 第N个节点的 父结点 index = (n -1) / 2
     *
     * @param startIndex 调整结点起始位置
     * @param endIndex   调整结点结束位置
     */
    private void onAdjustDown(int startIndex, int endIndex) {

        int value = heap[startIndex];
        int currIndex = startIndex;
        int leftIndex = currIndex * 2 + 1;

        while (leftIndex <= endIndex) {
            int tempIndex = leftIndex;
            int rightIndex = leftIndex + 1;
            if (rightIndex <= endIndex && heap[leftIndex] < heap[rightIndex]) {
                tempIndex = rightIndex;
            }
            int tempValue = heap[tempIndex];
            if (value > tempValue) {
                break;
            } else {
                heap[currIndex] = tempValue;
                heap[tempIndex] = value;
                currIndex = tempIndex;
                leftIndex = currIndex * 2 + 1;
            }
        }

        if (currIndex != startIndex) {
            heap[currIndex] = value;
        }

    }

    public void insert(int data) {
        if (count >= capacity) {
            return;
        }
        heap[count] = data;
        onAdjustUp(count);
        count += 1;
    }

    public boolean remove(int data) {
        if (count <= 0) {
            return false;
        }
        int index = getIndex(data);
        if (index < 0) {
            return false;
        }
        heap[index] = heap[count - 1];
        heap[count - 1] = 0;
        if ((count - 1) > 1 && index < count) {
            onAdjustDown(index, count);
        }
        count -= 1;
        return true;
    }

    private int getIndex(int data) {
        for (int i = 0; i < heap.length - 1; i++) {
            if (heap[i] == data) {
                return i;
            }
        }
        return -1;
    }


}
