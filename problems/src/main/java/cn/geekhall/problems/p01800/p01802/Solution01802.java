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
    //binary search should be good for us
    int leftCnt = index, rightCnt = n - index - 1;
    int left = 1, right = maxSum;
    int res = 0;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      long leftSum = getSum(mid-1, leftCnt), rightSum = getSum(mid-1, rightCnt);
      if (leftSum + rightSum + (long)mid > maxSum) {
        right = mid - 1;
      } else {
        res = mid;
        left = mid + 1;
      }
    }
    return res;
  }

  private long getSum(int x, int cnt) {
    if (x >= cnt) {
      return ((long)x + (long)(x - cnt + 1)) * (long)cnt / 2;
    } else {
      return ((long)x + 1) * (long)x / 2 + (long)(cnt-x);
    }
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

