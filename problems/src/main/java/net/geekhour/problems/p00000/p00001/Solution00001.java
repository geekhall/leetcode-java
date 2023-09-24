package net.geekhour.problems.p00000.p00001;

import java.util.*;

/**
 * ID: 00001
 * Title: Two Sum
 * Difficulty: Easy
 * Description: Given an array of integers nums and an integer target, return
 * indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 *
 * You can return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9 Output: [0,1] Explanation: Because
 * nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6 Output: [1,2]
 *
 * Example 3:
 *
 * Input: nums = [3,3], target = 6 Output: [0,1]
 *
 * Constraints:
 *
 * 2 <= nums.length <= 10 4
 * -10 9 <= nums[i] <= 10 9
 * -10 9 <= target <= 10 9
 * Only one valid answer exists.
 *
 * Follow-up: Can you come up with an algorithm that is less than O(n 2) time
 * complexity?
 */
class Solution00001 {

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    int[] result = new int[2];
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      int diff = target - num;
      if (map.containsKey(diff)) {
        result[0] = map.get(diff);
        result[1] = i;
        break;
      }
      map.put(num, i);
    }
    return result;
  }

  public static void test_00001() {
    Solution00001 solution = new Solution00001();
    int[] nums = { 2, 7, 11, 15 };
    int target = 9;
    int[] expected = { 0, 1 };
    int[] actual = solution.twoSum(nums, target);
    System.out
        .println("Test case 00001: expected: " + Arrays.toString(expected) + ", actual: " + Arrays.toString(actual));
    nums = new int[] { 3, 2, 4 };
    target = 6;
    expected = new int[] { 1, 2 };
    actual = solution.twoSum(nums, target);
    System.out
        .println("Test case 00001: expected: " + Arrays.toString(expected) + ", actual: " + Arrays.toString(actual));
    nums = new int[] { 3, 3 };
    target = 6;
    expected = new int[] { 0, 1 };
    actual = solution.twoSum(nums, target);
    System.out
        .println("Test case 00001: expected: " + Arrays.toString(expected) + ", actual: " + Arrays.toString(actual));

  }

  public static void main(String[] args) {
    test_00001();
  }
}
