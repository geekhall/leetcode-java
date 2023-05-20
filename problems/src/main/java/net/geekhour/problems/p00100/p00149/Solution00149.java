package net.geekhour.problems.p00100.p00149;

/**
 * ID: 00149
 * Title: Max Points on a Line
 * Difficulty: Hard
 * Description: Given an array of points where points[i] = [x i, y i ]
 * represents a point on the X-Y plane, return the maximum number of points that
 * lie on the same straight line.
 *
 * Example 1:
 *
 * Input: points = [[1,1],[2,2],[3,3]] Output: 3
 *
 * Example 2:
 *
 * Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]] Output: 4
 *
 * Constraints:
 *
 * 1 <= points.length <= 300
 * points[i].length == 2
 * -10 4 <= x i, y i <= 10 4
 * All the points are unique.
 */
class Solution00149 {

  public int maxPoints(int[][] points) {
    int result = 1;
    for (int i = 0; i < points.length; i++) {
      int[] p1 = points[i];
      for (int j = i + 1; j < points.length; j++) {
        int[] p2 = points[j];
        int count = 0;
        for (int k = 0; k < points.length; k++) {
          int[] p3 = points[k];
          if (isSameLine(p1, p2, p3)) {
            count++;
          }
        }
        result = Math.max(result, count);
      }
    }
    return result;
  }

  private boolean isSameLine(int[] p1, int[] p2, int[] p3) {
    return (p2[1] - p1[1]) * (p3[0] - p1[0]) == (p3[1] - p1[1]) * (p2[0] - p1[0]);
  }

  public static void test_00149() {
    Solution00149 solution = new Solution00149();
    int[][] points = { { 1, 1 }, { 2, 2 }, { 3, 3 } };
    int result = solution.maxPoints(points);
    System.out.println(result);
    int[][] points2 = { { 1, 1 }, { 3, 2 }, { 5, 3 }, { 4, 1 }, { 2, 3 }, { 1, 4 } };
    result = solution.maxPoints(points2);
    System.out.println(result);

  }

  public static void main(String[] args) {
    Solution00149.test_00149();
  }
}
