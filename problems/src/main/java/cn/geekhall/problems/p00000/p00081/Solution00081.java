package cn.geekhall.problems.p00000.p00081;

/**
 * ID:    00081
 * Title: Search in Rotated Sorted Array II
 * Difficulty: Medium
 * Description: There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
 *
 * Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
 *
 * Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.
 *
 * You must decrease the overall operation steps as much as possible.
 *
 * Example 1:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 0 Output: true
 *
 * Example 2:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 3 Output: false
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5000
 * -10 4 <= nums[i] <= 10 4
 * nums is guaranteed to be rotated at some pivot.
 * -10 4 <= target <= 10 4
 *
 * Follow up: This problem is similar to Search in Rotated Sorted Array, but nums may contain duplicates. Would this affect the runtime complexity? How and why?
 */
class Solution00081 {

  public boolean search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return true;
      }
      if (nums[left] == nums[mid]) {
        left++;
        continue;
      }
      if (nums[left] < nums[mid]) {
        if (nums[left] <= target && target < nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {
        if (nums[mid] < target && target <= nums[right]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }
    return false;
  }

  public static void test_00081() {
    Solution00081 solution = new Solution00081();
    int[] nums = {2, 5, 6, 0, 0, 1, 2};
    int target = 0;
    boolean result = solution.search(nums, target);
    System.out.println(result);
    int[] nums2 = {2, 5, 6, 0, 0, 1, 2};
    target = 3;
    result = solution.search(nums2, target);
    System.out.println(result);
  }

  public static void main(String[] args) {
    Solution00081.test_00081();
  }
}

