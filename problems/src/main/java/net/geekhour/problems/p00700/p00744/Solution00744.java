package net.geekhour.problems.p00700.p00744;

import java.util.*;

/**
 * ID: 00744
 * Title: Find Smallest Letter Greater Than Target
 * Difficulty: Easy
 * Description: You are given an array of characters letters that is sorted in
 * non-decreasing order, and a character target. There are at least two
 * different characters in letters.
 *
 * Return the smallest character in letters that is lexicographically greater
 * than target. If such a character does not exist, return the first character
 * in letters.
 *
 * Example 1:
 *
 * Input: letters = ["c","f","j"], target = "a" Output:"c" Explanation: The
 * smallest character that is lexicographically greater than 'a' in letters is
 * 'c'.
 *
 * Example 2:
 *
 * Input: letters = ["c","f","j"], target = "c" Output:"f" Explanation: The
 * smallest character that is lexicographically greater than 'c' in letters is
 * 'f'.
 *
 * Example 3:
 *
 * Input: letters = ["x","x","y","y"], target = "z" Output:"x" Explanation:
 * There are no characters in letters that is lexicographically greater than 'z'
 * so we return letters[0].
 *
 * Constraints:
 *
 * 2 <= letters.length <= 10 4
 * letters[i] is a lowercase English letter.
 * letters is sorted in non-decreasing order.
 * letters contains at least two different characters.
 * target is a lowercase English letter.
 */
class Solution00744 {

  public char nextGreatestLetter(char[] letters, char target) {
    int left = 0;
    int right = letters.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (letters[mid] <= target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return letters[left % letters.length];
  }

  public static void test_00744() {
    Solution00744 solution = new Solution00744();
    char[] letters = new char[] { 'c', 'f', 'j' };
    char target = 'a';
    char result = solution.nextGreatestLetter(letters, target);
    System.out.println(result);
    char[] letters2 = new char[] { 'c', 'f', 'j' };
    char target2 = 'c';
    char result2 = solution.nextGreatestLetter(letters2, target2);
    System.out.println(result2);
    char[] letters3 = new char[] { 'x', 'x', 'y', 'y' };
    char target3 = 'z';
    char result3 = solution.nextGreatestLetter(letters3, target3);
    System.out.println(result3);
  }

  public static void main(String[] args) {
    test_00744();
  }
}
