package net.geekhour.problems.p00200.p00287;

/**
 * ID: 00287
 * Title: Find the Duplicate Number
 * Difficulty: Medium
 * Description: Given an array of integers nums containing n + 1 integers where
 * each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and uses only
 * constant extra space.
 *
 * Example 1:
 *
 * Input: nums = [1,3,4,2,2] Output: 2
 *
 * Example 2:
 *
 * Input: nums = [3,1,3,4,2] Output: 3
 *
 * Constraints:
 *
 * 1 <= n <= 10 5
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * All the integers in nums appear only once except for precisely one integer
 * which appears two or more times.
 *
 * Follow up:
 *
 * How can we prove that at least one duplicate number must exist in nums?
 * Can you solve the problem in linear runtime complexity?
 */
class Solution00287 {

  public int findDuplicate(int[] nums) {
    int slow = 0;
    int fast = 0;
    do {
      slow = nums[slow];
      fast = nums[nums[fast]];
    } while (slow != fast);
    int ptr1 = 0;
    int ptr2 = slow;
    while (ptr1 != ptr2) {
      ptr1 = nums[ptr1];
      ptr2 = nums[ptr2];
    }
    return ptr1;
  }

  public static void test_00287() {
    Solution00287 solution = new Solution00287();
    int[] nums = { 1, 3, 4, 2, 2 };
    int result = solution.findDuplicate(nums);
    System.out.println(result);
    int[] nums2 = { 3, 1, 3, 4, 2 };
    result = solution.findDuplicate(nums2);
    System.out.println(result);
  }

  public static void main(String[] args) {
    Solution00287.test_00287();
  }
}
