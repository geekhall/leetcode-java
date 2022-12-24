package cn.geekhall.problems.p00600.p00611;

import java.util.Arrays;

/**
 * ID:    00611
 * Title: Valid Triangle Number
 * Difficulty: Medium
 * Description: Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
 *
 * Example 1:
 *
 * Input: nums = [2,2,3,4] Output: 3 Explanation: Valid combinations are: 2,3,4 (using the first 2) 2,3,4 (using the second 2) 2,2,3
 *
 * Example 2:
 *
 * Input: nums = [4,2,3,4] Output: 4
 *
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 */
class Solution00611 {

  public int triangleNumber(int[] nums) {
    // binary search
    Arrays.sort(nums);
    int result = 0;
    int len = nums.length;
    for (int i = 0; i < len; i++) {
      for (int j = i + 1; j < len; j++) {
        int left = j + 1;
        int right = len - 1;
        int k = j;
        while (left <= right) {
          int mid = (left + right) / 2;
          if (nums[mid] < nums[i] + nums[j]) {
            k = mid;
            left = mid + 1;
          } else {
            right = mid - 1;
          }
        }
        result += k - j;
      }
    }
    return result;
  }

  public static void test_00611() {
    Solution00611 solution = new Solution00611();
    int[] nums = {2, 2, 3, 4};
    int result = solution.triangleNumber(nums);
    System.out.println(result);
    int[] nums2 = {4, 2, 3, 4};
    result = solution.triangleNumber(nums2);
    System.out.println(result);
    int[] nums3 = {7, 0, 0, 0};
    result = solution.triangleNumber(nums3);
    System.out.println(result); // 0

  }

  public static void main(String[] args) {
    Solution00611.test_00611();
  }
}

