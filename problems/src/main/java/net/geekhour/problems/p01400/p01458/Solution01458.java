package net.geekhour.problems.p01400.p01458;

import java.util.*;

/**
 * ID: 01458
 * Title: Max Dot Product of Two Subsequences
 * Difficulty: Hard
 * Description: Given two arrays nums1 and nums2.
 *
 * Return the maximum dot product between non-empty subsequences of nums1 and
 * nums2 with the same length.
 *
 * A subsequence of a array is a new array which is formed from the original
 * array by deleting some (can be none) of the characters without disturbing the
 * relative positions of the remaining characters. (ie, [2,3,5] is a subsequence
 * of [1,2,3,4,5] while [1,5,3] is not).
 *
 * Example 1:
 *
 * Input: nums1 = [2,1,-2,5], nums2 = [3,0,-6] Output: 18 Explanation: Take
 * subsequence [2,-2] from nums1 and subsequence [3,-6] from nums2. Their dot
 * product is (2*3 + (-2)*(-6)) = 18.
 *
 * Example 2:
 *
 * Input: nums1 = [3,-2], nums2 = [2,-6,7] Output: 21 Explanation: Take
 * subsequence [3] from nums1 and subsequence [7] from nums2. Their dot product
 * is (3*7) = 21.
 *
 * Example 3:
 *
 * Input: nums1 = [-1,-1], nums2 = [1,1] Output: -1 Explanation: Take
 * subsequence [-1] from nums1 and subsequence [1] from nums2. Their dot product
 * is -1.
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 500
 * -1000 <= nums1[i], nums2[i] <= 1000
 */
class Solution01458 {

  public int maxDotProduct(int[] nums1, int[] nums2) {
    int n = nums1.length;
    int m = nums2.length;
    int[][] memo = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        memo[i][j] = Integer.MIN_VALUE;
      }
    }

    return dp(nums1, nums2, 0, 0, memo);
  }

  private int dp(int[] nums1, int[] nums2, int i, int j, int[][] memo) {
    int n = nums1.length;
    int m = nums2.length;

    if (i == n || j == m) {
      return Integer.MIN_VALUE;
    }

    if (memo[i][j] != Integer.MIN_VALUE) {
      return memo[i][j];
    }

    memo[i][j] = Math.max(
        nums1[i] * nums2[j] + Math.max(dp(nums1, nums2, i + 1, j + 1, memo), 0),
        Math.max(dp(nums1, nums2, i + 1, j, memo), dp(nums1, nums2, i, j + 1, memo)));

    return memo[i][j];
  }

  public static void test_01458() {
    Solution01458 solution = new Solution01458();
    int[] nums1 = { 2, 1, -2, 5 };
    int[] nums2 = { 3, 0, -6 };
    int result = solution.maxDotProduct(nums1, nums2);
    System.out.println(result);

    nums1 = new int[] { 3, -2 };
    nums2 = new int[] { 2, -6, 7 };
    result = solution.maxDotProduct(nums1, nums2);
    System.out.println(result);

    nums1 = new int[] { -1, -1 };
    nums2 = new int[] { 1, 1 };
    result = solution.maxDotProduct(nums1, nums2);
    System.out.println(result);
  }

  public static void main(String[] args) {
    test_01458();
  }
}
