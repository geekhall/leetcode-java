package cn.geekhall.problems.p01800.p01886;

import java.util.Arrays;

/**
 * ID:    01886
 * Title: Determine Whether Matrix Can Be Obtained By Rotation
 * Difficulty: Easy
 * Description: Given two n x n binary matrices mat and target, return true if it is possible to make mat equal to target by rotating mat in 90-degree increments, or false otherwise.
 *
 * Example 1:
 *
 * Input: mat = [[0,1],[1,0]], target = [[1,0],[0,1]] Output: true Explanation: We can rotate mat 90 degrees clockwise to make mat equal target.
 *
 * Example 2:
 *
 * Input: mat = [[0,1],[1,1]], target = [[1,0],[0,1]] Output: false Explanation: It is impossible to make mat equal to target by rotating mat.
 *
 * Example 3:
 *
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]] Output: true Explanation: We can rotate mat 90 degrees clockwise two times to make mat equal target.
 *
 * Constraints:
 *
 * n == mat.length == target.length
 * n == mat[i].length == target[i].length
 * 1 <= n <= 10
 * mat[i][j] and target[i][j] are either 0 or 1.
 */
class Solution01886 {

  public boolean findRotation(int[][] mat, int[][] target) {
    int n = mat.length;
    int[][] temp = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        temp[i][j] = mat[i][j];
      }
    }
    for (int i = 0; i < 4; i++) {
      rotate(temp);
      if (Arrays.deepEquals(temp, target)) {
        return true;
      }
    }
    return false;
  }

  /**
   * rotate a matrix 90 degrees clockwise.
   */
  private void rotate(int[][] temp) {
    int n = temp.length;
    for (int i = 0; i < n / 2; i++) {
      for (int j = i; j < n - i - 1; j++) {
        int temp1 = temp[i][j];
        temp[i][j] = temp[n - j - 1][i];
        temp[n - j - 1][i] = temp[n - i - 1][n - j - 1];
        temp[n - i - 1][n - j - 1] = temp[j][n - i - 1];
        temp[j][n - i - 1] = temp1;
      }
    }
  }

  public static void test_01886() {
    Solution01886 solution = new Solution01886();
    int[][] mat = {{0,1},{1,0}};
    int[][] target = {{1,0},{0,1}};
    boolean result = solution.findRotation(mat, target);
    System.out.println(result);
    int [][] mat2 = {{0,1},{1,1}};
    int [][] target2 = {{1,0},{0,1}};
    boolean result2 = solution.findRotation(mat2, target2);
    System.out.println(result2);
  }

  public static void main(String[] args) {
    Solution01886.test_01886();
  }
}

