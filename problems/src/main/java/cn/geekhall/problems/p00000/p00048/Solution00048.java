package cn.geekhall.problems.p00000.p00048;

import java.util.Arrays;

/**
 * ID:    00048
 * Title: Rotate Image
 * Difficulty: Medium
 * Description: You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]] Output: [[7,4,1],[8,5,2],[9,6,3]]
 *
 * Example 2:
 *
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]] Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 * Constraints:
 *
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 */
class Solution00048 {

  public void rotate(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n / 2; i++) {
      for (int j = 0; j < (n + 1) / 2; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[n - j - 1][i];
        matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
        matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
        matrix[j][n - i - 1] = temp;
      }
    }
  }

  public static void test_00048() {
    Solution00048 solution = new Solution00048();
    int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    solution.rotate(matrix);
    System.out.println(Arrays.deepToString(matrix));
  }

  public static void main(String[] args) {
    Solution00048.test_00048();
  }
}

