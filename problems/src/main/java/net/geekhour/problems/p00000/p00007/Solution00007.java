package net.geekhour.problems.p00000.p00007;

import java.util.*;

/**
 * ID: 00007
 * Title: Reverse Integer
 * Difficulty: Medium
 * Description: Given a signed 32-bit integer x, return x with its digits
 * reversed. If reversing x causes the value to go outside the signed 32-bit
 * integer range [-2 31, 2 31 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or
 * unsigned).
 *
 * Example 1:
 *
 * Input: x = 123 Output: 321
 *
 * Example 2:
 *
 * Input: x = -123 Output: -321
 *
 * Example 3:
 *
 * Input: x = 120 Output: 21
 *
 * Constraints:
 *
 * -2 31 <= x <= 2 31 - 1
 */
class Solution00007 {

  public int reverse(int x) {
    int rev = 0;
    while (x != 0) {
      int pop = x % 10;
      x /= 10;
      if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
        return 0;
      }
      if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
        return 0;
      }
      rev = rev * 10 + pop;
    }
    return rev;
  }

  public static void test_00007() {
    Solution00007 solution = new Solution00007();
    //
  }

  public static void main(String[] args) {
    test_00007();
  }
}
