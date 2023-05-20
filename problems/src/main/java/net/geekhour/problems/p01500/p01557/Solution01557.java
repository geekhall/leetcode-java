package net.geekhour.problems.p01500.p01557;

import java.util.*;

/**
 * ID: 01557
 * Title: Minimum Number of Vertices to Reach All Nodes
 * Difficulty: Medium
 * Description: Given a directed acyclic graph, with n vertices numbered from 0
 * to n-1, and an array edges where edges[i] = [from i, to i ] represents a
 * directed edge from node from i to node to i.
 *
 * Find the smallest set of vertices from which all nodes in the graph are
 * reachable. It's guaranteed that a unique solution exists.
 *
 * Notice that you can return the vertices in any order.
 *
 * Example 1:
 *
 * Input: n = 6, edges = [[0,1],[0,2],[2,5],[3,4],[4,2]] Output: [0,3]
 * Explanation: It's not possible to reach all the nodes from a single vertex.
 * From 0 we can reach [0,1,2,5]. From 3 we can reach [3,4,2,5]. So we output
 * [0,3].
 *
 * Example 2:
 *
 * Input: n = 5, edges = [[0,1],[2,1],[3,1],[1,4],[2,4]] Output: [0,2,3]
 * Explanation: Notice that vertices 0, 3 and 2 are not reachable from any other
 * node, so we must include them. Also any of these vertices can reach nodes 1
 * and 4.
 *
 * Constraints:
 *
 * 2 <= n <= 10^5
 * 1 <= edges.length <= min(10^5, n * (n - 1) / 2)
 * edges[i].length == 2
 * 0 <= from i, to i < n
 * All pairs (from i, to i) are distinct.
 */
class Solution01557 {

  public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
    List<Integer> result = new ArrayList<>();
    int[] inDegree = new int[n];
    // 计算入度
    for (List<Integer> edge : edges) {
      inDegree[edge.get(1)]++;
    }
    // 找到所有入度为0的节点
    for (int i = 0; i < n; i++) {
      if (inDegree[i] == 0) {
        result.add(i);
      }
    }
    return result;
  }

  public static void test_01557() {
    Solution01557 solution = new Solution01557();
    int n = 6;
    List<List<Integer>> edges = new ArrayList<>();
    edges.add(Arrays.asList(0, 1));
    edges.add(Arrays.asList(0, 2));
    edges.add(Arrays.asList(2, 5));
    edges.add(Arrays.asList(3, 4));
    edges.add(Arrays.asList(4, 2));
    List<Integer> result = solution.findSmallestSetOfVertices(n, edges);
    System.out.println(result);

    int n2 = 5;
    List<List<Integer>> edges2 = new ArrayList<>();
    edges2.add(Arrays.asList(0, 1));
    edges2.add(Arrays.asList(2, 1));
    edges2.add(Arrays.asList(3, 1));
    edges2.add(Arrays.asList(1, 4));
    edges2.add(Arrays.asList(2, 4));
    List<Integer> result2 = solution.findSmallestSetOfVertices(n2, edges2);
    System.out.println(result2);

  }

  public static void main(String[] args) {
    Solution01557.test_01557();
  }
}
