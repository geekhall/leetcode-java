package net.geekhour.problems.p02400.p02421;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import net.geekhour.utils.UnionFind;

/**
 * ID: 02421
 * Title: Number of Good Paths
 * Difficulty: Hard
 * Description: There is a tree (i.e. a connected, undirected graph with no
 * cycles) consisting of n nodes numbered from 0 to n - 1 and exactly n - 1
 * edges.
 *
 * You are given a 0-indexed integer array vals of length n where vals[i]
 * denotes the value of the i th node. You are also given a 2D integer array
 * edges where edges[i] = [a i, b i ] denotes that there exists an undirected
 * edge connecting nodes a i and b i.
 *
 * A good path is a simple path that satisfies the following conditions:
 *
 * The starting node and the ending node have the same value.
 * All nodes between the starting node and the ending node have values less than
 * or equal to the starting node (i.e. the starting node's value should be the
 * maximum value along the path).
 *
 * Return the number of distinct good paths.
 *
 * Note that a path and its reverse are counted as the same path. For example, 0
 * -> 1 is considered to be the same as 1 -> 0. A single node is also considered
 * as a valid path.
 *
 * Example 1:
 *
 * Input: vals = [1,3,2,1,3], edges = [[0,1],[0,2],[2,3],[2,4]] Output: 6
 * Explanation: There are 5 good paths consisting of a single node. There is 1
 * additional good path: 1 -> 0 -> 2 -> 4. (The reverse path 4 -> 2 -> 0 -> 1 is
 * treated as the same as 1 -> 0 -> 2 -> 4.) Note that 0 -> 2 -> 3 is not a good
 * path because vals[2] > vals[0].
 *
 * Example 2:
 *
 * Input: vals = [1,1,2,2,3], edges = [[0,1],[1,2],[2,3],[2,4]] Output: 7
 * Explanation: There are 5 good paths consisting of a single node. There are 2
 * additional good paths: 0 -> 1 and 2 -> 3.
 *
 * Example 3:
 *
 * Input: vals = [1], edges = [] Output: 1 Explanation: The tree consists of
 * only one node, so there is one good path.
 *
 * Constraints:
 *
 * n == vals.length
 * 1 <= n <= 3 * 10 4
 * 0 <= vals[i] <= 10 5
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= a i, b i < n
 * a i!= b i
 * edges represents a valid tree.
 */
class Solution02421 {

  public int numberOfGoodPaths(int[] vals, int[][] edges) {
    int n = vals.length;
    int result = n;
    // UnionFind solution
    UnionFind uf = new UnionFind(n);
    // adjacency list
    List<List<Integer>> groups = new ArrayList<>();
    TreeMap<Integer, List<Integer>> map = new TreeMap<>();

    for (int i = 0; i < n; i++) {
      groups.add(new ArrayList<>());
      map.putIfAbsent(vals[i], new ArrayList<>());
      map.get(vals[i]).add(i);
    }
    for (int[] edge : edges) {
      groups.get(edge[0]).add(edge[1]);
      groups.get(edge[1]).add(edge[0]);
    }

    // traverse node values from small to large
    Map.Entry<Integer, List<Integer>> entry = map.firstEntry();
    while (entry != null) {
      List<Integer> listsNodes = entry.getValue();

      for (Integer node : listsNodes) {
        List<Integer> neighbors = groups.get(node);
        for (Integer neighbor : neighbors) {
          if (vals[neighbor] <= vals[node]) {
            uf.union(node, neighbor);
          }
        }
      }

      // check if each node is in union set with other nodes in the same value
      if (listsNodes.size() > 1) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (Integer node : listsNodes) {
          int root = uf.find(node);
          freq.put(root, freq.getOrDefault(root, 0) + 1);
        }
        for (Integer parentKey : freq.keySet()) {
          int freqVal = freq.get(parentKey) - 1;
          result += (freqVal * (freqVal + 1)) / 2;
        }
      }
      entry = map.higherEntry(entry.getKey());
    }
    return result;
  }

  public static void test_02421() {
    Solution02421 solution = new Solution02421();
    int[] vals = { 1, 3, 2, 1, 3 };
    int[][] edges = { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 2, 4 } };
    int result = solution.numberOfGoodPaths(vals, edges);
    System.out.println(result);
    int[] vals2 = { 1, 1, 2, 2, 3 };
    int[][] edges2 = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 2, 4 } };
    int result2 = solution.numberOfGoodPaths(vals2, edges2);
    System.out.println(result2);
    int[] vals3 = { 1 };
    int[][] edges3 = {};
    int result3 = solution.numberOfGoodPaths(vals3, edges3);
    System.out.println(result3);
  }

  public static void main(String[] args) {
    Solution02421.test_02421();
  }
}
