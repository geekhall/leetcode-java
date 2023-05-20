package net.geekhour.problems.p01300.p01319;

import java.util.*;

import net.geekhour.utils.UnionFind;

/**
 * ID: 01319
 * Title: Number of Operations to Make Network Connected
 * Difficulty: Medium
 * Description: There are n computers numbered from 0 to n - 1 connected by
 * ethernet cables connections forming a network where connections[i] = [a i, b
 * i ] represents a connection between computers a i and b i. Any computer can
 * reach any other computer directly or indirectly through the network.
 *
 * You are given an initial computer network connections. You can extract
 * certain cables between two directly connected computers, and place them
 * between any pair of disconnected computers to make them directly connected.
 *
 * Return the minimum number of times you need to do this in order to make all
 * the computers connected. If it is not possible, return -1.
 *
 * Example 1:
 *
 * Input: n = 4, connections = [[0,1],[0,2],[1,2]] Output: 1 Explanation: Remove
 * cable between computer 1 and 2 and place between computers 1 and 3.
 *
 * Example 2:
 *
 * Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]] Output: 2
 *
 * Example 3:
 *
 * Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]] Output: -1 Explanation:
 * There are not enough cables.
 *
 * Constraints:
 *
 * 1 <= n <= 10 5
 * 1 <= connections.length <= min(n * (n - 1) / 2, 10 5)
 * connections[i].length == 2
 * 0 <= a i, b i < n
 * a i!= b i
 * There are no repeated connections.
 * No two computers are connected by more than one cable.
 */
class Solution01319 {

  public int makeConnected(int n, int[][] connections) {
    if (connections.length < n - 1) {
      return -1;
    }
    UnionFind unionFind = new UnionFind(n);
    for (int[] connection : connections) {
      unionFind.union(connection[0], connection[1]);
    }
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      set.add(unionFind.find(i));
    }
    return set.size() - 1;
  }

  public static void test_01319() {
    Solution01319 solution = new Solution01319();
    int n = 4;
    int[][] connections = { { 0, 1 }, { 0, 2 }, { 1, 2 } };
    int result = solution.makeConnected(n, connections);
    System.out.println(result);
    int n2 = 6;
    int[][] connections2 = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 2 }, { 1, 3 } };
    int result2 = solution.makeConnected(n2, connections2);
    System.out.println(result2);
    int n3 = 6;
    int[][] connections3 = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 2 } };
    int result3 = solution.makeConnected(n3, connections3);
    System.out.println(result3);

  }

  public static void main(String[] args) {
    Solution01319.test_01319();
  }
}
