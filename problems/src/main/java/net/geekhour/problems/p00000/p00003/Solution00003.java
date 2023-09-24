package net.geekhour.problems.p00000.p00003;

import java.util.*;

/**
 * ID: 00003
 * Title: Longest Substring Without Repeating Characters
 * Difficulty: Medium
 * Description: Given a string s, find the length of the longest substring
 * without repeating characters.
 *
 * Example 1:
 *
 * Input: s = "abcabcbb" Output: 3 Explanation: The answer is "abc", with the
 * length of 3.
 *
 * Example 2:
 *
 * Input: s = "bbbbb" Output: 1 Explanation: The answer is "b", with the length
 * of 1.
 *
 * Example 3:
 *
 * Input: s = "pwwkew" Output: 3 Explanation: The answer is "wke", with the
 * length of 3. Notice that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 10 4
 * s consists of English letters, digits, symbols and spaces.
 */
class Solution00003 {

  public int lengthOfLongestSubstring(String s) {
    int max = 0;
    int len = s.length();
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0, j = 0; j < len; j++) {
      char c = s.charAt(j);
      if (map.containsKey(c)) {
        i = Math.max(i, map.get(c));
      }
      max = Math.max(max, j - i + 1);
      map.put(c, j + 1);
    }
    return max;
  }

  public static void test_00003() {
    Solution00003 solution = new Solution00003();
    String s = "abcabcbb";
    int expected = 3;
    int actual = solution.lengthOfLongestSubstring(s);
    System.out.println("Test case 00003: expected: " + expected + ", actual: " + actual);
    s = "bbbbb";
    expected = 1;
    actual = solution.lengthOfLongestSubstring(s);
    System.out.println("Test case 00003: expected: " + expected + ", actual: " + actual);
    s = "pwwkew";
    expected = 3;
    actual = solution.lengthOfLongestSubstring(s);
    System.out.println("Test case 00003: expected: " + expected + ", actual: " + actual);

  }

  public static void main(String[] args) {
    test_00003();
  }
}
