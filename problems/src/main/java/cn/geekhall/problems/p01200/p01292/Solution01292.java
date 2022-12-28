package cn.geekhall.problems.p01200.p01292;

/**
 * ID:    01292
 * Title: Maximum Side Length of a Square with Sum Less than or Equal to Threshold
 * Difficulty: Medium
 * Description: Given a m x n matrix mat and an integer threshold, return the maximum side-length of a square with a sum less than or equal to threshold or return 0 if there is no such square.
 *
 * Example 1:
 *
 * Input: mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4 Output: 2 Explanation: The maximum side length of square with sum less than 4 is 2 as shown.
 *
 * Example 2:
 *
 * Input: mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]], threshold = 1 Output: 0
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 300
 * 0 <= mat[i][j] <= 10 4
 * 0 <= threshold <= 10 5
 */
class Solution01292 {

  public int maxSideLength(int[][] mat, int threshold) {
    int m = mat.length, n = mat[0].length;
    int[][] sum = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
      }
    }
    int ans = 0;
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        int lo = ans, hi = Math.min(m - i + 1, n - j + 1);
        while (lo < hi) {
          int mid = (lo + hi + 1) / 2;
          if (sum[i + mid - 1][j + mid - 1] - sum[i - 1][j + mid - 1] - sum[i + mid - 1][j - 1] + sum[i - 1][j - 1] <= threshold) {
            lo = mid;
          } else {
            hi = mid - 1;
          }
        }
        ans = Math.max(ans, lo);
      }
    }
    return ans;
  }

  public static void test_01292() {
    Solution01292 solution = new Solution01292();
    int[][] mat = {{1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}};
    int threshold = 4;
    int result = solution.maxSideLength(mat, threshold);
    System.out.println(result);
    int[][] mat2 = {{2, 2, 2, 2, 2}, {2, 2, 2, 2, 2}, {2, 2, 2, 2, 2}, {2, 2, 2, 2, 2}, {2, 2, 2, 2, 2}};
    int threshold2 = 1;
    int result2 = solution.maxSideLength(mat2, threshold2);
    System.out.println(result2);
  }

  public static void main(String[] args) {
    Solution01292.test_01292();
  }
}

