package com.algorithm.heap;


import java.util.Arrays;

public class MainHeap {

    private static int[] array = {49, 38, 65, 97, 76, 13, 27, 49, 78};

    public static void main(String[] args) {
        System.out.println("数据 array : " + Arrays.toString(array));
        MaxHeap maxHeap = new MaxHeap(array.length);
        for (int num : array) {
            maxHeap.insert(num);
        }
        System.out.println("大顶堆 : " + Arrays.toString(maxHeap.heap));
        System.out.println("大顶堆 删除 : " + maxHeap.remove(97));
        System.out.println("大顶堆 删除 97 后 : " + Arrays.toString(maxHeap.heap));
        System.out.println("大顶堆 删除 : " + maxHeap.remove(78));
        System.out.println("大顶堆 删除 78 后 : " + Arrays.toString(maxHeap.heap));
        System.out.println("大顶堆 删除 : " + maxHeap.remove(76));
        System.out.println("大顶堆 删除 76 后 : " + Arrays.toString(maxHeap.heap));

    }

}
