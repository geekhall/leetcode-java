package net.geekhour.problems.p00300.p00342;

import java.util.*;

/**
 * ID: 00342
 * Title: Power of Four
 * Difficulty: Easy
 * Description: Given an integer n, return true if it is a power of four.
 * Otherwise, return false.
 *
 * An integer n is a power of four, if there exists an integer x such that n ==
 * 4 x.
 *
 * Example 1:
 *
 * Input: n = 16 Output: true
 *
 * Example 2:
 *
 * Input: n = 5 Output: false
 *
 * Example 3:
 *
 * Input: n = 1 Output: true
 *
 * Constraints:
 *
 * -2 31 <= n <= 2 31 - 1
 *
 * Follow up: Could you solve it without loops/recursion?
 */
class Solution00342 {

  public boolean isPowerOfFour(int n) {
    if (n <= 0) {
      return false;
    }
    while (n % 4 == 0) {
      n /= 4;
    }
    return n == 1;
  }

  public static void test_00342() {
    Solution00342 solution = new Solution00342();
    System.out.println(solution.isPowerOfFour(16));
    System.out.println(solution.isPowerOfFour(5));
    System.out.println(solution.isPowerOfFour(1));
  }

  public static void main(String[] args) {
    test_00342();
  }
}
