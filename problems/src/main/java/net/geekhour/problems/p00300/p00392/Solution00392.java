package net.geekhour.problems.p00300.p00392;

import java.util.*;

/**
 * ID: 00392
 * Title: Is Subsequence
 * Difficulty: Easy
 * Description: Given two strings s and t, return true if s is a subsequence of
 * t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (i.e., "ace" is a
 * subsequence of " a b c d e" while "aec" is not).
 *
 * Example 1:
 *
 * Input: s = "abc", t = "ahbgdc" Output: true
 *
 * Example 2:
 *
 * Input: s = "axc", t = "ahbgdc" Output: false
 *
 * Constraints:
 *
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10 4
 * s and t consist only of lowercase English letters.
 *
 * Follow up: Suppose there are lots of incoming s, say s 1, s 2, ..., s k where
 * k >= 10 9, and you want to check one by one to see if t has its subsequence.
 * In this scenario, how would you change your code?
 */
class Solution00392 {

  public boolean isSubsequence(String s, String t) {
    int m = s.length();
    int n = t.length();
    int i = 0, j = 0;
    while (i < m && j < n) {
      if (s.charAt(i) == t.charAt(j)) {
        i++;
      }
      j++;
    }
    return i == m;
  }

  public static void test_00392() {
    Solution00392 solution = new Solution00392();
    String s = "abc";
    String t = "ahbgdc";
    boolean expected = true;
    boolean actual = solution.isSubsequence(s, t);
    System.out.println("Test case 00392: expected: " + expected + ", actual: " + actual);
    s = "axc";
    t = "ahbgdc";
    expected = false;
    actual = solution.isSubsequence(s, t);
    System.out.println("Test case 00392: expected: " + expected + ", actual: " + actual);
  }

  public static void main(String[] args) {
    test_00392();
  }
}
