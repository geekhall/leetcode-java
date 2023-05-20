package net.geekhour.problems.p00700.p00704;

/**
 * ID: 00704
 * Title: Binary Search
 * Difficulty: Easy
 * Description: Given an array of integers nums which is sorted in ascending
 * order, and an integer target, write a function to search target in nums. If
 * target exists, then return its index. Otherwise, return -1.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 9 Output: 4 Explanation: 9 exists in
 * nums and its index is 4
 *
 * Example 2:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 2 Output: -1 Explanation: 2 does not
 * exist in nums so return -1
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10 4
 * -10 4 < nums[i], target < 10 4
 * All the integers in nums are unique.
 * nums is sorted in ascending order.
 */
class Solution00704 {

  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }

  public static void test_00704() {
    Solution00704 solution = new Solution00704();
    int[] nums = { -1, 0, 3, 5, 9, 12 };
    int target = 9;
    int result = solution.search(nums, target);
    System.out.println(result);
    int[] nums2 = { -1, 0, 3, 5, 9, 12 };
    int target2 = 2;
    int result2 = solution.search(nums2, target2);
    System.out.println(result2);
  }

  public static void main(String[] args) {
    Solution00704.test_00704();
  }
}
