package cn.geekhall.problems.p01400.p01498;

import java.util.Arrays;

/**
 * ID:    01498
 * Title: Number of Subsequences That Satisfy the Given Sum Condition
 * Difficulty: Medium
 * Description: You are given an array of integers nums and an integer target.
 *
 * Return the number of non-empty subsequences of nums such that the sum of the minimum and maximum element on it is less or equal to target. Since the answer may be too large, return it modulo 10 9 + 7.
 *
 * Example 1:
 *
 * Input: nums = [3,5,6,7], target = 9 Output: 4 Explanation: There are 4 subsequences that satisfy the condition. [3] -> Min value + max value <= target (3 + 3 <= 9) [3,5] -> (3 + 5 <= 9) [3,5,6] -> (3 + 6 <= 9) [3,6] -> (3 + 6 <= 9)
 *
 * Example 2:
 *
 * Input: nums = [3,3,6,8], target = 10 Output: 6 Explanation: There are 6 subsequences that satisfy the condition. (nums can have repeated numbers). [3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6]
 *
 * Example 3:
 *
 * Input: nums = [2,3,3,4,6,7], target = 12 Output: 61 Explanation: There are 63 non-empty subsequences, two of them do not satisfy the condition ([6,7], [7]). Number of valid subsequences (63 - 2 = 61).
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10 5
 * 1 <= nums[i] <= 10 6
 * 1 <= target <= 10 6
 */
class Solution01498 {

  public int numSubseq(int[] nums, int target) {
    int n = nums.length;
    int mod = 1000000007;
    int[] pow = new int[n];
    pow[0] = 1;
    for (int i = 1; i < n; i++) {
      pow[i] = pow[i - 1] * 2 % mod;
    }
    Arrays.sort(nums);
    int left = 0, right = n - 1;
    int ans = 0;
    while (left <= right) {
      if (nums[left] + nums[right] > target) {
        right--;
      } else {
        ans = (ans + pow[right - left]) % mod;
        left++;
      }
    }
    return ans;
  }

  public static void test_01498() {
    Solution01498 solution = new Solution01498();
    int[] nums = {3, 5, 6, 7};
    int target = 9;
    int result = solution.numSubseq(nums, target);
    System.out.println(result);
    int[] nums2 = {3, 3, 6, 8};
    int target2 = 10;
    int result2 = solution.numSubseq(nums2, target2);
    System.out.println(result2);
    int[] nums3 = {2, 3, 3, 4, 6, 7};
    int target3 = 12;
    int result3 = solution.numSubseq(nums3, target3);
    System.out.println(result3);

  }

  public static void main(String[] args) {
    Solution01498.test_01498();
  }
}

