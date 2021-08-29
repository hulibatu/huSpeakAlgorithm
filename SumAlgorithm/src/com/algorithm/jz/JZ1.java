package com.algorithm.jz;

/**
 * JZ1 二维数组中的查找
 * <p>
 * https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&&tqId=11154&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class JZ1 {

    public static void main(String[] args) {
        int target = 7;
        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        JZ1 jz1 = new JZ1();
        System.out.println("暴力法 : " + jz1.find1(target, array));
        System.out.println("左下右上法 : " + jz1.find2(target, array));
    }

    /**
     * 暴力法 O（n^2）
     *
     * @param target
     * @param array
     * @return
     */
    public boolean find1(int target, int[][] array) {

        int rows = array.length;
        if (rows == 0) {
            return false;
        }

        int cols = array[0].length;
        if (cols == 0) {
            return false;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (array[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 左下右上法
     *
     * @param target
     * @param array
     * @return
     */
    public boolean find2(int target, int[][] array) {
        int rows = array.length;
        if (rows == 0) {
            return false;
        }
        int cols = array[0].length;
        if (cols == 0) {
            return false;
        }
        int row = rows - 1;
        int col = 0;
        while (row >= 0 && col < cols) {
            if (array[row][col] < target) {
                col++;
            } else if (array[row][col] > target) {
                row--;
            } else {
                return true;
            }
        }
        return false;
    }


}
