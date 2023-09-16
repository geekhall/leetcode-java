package net.geekhour.problems.p01600.p01631;

import java.util.*;

/**
 * ID: 01631
 * Title: Path With Minimum Effort
 * Difficulty: Medium
 * Description: You are a hiker preparing for an upcoming hike. You are given
 * heights, a 2D array of size rows x columns, where heights[row][col]
 * represents the height of cell (row, col). You are situated in the top-left
 * cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1,
 * columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you
 * wish to find a route that requires the minimum effort.
 *
 * A route's effort is the maximum absolute difference in heights between two
 * consecutive cells of the route.
 *
 * Return the minimum effort required to travel from the top-left cell to the
 * bottom-right cell.
 *
 * Example 1:
 *
 * Input: heights = [[1,2,2],[3,8,2],[5,3,5]] Output: 2 Explanation: The route
 * of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
 * This is better than the route of [1,2,2,2,5], where the maximum absolute
 * difference is 3.
 *
 * Example 2:
 *
 * Input: heights = [[1,2,3],[3,8,4],[5,3,5]] Output: 1 Explanation: The route
 * of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells,
 * which is better than route [1,3,5,3,5].
 *
 * Example 3:
 *
 * Input: heights =
 * [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]] Output: 0
 * Explanation: This route does not require any effort.
 *
 * Constraints:
 *
 * rows == heights.length
 * columns == heights[i].length
 * 1 <= rows, columns <= 100
 * 1 <= heights[i][j] <= 10 6
 */
class Solution01631 {

  public int minimumEffortPath(int[][] heights) {
    int rows = heights.length;
    int cols = heights[0].length;
    int[][] efforts = new int[rows][cols];
    for (int[] row : efforts) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }
    efforts[0][0] = 0;
    PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
    queue.offer(new int[] { 0, 0, 0 });
    int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    while (!queue.isEmpty()) {
      int[] cell = queue.poll();
      int row = cell[0];
      int col = cell[1];
      int effort = cell[2];
      if (row == rows - 1 && col == cols - 1) {
        return effort;
      }
      for (int[] direction : directions) {
        int newRow = row + direction[0];
        int newCol = col + direction[1];
        if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
          int newEffort = Math.max(effort, Math.abs(heights[newRow][newCol] - heights[row][col]));
          if (newEffort < efforts[newRow][newCol]) {
            efforts[newRow][newCol] = newEffort;
            queue.offer(new int[] { newRow, newCol, newEffort });
          }
        }
      }
    }
    return 0;
  }

  public static void test_01631() {
    Solution01631 solution = new Solution01631();
    int[][] heights = new int[][] { { 1, 2, 2 }, { 3, 8, 2 }, { 5, 3, 5 } };
    int result = solution.minimumEffortPath(heights);
    System.out.println(result);
    int[][] heights2 = new int[][] { { 1, 2, 3 }, { 3, 8, 4 }, { 5, 3, 5 } };
    int result2 = solution.minimumEffortPath(heights2);
    System.out.println(result2);
    int[][] heights3 = new int[][] { { 1, 2, 1, 1, 1 }, { 1, 2, 1, 2, 1 }, { 1, 2, 1, 2, 1 },
        { 1, 2, 1, 2, 1 }, { 1, 1, 1, 2, 1 } };
    int result3 = solution.minimumEffortPath(heights3);
    System.out.println(result3);

    //
  }

  public static void main(String[] args) {
    test_01631();
  }
}
