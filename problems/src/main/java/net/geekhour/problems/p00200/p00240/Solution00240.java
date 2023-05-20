package net.geekhour.problems.p00200.p00240;

/**
 * ID: 00240
 * Title: Search a 2D Matrix II
 * Difficulty: Medium
 * Description: Write an efficient algorithm that searches for a value target in
 * an m x n integer matrix matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 *
 * Example 1:
 *
 * Input: matrix =
 * [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]],
 * target = 5 Output: true
 *
 * Example 2:
 *
 * Input: matrix =
 * [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]],
 * target = 20 Output: false
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -10 9 <= matrix[i][j] <= 10 9
 * All the integers in each row are sorted in ascending order.
 * All the integers in each column are sorted in ascending order.
 * -10 9 <= target <= 10 9
 */
class Solution00240 {

  public boolean searchMatrix(int[][] matrix, int target) {
    int row = matrix.length;
    int col = matrix[0].length;
    int i = 0;
    int j = col - 1;
    while (i < row && j >= 0) {
      if (matrix[i][j] == target) {
        return true;
      } else if (matrix[i][j] > target) {
        j--;
      } else {
        i++;
      }
    }
    return false;
  }

  public static void test_00240() {
    Solution00240 solution = new Solution00240();
    int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
        { 18, 21, 23, 26, 30 } };
    int target = 5;
    boolean result = solution.searchMatrix(matrix, target);
    System.out.println(result); // true
    int[][] matrix2 = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
        { 18, 21, 23, 26, 30 } };
    int target2 = 20;
    boolean result2 = solution.searchMatrix(matrix2, target2);
    System.out.println(result2); // false
  }

  public static void main(String[] args) {
    Solution00240.test_00240();
  }
}
