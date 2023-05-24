package net.geekhour.problems.p02500.p02542;

import java.util.*;

/**
 * ID: 02542
 * Title: Maximum Subsequence Score
 * Difficulty: Medium
 * Description: You are given two 0-indexed integer arrays nums1 and nums2 of
 * equal length n and a positive integer k. You must choose a subsequence of
 * indices from nums1 of length k.
 *
 * For chosen indices i 0, i 1, ..., i k - 1, your score is defined as:
 *
 * The sum of the selected elements from nums1 multiplied with the minimum of
 * the selected elements from nums2.
 * It can defined simply as: (nums1[i 0 ] + nums1[i 1 ] +...+ nums1[i k - 1 ]) *
 * min(nums2[i 0 ] , nums2[i 1 ], ... ,nums2[i k - 1 ]).
 *
 * Return the maximum possible score.
 *
 * A subsequence of indices of an array is a set that can be derived from the
 * set {0, 1, ..., n-1} by deleting some or no elements.
 *
 * Example 1:
 *
 * Input: nums1 = [1,3,3,2], nums2 = [2,1,3,4], k = 3 Output: 12 Explanation:
 * The four possible subsequence scores are: - We choose the indices 0, 1, and 2
 * with score = (1+3+3) * min(2,1,3) = 7. - We choose the indices 0, 1, and 3
 * with score = (1+3+2) * min(2,1,4) = 6. - We choose the indices 0, 2, and 3
 * with score = (1+3+2) * min(2,3,4) = 12. - We choose the indices 1, 2, and 3
 * with score = (3+3+2) * min(1,3,4) = 8. Therefore, we return the max score,
 * which is 12.
 *
 * Example 2:
 *
 * Input: nums1 = [4,2,3,1,1], nums2 = [7,5,10,9,6], k = 1 Output: 30
 * Explanation: Choosing index 2 is optimal: nums1[2] * nums2[2] = 3 * 10 = 30
 * is the maximum possible score.
 *
 * Constraints:
 *
 * n == nums1.length == nums2.length
 * 1 <= n <= 10 5
 * 0 <= nums1[i], nums2[j] <= 10 5
 * 1 <= k <= n
 */
class Solution02542 {

  class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
      int n = nums1.length;
      int[][] pairs = new int[n][2];
      for (int i = 0; i < n; i++) {
        pairs[i] = new int[] { nums2[i], nums1[i] };
      }
      Arrays.sort(pairs, (a, b) -> b[0] - a[0]);
      PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);
      long res = 0, totalSum = 0;
      for (int[] pair : pairs) {
        pq.add(pair[1]);
        totalSum += pair[1];
        if (pq.size() > k) {
          totalSum -= pq.poll();
        }
        if (pq.size() == k) {
          res = Math.max(res, totalSum * pair[0]);
        }
      }
      return res;
    }
  }

  public static void test_02542() {
    Solution02542 solution = new Solution02542();
    int[] nums1 = { 1, 3, 3, 2 };
    int[] nums2 = { 2, 1, 3, 4 };
    int k = 3;
    long maxScore = solution.new Solution().maxScore(nums1, nums2, k);
    System.out.println(maxScore);
    int[] nums3 = { 4, 2, 3, 1, 1 };
    int[] nums4 = { 7, 5, 10, 9, 6 };
    k = 1;
    maxScore = solution.new Solution().maxScore(nums3, nums4, k);
    System.out.println(maxScore);
  }

  public static void main(String[] args) {
    Solution02542.test_02542();
  }
}
