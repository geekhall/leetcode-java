package net.geekhour.problems.p01500.p01512;

import java.util.*;

/**
 * ID: 01512
 * Title: Number of Good Pairs
 * Difficulty: Easy
 * Description: Given an array of integers nums, return the number of good
 * pairs.
 *
 * A pair (i, j) is called good if nums[i] == nums[j] and i < j.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1,1,3] Output: 4 Explanation: There are 4 good pairs
 * (0,3), (0,4), (3,4), (2,5) 0-indexed.
 *
 * Example 2:
 *
 * Input: nums = [1,1,1,1] Output: 6 Explanation: Each pair in the array are
 * good.
 *
 * Example 3:
 *
 * Input: nums = [1,2,3] Output: 0
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
class Solution01512 {

  public int numIdenticalPairs(int[] nums) {
    int n = nums.length;
    int count = 0;
    for (int i = 0; i < n; i++) {
      int num = nums[i];
      for (int j = i + 1; j < n; j++) {
        if (num == nums[j]) {
          count++;
        }
      }
    }
    return count;
  }

  public static void test_01512() {
    Solution01512 solution = new Solution01512();
    int[] nums = { 1, 2, 3, 1, 1, 3 };
    int expected = 4;
    int actual = solution.numIdenticalPairs(nums);
    System.out.println("expected: " + expected + ", actual: " + actual);
    nums = new int[] { 1, 1, 1, 1 };
    expected = 6;
    actual = solution.numIdenticalPairs(nums);
    System.out.println("expected: " + expected + ", actual: " + actual);
    nums = new int[] { 1, 2, 3 };
    expected = 0;
    actual = solution.numIdenticalPairs(nums);
    System.out.println("expected: " + expected + ", actual: " + actual);
  }

  public static void main(String[] args) {
    test_01512();
  }
}
