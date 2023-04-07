package cn.geekhall.problems.p01000.p01020;

import java.util.*;

/**
 * ID: 01020
 * Title: Number of Enclaves
 * Difficulty: Medium
 * Description: You are given an m x n binary matrix grid, where 0 represents a
 * sea cell and 1 represents a land cell.
 *
 * A move consists of walking from one land cell to another adjacent
 * (4-directionally) land cell or walking off the boundary of the grid.
 *
 * Return the number of land cells in grid for which we cannot walk off the
 * boundary of the grid in any number of moves.
 *
 * Example 1:
 *
 * Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]] Output: 3
 * Explanation: There are three 1s that are enclosed by 0s, and one 1 that is
 * not enclosed because its on the boundary.
 *
 * Example 2:
 *
 * Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]] Output: 0
 * Explanation: All 1s are either on the boundary or can reach the boundary.
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 500
 * grid[i][j] is either 0 or 1.
 */
class Solution01020 {

  /**
   * method 1
   */
  public int numEnclaves(int[][] grid) {
    // Traverse the first and last rows of the grid, marking all connected 1's as
    // reachable
    for (int j = 0; j < grid[0].length; j++) {
      dfs(grid, 0, j);
      dfs(grid, grid.length - 1, j);
    }

    // Traverse the first and last columns of the grid, marking all connected 1's as
    // reachable
    for (int i = 0; i < grid.length; i++) {
      dfs(grid, i, 0);
      dfs(grid, i, grid[0].length - 1);
    }

    // Count the number of enclosed cells by 0
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          count += dfs(grid, i, j);
        }
      }
    }

    return count;
  }

  private int dfs(int[][] grid, int i, int j) {
    // Check if cell is valid and a land cell
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
      return 0;
    }

    grid[i][j] = 0; // Mark cell as visited

    // Traverse all adjacent cells, returning the sum of enclosed cells by 0
    int sum = 1;
    sum += dfs(grid, i + 1, j);
    sum += dfs(grid, i - 1, j);
    sum += dfs(grid, i, j + 1);
    sum += dfs(grid, i, j - 1);

    return sum;
  }

  public static void test_01020() {
    Solution01020 solution = new Solution01020();
    int[][] grid = { { 0, 0, 0, 0 }, { 1, 0, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } };
    int result = solution.numEnclaves(grid);
    System.out.println(result);
    int[][] grid2 = { { 0, 1, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 } };
    int result2 = solution.numEnclaves(grid2);
    System.out.println(result2);
  }

  public static void main(String[] args) {
    Solution01020.test_01020();
  }
}
