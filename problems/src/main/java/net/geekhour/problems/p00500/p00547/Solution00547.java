package net.geekhour.problems.p00500.p00547;

import java.util.*;

/**
 * ID: 00547
 * Title: Number of Provinces
 * Difficulty: Medium
 * Description: There are n cities. Some of them are connected, while some are
 * not. If city a is connected directly with city b, and city b is connected
 * directly with city c, then city a is connected indirectly with city c.
 *
 * A province is a group of directly or indirectly connected cities and no other
 * cities outside of the group.
 *
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the
 * i th city and the j th city are directly connected, and isConnected[i][j] = 0
 * otherwise.
 *
 * Return the total number of provinces.
 *
 * Example 1:
 *
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]] Output: 2
 *
 * Example 2:
 *
 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]] Output: 3
 *
 * Constraints:
 *
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] is 1 or 0.
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 */
class Solution00547 {

  public int findCircleNum(int[][] isConnected) {
    int n = isConnected.length;
    int[] visited = new int[n];
    int count = 0;
    for (int i = 0; i < n; i++) {
      if (visited[i] == 0) {
        dfs(isConnected, visited, i);
        count++;
      }
    }
    return count;
  }

  private void dfs(int[][] isConnected, int[] visited, int i) {
    for (int j = 0; j < isConnected.length; j++) {
      if (isConnected[i][j] == 1 && visited[j] == 0) {
        visited[j] = 1;
        dfs(isConnected, visited, j);
      }
    }
  }

  public static void test_00547() {
    Solution00547 solution = new Solution00547();
    int[][] isConnected = new int[][] {
        { 1, 1, 0 },
        { 1, 1, 0 },
        { 0, 0, 1 }
    };
    int expected = 2;
    int actual = solution.findCircleNum(isConnected);
    System.out.println("Expected: " + expected + ", actual: " + actual);
    int[][] isConnected2 = new int[][] {
        { 1, 0, 0 },
        { 0, 1, 0 },
        { 0, 0, 1 }
    };
    expected = 3;
    actual = solution.findCircleNum(isConnected2);
    System.out.println("Expected: " + expected + ", actual: " + actual);

  }

  public static void main(String[] args) {
    Solution00547.test_00547();
  }
}
