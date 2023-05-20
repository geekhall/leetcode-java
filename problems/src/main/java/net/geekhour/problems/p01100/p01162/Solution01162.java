package net.geekhour.problems.p01100.p01162;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ID: 01162
 * Title: As Far from Land as Possible
 * Difficulty: Medium
 * Description: Given an n x n grid containing only values 0 and 1, where 0
 * represents water and 1 represents land, find a water cell such that its
 * distance to the nearest land cell is maximized, and return the distance. If
 * no land or water exists in the grid, return -1.
 *
 * The distance used in this problem is the Manhattan distance: the distance
 * between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
 *
 * Example 1:
 *
 * Input: grid = [[1,0,1],[0,0,0],[1,0,1]] Output: 2 Explanation: The cell (1,
 * 1) is as far as possible from all the land with distance 2.
 *
 * Example 2:
 *
 * Input: grid = [[1,0,0],[0,0,0],[0,0,0]] Output: 4 Explanation: The cell (2,
 * 2) is as far as possible from all the land with distance 4.
 *
 * Constraints:
 *
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 100
 * grid[i][j] is 0 or 1
 */
class Solution01162 {

  public int maxDistance(int[][] grid) {
    int n = grid.length;
    int[][] dist = new int[n][n];
    int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    // BFS
    // queue 保存所有的陆地格子
    Queue<int[]> queue = new LinkedList<>();
    // 将所有的陆地格子加入队列中，距离初始化为 0
    // 将所有的海洋格子的距离初始化为 Integer.MAX_VALUE
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          queue.offer(new int[] { i, j });
        } else {
          dist[i][j] = Integer.MAX_VALUE;
        }
      }
    }
    // System.out.println(Arrays.deepToString(dist));
    // System.out.println(Arrays.deepToString(queue.toArray()));
    // 从陆地格子开始，向四周扩散，直到遇到海洋格子
    boolean hasOcean = false;
    while (!queue.isEmpty()) {
      int[] cell = queue.poll();
      int r = cell[0], c = cell[1];
      for (int[] dir : dirs) {
        int nr = r + dir[0];
        int nc = c + dir[1];
        // 上下左右四个方向，如果是海洋格子，且距离还没有被更新过，那么更新距离
        if (nr >= 0 && nr < n && nc >= 0 && nc < n && dist[nr][nc] == Integer.MAX_VALUE) {
          dist[nr][nc] = dist[r][c] + 1;
          queue.offer(new int[] { nr, nc });
          hasOcean = true;
        }
      }
    }
    int ans = 0;
    if (hasOcean) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (dist[i][j] != Integer.MAX_VALUE) {
            ans = Math.max(ans, dist[i][j]);
          }
        }
      }
    } else {
      ans = -1;
    }
    return ans;
  }

  public static void test_01162() {
    Solution01162 solution = new Solution01162();
    int[][] grid = { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } };
    int result = solution.maxDistance(grid);
    System.out.println(result);
    int[][] grid2 = { { 1, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
    int result2 = solution.maxDistance(grid2);
    System.out.println(result2);

  }

  public static void main(String[] args) {
    Solution01162.test_01162();
  }
}
