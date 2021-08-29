package com.algorithm.heap;

public class MinHeap {

    // 堆的物理结构，使用数组来实现
    public int[] heap;
    // 容量
    private int capacity = 16;
    // 节点数量
    private int count;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.heap = new int[capacity + 1];
    }


}
