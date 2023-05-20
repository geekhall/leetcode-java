package net.geekhour.problems.p01800.p01857;

import java.util.*;

/**
 * ID: 01857
 * Title: Largest Color Value in a Directed Graph
 * Difficulty: Hard
 * Description: There is a directed graph of n colored nodes and m edges. The
 * nodes are numbered from 0 to n - 1.
 *
 * You are given a string colors where colors[i] is a lowercase English letter
 * representing the color of the i th node in this graph (0-indexed). You are
 * also given a 2D array edges where edges[j] = [a j, b j ] indicates that there
 * is a directed edge from node a j to node b j.
 *
 * A valid path in the graph is a sequence of nodes x 1 -> x 2 -> x 3 -> ... ->
 * x k such that there is a directed edge from x i to x i+1 for every 1 <= i <
 * k. The color value of the path is the number of nodes that are colored the
 * most frequently occurring color along that path.
 *
 * Return the largest color value of any valid path in the given graph, or -1 if
 * the graph contains a cycle.
 *
 * Example 1:
 *
 * Input: colors = "abaca", edges = [[0,1],[0,2],[2,3],[3,4]] Output: 3
 * Explanation: The path 0 -> 2 -> 3 -> 4 contains 3 nodes that are colored "a"
 * (red in the above image).
 *
 * Example 2:
 *
 * Input: colors = "a", edges = [[0,0]] Output: -1 Explanation: There is a cycle
 * from 0 to 0.
 *
 * Constraints:
 *
 * n == colors.length
 * m == edges.length
 * 1 <= n <= 10 5
 * 0 <= m <= 10 5
 * colors consists of lowercase English letters.
 * 0 <= a j, b j < n
 */
class Solution01857 {

  public int largestPathValue(String colors, int[][] edges) {
    int n = colors.length(); // 节点数
    int m = edges.length; // 边数
    // 邻接表
    List<Integer>[] adj = new List[n];
    for (int i = 0; i < n; i++) {
      adj[i] = new ArrayList<>();
    }
    // 入度
    int[] inDegree = new int[n];
    for (int[] edge : edges) {
      adj[edge[0]].add(edge[1]);
      inDegree[edge[1]]++;
    }
    // 拓扑排序
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (inDegree[i] == 0) {
        queue.offer(i); // 入度为0的节点入队
      }
    }
    int[] f = new int[n]; // f[i]表示以i为终点的路径的最大颜色值
    int[][] colorDP = new int[n][26]; // color[i][j]表示以i为终点的路径中颜色为j的节点的个数
    int res = 0;
    while (!queue.isEmpty()) {
      int u = queue.poll();
      int color = colors.charAt(u) - 'a';
      colorDP[u][color]++;
      f[u] = Math.max(f[u], colorDP[u][color]);
      res = Math.max(res, f[u]);
      for (int v : adj[u]) {
        for (int i = 0; i < 26; i++) {
          colorDP[v][i] = Math.max(colorDP[v][i], colorDP[u][i]);
        }
        if (--inDegree[v] == 0) {
          queue.offer(v);
        }
      }
    }
    for (int i = 0; i < n; i++) {
      if (inDegree[i] != 0) {
        return -1; // 存在环
      }
    }
    return res;
  }

  public static void test_01857() {
    Solution01857 solution = new Solution01857();
    String colors = "abaca";
    int[][] edges = { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 3, 4 } };
    int result = solution.largestPathValue(colors, edges);
    System.out.println(result);
    String colors2 = "a";
    int[][] edges2 = { { 0, 0 } };
    result = solution.largestPathValue(colors2, edges2);
    System.out.println(result);
    String colors3 = "iiiiii";
    int[][] edges3 = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 } };
    result = solution.largestPathValue(colors3, edges3);
    System.out.println(result); // Expected: 6
  }

  public static void main(String[] args) {
    Solution01857.test_01857();
  }
}
