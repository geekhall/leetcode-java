package net.geekhour.problems.p00000.p00014;

import java.util.*;

/**
 * ID: 00014
 * Title: Longest Common Prefix
 * Difficulty: Easy
 * Description: Write a function to find the longest common prefix string
 * amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"] Output:"fl"
 *
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"] Output:"" Explanation: There is no
 * common prefix among the input strings.
 *
 * Constraints:
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 */
class Solution00014 {

  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) {
      return "";
    }
    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++) {
      while (strs[i].indexOf(prefix) != 0) {
        prefix = prefix.substring(0, prefix.length() - 1);
        if (prefix.isEmpty()) {
          return "";
        }
      }
    }
    return prefix;
  }

  public static void test_00014() {
    Solution00014 solution = new Solution00014();
    String[] strs = { "flower", "flow", "flight" };
    String expected = "fl";
    String actual = solution.longestCommonPrefix(strs);
    System.out.println("Test case 00014: expected: " + expected + ", actual: " + actual);
    strs = new String[] { "dog", "racecar", "car" };
    expected = "";
    actual = solution.longestCommonPrefix(strs);
    System.out.println("Test case 00014: expected: " + expected + ", actual: " + actual);

  }

  public static void main(String[] args) {
    test_00014();
  }
}
