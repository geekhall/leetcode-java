package net.geekhour.problems.p00300.p00316;

import java.util.*;

/**
 * ID: 00316
 * Title: Remove Duplicate Letters
 * Difficulty: Medium
 * Description: Given a string s, remove duplicate letters so that every letter
 * appears once and only once. You must make sure your result is the smallest in
 * lexicographical order among all possible results.
 *
 * Example 1:
 *
 * Input: s = "bcabc" Output:"abc"
 *
 * Example 2:
 *
 * Input: s = "cbacdcbc" Output:"acdb"
 *
 * Constraints:
 *
 * 1 <= s.length <= 10 4
 * s consists of lowercase English letters.
 *
 * Note: This question is the same as 1081:
 * https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 */
class Solution00316 {

  public String removeDuplicateLetters(String s) {
    int[] count = new int[26];
    boolean[] used = new boolean[26];
    char[] chars = s.toCharArray();
    for (char c : chars) {
      count[c - 'a']++;
    }
    Stack<Character> stack = new Stack<>();
    for (char c : chars) {
      count[c - 'a']--;
      if (used[c - 'a']) {
        continue;
      }
      while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
        used[stack.pop() - 'a'] = false;
      }
      stack.push(c);
      used[c - 'a'] = true;
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    return sb.reverse().toString();
  }

  public static void test_00316() {
    Solution00316 solution = new Solution00316();
    System.out.println(solution.removeDuplicateLetters("bcabc"));
    System.out.println(solution.removeDuplicateLetters("cbacdcbc"));
  }

  public static void main(String[] args) {
    test_00316();
  }
}
