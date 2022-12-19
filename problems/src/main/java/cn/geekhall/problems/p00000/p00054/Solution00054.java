package cn.geekhall.problems.p00000.p00054;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ID:    00054
 * Title: Spiral Matrix
 * Difficulty: Medium
 * Description: Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]] Output: [1,2,3,6,9,8,7,4,5]
 *
 * Example 2:
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]] Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
class Solution00054 {

  public List<Integer> spiralOrder(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int directionIndex = 0;
    int total = m * n;
    int row = 0, column = 0;
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < total; i++) {
      result.add(matrix[row][column]);
      matrix[row][column] = 101;
      int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
      if (nextRow < 0 || nextRow >= m || nextColumn < 0 || nextColumn >= n || matrix[nextRow][nextColumn] == 101) {
        directionIndex = (directionIndex + 1) % 4;
      }
      row += directions[directionIndex][0];
      column += directions[directionIndex][1];
    }
    return result;
  }

  public static void test_00054() {
    Solution00054 solution = new Solution00054();
    int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    List<Integer> result = solution.spiralOrder(matrix);
    System.out.println(result.toString());
  }

  public static void main(String[] args) {
    Solution00054.test_00054();
  }
}

