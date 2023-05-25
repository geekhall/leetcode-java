package net.geekhour.problems.p00800.p00837;

import java.util.*;

/**
 * ID: 00837
 * Title: New 21 Game
 * Difficulty: Medium
 * Description: Alice plays the following game, loosely based on the card game
 * "21".
 *
 * Alice starts with 0 points and draws numbers while she has less than k
 * points. During each draw, she gains an integer number of points randomly from
 * the range [1, maxPts], where maxPts is an integer. Each draw is independent
 * and the outcomes have equal probabilities.
 *
 * Alice stops drawing numbers when she gets k or more points.
 *
 * Return the probability that Alice has n or fewer points.
 *
 * Answers within 10 -5 of the actual answer are considered accepted.
 *
 * Example 1:
 *
 * Input: n = 10, k = 1, maxPts = 10 Output: 1.00000 Explanation: Alice gets a
 * single card, then stops.
 *
 * Example 2:
 *
 * Input: n = 6, k = 1, maxPts = 10 Output: 0.60000 Explanation: Alice gets a
 * single card, then stops. In 6 out of 10 possibilities, she is at or below 6
 * points.
 *
 * Example 3:
 *
 * Input: n = 21, k = 17, maxPts = 10 Output: 0.73278
 *
 * Constraints:
 *
 * 0 <= k <= n <= 10 4
 * 1 <= maxPts <= 10 4
 */
class Solution00837 {

  public double new21Game(int n, int k, int maxPts) {
    if (k == 0) {
      return 1;
    }
    double[] dp = new double[k + maxPts];
    for (int i = k; i <= n && i < k + maxPts; i++) {
      dp[i] = 1;
    }
    dp[k - 1] = 1.0 * Math.min(n - k + 1, maxPts) / maxPts;
    for (int i = k - 2; i >= 0; i--) {
      dp[i] = dp[i + 1] - (dp[i + maxPts + 1] - dp[i + 1]) / maxPts;
    }
    return dp[0];
  }

  public static void test_00837() {
    Solution00837 solution = new Solution00837();
    System.out.println(solution.new21Game(10, 1, 10));
    System.out.println(solution.new21Game(6, 1, 10));
    System.out.println(solution.new21Game(21, 17, 10));
  }

  public static void main(String[] args) {
    Solution00837.test_00837();
  }
}
