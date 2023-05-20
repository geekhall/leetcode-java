package net.geekhour.problems.p02300.p02348;

import java.util.*;

/**
 * ID: 02348
 * Title: Number of Zero-Filled Subarrays
 * Difficulty: Medium
 * Description: Given an integer array nums, return the number of subarrays
 * filled with 0.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 * Example 1:
 *
 * Input: nums = [1,3,0,0,2,0,0,4] Output: 6 Explanation: There are 4
 * occurrences of [0] as a subarray. There are 2 occurrences of [0,0] as a
 * subarray. There is no occurrence of a subarray with a size more than 2 filled
 * with 0. Therefore, we return 6.
 *
 * Example 2:
 *
 * Input: nums = [0,0,0,2,0,0] Output: 9 Explanation: There are 5 occurrences of
 * [0] as a subarray. There are 3 occurrences of [0,0] as a subarray. There is 1
 * occurrence of [0,0,0] as a subarray. There is no occurrence of a subarray
 * with a size more than 3 filled with 0. Therefore, we return 9.
 *
 * Example 3:
 *
 * Input: nums = [2,10,2019] Output: 0 Explanation: There is no subarray filled
 * with 0. Therefore, we return 0.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10 5
 * -10 9 <= nums[i] <= 10 9
 */
class Solution02348 {

  public long zeroFilledSubarray(int[] nums) {
    long result = 0;
    int n = nums.length;
    int[] prefix = new int[n + 1];
    for (int i = 0; i < n; i++) {
      prefix[i + 1] = prefix[i] + nums[i];
    }
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i <= n; i++) {
      int key = prefix[i];
      map.put(key, map.getOrDefault(key, 0) + 1);
    }
    for (int key : map.keySet()) {
      int value = map.get(key);
      result += (long) value * (value - 1) / 2;
    }
    return result;
  }

  public static void test_02348() {
    Solution02348 solution = new Solution02348();
    int[] nums = { 1, 3, 0, 0, 2, 0, 0, 4 };
    long result = solution.zeroFilledSubarray(nums);
    System.out.println(result);
    int[] nums2 = { 0, 0, 0, 2, 0, 0 };
    long result2 = solution.zeroFilledSubarray(nums2);
    System.out.println(result2);
    int[] nums3 = { 2, 10, 2019 };
    long result3 = solution.zeroFilledSubarray(nums3);
    System.out.println(result3);
    int[] nums4 = { 0, -9, 6, -5, 0, 0, 8, 0, 0, 3, -3 };
    long result4 = solution.zeroFilledSubarray(nums4);
    System.out.println(result4);
  }

  public static void main(String[] args) {
    Solution02348.test_02348();
  }
}
