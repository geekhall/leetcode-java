package net.geekhour.problems.p00700.p00787;

import java.util.Arrays;

/**
 * ID: 00787
 * Title: Cheapest Flights Within K Stops
 * Difficulty: Medium
 * Description: There are n cities connected by some number of flights. You are
 * given an array flights where flights[i] = [from i, to i, price i ] indicates
 * that there is a flight from city from i to city to i with cost price i.
 *
 * You are also given three integers src, dst, and k, return the cheapest price
 * from src to dst with at most k stops. If there is no such route, return -1.
 *
 * Example 1:
 *
 * Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]],
 * src = 0, dst = 3, k = 1 Output: 700 Explanation: The graph is shown above.
 * The optimal path with at most 1 stop from city 0 to 3 is marked in red and
 * has cost 100 + 600 = 700. Note that the path through cities [0,1,2,3] is
 * cheaper but is invalid because it uses 2 stops.
 *
 * Example 2:
 *
 * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k
 * = 1 Output: 200 Explanation: The graph is shown above. The optimal path with
 * at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 =
 * 200.
 *
 * Example 3:
 *
 * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k
 * = 0 Output: 500 Explanation: The graph is shown above. The optimal path with
 * no stops from city 0 to 2 is marked in red and has cost 500.
 *
 * Constraints:
 *
 * 1 <= n <= 100
 * 0 <= flights.length <= (n * (n - 1) / 2)
 * flights[i].length == 3
 * 0 <= from i, to i < n
 * from i!= to i
 * 1 <= price i <= 10 4
 * There will not be any multiple flights between two cities.
 * 0 <= src, dst, k < n
 * src != dst
 */
class Solution00787 {

  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    int[][] dp = new int[k + 2][n];
    int INF = 10000 * 101 + 1;
    for (int i = 0; i < k + 2; ++i) {
      Arrays.fill(dp[i], INF);
    }
    dp[0][src] = 0;
    for (int t = 1; t <= k + 1; ++t) {
      for (int[] flight : flights) {
        int j = flight[0], i = flight[1], cost = flight[2];
        dp[t][i] = Math.min(dp[t][i], dp[t - 1][j] + cost);
      }
    }
    int ans = INF;
    for (int t = 1; t <= k + 1; ++t) {
      ans = Math.min(ans, dp[t][dst]);
    }
    return ans == INF ? -1 : ans;
  }

  public static void test_00787() {
    Solution00787 solution = new Solution00787();
    int n = 4;
    int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
    int src = 0;
    int dst = 3;
    int k = 1;
    int result = solution.findCheapestPrice(n, flights, src, dst, k);
    System.out.println(result);
    int n2 = 3;
    int[][] flights2 = { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };
    int src2 = 0;
    int dst2 = 2;
    int k2 = 1;
    int result2 = solution.findCheapestPrice(n2, flights2, src2, dst2, k2);
    System.out.println(result2);
    int n3 = 3;
    int[][] flights3 = { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };
    int src3 = 0;
    int dst3 = 2;
    int k3 = 0;
    int result3 = solution.findCheapestPrice(n3, flights3, src3, dst3, k3);
    System.out.println(result3);
  }

  public static void main(String[] args) {
    Solution00787.test_00787();
  }
}
