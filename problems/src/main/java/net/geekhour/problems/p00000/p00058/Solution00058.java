package net.geekhour.problems.p00000.p00058;

/**
 * ID: 00058
 * Title: Length of Last Word
 * Difficulty: Easy
 * Description: Given a string s consisting of words and spaces, return the
 * length of the last word in the string.
 *
 * A word is a maximal substring consisting of non-space characters only.
 *
 * Example 1:
 *
 * Input: s = "Hello World" Output: 5 Explanation: The last word is "World" with
 * length 5.
 *
 * Example 2:
 *
 * Input: s = " fly me to the moon " Output: 4 Explanation: The last word is
 * "moon" with length 4.
 *
 * Example 3:
 *
 * Input: s = "luffy is still joyboy" Output: 6 Explanation: The last word is
 * "joyboy" with length 6.
 *
 * Constraints:
 *
 * 1 <= s.length <= 10 4
 * s consists of only English letters and spaces ' '.
 * There will be at least one word in s.
 */
class Solution00058 {

  public int lengthOfLastWord(String s) {
    int len = s.length();
    int end = len - 1;
    while (end >= 0 && s.charAt(end) == ' ') {
      end--;
    }
    if (end < 0) {
      return 0;
    }
    int start = end;
    while (start >= 0 && s.charAt(start) != ' ') {
      start--;
    }
    return end - start;
  }

  public static void test_00058() {
    Solution00058 solution = new Solution00058();
    String s = "Hello World";
    int result = solution.lengthOfLastWord(s);
    System.out.println(result);
  }

  public static void main(String[] args) {
    Solution00058.test_00058();
  }
}
