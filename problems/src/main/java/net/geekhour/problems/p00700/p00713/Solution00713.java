package net.geekhour.problems.p00700.p00713;

/**
 * ID: 00713
 * Title: Subarray Product Less Than K
 * Difficulty: Medium
 * Description: Given an array of integers nums and an integer k, return the
 * number of contiguous subarrays where the product of all the elements in the
 * subarray is strictly less than k.
 *
 * Example 1:
 *
 * Input: nums = [10,5,2,6], k = 100 Output: 8 Explanation: The 8 subarrays that
 * have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6],
 * [5, 2, 6] Note that [10, 5, 2] is not included as the product of 100 is not
 * strictly less than k.
 *
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 0 Output: 0
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 10 4
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 10 6
 */
class Solution00713 {

  public int numSubarrayProductLessThanK(int[] nums, int k) {
    int result = 0;
    int left = 0;
    int right = 0;
    int product = 1;
    while (right < nums.length) {
      product *= nums[right];
      while (left <= right && product >= k) {
        product /= nums[left];
        left++;
      }
      result += right - left + 1;
      right++;
    }
    return result;
  }

  public static void test_00713() {
    Solution00713 solution = new Solution00713();
    int[] nums = { 10, 5, 2, 6 };
    int k = 100;
    int result = solution.numSubarrayProductLessThanK(nums, k);
    System.out.println(result);
  }

  public static void main(String[] args) {
    Solution00713.test_00713();
  }
}
