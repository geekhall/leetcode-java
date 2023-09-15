package net.geekhour.problems.p01500.p01584;

import java.util.*;

/**
 * ID: 01584
 * Title: Min Cost to Connect All Points
 * Difficulty: Medium
 * Description: You are given an array points representing integer coordinates
 * of some points on a 2D-plane, where points[i] = [x i, y i ].
 *
 * The cost of connecting two points [x i, y i ] and [x j, y j ] is the
 * manhattan distance between them: |x i - x j | + |y i - y j |, where |val|
 * denotes the absolute value of val.
 *
 * Return the minimum cost to make all points connected. All points are
 * connected if there is exactly one simple path between any two points.
 *
 * Example 1:
 *
 * Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]] Output: 20 Explanation: We
 * can connect the points as shown above to get the minimum cost of 20. Notice
 * that there is a unique path between every pair of points.
 *
 * Example 2:
 *
 * Input: points = [[3,12],[-2,5],[-4,1]] Output: 18
 *
 * Constraints:
 *
 * 1 <= points.length <= 1000
 * -10 6 <= x i, y i <= 10 6
 * All pairs (x i, y i) are distinct.
 */
class Solution01584 {

  public int minCostConnectPoints(int[][] points) {
    int n = points.length;
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[0] = 0;
    boolean[] visited = new boolean[n];
    int result = 0;
    for (int i = 0; i < n; i++) {
      int u = -1;
      for (int j = 0; j < n; j++) {
        if (!visited[j] && (u == -1 || dist[j] < dist[u])) {
          u = j;
        }
      }
      visited[u] = true;
      result += dist[u];
      for (int v = 0; v < n; v++) {
        if (!visited[v]) {
          dist[v] = Math.min(dist[v], Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]));
        }
      }
    }
    return result;
  }

  public static void test_01584() {
    Solution01584 solution = new Solution01584();
    int[][] points = { { 0, 0 }, { 2, 2 }, { 3, 10 }, { 5, 2 }, { 7, 0 } };
    int result = solution.minCostConnectPoints(points);
    System.out.println(result);
    int[][] points1 = { { 3, 12 }, { -2, 5 }, { -4, 1 } };
    int result1 = solution.minCostConnectPoints(points1);
    System.out.println(result1);
  }

  public static void main(String[] args) {
    test_01584();
  }
}
