package net.geekhour.problems.p00000.p00035;

/**
 * ID: 00035
 * Title: Search Insert Position
 * Difficulty: Easy
 * Description: Given a sorted array of distinct integers and a target value,
 * return the index if the target is found. If not, return the index where it
 * would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 *
 * Input: nums = [1,3,5,6], target = 5 Output: 2
 *
 * Example 2:
 *
 * Input: nums = [1,3,5,6], target = 2 Output: 1
 *
 * Example 3:
 *
 * Input: nums = [1,3,5,6], target = 7 Output: 4
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10 4
 * -10 4 <= nums[i] <= 10 4
 * nums contains distinct values sorted in ascending order.
 * -10 4 <= target <= 10 4
 */
class Solution00035 {

  public int searchInsert(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  public static void test_00035() {
    Solution00035 solution = new Solution00035();
    int[] nums = { 1, 3, 5, 6 };
    int target = 5;
    int result = solution.searchInsert(nums, target);
    System.out.println(result);
    int[] nums2 = { 1, 3, 5, 6 };
    int target2 = 2;
    int result2 = solution.searchInsert(nums2, target2);
    System.out.println(result2);
    int[] nums3 = { 1, 3, 5, 6 };
    int target3 = 7;
    int result3 = solution.searchInsert(nums3, target3);
    System.out.println(result3);
  }

  public static void main(String[] args) {
    Solution00035.test_00035();
  }
}
