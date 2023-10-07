package net.geekhour.problems.p01400.p01420;

import java.util.*;

/**
 * ID: 01420
 * Title: Build Array Where You Can Find The Maximum Exactly K Comparisons
 * Difficulty: Hard
 * Description: You are given three integers n, m and k. Consider the following
 * algorithm to find the maximum element of an array of positive integers:
 *
 * You should build the array arr which has the following properties:
 *
 * arr has exactly n integers.
 * 1 <= arr[i] <= m where (0 <= i < n).
 * After applying the mentioned algorithm to arr, the value search_cost is equal
 * to k.
 *
 * Return the number of ways to build the array arr under the mentioned
 * conditions. As the answer may grow large, the answer must be computed modulo
 * 10 9 + 7.
 *
 * Example 1:
 *
 * Input: n = 2, m = 3, k = 1 Output: 6 Explanation: The possible arrays are [1,
 * 1], [2, 1], [2, 2], [3, 1], [3, 2] [3, 3]
 *
 * Example 2:
 *
 * Input: n = 5, m = 2, k = 3 Output: 0 Explanation: There are no possible
 * arrays that satisify the mentioned conditions.
 *
 * Example 3:
 *
 * Input: n = 9, m = 1, k = 1 Output: 1 Explanation: The only possible array is
 * [1, 1, 1, 1, 1, 1, 1, 1, 1]
 *
 * Constraints:
 *
 * 1 <= n <= 50
 * 1 <= m <= 100
 * 0 <= k <= n
 */
class Solution01420 {

  public int numOfArrays(int n, int m, int k) {
    final int mod = 1000000007;

    int[][] dp = new int[m + 1][k + 1];
    int[][] prefix = new int[m + 1][k + 1];
    int[][] prevDp = new int[m + 1][k + 1];
    int[][] prevPrefix = new int[m + 1][k + 1];

    for (int j = 1; j <= m; j++) {
      prevDp[j][1] = 1;
      prevPrefix[j][1] = j;
    }

    for (int i = 2; i <= n; i++) {
      for (int maxNum = 1; maxNum <= m; maxNum++) {
        for (int cost = 1; cost <= k; cost++) {
          dp[maxNum][cost] = (int) (((long) maxNum * prevDp[maxNum][cost]) % mod);

          if (maxNum > 1 && cost > 1) {
            dp[maxNum][cost] = (dp[maxNum][cost] + prevPrefix[maxNum - 1][cost - 1]) % mod;
          }

          prefix[maxNum][cost] = (prefix[maxNum - 1][cost] + dp[maxNum][cost]) % mod;
        }
      }

      for (int j = 1; j <= m; j++) {
        System.arraycopy(dp[j], 0, prevDp[j], 0, k + 1);
        System.arraycopy(prefix[j], 0, prevPrefix[j], 0, k + 1);
      }
    }

    return prefix[m][k];
  }

  public static void test_01420() {
    Solution01420 solution = new Solution01420();
    System.out.println(solution.numOfArrays(2, 3, 1));
    System.out.println(solution.numOfArrays(5, 2, 3));
    System.out.println(solution.numOfArrays(9, 1, 1));

  }

  public static void main(String[] args) {
    test_01420();
  }
}
