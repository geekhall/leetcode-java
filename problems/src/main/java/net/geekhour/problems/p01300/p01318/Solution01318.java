package net.geekhour.problems.p01300.p01318;

import java.util.*;

/**
 * ID: 01318
 * Title: Minimum Flips to Make a OR b Equal to c
 * Difficulty: Medium
 * Description: Given 3 positives numbers a, b and c. Return the minimum flips
 * required in some bits of a and b to make ( a OR b == c). (bitwise OR
 * operation).
 * Flip operation consists of change any single bit 1 to 0 or change the bit 0
 * to 1 in their binary representation.
 *
 * Example 1:
 *
 * Input: a = 2, b = 6, c = 5 Output: 3 Explanation: After flips a = 1 , b = 4 ,
 * c = 5 such that (a OR b == c)
 *
 * Example 2:
 *
 * Input: a = 4, b = 2, c = 7 Output: 1
 *
 * Example 3:
 *
 * Input: a = 1, b = 2, c = 3 Output: 0
 *
 * Constraints:
 *
 * 1 <= a <= 10^9
 * 1 <= b <= 10^9
 * 1 <= c <= 10^9
 */
class Solution01318 {

  public int minFlips(int a, int b, int c) {
    int count = 0;
    while (a > 0 || b > 0 || c > 0) {
      int aBit = a & 1;
      int bBit = b & 1;
      int cBit = c & 1;
      if (cBit == 0) {
        if (aBit == 1) {
          count++;
        }
        if (bBit == 1) {
          count++;
        }
      } else {
        if (aBit == 0 && bBit == 0) {
          count++;
        }
      }
      a >>= 1;
      b >>= 1;
      c >>= 1;
    }
    return count;
  }

  public static void test_01318() {
    Solution01318 solution = new Solution01318();
    int a = 2;
    int b = 6;
    int c = 5;
    int expected = 3;
    int actual = solution.minFlips(a, b, c);
    System.out.println("expected: " + expected + ", actual: " + actual);
    int a2 = 4;
    int b2 = 2;
    int c2 = 7;
    int expected2 = 1;
    int actual2 = solution.minFlips(a2, b2, c2);
    System.out.println("expected: " + expected2 + ", actual: " + actual2);
    int a3 = 1;
    int b3 = 2;
    int c3 = 3;
    int expected3 = 0;
    int actual3 = solution.minFlips(a3, b3, c3);
    System.out.println("expected: " + expected3 + ", actual: " + actual3);
  }

  public static void main(String[] args) {
    test_01318();
  }
}
