package cn.geekhall.problems.p02300.p02390;

import java.util.*;

/**
 * ID: 02390
 * Title: Removing Stars From a String
 * Difficulty: Medium
 * Description: You are given a string s, which contains stars *.
 *
 * In one operation, you can:
 *
 * Choose a star in s.
 * Remove the closest non-star character to its left, as well as remove the star
 * itself.
 *
 * Return the string after all stars have been removed.
 *
 * Note:
 *
 * The input will be generated such that the operation is always possible.
 * It can be shown that the resulting string will always be unique.
 *
 * Example 1:
 *
 * Input: s = "leet**cod*e" Output:"lecoe" Explanation: Performing the removals
 * from left to right: - The closest character to the 1 st star is 't' in "lee t
 * **cod*e". s becomes "lee*cod*e". - The closest character to the 2 nd star is
 * 'e' in "le e *cod*e". s becomes "lecod*e". - The closest character to the 3
 * rd star is 'd' in "leco d *e". s becomes "lecoe". There are no more stars, so
 * we return "lecoe".
 *
 * Example 2:
 *
 * Input: s = "erase*****" Output:"" Explanation: The entire string is removed,
 * so we return an empty string.
 *
 * Constraints:
 *
 * 1 <= s.length <= 10 5
 * s consists of lowercase English letters and stars *.
 * The operation above can be performed on s.
 */
class Solution02390 {

  public String removeStars(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '*') {
        if (!stack.isEmpty()) {
          stack.pop();
        }
      } else {
        stack.push(c);
      }
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    return sb.reverse().toString();
  }

  public static void test_02390() {
    Solution02390 solution = new Solution02390();
    String s = "leet**cod*e";
    String result = solution.removeStars(s);
    System.out.println(result);
    String s2 = "erase*****";
    String result2 = solution.removeStars(s2);
    System.out.println(result2);
  }

  public static void main(String[] args) {
    Solution02390.test_02390();
  }
}
