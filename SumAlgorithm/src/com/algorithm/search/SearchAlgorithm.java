package com.algorithm.search;

import java.util.Arrays;

/**
 * 7 大搜索 算法
 * https://www.processon.com/view/link/6103db77637689719d328270
 */
public class SearchAlgorithm {

    public static void main(String[] args) {
        int target = 3;
        int[] array1 = {9, 8, 7, 6, 1, 2, 3, 4, 5, 0};
        int[] array2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        SearchAlgorithm search = new SearchAlgorithm();
//        System.out.println("顺序查找 : " + search.find1(target, array1));
        System.out.println("二分查找 : " + search.find2(target, array2));
        System.out.println("插值查找 : " + search.find3(target, array2));
        System.out.println("斐波那锲查找 : " + search.find4(target, array2));
//        System.out.println("分块查找 : " + search.find5(target, array1));
//        System.out.println("哈希查找 : " + search.find6(target, array1));
    }

    // 顺序查找
    public boolean find1(int target, int[] array) {
        for (int num : array) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    // 二分查找
    public boolean find2(int target, int[] array) {
        return binarySearch(target, 0, array.length - 1, array);
    }

    private boolean binarySearch(int target, int low, int hight, int[] array) {
        System.out.println("binarySearch : " + low + "," + hight);
        if (low >= hight) {
            return false;
        }
        int middle = low + (hight - low) / 2;
        if (array[middle] == target) {
            return true;
        } else if (array[middle] > target) {
            hight = middle - 1;
            return binarySearch(target, low, hight, array);
        } else if (array[middle] < target) {
            low = middle + 1;
            return binarySearch(target, low, hight, array);
        }
        return false;
    }

    // 插值查找
    public boolean find3(int target, int[] array) {
        return insertSearch(target, 0, array.length - 1, array);
    }

    private boolean insertSearch(int target, int low, int hight, int[] array) {
        System.out.println("insertSearch : " + low + "," + hight);
        if (low > hight || target < array[low] || target > array[hight]) {
            return false;
        }
        int middle = low + (hight - low) * (target - array[low]) / (array[hight] - array[low]);
        if (array[middle] > target) {
            hight = middle - 1;
            return insertSearch(target, low, hight, array);
        } else if (array[middle] < target) {
            low = middle + 1;
            return insertSearch(target, low, hight, array);
        } else {
            return true;
        }
    }

    // 斐波那锲查找
    public boolean find4(int target, int[] array) {
        return fbSearch(target, array);
    }

    private int[] createFbArray(int size) {
        int[] array = new int[size];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i < size; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array;
    }

    private boolean fbSearch(int target, int[] array) {

        int low = 0;
        int hight = array.length - 1;
        int middle = 0;

        // 生成斐波那契数列
        int[] fbArray = createFbArray(array.length);

        int fbIndex = 1;
        while (hight > fbArray[fbIndex] - 1) {
            fbIndex++;
        }

        int[] temp = Arrays.copyOf(array, fbArray[fbIndex]);

        for (int i = hight; i < temp.length; i++) {
            temp[i] = temp[hight];
        }

        while (low <= hight) {
            System.out.println("fbSearch : " + low + "," + hight);
            middle = low + fbArray[fbIndex - 1] - 1;
            if (target < array[middle]) {
                hight = middle - 1;
                fbIndex -= 1;
            } else if (target > array[middle]) {
                low = middle + 1;
                fbIndex -= 2;
            } else {
                return true;
            }
        }
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
