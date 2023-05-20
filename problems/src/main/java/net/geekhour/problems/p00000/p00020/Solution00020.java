package net.geekhour.problems.p00000.p00020;

import java.util.*;

/**
 * ID: 00020
 * Title: Valid Parentheses
 * Difficulty: Easy
 * Description: Given a string s containing just the characters '(', ')', '{',
 * '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 * Example 1:
 *
 * Input: s = "()" Output: true
 *
 * Example 2:
 *
 * Input: s = "()[]{}" Output: true
 *
 * Example 3:
 *
 * Input: s = "(]" Output: false
 *
 * Constraints:
 *
 * 1 <= s.length <= 10 4
 * s consists of parentheses only '()[]{}'.
 */
class Solution00020 {

  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(' || c == '[' || c == '{') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) {
          return false;
        }
        char topChar = stack.pop();
        if (c == ')' && topChar != '(') {
          return false;
        }
        if (c == ']' && topChar != '[') {
          return false;
        }
        if (c == '}' && topChar != '{') {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }

  public static void test_00020() {
    Solution00020 solution = new Solution00020();
    System.out.println(solution.isValid("()"));
    System.out.println(solution.isValid("()[]{}"));
    System.out.println(solution.isValid("(]"));
  }

  public static void main(String[] args) {
    Solution00020.test_00020();
  }
}
