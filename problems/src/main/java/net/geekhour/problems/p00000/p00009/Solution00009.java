package net.geekhour.problems.p00000.p00009;

import java.util.*;

/**
 * ID: 00009
 * Title: Palindrome Number
 * Difficulty: Easy
 * Description: Given an integer x, return true if x is a palindrome, and false
 * otherwise.
 *
 * Example 1:
 *
 * Input: x = 121 Output: true Explanation: 121 reads as 121 from left to right
 * and from right to left.
 *
 * Example 2:
 *
 * Input: x = -121 Output: false Explanation: From left to right, it reads -121.
 * From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 * Example 3:
 *
 * Input: x = 10 Output: false Explanation: Reads 01 from right to left.
 * Therefore it is not a palindrome.
 *
 * Constraints:
 *
 * -2 31 <= x <= 2 31 - 1
 *
 * Follow up: Could you solve it without converting the integer to a string?
 */
class Solution00009 {

  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }
    int rev = 0;
    int temp = x;
    while (temp != 0) {
      int pop = temp % 10;
      temp /= 10;
      rev = rev * 10 + pop;
    }
    return rev == x;
  }

  public static void test_00009() {
    Solution00009 solution = new Solution00009();
    int x = 121;
    boolean expected = true;
    boolean actual = solution.isPalindrome(x);
    System.out.println("Test case 00009: expected: " + expected + ", actual: " + actual);
    x = -121;
    expected = false;
    actual = solution.isPalindrome(x);
    System.out.println("Test case 00009: expected: " + expected + ", actual: " + actual);
    x = 10;
    expected = false;
    actual = solution.isPalindrome(x);
    System.out.println("Test case 00009: expected: " + expected + ", actual: " + actual);

  }

  public static void main(String[] args) {
    test_00009();
  }
}
