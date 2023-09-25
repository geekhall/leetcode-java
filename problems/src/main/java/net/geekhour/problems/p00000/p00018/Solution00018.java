package net.geekhour.problems.p00000.p00018;

import java.util.*;

/**
 * ID: 00018
 * Title: 4Sum
 * Difficulty: Medium
 * Description: Given an array nums of n integers, return an array of all the
 * unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 *
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 *
 * You may return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,0,-1,0,-2,2], target = 0 Output:
 * [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *
 * Example 2:
 *
 * Input: nums = [2,2,2,2,2], target = 8 Output: [[2,2,2,2]]
 *
 * Constraints:
 *
 * 1 <= nums.length <= 200
 * -10 9 <= nums[i] <= 10 9
 * -10 9 <= target <= 10 9
 */
class Solution00018 {

  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);

    return result;
  }

  public static void test_00018() {
    Solution00018 solution = new Solution00018();
    int[] nums = { 1, 0, -1, 0, -2, 2 };
    int target = 0;
    List<List<Integer>> expected = Arrays.asList(Arrays.asList(-2, -1, 1, 2), Arrays.asList(-2, 0, 0, 2),
        Arrays.asList(-1, 0, 0, 1));
    List<List<Integer>> actual = solution.fourSum(nums, target);
    System.out.println("Test case 00018: expected: " + expected + ", actual: " + actual);
    nums = new int[] { 2, 2, 2, 2, 2 };
    target = 8;
    expected = Arrays.asList(Arrays.asList(2, 2, 2, 2));
    actual = solution.fourSum(nums, target);
    System.out.println("Test case 00018: expected: " + expected + ", actual: " + actual);
    nums = new int[] { 1000000000, 1000000000, 1000000000, 1000000000 };
    target = -294967296;
    expected = Arrays.asList();
    actual = solution.fourSum(nums, target);
    System.out.println("Test case 00018: expected: " + expected + ", actual: " + actual);
  }

  public static void main(String[] args) {
    test_00018();
  }
}
