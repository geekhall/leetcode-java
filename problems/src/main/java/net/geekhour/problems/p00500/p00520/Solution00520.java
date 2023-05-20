package net.geekhour.problems.p00500.p00520;

/**
 * ID: 00520
 * Title: Detect Capital
 * Difficulty: Easy
 * Description: We define the usage of capitals in a word to be right when one
 * of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 *
 * Given a string word, return true if the usage of capitals in it is right.
 *
 * Example 1:
 *
 * Input: word = "USA" Output: true
 *
 * Example 2:
 *
 * Input: word = "FlaG" Output: false
 *
 * Constraints:
 *
 * 1 <= word.length <= 100
 * word consists of lowercase and uppercase English letters.
 */
class Solution00520 {

  private boolean isAllUpper(String word) {
    int n = word.length();
    for (int i = 0; i < n; i++) {
      if (!isUpper(word.charAt(i)))
        return false;
    }
    return true;
  }

  public boolean detectCapitalUse(String word) {
    int n = word.length();
    if (isAllUpper(word))
      return true;
    for (int i = 1; i < n; i++) {
      if (isUpper(word.charAt(i))) {
        return false;
      }
    }
    return true;
  }

  private boolean isUpper(char c) {
    return c >= 'A' && c <= 'Z';
  }

  public static void test_00520() {
    Solution00520 solution = new Solution00520();
    String word = "USA";
    boolean result = solution.detectCapitalUse(word);
    System.out.println(result);
    String word2 = "FlaG";
    boolean result2 = solution.detectCapitalUse(word2);
    System.out.println(result2);
  }

  public static void main(String[] args) {
    Solution00520.test_00520();
  }
}
