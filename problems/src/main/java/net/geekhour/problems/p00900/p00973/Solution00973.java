package net.geekhour.problems.p00900.p00973;

import java.util.Arrays;

/**
 * ID: 00973
 * Title: K Closest Points to Origin
 * Difficulty: Medium
 * Description: Given an array of points where points[i] = [x i, y i ]
 * represents a point on the X-Y plane and an integer k, return the k closest
 * points to the origin (0, 0).
 *
 * The distance between two points on the X-Y plane is the Euclidean distance
 * (i.e., √(x 1 - x 2) 2 + (y 1 - y 2) 2).
 *
 * You may return the answer in any order. The answer is guaranteed to be unique
 * (except for the order that it is in).
 *
 * Example 1:
 *
 * Input: points = [[1,3],[-2,2]], k = 1 Output: [[-2,2]] Explanation: The
 * distance between (1, 3) and the origin is sqrt(10). The distance between (-2,
 * 2) and the origin is sqrt(8). Since sqrt(8) < sqrt(10), (-2, 2) is closer to
 * the origin. We only want the closest k = 1 points from the origin, so the
 * answer is just [[-2,2]].
 *
 * Example 2:
 *
 * Input: points = [[3,3],[5,-1],[-2,4]], k = 2 Output: [[3,3],[-2,4]]
 * Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 *
 * Constraints:
 *
 * 1 <= k <= points.length <= 10 4
 * -10 4 < x i, y i < 10 4
 */
class Solution00973 {

  public int[][] kClosest(int[][] points, int k) {
    int[][] result = new int[k][2];
    int[] distance = new int[points.length];
    for (int i = 0; i < points.length; i++) {
      distance[i] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
    }
    int[] temp = new int[2];
    for (int i = 0; i < k; i++) {
      int min = distance[i];
      int minIndex = i;
      for (int j = i + 1; j < points.length; j++) {
        if (distance[j] < min) {
          min = distance[j];
          minIndex = j;
        }
      }
      temp[0] = points[i][0];
      temp[1] = points[i][1];
      points[i][0] = points[minIndex][0];
      points[i][1] = points[minIndex][1];
      points[minIndex][0] = temp[0];
      points[minIndex][1] = temp[1];
      temp[0] = distance[i];
      distance[i] = distance[minIndex];
      distance[minIndex] = temp[0];
    }
    for (int i = 0; i < k; i++) {
      result[i][0] = points[i][0];
      result[i][1] = points[i][1];
    }
    return result;
  }

  public static void test_00973() {
    Solution00973 solution = new Solution00973();
    int[][] points = { { 1, 3 }, { -2, 2 } };
    int k = 1;
    int[][] result = solution.kClosest(points, k);
    System.out.println(Arrays.deepToString(result));
    int[][] points2 = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
    int k2 = 2;
    int[][] result2 = solution.kClosest(points2, k2);
    System.out.println(Arrays.deepToString(result2));
  }

  public static void main(String[] args) {
    Solution00973.test_00973();
  }
}
