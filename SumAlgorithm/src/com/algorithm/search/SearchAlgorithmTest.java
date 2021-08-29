package com.algorithm.search;

/**
 * 7 大搜索 算法
 * https://www.processon.com/view/link/6103db77637689719d328270
 */
public class SearchAlgorithmTest {

    public static void main(String[] args) {
        int target = 5;
        int[] array1 = {9, 8, 7, 6, 1, 2, 3, 4, 5, 0};
        int[] array2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        SearchAlgorithm search = new SearchAlgorithm();
        System.out.println("顺序查找 : " + search.find1(target, array1));
        System.out.println("二分查找 : " + search.find2(target, array1));
        System.out.println("插值查找 : " + search.find3(target, array1));
        System.out.println("斐波那锲查找 : " + search.find4(target, array1));
        System.out.println("分块查找 : " + search.find5(target, array1));
        System.out.println("哈希查找 : " + search.find6(target, array1));
    }

    // 顺序查找
    public boolean find1(int target, int[] array) {
        return false;
    }

    // 二分查找
    public boolean find2(int target, int[] array) {
        return false;
    }

    // 插值查找
    public boolean find3(int target, int[] array) {
        return false;
    }

    // 斐波那锲查找
    public boolean find4(int target, int[] array) {
        return false;
    }

    // 分块查找
    public boolean find5(int target, int[] array) {
        return false;
    }

    // 哈希查找
    public boolean find6(int target, int[] array) {
        return false;
    }

}
