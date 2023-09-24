package net.geekhour.problems.p00000.p00015;

import java.util.*;

/**
 * ID: 00015
 * Title: 3Sum
 * Difficulty: Medium
 * Description: Given an integer array nums, return all the triplets [nums[i],
 * nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j]
 * + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]] Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0. nums[1] + nums[2] + nums[4] =
 * 0 + 1 + (-1) = 0. nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0. The
 * distinct triplets are [-1,0,1] and [-1,-1,2]. Notice that the order of the
 * output and the order of the triplets does not matter.
 *
 * Example 2:
 *
 * Input: nums = [0,1,1] Output: [] Explanation: The only possible triplet does
 * not sum up to 0.
 *
 * Example 3:
 *
 * Input: nums = [0,0,0] Output: [[0,0,0]] Explanation: The only possible
 * triplet sums up to 0.
 *
 * Constraints:
 *
 * 3 <= nums.length <= 3000
 * -10 5 <= nums[i] <= 10 5
 */
class Solution00015 {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      if (i == 0 || nums[i] != nums[i - 1]) {
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
          int sum = nums[i] + nums[left] + nums[right];
          if (sum == 0) {
            result.add(Arrays.asList(nums[i], nums[left], nums[right]));
            while (left < right && nums[left] == nums[left + 1]) {
              left++;
            }
            while (left < right && nums[right] == nums[right - 1]) {
              right--;
            }
            left++;
            right--;
          } else if (sum < 0) {
            left++;
          } else {
            right--;
          }
        }
      }
    }
    return result;
  }

  public static void test_00015() {
    Solution00015 solution = new Solution00015();
    int[] nums = { -1, 0, 1, 2, -1, -4 };
    List<List<Integer>> expected = Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1));
    List<List<Integer>> actual = solution.threeSum(nums);
    System.out.println("Test case 00015: expected: " + expected + ", actual: " + actual);
    nums = new int[] { 0, 1, 1 };
    expected = new ArrayList<>();
    actual = solution.threeSum(nums);
    System.out.println("Test case 00015: expected: " + expected + ", actual: " + actual);
    nums = new int[] { 0, 0, 0 };
    expected = Arrays.asList(Arrays.asList(0, 0, 0));
    actual = solution.threeSum(nums);
    System.out.println("Test case 00015: expected: " + expected + ", actual: " + actual);

  }

  public static void main(String[] args) {
    test_00015();
  }
}
