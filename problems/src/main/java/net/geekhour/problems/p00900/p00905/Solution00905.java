package net.geekhour.problems.p00900.p00905;

import java.util.*;

/**
 * ID: 00905
 * Title: Sort Array By Parity
 * Difficulty: Easy
 * Description: Given an integer array nums, move all the even integers at the
 * beginning of the array followed by all the odd integers.
 *
 * Return any array that satisfies this condition.
 *
 * Example 1:
 *
 * Input: nums = [3,1,2,4] Output: [2,4,3,1] Explanation: The outputs [4,2,3,1],
 * [2,4,1,3], and [4,2,1,3] would also be accepted.
 *
 * Example 2:
 *
 * Input: nums = [0] Output: [0]
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5000
 * 0 <= nums[i] <= 5000
 */
class Solution00905 {

  public int[] sortArrayByParity(int[] nums) {
    int[] result = new int[nums.length];
    int even = 0;
    int odd = nums.length - 1;
    for (int num : nums) {
      if (num % 2 == 0) {
        result[even++] = num;
      } else {
        result[odd--] = num;
      }
    }
    return result;
  }

  public static void test_00905() {
    Solution00905 solution = new Solution00905();
    System.out.println(Arrays.toString(solution.sortArrayByParity(new int[] { 3, 1, 2, 4 })));
    System.out.println(Arrays.toString(solution.sortArrayByParity(new int[] { 0 })));
  }

  public static void main(String[] args) {
    test_00905();
  }
}
