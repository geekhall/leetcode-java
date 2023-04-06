package cn.geekhall.problems.p01200.p01254;

import java.util.*;

/**
 * ID: 01254
 * Title: Number of Closed Islands
 * Difficulty: Medium
 * Description: Given a 2D grid consists of 0s (land) and 1s (water). An island
 * is a maximal 4-directionally connected group of 0 s and a closed island is an
 * island totally (all left, top, right, bottom) surrounded by 1s.
 *
 * Return the number of closed islands.
 *
 * Example 1:
 *
 * Input: grid =
 * [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * Output: 2 Explanation: Islands in gray are closed because they are completely
 * surrounded by water (group of 1s).
 *
 * Example 2:
 *
 * Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]] Output: 1
 *
 * Example 3:
 *
 * Input: grid = [[1,1,1,1,1,1,1], [1,0,0,0,0,0,1], [1,0,1,1,1,0,1],
 * [1,0,1,0,1,0,1], [1,0,1,1,1,0,1], [1,0,0,0,0,0,1], [1,1,1,1,1,1,1]] Output: 2
 *
 * Constraints:
 *
 * 1 <= grid.length, grid[0].length <= 100
 * 0 <= grid[i][j] <=1
 */
class Solution01254 {

  public int closedIsland(int[][] grid) {
    int result = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 0) {
          if (dfs(grid, i, j)) {
            result++;
          }
        }
      }
    }
    return result;
  }

  private boolean dfs(int[][] grid, int i, int j) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
      return false;
    }
    if (grid[i][j] == 1) {
      return true;
    }
    grid[i][j] = 1;
    boolean up = dfs(grid, i - 1, j);
    boolean down = dfs(grid, i + 1, j);
    boolean left = dfs(grid, i, j - 1);
    boolean right = dfs(grid, i, j + 1);
    return up && down && left && right;
  }

  public static void test_01254() {
    Solution01254 solution = new Solution01254();
    int[][] grid = {
        { 1, 1, 1, 1, 1, 1, 1, 0 },
        { 1, 0, 0, 0, 0, 1, 1, 0 },
        { 1, 0, 1, 0, 1, 1, 1, 0 },
        { 1, 0, 0, 0, 0, 1, 0, 1 },
        { 1, 1, 1, 1, 1, 1, 1, 0 } };
    int result = solution.closedIsland(grid);
    System.out.println(result);
    int[][] grid2 = { { 0, 0, 1, 0, 0 }, { 0, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 } };
    result = solution.closedIsland(grid2);
    System.out.println(result);
  }

  public static void main(String[] args) {
    Solution01254.test_01254();
  }
}
