package cn.geekhall.problems.p01800.p01802;

/**
 * ID:    01802
 * Title: Maximum Value at a Given Index in a Bounded Array
 * Difficulty: Medium
 * Description: You are given three positive integers: n, index, and maxSum. You want to construct an array nums (0-indexed) that satisfies the following conditions:
 *
 * nums.length == n
 * nums[i] is a positive integer where 0 <= i < n.
 * abs(nums[i] - nums[i+1]) <= 1 where 0 <= i < n-1.
 * The sum of all the elements of nums does not exceed maxSum.
 * nums[index] is maximized.
 *
 * Return nums[index] of the constructed array.
 *
 * Note that abs(x) equals x if x >= 0, and -x otherwise.
 *
 * Example 1:
 *
 * Input: n = 4, index = 2, maxSum = 6 Output: 2 Explanation: nums = [1,2, 2,1] is one array that satisfies all the conditions. There are no arrays that satisfy all the conditions and have nums[2] == 3, so 2 is the maximum nums[2].
 *
 * Example 2:
 *
 * Input: n = 6, index = 1, maxSum = 10 Output: 3
 *
 * Constraints:
 *
 * 1 <= n <= maxSum <= 10 9
 * 0 <= index < n
 */
class Solution01802 {

  public int maxValue(int n, int index, int maxSum) {
    int left = 1;
    int right = maxSum;
    while (left < right) {
      int mid = left + (right - left + 1) / 2;
      if (check(n, index, maxSum, mid)) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }


  private boolean check(int n, int index, int maxSum, int mid) {
    long sum = mid;
    int left = Math.max(0, index - (mid - 1));
    int right = Math.min(n - 1, index + (mid - 1));
    sum += (long) (mid - 1) * (mid - 2) / 2;
    sum += (long) (index - left + 1) * (mid - 1);
    sum += (long) (right - index + 1) * (mid - 1);
    return sum <= maxSum;
  }

  public static void test_01802() {
    Solution01802 solution = new Solution01802();
    int n = 4;
    int index = 2;
    int maxSum = 6;
    int result = solution.maxValue(n, index, maxSum);
    System.out.println(result);
    int n2 = 6;
    int index2 = 1;
    int maxSum2 = 10;
    int result2 = solution.maxValue(n2, index2, maxSum2);
    System.out.println(result2);
  }

  public static void main(String[] args) {
    Solution01802.test_01802();
  }
}

