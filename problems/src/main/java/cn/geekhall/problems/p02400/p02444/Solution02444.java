package cn.geekhall.problems.p02400.p02444;

/**
 * ID: 02444
 * Title: Count Subarrays With Fixed Bounds
 * Difficulty: Hard
 * Description: You are given an integer array nums and two integers minK and
 * maxK.
 *
 * A fixed-bound subarray of nums is a subarray that satisfies the following
 * conditions:
 *
 * The minimum value in the subarray is equal to minK.
 * The maximum value in the subarray is equal to maxK.
 *
 * Return the number of fixed-bound subarrays.
 *
 * A subarray is a contiguous part of an array.
 *
 * Example 1:
 *
 * Input: nums = [1,3,5,2,7,5], minK = 1, maxK = 5 Output: 2 Explanation: The
 * fixed-bound subarrays are [1,3,5] and [1,3,5,2].
 *
 * Example 2:
 *
 * Input: nums = [1,1,1,1], minK = 1, maxK = 1 Output: 10 Explanation: Every
 * subarray of nums is a fixed-bound subarray. There are 10 possible subarrays.
 *
 * Constraints:
 *
 * 2 <= nums.length <= 10 5
 * 1 <= nums[i], minK, maxK <= 10 6
 */
class Solution02444 {

  public long countSubarrays(int[] nums, int minK, int maxK) {
    int n = nums.length;
    int leftBound = -1;
    int lastMin = -1, lastMax = -1;
    long count = 0;

    for (int i = 0; i < n; i++) {
      if (nums[i] >= minK && nums[i] <= maxK) {
        lastMin = (nums[i] == minK) ? i : lastMin;
        lastMax = (nums[i] == maxK) ? i : lastMax;
        count += Math.max(0, Math.min(lastMin, lastMax) - leftBound);
      } else {
        leftBound = i;
        lastMin = -1;
        lastMax = -1;
      }
    }

    return count;
  }

  public static void test_02444() {
    Solution02444 solution = new Solution02444();
    int[] nums = { 1, 3, 5, 2, 7, 5 };
    int minK = 1;
    int maxK = 5;
    long result = solution.countSubarrays(nums, minK, maxK);
    System.out.println(result);
    int[] nums2 = { 1, 1, 1, 1 };
    int minK2 = 1;
    int maxK2 = 1;
    long result2 = solution.countSubarrays(nums2, minK2, maxK2);
    System.out.println(result2);

  }

  public static void main(String[] args) {
    Solution02444.test_02444();
  }
}
