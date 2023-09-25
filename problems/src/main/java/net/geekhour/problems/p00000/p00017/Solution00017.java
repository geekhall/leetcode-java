package net.geekhour.problems.p00000.p00017;

import java.util.*;

/**
 * ID: 00017
 * Title: Letter Combinations of a Phone Number
 * Difficulty: Medium
 * Description: Given a string containing digits from 2-9 inclusive, return all
 * possible letter combinations that the number could represent. Return the
 * answer in any order.
 *
 * A mapping of digits to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 *
 * Example 1:
 *
 * Input: digits = "23" Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * Example 2:
 *
 * Input: digits = "" Output: []
 *
 * Example 3:
 *
 * Input: digits = "2" Output: ["a","b","c"]
 *
 * Constraints:
 *
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 */
class Solution00017 {

  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    if (digits.length() == 0) {
      return result;
    }
    String[] mapping = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs",
        "tuv", "wxyz" };
    letterCombinationsRecursive(result, digits, "", 0, mapping);
    return result;
  }

  private void letterCombinationsRecursive(List<String> result, String digits, String string, int i, String[] mapping) {
    if (i == digits.length()) {
      result.add(string);
      return;
    }
    String letters = mapping[digits.charAt(i) - '0'];
    for (int j = 0; j < letters.length(); j++) {
      letterCombinationsRecursive(result, digits, string + letters.charAt(j), i + 1, mapping);
    }
  }

  public static void test_00017() {
    Solution00017 solution = new Solution00017();
    String digits = "23";
    List<String> expected = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
    List<String> actual = solution.letterCombinations(digits);
    System.out.println("Test case 00017: expected: " + expected + ", actual: " + actual);
    digits = "";
    expected = new ArrayList<>();
    actual = solution.letterCombinations(digits);
    System.out.println("Test case 00017: expected: " + expected + ", actual: " + actual);
    digits = "2";
    expected = Arrays.asList("a", "b", "c");
    actual = solution.letterCombinations(digits);
    System.out.println("Test case 00017: expected: " + expected + ", actual: " + actual);
  }

  public static void main(String[] args) {
    test_00017();
  }
}
