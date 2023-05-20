package net.geekhour.problems.p01500.p01523;

/**
 * ID: 01523
 * Title: Count Odd Numbers in an Interval Range
 * Difficulty: Easy
 * Description: Given two non-negative integers low and high. Return the count
 * of odd numbers between low and high (inclusive).
 *
 * Example 1:
 *
 * Input: low = 3, high = 7 Output: 3 Explanation: The odd numbers between 3 and
 * 7 are [3,5,7].
 *
 * Example 2:
 *
 * Input: low = 8, high = 10 Output: 1 Explanation: The odd numbers between 8
 * and 10 are [9].
 *
 * Constraints:
 *
 * 0 <= low <= high <= 10^9
 */
class Solution01523 {

  public int countOdds(int low, int high) {
    int count = 0;
    if (low % 2 == 0) {
      low++;
    }
    if (high % 2 == 0) {
      high--;
    }
    if (low <= high) {
      count = (high - low) / 2 + 1;
    }
    return count;
  }

  public static void test_01523() {
    Solution01523 solution = new Solution01523();
    int low = 3, high = 7;
    int result = solution.countOdds(low, high);
    System.out.println(result);
    int low2 = 8, high2 = 10;
    int result2 = solution.countOdds(low2, high2);
    System.out.println(result2);
  }

  public static void main(String[] args) {
    Solution01523.test_01523();
  }
}
