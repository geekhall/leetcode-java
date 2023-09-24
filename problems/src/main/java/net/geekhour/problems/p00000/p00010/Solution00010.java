package net.geekhour.problems.p00000.p00010;

import java.util.*;

/**
 * ID: 00010
 * Title: Regular Expression Matching
 * Difficulty: Hard
 * Description: Given an input string s and a pattern p, implement regular
 * expression matching with support for '.' and '*' where:
 *
 * '.' Matches any single character.​​​​
 * '*' Matches zero or more of the preceding element.
 *
 * The matching should cover the entire input string (not partial).
 *
 * Example 1:
 *
 * Input: s = "aa", p = "a" Output: false Explanation:"a" does not match the
 * entire string "aa".
 *
 * Example 2:
 *
 * Input: s = "aa", p = "a*" Output: true Explanation: '*' means zero or more of
 * the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes
 * "aa".
 *
 * Example 3:
 *
 * Input: s = "ab", p = ".*" Output: true Explanation:".*" means "zero or more
 * (*) of any character (.)".
 *
 * Constraints:
 *
 * 1 <= s.length <= 20
 * 1 <= p.length <= 20
 * s contains only lowercase English letters.
 * p contains only lowercase English letters, '.', and '*'.
 * It is guaranteed for each appearance of the character '*', there will be a
 * previous valid character to match.
 */
class Solution00010 {

  public boolean isMatch(String s, String p) {
    int sLen = s.length();
    int pLen = p.length();
    boolean[][] dp = new boolean[sLen + 1][pLen + 1];
    dp[0][0] = true;
    for (int i = 0; i <= sLen; i++) {
      for (int j = 1; j <= pLen; j++) {
        if (p.charAt(j - 1) == '*') {
          dp[i][j] = dp[i][j - 2];
          if (matches(s, p, i, j - 1)) {
            dp[i][j] = dp[i][j] || dp[i - 1][j];
          }
        } else {
          if (matches(s, p, i, j)) {
            dp[i][j] = dp[i - 1][j - 1];
          }
        }
      }
    }
    return dp[sLen][pLen];
  }

  private boolean matches(String s, String p, int i, int j) {
    if (i == 0) {
      return false;
    }
    if (p.charAt(j - 1) == '.') {
      return true;
    }
    return s.charAt(i - 1) == p.charAt(j - 1);
  }

  public static void test_00010() {
    Solution00010 solution = new Solution00010();
    String s = "aa";
    String p = "a";
    boolean expected = false;
    boolean actual = solution.isMatch(s, p);
    System.out.println("Test case 00010: expected: " + expected + ", actual: " + actual);
    s = "aa";
    p = "a*";
    expected = true;
    actual = solution.isMatch(s, p);
    System.out.println("Test case 00010: expected: " + expected + ", actual: " + actual);
    s = "ab";
    p = ".*";
    expected = true;
    actual = solution.isMatch(s, p);
    System.out.println("Test case 00010: expected: " + expected + ", actual: " + actual);

  }

  public static void main(String[] args) {
    test_00010();
  }
}
