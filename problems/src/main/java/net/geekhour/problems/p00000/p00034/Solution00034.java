package net.geekhour.problems.p00000.p00034;

import java.util.*;

/**
 * ID: 00034
 * Title: Find First and Last Position of Element in Sorted Array
 * Difficulty: Medium
 * Description: Given an array of integers nums sorted in non-decreasing order,
 * find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4]
 *
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6 Output: [-1,-1]
 *
 * Example 3:
 *
 * Input: nums = [], target = 0 Output: [-1,-1]
 *
 * Constraints:
 *
 * 0 <= nums.length <= 10 5
 * -10 9 <= nums[i] <= 10 9
 * nums is a non-decreasing array.
 * -10 9 <= target <= 10 9
 */
class Solution00034 {

  public int[] searchRange(int[] nums, int target) {
    int n = nums.length;
    int[] result = new int[] { -1, -1 };
    if (n == 0) {
      return result;
    }
    int left = 0;
    int right = n - 1;
    int mid = 0;
    while (left <= right) {
      mid = (left + right) / 2;
      if (nums[mid] == target) {
        break;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      }
    }
    if (nums[mid] != target) {
      return result;
    }
    int i = mid;
    while (i >= 0 && nums[i] == target) {
      i--;
    }
    result[0] = i + 1;
    i = mid;
    while (i < n && nums[i] == target) {
      i++;
    }
    result[1] = i - 1;
    return result;
  }

  public static void test_00034() {
    Solution00034 solution = new Solution00034();
    int[] nums = new int[] { 5, 7, 7, 8, 8, 10 };
    int target = 8;
    for (int i : solution.searchRange(nums, target)) {
      System.out.print(i + " ");
    }
    nums = new int[] { 5, 7, 7, 8, 8, 10 };
    target = 6;
    for (int i : solution.searchRange(nums, target)) {
      System.out.print(i + " ");
    }
    nums = new int[] {};
    target = 0;
    for (int i : solution.searchRange(nums, target)) {
      System.out.print(i + " ");
    }

  }

  public static void main(String[] args) {
    test_00034();
  }
}
