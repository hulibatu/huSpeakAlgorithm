package com.algorithm.sort;

/**
 * 基数排序 时间复杂度 O(d*(n+r)) 空间复杂度 O(n+r) ：d 为位数，r 为基数，n 为原数组个数
 * <p>
 * 示意图 https://images.morethink.cn/radix-sort_sample.gif
 * <p>
 * 两种实现方式
 * 1.MSD（Most significant digital） 从最左侧高位开始进行排序
 * 2.LSD（Least significant digital）从最右侧低位开始进行排序
 * <p>
 * LSD 为例
 * 1.取得数组中的最大数，并取得位数；
 * 2.arr为原始数组，从最低位开始取每个位组成radix数组；
 * 3.对radix进行计数排序（利用计数排序适用于小范围数的特点）；
 * <p>
 * 核心步骤：分配 收集
 */
public class RadixSort {

    public int[] sort(int[] array) {
        sort1(array);
        return array;
    }

    public void sort1(int[] array) {
        if (array.length <= 1) {
            return;
        }

        //取得数组中的最大数，并取得位数
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }

        // 最大位数
        int maxDigit = 1;
        while (max / 10 > 0) {
            maxDigit++;
            max = max / 10;
        }

        //申请一个桶空间
        int[][] buckets = new int[10][array.length];
        int base = 10;

        //从低位到高位，对每一位遍历，将所有元素分配到桶中
        for (int i = 0; i < maxDigit; i++) {

            //存储各个桶中存储元素的数量
            int[] bktLen = new int[10];

            //分配：将所有元素分配到桶中
            for (int j = 0; j < array.length; j++) {
                int whichBucket = (array[j] % base) / (base / 10);
                buckets[whichBucket][bktLen[whichBucket]] = array[j];
                bktLen[whichBucket]++;
            }

            //收集：将不同桶里数据挨个捞出来,为下一轮高位排序做准备,由于靠近桶底的元素排名靠前,因此从桶底先捞
            int k = 0;
            for (int b = 0; b < buckets.length; b++) {
                for (int p = 0; p < bktLen[b]; p++) {
                    array[k++] = buckets[b][p];
                }
            }
            base *= 10;
        }
    }

}
