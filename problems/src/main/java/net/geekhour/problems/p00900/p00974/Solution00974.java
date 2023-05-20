package net.geekhour.problems.p00900.p00974;

import java.util.Arrays;

/**
 * ID: 00974
 * Title: Subarray Sums Divisible by K
 * Difficulty: Medium
 * Description: Given an integer array nums and an integer k, return the number
 * of non-empty subarrays that have a sum divisible by k.
 *
 * A subarray is a contiguous part of an array.
 *
 * Example 1:
 *
 * Input: nums = [4,5,0,-2,-3,1], k = 5 Output: 7 Explanation: There are 7
 * subarrays with a sum divisible by k = 5: [4, 5, 0, -2, -3, 1], [5], [5, 0],
 * [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *
 * Example 2:
 *
 * Input: nums = [5], k = 9 Output: 0
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 10 4
 * -10 4 <= nums[i] <= 10 4
 * 2 <= k <= 10 4
 */
class Solution00974 {

  public int subarraysDivByK(int[] nums, int k) {
    int result = 0;
    int[] sum = new int[nums.length];
    sum[0] = nums[0];
    // 计算前缀和
    for (int i = 1; i < nums.length; i++) {
      sum[i] = sum[i - 1] + nums[i];
    }
    System.out.println(Arrays.toString(sum));
    // 计算余数
    int[] mod = new int[k];
    Arrays.fill(mod, 0);
    // 余数为0的情况
    for (int i = 0; i < nums.length; i++) {
      int m = sum[i] % k; // 余数
      if (m < 0) {
        m += k;
      }
      mod[m]++;
    }
    System.out.println(Arrays.toString(mod));
    for (int i = 0; i < k; i++) {
      if (mod[i] > 1) {
        result += (mod[i] * (mod[i] - 1)) / 2; // 组合数
      }
    }

    result += mod[0];
    return result;
  }

  public static void test_00974() {
    Solution00974 solution = new Solution00974();
    int[] nums = { 4, 5, 0, -2, -3, 1 };
    int k = 5;
    int result = solution.subarraysDivByK(nums, k);
    System.out.println(result);
    int[] nums2 = { 5 };
    k = 9;
    result = solution.subarraysDivByK(nums2, k);
    System.out.println(result);
  }

  public static void main(String[] args) {
    Solution00974.test_00974();
  }
}
