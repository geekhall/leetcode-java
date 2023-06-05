package net.geekhour.problems.p01200.p01232;

import java.util.*;

/**
 * ID: 01232
 * Title: Check If It Is a Straight Line
 * Difficulty: Easy
 * Description: You are given an array coordinates, coordinates[i] = [x, y],
 * where [x, y] represents the coordinate of a point. Check if these points make
 * a straight line in the XY plane.
 *
 * Example 1:
 *
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]] Output: true
 *
 * Example 2:
 *
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]] Output: false
 *
 * Constraints:
 *
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates contains no duplicate point.
 */
class Solution01232 {

  public boolean checkStraightLine(int[][] coordinates) {
    int n = coordinates.length;
    if (n == 2) {
      return true;
    }
    int x0 = coordinates[0][0];
    int y0 = coordinates[0][1];
    int x1 = coordinates[1][0];
    int y1 = coordinates[1][1];
    for (int i = 2; i < n; i++) {
      int x = coordinates[i][0];
      int y = coordinates[i][1];
      if ((y1 - y0) * (x - x0) != (y - y0) * (x1 - x0)) {
        return false;
      }
    }
    return true;
  }

  public static void test_01232() {
    Solution01232 solution = new Solution01232();
    int[][] coordinates = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 },
        { 6, 7 } };
    boolean expected = true;
    boolean actual = solution.checkStraightLine(coordinates);
    System.out.println("expected: " + expected + ", actual: " + actual);
    int[][] coordinates2 = { { 1, 1 }, { 2, 2 }, { 3, 4 }, { 4, 5 }, { 5, 6 },
        { 7, 7 } };
    boolean expected2 = false;
    boolean actual2 = solution.checkStraightLine(coordinates2);
    System.out.println("expected: " + expected2 + ", actual: " + actual2);
  }

  public static void main(String[] args) {
    Solution01232.test_01232();
  }
}
