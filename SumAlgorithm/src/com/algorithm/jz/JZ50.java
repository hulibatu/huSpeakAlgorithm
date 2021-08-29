package com.algorithm.jz;

import java.util.HashSet;
import java.util.Set;

/**
 * JZ50 数组中重复的数字
 * https://www.nowcoder.com/practice/6fe361ede7e54db1b84adc81d09d8524?tpId=13&&tqId=11203&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class JZ50 {

    public static void main(String[] args) {
        int[] numbers = {1,0,1,3};
        JZ50 jz = new JZ50();
//        System.out.println("暴力法 : " + jz.duplicate1(numbers));
        System.out.println("排序法 : " + jz.duplicate2(numbers));
    }

    /**
     * 暴力法
     *
     * @param numbers
     */
    public int duplicate1(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : numbers) {
            if (set.contains(num)) {
                return num;
            } else {
                set.add(num);
            }
        }
        return -1;
    }

    /**
     * 排序法
     *
     * @param numbers
     */
    public int duplicate2(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        for (int i = 0; i < numbers.length; i++) {
            int curr = numbers[i];
            if (curr != i) {
                if (curr == numbers[curr]) {
                    return curr;
                } else {
                    int temp = numbers[curr];
                    numbers[i] = temp;
                    numbers[curr] = curr;
                }
            }
        }
        return -1;
    }

}
