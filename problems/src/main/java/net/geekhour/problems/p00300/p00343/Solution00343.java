package net.geekhour.problems.p00300.p00343;

import java.util.*;

/**
 * ID: 00343
 * Title: Integer Break
 * Difficulty: Medium
 * Description: Given an integer n, break it into the sum of k positive
 * integers, where k >= 2, and maximize the product of those integers.
 *
 * Return the maximum product you can get.
 *
 * Example 1:
 *
 * Input: n = 2 Output: 1 Explanation: 2 = 1 + 1, 1 × 1 = 1.
 *
 * Example 2:
 *
 * Input: n = 10 Output: 36 Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 *
 * Constraints:
 *
 * 2 <= n <= 58
 */
class Solution00343 {

  public int integerBreak(int n) {
    int[] dp = new int[n + 1];
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      int max = 0;
      for (int j = 1; j < i; j++) {
        max = Math.max(max, Math.max(j * (i - j), j * dp[i - j]));
      }
      dp[i] = max;
    }
    return dp[n];
  }

  public static void test_00343() {
    Solution00343 solution = new Solution00343();
    System.out.println(solution.integerBreak(2));
    System.out.println(solution.integerBreak(10));

  }

  public static void main(String[] args) {
    test_00343();
  }
}
