package net.geekhour.problems.p00800.p00847;

import java.util.*;

/**
 * ID: 00847
 * Title: Shortest Path Visiting All Nodes
 * Difficulty: Hard
 * Description: You have an undirected, connected graph of n nodes labeled from
 * 0 to n - 1. You are given an array graph where graph[i] is a list of all the
 * nodes connected with node i by an edge.
 *
 * Return the length of the shortest path that visits every node. You may start
 * and stop at any node, you may revisit nodes multiple times, and you may reuse
 * edges.
 *
 * Example 1:
 *
 * Input: graph = [[1,2,3],[0],[0],[0]] Output: 4 Explanation: One possible path
 * is [1,0,2,0,3]
 *
 * Example 2:
 *
 * Input: graph = [[1],[0,2,4],[1,3,4],[2],[1,2]] Output: 4 Explanation: One
 * possible path is [0,1,4,2,3]
 *
 * Constraints:
 *
 * n == graph.length
 * 1 <= n <= 12
 * 0 <= graph[i].length < n
 * graph[i] does not contain i.
 * If graph[a] contains b, then graph[b] contains a.
 * The input graph is always connected.
 */
class Solution00847 {

  public int shortestPathLength(int[][] graph) {
    int n = graph.length;
    int[][] dp = new int[n][1 << n];
    for (int[] row : dp) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }
    for (int i = 0; i < n; i++) {
      dp[i][1 << i] = 0;
    }
    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      queue.offer(new int[] { i, 1 << i });
    }
    while (!queue.isEmpty()) {
      int[] pair = queue.poll();
      int u = pair[0];
      int mask = pair[1];
      int dist = dp[u][mask];
      if (mask == (1 << n) - 1) {
        return dist;
      }
      for (int v : graph[u]) {
        int nextMask = mask | (1 << v);
        if (dp[v][nextMask] > dist + 1) {
          dp[v][nextMask] = dist + 1;
          queue.offer(new int[] { v, nextMask });
        }
      }
    }
    return -1;
  }

  public static void test_00847() {
    Solution00847 solution = new Solution00847();
    int[][] graph = new int[][] { { 1, 2, 3 }, { 0 }, { 0 }, { 0 } };
    int expected = 4;
    int actual = solution.shortestPathLength(graph);
    System.out.println("expected: " + expected + ", actual: " + actual);

    int[][] graph2 = new int[][] { { 1 }, { 0, 2, 4 }, { 1, 3, 4 }, { 2 }, { 1, 2 } };
    expected = 4;
    actual = solution.shortestPathLength(graph2);
    System.out.println("expected: " + expected + ", actual: " + actual);

  }

  public static void main(String[] args) {
    test_00847();
  }
}
