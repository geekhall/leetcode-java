package net.geekhour.problems.p00700.p00799;

import java.util.*;

/**
 * ID: 00799
 * Title: Champagne Tower
 * Difficulty: Medium
 * Description: We stack glasses in a pyramid, where the first row has 1 glass,
 * the second row has 2 glasses, and so on until the 100 th row. Each glass
 * holds one cup of champagne.
 *
 * Then, some champagne is poured into the first glass at the top. When the
 * topmost glass is full, any excess liquid poured will fall equally to the
 * glass immediately to the left and right of it. When those glasses become
 * full, any excess champagne will fall equally to the left and right of those
 * glasses, and so on. (A glass at the bottom row has its excess champagne fall
 * on the floor.)
 *
 * For example, after one cup of champagne is poured, the top most glass is
 * full. After two cups of champagne are poured, the two glasses on the second
 * row are half full. After three cups of champagne are poured, those two cups
 * become full - there are 3 full glasses total now. After four cups of
 * champagne are poured, the third row has the middle glass half full, and the
 * two outside glasses are a quarter full, as pictured below.
 *
 * Now after pouring some non-negative integer cups of champagne, return how
 * full the j th glass in the i th row is (both i and j are 0-indexed.)
 *
 * Example 1:
 *
 * Input: poured = 1, query_row = 1, query_glass = 1 Output: 0.00000
 * Explanation: We poured 1 cup of champange to the top glass of the tower
 * (which is indexed as (0, 0)). There will be no excess liquid so all the
 * glasses under the top glass will remain empty.
 *
 * Example 2:
 *
 * Input: poured = 2, query_row = 1, query_glass = 1 Output: 0.50000
 * Explanation: We poured 2 cups of champange to the top glass of the tower
 * (which is indexed as (0, 0)). There is one cup of excess liquid. The glass
 * indexed as (1, 0) and the glass indexed as (1, 1) will share the excess
 * liquid equally, and each will get half cup of champange.
 *
 * Example 3:
 *
 * Input: poured = 100000009, query_row = 33, query_glass = 17 Output: 1.00000
 *
 * Constraints:
 *
 * 0 <= poured <= 10 9
 * 0 <= query_glass <= query_row < 100
 */
class Solution00799 {

  public double champagneTower(int poured, int query_row, int query_glass) {
    double[][] dp = new double[query_row + 2][query_row + 2];
    dp[0][0] = poured;
    for (int i = 0; i <= query_row; i++) {
      for (int j = 0; j <= i; j++) {
        double q = (dp[i][j] - 1.0) / 2.0;
        if (q > 0) {
          dp[i + 1][j] += q;
          dp[i + 1][j + 1] += q;
        }
      }
    }
    return Math.min(1, dp[query_row][query_glass]);
  }

  public static void test_00799() {
    Solution00799 solution = new Solution00799();
    int poured = 1;
    int query_row = 1;
    int query_glass = 1;
    double expected = 0.0;
    double actual = solution.champagneTower(poured, query_row, query_glass);
    System.out.println("Test case 00799: expected: " + expected + ", actual: " + actual);
    poured = 2;
    query_row = 1;
    query_glass = 1;
    expected = 0.5;
    actual = solution.champagneTower(poured, query_row, query_glass);
    System.out.println("Test case 00799: expected: " + expected + ", actual: " + actual);
    poured = 100000009;
    query_row = 33;
    query_glass = 17;
    expected = 1.0;
    actual = solution.champagneTower(poured, query_row, query_glass);
    System.out.println("Test case 00799: expected: " + expected + ", actual: " + actual);

  }

  public static void main(String[] args) {
    test_00799();
  }
}
