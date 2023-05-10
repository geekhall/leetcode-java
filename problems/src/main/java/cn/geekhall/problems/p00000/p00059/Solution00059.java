package cn.geekhall.problems.p00000.p00059;

import java.util.*;

/**
 * ID: 00059
 * Title: Spiral Matrix II
 * Difficulty: Medium
 * Description: Given a positive integer n, generate an n x n matrix filled with
 * elements from 1 to n 2 in spiral order.
 *
 * Example 1:
 *
 * Input: n = 3 Output: [[1,2,3],[8,9,4],[7,6,5]]
 *
 * Example 2:
 *
 * Input: n = 1 Output: [[1]]
 *
 * Constraints:
 *
 * 1 <= n <= 20
 */
class Solution00059 {

  public int[][] generateMatrix(int n) {
    int[][] matrix = new int[n][n];
    int num = 1;
    int left = 0, right = n - 1, top = 0, bottom = n - 1;
    while (left <= right && top <= bottom) {
      for (int column = left; column <= right; column++) {
        matrix[top][column] = num++;
      }
      for (int row = top + 1; row <= bottom; row++) {
        matrix[row][right] = num++;
      }
      if (left < right && top < bottom) {
        for (int column = right - 1; column > left; column--) {
          matrix[bottom][column] = num++;
        }
        for (int row = bottom; row > top; row--) {
          matrix[row][left] = num++;
        }
      }
      left++;
      right--;
      top++;
      bottom--;
    }
    return matrix;
  }

  public static void test_00059() {
    Solution00059 solution = new Solution00059();
    int[][] generateMatrix = solution.generateMatrix(3);
    for (int[] ints : generateMatrix) {
      for (int anInt : ints) {
        System.out.printf("%d\t", anInt);
      }
      System.out.println();
    }
    int[][] generateMatrix2 = solution.generateMatrix(1);
    for (int[] ints : generateMatrix2) {
      for (int anInt : ints) {
        System.out.printf("%d\t", anInt);
      }
      System.out.println();
    }

  }

  public static void main(String[] args) {
    Solution00059.test_00059();
  }
}
