package cn.geekhall.problems.p01800.p01838;

import java.util.Arrays;

/**
 * ID:    01838
 * Title: Frequency of the Most Frequent Element
 * Difficulty: Medium
 * Description: The frequency of an element is the number of times it occurs in an array.
 *
 * You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and increment the element at that index by 1.
 *
 * Return the maximum possible frequency of an element after performing at most k operations.
 *
 * Example 1:
 *
 * Input: nums = [1,2,4], k = 5 Output: 3 Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4]. 4 has a frequency of 3.
 *
 * Example 2:
 *
 * Input: nums = [1,4,8,13], k = 5 Output: 2 Explanation: There are multiple optimal solutions: - Increment the first element three times to make nums = [4,4,8,13]. 4 has a frequency of 2. - Increment the second element four times to make nums = [1,8,8,13]. 8 has a frequency of 2. - Increment the third element five times to make nums = [1,4,13,13]. 13 has a frequency of 2.
 *
 * Example 3:
 *
 * Input: nums = [3,9,6], k = 2 Output: 1
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10 5
 * 1 <= nums[i] <= 10 5
 * 1 <= k <= 10 5
 */
class Solution01838 {

  public int maxFrequency(int[] nums, int k) {
    int n = nums.length;
    Arrays.sort(nums);
    int left = 0;
    int right = 0;
    long total = 0;
    int ans = 1;
    while (right < n) {
      total += nums[right];
      while (total + k < (long) (right - left + 1) * nums[right]) {
        total -= nums[left];
        left++;
      }
      ans = Math.max(ans, right - left + 1);
      right++;
    }
    return ans;
  }

  public static void test_01838() {
    Solution01838 solution = new Solution01838();
    int[] nums = {1, 2, 4};
    int k = 5;
    int result = solution.maxFrequency(nums, k);
    System.out.println(result);
    int[] nums2 = {1, 4, 8, 13};
    int k2 = 5;
    int result2 = solution.maxFrequency(nums2, k2);
    System.out.println(result2);
    int[] nums3 = {3, 9, 6};
    int k3 = 2;
    int result3 = solution.maxFrequency(nums3, k3);
    System.out.println(result3);

  }

  public static void main(String[] args) {
    Solution01838.test_01838();
  }
}

