package net.geekhour.problems.p01400.p01425;

import java.util.*;

/**
 * ID: 01425
 * Title: Constrained Subsequence Sum
 * Difficulty: Hard
 * Description: Given an integer array nums and an integer k, return the maximum
 * sum of a non-empty subsequence of that array such that for every two
 * consecutive integers in the subsequence, nums[i] and nums[j], where i < j,
 * the condition j - i <= k is satisfied.
 *
 * A subsequence of an array is obtained by deleting some number of elements
 * (can be zero) from the array, leaving the remaining elements in their
 * original order.
 *
 * Example 1:
 *
 * Input: nums = [10,2,-10,5,20], k = 2 Output: 37 Explanation: The subsequence
 * is [10, 2, 5, 20].
 *
 * Example 2:
 *
 * Input: nums = [-1,-2,-3], k = 1 Output: -1 Explanation: The subsequence must
 * be non-empty, so we choose the largest number.
 *
 * Example 3:
 *
 * Input: nums = [10,-2,-10,-5,20], k = 2 Output: 23 Explanation: The
 * subsequence is [10, -2, -5, 20].
 *
 * Constraints:
 *
 * 1 <= k <= nums.length <= 10 5
 * -10 4 <= nums[i] <= 10 4
 */
class Solution01425 {

  public int constrainedSubsetSum(int[] nums, int k) {
    int n = nums.length;
    int[] dp = new int[n];
    Deque<Integer> deque = new LinkedList<>();
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      dp[i] = nums[i];
      if (!deque.isEmpty()) {
        dp[i] = Math.max(dp[i], dp[deque.peekFirst()] + nums[i]);
      }
      max = Math.max(max, dp[i]);
      while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
        deque.pollLast();
      }
      deque.offerLast(i);
      if (i - deque.peekFirst() + 1 > k) {
        deque.pollFirst();
      }
    }
    return max;
  }

  public static void test_01425() {
    Solution01425 solution = new Solution01425();
    System.out.println(solution.constrainedSubsetSum(new int[] { 10, 2, -10, 5, 20 }, 2));
    System.out.println(solution.constrainedSubsetSum(new int[] { -1, -2, -3 }, 1));
    System.out.println(solution.constrainedSubsetSum(new int[] { 10, -2, -10, -5, 20 }, 2));
  }

  public static void main(String[] args) {
    test_01425();
  }
}
