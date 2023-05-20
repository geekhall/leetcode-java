package net.geekhour.problems.p00500.p00556;

import java.util.Arrays;

/**
 * ID: 00556
 * Title: Next Greater Element III
 * Difficulty: Medium
 * Description: Given a positive integer n, find the smallest integer which has
 * exactly the same digits existing in the integer n and is greater in value
 * than n. If no such positive integer exists, return -1.
 *
 * Note that the returned integer should fit in 32-bit integer, if there is a
 * valid answer but it does not fit in 32-bit integer, return -1.
 *
 * Example 1:
 *
 * Input: n = 12 Output: 21
 *
 * Example 2:
 *
 * Input: n = 21 Output: -1
 *
 * Constraints:
 *
 * 1 <= n <= 2 31 - 1
 */
class Solution00556 {

  public int nextGreaterElement(int n) {
    char[] chars = String.valueOf(n).toCharArray();
    int i = chars.length - 2;
    while (i >= 0 && chars[i] >= chars[i + 1]) {
      i--;
    }
    if (i < 0) {
      return -1;
    }
    int j = chars.length - 1;
    while (j >= 0 && chars[j] <= chars[i]) {
      j--;
    }
    swap(chars, i, j);
    reverse(chars, i + 1);
    long val = Long.parseLong(new String(chars));
    return (val > Integer.MAX_VALUE) ? -1 : (int) val;
  }

  /**
   * reverse chars[i] to chars[chars.length - 1]
   */
  private void reverse(char[] chars, int i) {
    int j = chars.length - 1;
    while (i < j) {
      swap(chars, i, j);
      i++;
      j--;
    }
  }

  /**
   * swap chars[i] and chars[j]
   */
  private void swap(char[] chars, int i, int j) {
    char temp = chars[i];
    chars[i] = chars[j];
    chars[j] = temp;
  }

  public static void test_00556() {
    Solution00556 solution = new Solution00556();
    int n = 12;
    int result = solution.nextGreaterElement(n);
    System.out.println(result);
    int n2 = 21;
    int result2 = solution.nextGreaterElement(n2);
    System.out.println(result2);
  }

  public static void main(String[] args) {
    Solution00556.test_00556();
  }
}
