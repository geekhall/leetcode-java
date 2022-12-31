package cn.geekhall.problems.p01700.p01712;

/**
 * ID:    01712
 * Title: Ways to Split Array Into Three Subarrays
 * Difficulty: Medium
 * Description: A split of an integer array is good if:
 *
 * The array is split into three non-empty contiguous subarrays - named left, mid, right respectively from left to right.
 * The sum of the elements in left is less than or equal to the sum of the elements in mid, and the sum of the elements in mid is less than or equal to the sum of the elements in right.
 *
 * Given nums, an array of non-negative integers, return the number of good ways to split nums. As the number may be too large, return it modulo 10 9 + 7.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1] Output: 1 Explanation: The only good way to split nums is [1] [1] [1].
 *
 * Example 2:
 *
 * Input: nums = [1,2,2,2,5,0] Output: 3 Explanation: There are three good ways of splitting nums: [1] [2] [2,2,5,0] [1] [2,2] [2,5,0] [1,2] [2,2] [5,0]
 *
 * Example 3:
 *
 * Input: nums = [3,2,1] Output: 0 Explanation: There is no good way to split nums.
 *
 * Constraints:
 *
 * 3 <= nums.length <= 10 5
 * 0 <= nums[i] <= 10 4
 */
class Solution01712 {

  public int waysToSplit(int[] nums) {
    int mod = 1000000007;
    int n = nums.length;
    int[] preSum = new int[n];
    preSum[0] = nums[0];
    for (int i = 1; i < n; i++) {
      preSum[i] = preSum[i - 1] + nums[i];
    }
    int result = 0;
    for (int i = 0; i < n - 2; i++) {
      int left = preSum[i];
      int right = preSum[n - 1] - preSum[i];
      int mid = preSum[n - 1] - left - right;
      if (left > mid || mid > right) {
        continue;
      }
      int leftIndex = i + 1;
      int rightIndex = n - 1;
      while (leftIndex < rightIndex) {
        int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
        int leftSum = preSum[midIndex - 1] - preSum[i];
        int rightSum = preSum[n - 1] - preSum[midIndex - 1];
        if (leftSum > rightSum) {
          rightIndex = midIndex;
        } else {
          leftIndex = midIndex + 1;
        }
      }
      int leftSum = preSum[leftIndex - 1] - preSum[i];
      int rightSum = preSum[n - 1] - preSum[leftIndex - 1];
      if (leftSum <= rightSum) {
        result = (result + (leftIndex - i)) % mod;
      }
    }
    return result;
  }

  public static void test_01712() {
    Solution01712 solution = new Solution01712();
    int[] nums = {1, 1, 1};
    int result = solution.waysToSplit(nums);
    System.out.println(result);
    int[] nums2 = {1, 2, 2, 2, 5, 0};
    result = solution.waysToSplit(nums2);
    System.out.println(result);
    int[] nums3 = {3, 2, 1};
    result = solution.waysToSplit(nums3);
    System.out.println(result);
  }

  public static void main(String[] args) {
    Solution01712.test_01712();
  }
}

