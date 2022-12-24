package cn.geekhall.problems.p00500.p00540;

/**
 * ID:    00540
 * Title: Single Element in a Sorted Array
 * Difficulty: Medium
 * Description: You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
 *
 * Return the single element that appears only once.
 *
 * Your solution must run in O(log n) time and O(1) space.
 *
 * Example 1:
 *
 * Input: nums = [1,1,2,3,3,4,4,8,8] Output: 2
 *
 * Example 2:
 *
 * Input: nums = [3,3,7,7,10,11,11] Output: 10
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10 5
 * 0 <= nums[i] <= 10 5
 */
class Solution00540 {

  public int singleNonDuplicate(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (mid % 2 == 1) {
        mid--;
      }
      if (nums[mid] == nums[mid + 1]) {
        left = mid + 2;
      } else {
        right = mid;
      }
    }
    return nums[left];
  }

  public static void test_00540() {
    Solution00540 solution = new Solution00540();
    int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
    int result = solution.singleNonDuplicate(nums);
    System.out.println(result);
    int[] nums2 = {3, 3, 7, 7, 10, 11, 11};
    int result2 = solution.singleNonDuplicate(nums2);
    System.out.println(result2);

  }

  public static void main(String[] args) {
    Solution00540.test_00540();
  }
}

