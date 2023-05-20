package net.geekhour.problems.p01500.p01552;

import java.util.Arrays;

/**
 * ID: 01552
 * Title: Magnetic Force Between Two Balls
 * Difficulty: Medium
 * Description: In the universe Earth C-137, Rick discovered a special form of
 * magnetic force between two balls if they are put in his new invented basket.
 * Rick has n empty baskets, the i th basket is at position[i], Morty has m
 * balls and needs to distribute the balls into the baskets such that the
 * minimum magnetic force between any two balls is maximum.
 *
 * Rick stated that magnetic force between two different balls at positions x
 * and y is |x - y|.
 *
 * Given the integer array position and the integer m. Return the required
 * force.
 *
 * Example 1:
 *
 * Input: position = [1,2,3,4,7], m = 3 Output: 3 Explanation: Distributing the
 * 3 balls into baskets 1, 4 and 7 will make the magnetic force between ball
 * pairs [3, 3, 6]. The minimum magnetic force is 3. We cannot achieve a larger
 * minimum magnetic force than 3.
 *
 * Example 2:
 *
 * Input: position = [5,4,3,2,1,1000000000], m = 2 Output: 999999999
 * Explanation: We can use baskets 1 and 1000000000.
 *
 * Constraints:
 *
 * n == position.length
 * 2 <= n <= 10 5
 * 1 <= position[i] <= 10 9
 * All integers in position are distinct.
 * 2 <= m <= position.length
 */
class Solution01552 {

  public int maxDistance(int[] position, int m) {
    Arrays.sort(position);
    int left = 1;
    int right = position[position.length - 1] - position[0];
    while (left < right) {
      int mid = left + (right - left + 1) / 2;
      int count = 1;
      int prev = position[0];
      for (int i = 1; i < position.length; i++) {
        if (position[i] - prev >= mid) {
          count++;
          prev = position[i];
        }
      }
      if (count >= m) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }

  public static void test_01552() {
    Solution01552 solution = new Solution01552();
    int[] position = { 1, 2, 3, 4, 7 };
    int m = 3;
    int result = solution.maxDistance(position, m);
    System.out.println(result);
    int[] position2 = { 5, 4, 3, 2, 1, 1000000000 };
    m = 2;
    result = solution.maxDistance(position2, m);
    System.out.println(result);
  }

  public static void main(String[] args) {
    Solution01552.test_01552();
  }
}
