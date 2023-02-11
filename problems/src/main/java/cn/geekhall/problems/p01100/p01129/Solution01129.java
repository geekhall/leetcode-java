package cn.geekhall.problems.p01100.p01129;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * ID: 01129
 * Title: Shortest Path with Alternating Colors
 * Difficulty: Medium
 * Description: You are given an integer n, the number of nodes in a directed
 * graph where the nodes are labeled from 0 to n - 1. Each edge is red or blue
 * in this graph, and there could be self-edges and parallel edges.
 *
 * You are given two arrays redEdges and blueEdges where:
 *
 * redEdges[i] = [a i, b i ] indicates that there is a directed red edge from
 * node a i to node b i in the graph, and
 * blueEdges[j] = [u j, v j ] indicates that there is a directed blue edge from
 * node u j to node v j in the graph.
 *
 * Return an array answer of length n, where each answer[x] is the length of the
 * shortest path from node 0 to node x such that the edge colors alternate along
 * the path, or -1 if such a path does not exist.
 *
 * Example 1:
 *
 * Input: n = 3, redEdges = [[0,1],[1,2]], blueEdges = [] Output: [0,1,-1]
 *
 * Example 2:
 *
 * Input: n = 3, redEdges = [[0,1]], blueEdges = [[2,1]] Output: [0,1,-1]
 *
 * Constraints:
 *
 * 1 <= n <= 100
 * 0 <= redEdges.length, blueEdges.length <= 400
 * redEdges[i].length == blueEdges[j].length == 2
 * 0 <= a i, b i, u j, v j < n
 */
class Solution01129 {

  public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
    int[] result = new int[n];
    Arrays.fill(result, -1);
    result[0] = 0;
    Map<Integer, List<Integer>> redMap = new HashMap<>();
    Map<Integer, List<Integer>> blueMap = new HashMap<>();
    for (int[] redEdge : redEdges) {
      int from = redEdge[0];
      int to = redEdge[1];
      List<Integer> list = redMap.getOrDefault(from, new ArrayList<>());
      list.add(to);
      redMap.put(from, list);
    }
    for (int[] blueEdge : blueEdges) {
      int from = blueEdge[0];
      int to = blueEdge[1];
      List<Integer> list = blueMap.getOrDefault(from, new ArrayList<>());
      list.add(to);
      blueMap.put(from, list);
    }
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[] { 0, 0 });
    queue.offer(new int[] { 0, 1 });
    Set<String> visited = new HashSet<>();
    visited.add("0,0");
    visited.add("0,1");
    int step = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      step++;
      for (int i = 0; i < size; i++) {
        int[] node = queue.poll();
        int cur = node[0];
        int color = node[1];
        if (color == 0) {
          List<Integer> list = redMap.getOrDefault(cur, new ArrayList<>());
          for (int next : list) {
            if (result[next] == -1) {
              result[next] = step;
            }
            if (!visited.contains(next + ",1")) {
              queue.offer(new int[] { next, 1 });
              visited.add(next + ",1");
            }
          }
        } else {
          List<Integer> list = blueMap.getOrDefault(cur, new ArrayList<>());
          for (int next : list) {
            if (result[next] == -1) {
              result[next] = step;
            }
            if (!visited.contains(next + ",0")) {
              queue.offer(new int[] { next, 0 });
              visited.add(next + ",0");
            }
          }
        }
      }
    }
    return result;
  }

  public static void test_01129() {
    Solution01129 solution = new Solution01129();
    int n = 3;
    int[][] redEdges = { { 0, 1 }, { 1, 2 } };
    int[][] blueEdges = {};
    int[] result = solution.shortestAlternatingPaths(n, redEdges, blueEdges);
    System.out.println(Arrays.toString(result));
    int n2 = 3;
    int[][] redEdges2 = { { 0, 1 } };
    int[][] blueEdges2 = { { 2, 1 } };
    int[] result2 = solution.shortestAlternatingPaths(n2, redEdges2, blueEdges2);
    System.out.println(Arrays.toString(result2));
  }

  public static void main(String[] args) {
    Solution01129.test_01129();
  }
}
