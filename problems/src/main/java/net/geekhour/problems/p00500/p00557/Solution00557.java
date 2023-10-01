package net.geekhour.problems.p00500.p00557;

import java.util.*;

/**
 * ID: 00557
 * Title: Reverse Words in a String III
 * Difficulty: Easy
 * Description: Given a string s, reverse the order of characters in each word
 * within a sentence while still preserving whitespace and initial word order.
 *
 * Example 1:
 *
 * Input: s = "Let's take LeetCode contest" Output:"s'teL ekat edoCteeL tsetnoc"
 *
 * Example 2:
 *
 * Input: s = "God Ding" Output:"doG gniD"
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 10 4
 * s contains printable ASCII characters.
 * s does not contain any leading or trailing spaces.
 * There is at least one word in s.
 * All the words in s are separated by a single space.
 */
class Solution00557 {

  public String reverseWords(String s) {
    StringBuilder sb = new StringBuilder();
    int n = s.length();
    int i = 0;
    while (i < n) {
      int j = i;
      while (j < n && s.charAt(j) != ' ') {
        j++;
      }
      for (int k = j - 1; k >= i; k--) {
        sb.append(s.charAt(k));
      }
      if (j < n) {
        sb.append(' ');
      }
      i = j + 1;
    }
    return sb.toString();
  }

  public static void test_00557() {
    Solution00557 solution = new Solution00557();
    String s = "Let's take LeetCode contest";
    System.out.println(solution.reverseWords(s));
    s = "God Ding";
    System.out.println(solution.reverseWords(s));

  }

  public static void main(String[] args) {
    test_00557();
  }
}
