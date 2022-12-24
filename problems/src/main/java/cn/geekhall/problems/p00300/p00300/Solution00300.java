package cn.geekhall.problems.p00300.p00300;

/**
 * ID:    00300
 * Title: Longest Increasing Subsequence
 * Difficulty: Medium
 * Description: Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18] Output: 4 Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 *
 * Example 2:
 *
 * Input: nums = [0,1,0,3,2,3] Output: 4
 *
 * Example 3:
 *
 * Input: nums = [7,7,7,7,7,7,7] Output: 1
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2500
 * -10 4 <= nums[i] <= 10 4
 *
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 */
class Solution00300 {

  public int lengthOfLIS(int[] nums) {
    int len = nums.length;
    if (len == 0) {
      return 0;
    }
    int[] dp = new int[len];
    dp[0] = 1;
    int max = 1;
    for (int i = 1; i < len; i++) {
      int maxVal = 0;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          maxVal = Math.max(maxVal, dp[j]);
        }
      }
      dp[i] = maxVal + 1;
      max = Math.max(max, dp[i]);
    }
    return max;
  }

  public static void test_00300() {
    Solution00300 solution = new Solution00300();
    int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
    int result = solution.lengthOfLIS(nums);
    System.out.println(result);
    int[] nums2 = {0, 1, 0, 3, 2, 3};
    result = solution.lengthOfLIS(nums2);
    System.out.println(result);
    int[] nums3 = {7, 7, 7, 7, 7, 7, 7};
    result = solution.lengthOfLIS(nums3);
    System.out.println(result);
  }

  public static void main(String[] args) {
    Solution00300.test_00300();
  }
}

