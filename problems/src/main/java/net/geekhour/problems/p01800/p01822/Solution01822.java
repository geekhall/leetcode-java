package net.geekhour.problems.p01800.p01822;

import java.util.*;

/**
 * ID: 01822
 * Title: Sign of the Product of an Array
 * Difficulty: Easy
 * Description: There is a function signFunc(x) that returns:
 *
 * 1 if x is positive.
 * -1 if x is negative.
 * 0 if x is equal to 0.
 *
 * You are given an integer array nums. Let product be the product of all values
 * in the array nums.
 *
 * Return signFunc(product).
 *
 * Example 1:
 *
 * Input: nums = [-1,-2,-3,-4,3,2,1] Output: 1 Explanation: The product of all
 * values in the array is 144, and signFunc(144) = 1
 *
 * Example 2:
 *
 * Input: nums = [1,5,0,2,-3] Output: 0 Explanation: The product of all values
 * in the array is 0, and signFunc(0) = 0
 *
 * Example 3:
 *
 * Input: nums = [-1,1,-1,1,-1] Output: -1 Explanation: The product of all
 * values in the array is -1, and signFunc(-1) = -1
 *
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * -100 <= nums[i] <= 100
 */
class Solution01822 {

  public int arraySign(int[] nums) {
    int sign = 1;
    for (int n : nums) {
      if (n == 0) {
        return 0;
      } else if (n < 0) {
        sign *= -1;
      }
    }
    return sign;
  }

  public static void test_01822() {
    Solution01822 solution = new Solution01822();
    int[] nums = { -1, -2, -3, -4, 3, 2, 1 };
    int sign = solution.arraySign(nums);
    System.out.println(sign);
    int[] nums2 = { 1, 5, 0, 2, -3 };
    int sign2 = solution.arraySign(nums2);
    System.out.println(sign2);
  }

  public static void main(String[] args) {
    Solution01822.test_01822();
  }
}
