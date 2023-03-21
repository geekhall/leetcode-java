package cn.geekhall.problems.p02300.p02348;

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
    long count = 0;
    int len = nums.length;
    int zeroCount = 0;
    for (int i = 0; i < len; i++) {
      if (nums[i] == 0) {
        zeroCount++;
      } else {
        if (zeroCount > 0) {
          count += (zeroCount + 1) * zeroCount / 2;
          zeroCount = 0;
        }
      }
    }
    if (zeroCount > 0) {
      count += (zeroCount + 1) * zeroCount / 2;
    }
    return count;
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
  }

  public static void main(String[] args) {
    Solution02348.test_02348();
  }
}
