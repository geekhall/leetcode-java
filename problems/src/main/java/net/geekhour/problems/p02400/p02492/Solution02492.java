package net.geekhour.problems.p02400.p02492;

import java.util.*;

/**
 * ID: 02492
 * Title: Minimum Score of a Path Between Two Cities
 * Difficulty: Medium
 * Description: You are given a positive integer n representing n cities
 * numbered from 1 to n. You are also given a 2D array roads where roads[i] = [a
 * i, b i, distance i ] indicates that there is a bidirectional road between
 * cities a i and b i with a distance equal to distance i. The cities graph is
 * not necessarily connected.
 *
 * The score of a path between two cities is defined as the minimum distance of
 * a road in this path.
 *
 * Return the minimum possible score of a path between cities 1 and n.
 *
 * Note:
 *
 * A path is a sequence of roads between two cities.
 * It is allowed for a path to contain the same road multiple times, and you can
 * visit cities 1 and n multiple times along the path.
 * The test cases are generated such that there is at least one path between 1
 * and n.
 *
 * Example 1:
 *
 * Input: n = 4, roads = [[1,2,9],[2,3,6],[2,4,5],[1,4,7]] Output: 5
 * Explanation: The path from city 1 to 4 with the minimum score is: 1 -> 2 ->
 * 4. The score of this path is min(9,5) = 5. It can be shown that no other path
 * has less score.
 *
 * Example 2:
 *
 * Input: n = 4, roads = [[1,2,2],[1,3,4],[3,4,7]] Output: 2 Explanation: The
 * path from city 1 to 4 with the minimum score is: 1 -> 2 -> 1 -> 3 -> 4. The
 * score of this path is min(2,2,4,7) = 2.
 *
 * Constraints:
 *
 * 2 <= n <= 10 5
 * 1 <= roads.length <= 10 5
 * roads[i].length == 3
 * 1 <= a i, b i <= n
 * a i!= b i
 * 1 <= distance i <= 10 4
 * There are no repeated edges.
 * There is at least one path between 1 and n.
 */
class Pair {
  int node;
  int dist;

  Pair(int node, int dist) {
    this.node = node;
    this.dist = dist;
  }
}

class Solution02492 {

  public int minScore(int n, int[][] roads) {
    List<List<Pair>> adj = new ArrayList<>();
    for (int i = 0; i < n + 1; i++)
      adj.add(new ArrayList<>());
    for (int i = 0; i < roads.length; i++) {
      adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
      adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
    }
    Queue<Pair> queue = new LinkedList<>();
    boolean vis[] = new boolean[n + 1];
    queue.add(new Pair(1, Integer.MAX_VALUE));
    int ans = Integer.MAX_VALUE;
    while (!queue.isEmpty()) {
      Pair p = queue.poll();
      vis[p.node] = true;
      ans = Math.min(ans, p.dist);
      for (Pair adjcomp : adj.get(p.node)) {
        if (!vis[adjcomp.node]) {
          queue.add(adjcomp);
        }
      }
    }
    return ans;
  }

  public static void test_02492() {
    Solution02492 solution = new Solution02492();
    int n = 4;
    int[][] roads = { { 1, 2, 9 }, { 2, 3, 6 }, { 2, 4, 5 }, { 1, 4, 7 } };
    int result = solution.minScore(n, roads);
    System.out.println(result);
    int n2 = 4;
    int[][] roads2 = { { 1, 2, 2 }, { 1, 3, 4 }, { 3, 4, 7 } };
    int result2 = solution.minScore(n2, roads2);
    System.out.println(result2);
    int n3 = 5;
    int[][] roads3 = { { 1, 2, 3 }, { 1, 3, 4 }, { 2, 3, 1 }, { 2, 4, 2 }, { 3, 4, 3 }, { 3, 5, 2 }, { 4, 5, 1 } };
    int result3 = solution.minScore(n3, roads3);
    System.out.println(result3);
  }

  public static void main(String[] args) {
    Solution02492.test_02492();
  }
}
