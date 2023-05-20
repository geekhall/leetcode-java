package net.geekhour.problems.p01400.p01443;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ID: 01443
 * Title: Minimum Time to Collect All Apples in a Tree
 * Difficulty: Medium
 * Description: Given an undirected tree consisting of n vertices numbered from
 * 0 to n-1, which has some apples in their vertices. You spend 1 second to walk
 * over one edge of the tree. Return the minimum time in seconds you have to
 * spend to collect all apples in the tree, starting at vertex 0 and coming back
 * to this vertex.
 *
 * The edges of the undirected tree are given in the array edges, where edges[i]
 * = [a i, b i ] means that exists an edge connecting the vertices a i and b i.
 * Additionally, there is a boolean array hasApple, where hasApple[i] = true
 * means that vertex i has an apple; otherwise, it does not have any apple.
 *
 * Example 1:
 *
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple =
 * [false,false,true,false,true,true,false] Output: 8 Explanation: The figure
 * above represents the given tree where red vertices have an apple. One optimal
 * path to collect all apples is shown by the green arrows.
 *
 * Example 2:
 *
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple =
 * [false,false,true,false,false,true,false] Output: 6 Explanation: The figure
 * above represents the given tree where red vertices have an apple. One optimal
 * path to collect all apples is shown by the green arrows.
 *
 * Example 3:
 *
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple =
 * [false,false,false,false,false,false,false] Output: 0
 *
 * Constraints:
 *
 * 1 <= n <= 10 5
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= a i < b i <= n - 1
 * from i < to i
 * hasApple.length == n
 */
class Solution01443 {

  public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
    // Create an adjacency list
    List<List<Integer>> adj = new ArrayList<>();
    // Initialize the adjacency list
    for (int i = 0; i < n; i++)
      adj.add(new ArrayList<>());
    // Add edges to the adjacency list
    for (int[] edge : edges) {
      adj.get(edge[0]).add(edge[1]);
      adj.get(edge[1]).add(edge[0]);
    }
    // Call the helper function
    return minTimeToCollectApples(0, adj, hasApple, -1);
  }

  // Helper function
  int minTimeToCollectApples(int index, List<List<Integer>> adj, List<Boolean> hasApple, int parent) {
    // variable to keep track of total time
    int total = 0;
    // for each neighbor of current node
    for (int nbr : adj.get(index)) {
      // if the neighbor is the parent node, then we skip
      if (nbr == parent)
        continue;
      // we recursively call the helper function for each neighbor
      total += minTimeToCollectApples(nbr, adj, hasApple, index);
    }
    // If current node is not the root (0th) node, and it has an apple or any of its
    // descendant has
    // then we need to add 2 time for moving to and from it
    if (index != 0 && (hasApple.get(index) || total > 0))
      total += 2;
    return total;
  }

  public static void test_01443() {
    Solution01443 solution = new Solution01443();
    int n = 7;
    int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, { 2, 6 } };
    List<Boolean> hasApple = Arrays.asList(false, false, true, false, true, true, false);
    int result = solution.minTime(n, edges, hasApple);
    System.out.println(result);
  }

  public static void main(String[] args) {
    Solution01443.test_01443();
  }
}
