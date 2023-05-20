package net.geekhour.problems.p00200.p00209;

/**
 * ID: 00209
 * Title: Minimum Size Subarray Sum
 * Difficulty: Medium
 * Description: Given an array of positive integers nums and a positive integer
 * target, return the minimal length of a subarray whose sum is greater than or
 * equal to target. If there is no such subarray, return 0 instead.
 *
 * Example 1:
 *
 * Input: target = 7, nums = [2,3,1,2,4,3] Output: 2 Explanation: The subarray
 * [4,3] has the minimal length under the problem constraint.
 *
 * Example 2:
 *
 * Input: target = 4, nums = [1,4,4] Output: 1
 *
 * Example 3:
 *
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1] Output: 0
 *
 * Constraints:
 *
 * 1 <= target <= 10 9
 * 1 <= nums.length <= 10 5
 * 1 <= nums[i] <= 10 4
 *
 * Follow up: If you have figured out the O(n) solution, try coding another
 * solution of which the time complexity is O(n log(n)).
 */
class Solution00209 {

  public int minSubArrayLen(int target, int[] nums) {
    int result = 0;
    int sum = 0;
    int left = 0;
    int right = 0;
    while (right < nums.length) {
      sum += nums[right];
      while (sum >= target) {
        if (result == 0) {
          result = right - left + 1;
        } else {
          result = Math.min(result, right - left + 1);
        }
        sum -= nums[left];
        left++;
      }
      right++;
    }
    return result;
  }

  public static void test_00209() {
    Solution00209 solution = new Solution00209();
    int target = 7;
    int[] nums = { 2, 3, 1, 2, 4, 3 };
    int result = solution.minSubArrayLen(target, nums);
    System.out.println(result);
    int target2 = 4;
    int[] nums2 = { 1, 4, 4 };
    int result2 = solution.minSubArrayLen(target2, nums2);
    System.out.println(result2);
    int target3 = 11;
    int[] nums3 = { 1, 1, 1, 1, 1, 1, 1, 1 };
    int result3 = solution.minSubArrayLen(target3, nums3);
    System.out.println(result3);

  }

  public static void main(String[] args) {
    Solution00209.test_00209();
  }
}
