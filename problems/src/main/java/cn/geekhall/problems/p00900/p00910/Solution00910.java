package cn.geekhall.problems.p00900.p00910;

import java.util.Arrays;

/**
 * ID:    00910
 * Title: Smallest Range II
 * Difficulty: Medium
 * Description: You are given an integer array nums and an integer k.
 *
 * For each index i where 0 <= i < nums.length, change nums[i] to be either nums[i] + k or nums[i] - k.
 *
 * The score of nums is the difference between the maximum and minimum elements in nums.
 *
 * Return the minimum score of nums after changing the values at each index.
 *
 * Example 1:
 *
 * Input: nums = [1], k = 0 Output: 0 Explanation: The score is max(nums) - min(nums) = 1 - 1 = 0.
 *
 * Example 2:
 *
 * Input: nums = [0,10], k = 2 Output: 6 Explanation: Change nums to be [2, 8]. The score is max(nums) - min(nums) = 8 - 2 = 6.
 *
 * Example 3:
 *
 * Input: nums = [1,3,6], k = 3 Output: 3 Explanation: Change nums to be [4, 6, 3]. The score is max(nums) - min(nums) = 6 - 3 = 3.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10 4
 * 0 <= nums[i] <= 10 4
 * 0 <= k <= 10 4
 */
class Solution00910 {

  public int smallestRangeII(int[] nums, int k) {
    Arrays.sort(nums);
    int n = nums.length;
    int ans = nums[n - 1] - nums[0];
    for (int i = 0; i < n - 1; i++) {
      int max = Math.max(nums[i] + k, nums[n - 1] - k);
      int min = Math.min(nums[0] + k, nums[i + 1] - k);
      ans = Math.min(ans, max - min);
    }
    return ans;
  }

  public static void test_00910() {
    Solution00910 solution = new Solution00910();
    int[] nums = {1, 3, 6};
    int k = 3;
    int result = solution.smallestRangeII(nums, k);
    System.out.println(result); // 3
  }

  public static void main(String[] args) {
    Solution00910.test_00910();
  }
}

