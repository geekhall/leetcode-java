package net.geekhour.problems.p01700.p01712;

/**
 * ID: 01712
 * Title: Ways to Split Array Into Three Subarrays
 * Difficulty: Medium
 * Description: A split of an integer array is good if:
 *
 * The array is split into three non-empty contiguous subarrays - named left,
 * mid, right respectively from left to right.
 * The sum of the elements in left is less than or equal to the sum of the
 * elements in mid, and the sum of the elements in mid is less than or equal to
 * the sum of the elements in right.
 *
 * Given nums, an array of non-negative integers, return the number of good ways
 * to split nums. As the number may be too large, return it modulo 10 9 + 7.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1] Output: 1 Explanation: The only good way to split nums
 * is [1] [1] [1].
 *
 * Example 2:
 *
 * Input: nums = [1,2,2,2,5,0] Output: 3 Explanation: There are three good ways
 * of splitting nums: [1] [2] [2,2,5,0] [1] [2,2] [2,5,0] [1,2] [2,2] [5,0]
 *
 * Example 3:
 *
 * Input: nums = [3,2,1] Output: 0 Explanation: There is no good way to split
 * nums.
 *
 * Constraints:
 *
 * 3 <= nums.length <= 10 5
 * 0 <= nums[i] <= 10 4
 */
class Solution01712 {

  public int waysToSplit(int[] nums) {

    int MOD = 1000000007;
    int N = nums.length;

    // prefix array
    int[] A = new int[N];
    A[0] = nums[0];
    for (int i = 1; i < N; ++i)
      A[i] = A[i - 1] + nums[i];

    int res = 0;
    for (int i = 1; i < N - 1; ++i) {
      if (A[i - 1] > (A[N - 1] - A[i - 1]) / 2)
        break; // early termination
      int left = helper(A, A[i - 1], i, true);
      int right = helper(A, A[i - 1], i, false);
      if (left == -1 || right == -1)
        continue; // none is satisfied
      res = (res + (right - left + 1) % MOD) % MOD;
    }
    return res;
  }

  private int helper(int[] A, int leftSum, int index, boolean searchLeft) {

    int N = A.length;
    int l = index, r = N - 2;
    int res = -1;

    while (l <= r) {

      int m = (r - l) / 2 + l;
      int midSum = A[m] - A[index - 1];
      int rightSum = A[N - 1] - A[m];

      if (leftSum <= midSum && midSum <= rightSum) {
        res = m;
        if (searchLeft)
          r = m - 1;
        else
          l = m + 1;
      } else if (leftSum > midSum) { // shrink left
        l = m + 1;
      } else { // shrink right
        r = m - 1;
      }
    }
    return res;
  }

  public static void test_01712() {
    Solution01712 solution = new Solution01712();
    int[] nums = { 1, 1, 1 };
    int result = solution.waysToSplit(nums);
    System.out.println(result);
    int[] nums2 = { 1, 2, 2, 2, 5, 0 };
    result = solution.waysToSplit(nums2);
    System.out.println(result);
    int[] nums3 = { 3, 2, 1 };
    result = solution.waysToSplit(nums3);
    System.out.println(result);
  }

  public static void main(String[] args) {
    Solution01712.test_01712();
  }
}
