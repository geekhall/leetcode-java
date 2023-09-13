package net.geekhour.problems.p00100.p00135;

import java.util.*;

/**
 * ID: 00135
 * Title: Candy
 * Difficulty: Hard
 * Description: There are n children standing in a line. Each child is assigned
 * a rating value given in the integer array ratings.
 *
 * You are giving candies to these children subjected to the following
 * requirements:
 *
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 *
 * Return the minimum number of candies you need to have to distribute the
 * candies to the children.
 *
 * Example 1:
 *
 * Input: ratings = [1,0,2] Output: 5 Explanation: You can allocate to the
 * first, second and third child with 2, 1, 2 candies respectively.
 *
 * Example 2:
 *
 * Input: ratings = [1,2,2] Output: 4 Explanation: You can allocate to the
 * first, second and third child with 1, 2, 1 candies respectively. The third
 * child gets 1 candy because it satisfies the above two conditions.
 *
 * Constraints:
 *
 * n == ratings.length
 * 1 <= n <= 2 * 10 4
 * 0 <= ratings[i] <= 2 * 10 4
 */
class Solution00135 {

  public int candy(int[] ratings) {
    int n = ratings.length;
    int[] left = new int[n];
    int[] right = new int[n];
    Arrays.fill(left, 1);
    Arrays.fill(right, 1);
    for (int i = 1; i < n; i++) {
      if (ratings[i] > ratings[i - 1]) {
        left[i] = left[i - 1] + 1;
      }
    }
    for (int i = n - 2; i >= 0; i--) {
      if (ratings[i] > ratings[i + 1]) {
        right[i] = right[i + 1] + 1;
      }
    }
    int ans = 0;
    for (int i = 0; i < n; i++) {
      ans += Math.max(left[i], right[i]);
    }
    return ans;
  }

  public static void test_00135() {
    Solution00135 solution = new Solution00135();
    int[] ratings = { 1, 0, 2 };
    int expected = 5;
    int actual = solution.candy(ratings);
    System.out.printf("expected: %d, actual: %d\n", expected, actual);
    int[] ratings2 = { 1, 2, 2 };
    int expected2 = 4;
    int actual2 = solution.candy(ratings2);
    System.out.printf("expected: %d, actual: %d\n", expected2, actual2);
  }

  public static void main(String[] args) {
    test_00135();
  }
}
