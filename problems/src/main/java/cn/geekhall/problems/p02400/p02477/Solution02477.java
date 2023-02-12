package cn.geekhall.problems.p02400.p02477;

import java.util.*;

/**
 * ID: 02477
 * Title: Minimum Fuel Cost to Report to the Capital
 * Difficulty: Medium
 * Description: There is a tree (i.e., a connected, undirected graph with no
 * cycles) structure country network consisting of n cities numbered from 0 to n
 * - 1 and exactly n - 1 roads. The capital city is city 0. You are given a 2D
 * integer array roads where roads[i] = [a i, b i ] denotes that there exists a
 * bidirectional road connecting cities a i and b i.
 *
 * There is a meeting for the representatives of each city. The meeting is in
 * the capital city.
 *
 * There is a car in each city. You are given an integer seats that indicates
 * the number of seats in each car.
 *
 * A representative can use the car in their city to travel or change the car
 * and ride with another representative. The cost of traveling between two
 * cities is one liter of fuel.
 *
 * Return the minimum number of liters of fuel to reach the capital city.
 *
 * Example 1:
 *
 * Input: roads = [[0,1],[0,2],[0,3]], seats = 5 Output: 3 Explanation: -
 * Representative 1 goes directly to the capital with 1 liter of fuel. -
 * Representative 2 goes directly to the capital with 1 liter of fuel. -
 * Representative 3 goes directly to the capital with 1 liter of fuel. It costs
 * 3 liters of fuel at minimum. It can be proven that 3 is the minimum number of
 * liters of fuel needed.
 *
 * Example 2:
 *
 * Input: roads = [[3,1],[3,2],[1,0],[0,4],[0,5],[4,6]], seats = 2 Output: 7
 * Explanation: - Representative 2 goes directly to city 3 with 1 liter of fuel.
 * - Representative 2 and representative 3 go together to city 1 with 1 liter of
 * fuel. - Representative 2 and representative 3 go together to the capital with
 * 1 liter of fuel. - Representative 1 goes directly to the capital with 1 liter
 * of fuel. - Representative 5 goes directly to the capital with 1 liter of
 * fuel. - Representative 6 goes directly to city 4 with 1 liter of fuel. -
 * Representative 4 and representative 6 go together to the capital with 1 liter
 * of fuel. It costs 7 liters of fuel at minimum. It can be proven that 7 is the
 * minimum number of liters of fuel needed.
 *
 * Example 3:
 *
 * Input: roads = [], seats = 1 Output: 0 Explanation: No representatives need
 * to travel to the capital city.
 *
 * Constraints:
 *
 * 1 <= n <= 10 5
 * roads.length == n - 1
 * roads[i].length == 2
 * 0 <= a i, b i < n
 * a i!= b i
 * roads represents a valid tree.
 * 1 <= seats <= 10 5
 */
class Solution02477 {

  long fuel;

  public long dfs(int node, int parent, Map<Integer, List<Integer>> adj, int seats) {
    // The node itself has one representative.
    int representatives = 1;
    if (!adj.containsKey(node)) {
      return representatives;
    }
    for (int child : adj.get(node)) {
      if (child != parent) {
        // Add count of representatives in each child subtree to the parent subtree.
        representatives += dfs(child, node, adj, seats);
      }
    }
    if (node != 0) {
      // Count the fuel it takes to move to the parent node.
      // Root node does not have any parent so we ignore it.
      fuel += Math.ceil((double) representatives / seats);
    }
    return representatives;
  }

  public long minimumFuelCost(int[][] roads, int seats) {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    for (int[] road : roads) {
      adj.computeIfAbsent(road[0], k -> new ArrayList<Integer>()).add(road[1]);
      adj.computeIfAbsent(road[1], k -> new ArrayList<Integer>()).add(road[0]);
    }
    dfs(0, -1, adj, seats);
    return fuel;
  }

  public static void test_02477() {
    Solution02477 solution = new Solution02477();
    int[][] roads = { { 0, 1 }, { 0, 2 }, { 0, 3 } };
    int seats = 5;
    long result = solution.minimumFuelCost(roads, seats);
    System.out.println(result);
    Solution02477 solution2 = new Solution02477();
    int[][] roads2 = { { 3, 1 }, { 3, 2 }, { 1, 0 }, { 0, 4 }, { 0, 5 }, { 4, 6 } };
    int seats2 = 2;
    long result2 = solution2.minimumFuelCost(roads2, seats2);
    System.out.println(result2);
    Solution02477 solution3 = new Solution02477();
    int[][] roads3 = {};
    int seats3 = 1;
    long result3 = solution3.minimumFuelCost(roads3, seats3);
    System.out.println(result3);
  }

  public static void main(String[] args) {
    Solution02477.test_02477();
  }
}
