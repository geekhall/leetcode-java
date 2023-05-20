package net.geekhour.problems.p00900.p00918;

/**
 * ID: 00918
 * Title: Maximum Sum Circular Subarray
 * Difficulty: Medium
 * Description: Given a circular integer array nums of length n, return the
 * maximum possible sum of a non-empty subarray of nums.
 *
 * A circular array means the end of the array connects to the beginning of the
 * array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the
 * previous element of nums[i] is nums[(i - 1 + n) % n].
 *
 * A subarray may only include each element of the fixed buffer nums at most
 * once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does
 * not exist i <= k1, k2 <= j with k1 % n == k2 % n.
 *
 * Example 1:
 *
 * Input: nums = [1,-2,3,-2] Output: 3 Explanation: Subarray [3] has maximum sum
 * 3.
 *
 * Example 2:
 *
 * Input: nums = [5,-3,5] Output: 10 Explanation: Subarray [5,5] has maximum sum
 * 5 + 5 = 10.
 *
 * Example 3:
 *
 * Input: nums = [-3,-2,-3] Output: -2 Explanation: Subarray [-2] has maximum
 * sum -2.
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 3 * 10 4
 * -3 * 10 4 <= nums[i] <= 3 * 10 4
 */
class Solution00918 {

  public int maxSubarraySumCircular(int[] nums) {
    int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, sum = 0, curMax = 0, curMin = 0;
    for (int num : nums) {
      curMax = Math.max(curMax + num, num);
      max = Math.max(max, curMax);
      curMin = Math.min(curMin + num, num);
      min = Math.min(min, curMin);
      sum += num;
    }
    return max > 0 ? Math.max(max, sum - min) : max;
  }

  public static void test_00918() {
    Solution00918 solution = new Solution00918();
    int[] nums = { 1, -2, 3, -2 };
    int res = solution.maxSubarraySumCircular(nums);
    System.out.println(res);
    int[] nums2 = { 5, -3, 5 };
    int res2 = solution.maxSubarraySumCircular(nums2);
    System.out.println(res2);
    int[] nums3 = { -3, -2, -3 };
    int res3 = solution.maxSubarraySumCircular(nums3);
    System.out.println(res3);
  }

  public static void main(String[] args) {
    Solution00918.test_00918();
  }
}
