package net.geekhour.problems.p01100.p01137;

/**
 * ID: 01137
 * Title: N-th Tribonacci Number
 * Difficulty: Easy
 * Description: The Tribonacci sequence T n is defined as follows:
 *
 * T 0 = 0, T 1 = 1, T 2 = 1, and T n+3 = T n + T n+1 + T n+2 for n >= 0.
 *
 * Given n, return the value of T n.
 *
 * Example 1:
 *
 * Input: n = 4 Output: 4 Explanation: T_3 = 0 + 1 + 1 = 2 T_4 = 1 + 1 + 2 = 4
 *
 * Example 2:
 *
 * Input: n = 25 Output: 1389537
 *
 * Constraints:
 *
 * 0 <= n <= 37
 * The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 -
 * 1.
 */
class Solution01137 {

  public int tribonacci(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1 || n == 2) {
      return 1;
    }
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 1;
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
    }
    return dp[n];
  }

  public static void test_01137() {
    Solution01137 solution = new Solution01137();
    int n = 4;
    int result = solution.tribonacci(n);
    System.out.println(result);
    int n2 = 25;
    int result2 = solution.tribonacci(n2);
    System.out.println(result2);
  }

  public static void main(String[] args) {
    Solution01137.test_01137();
  }
}
