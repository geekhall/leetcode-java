package net.geekhour.problems.p00000.p00005;

import java.util.*;

/**
 * ID: 00005
 * Title: Longest Palindromic Substring
 * Difficulty: Medium
 * Description: Given a string s, return the longest palindromic substring in s.
 *
 * Example 1:
 *
 * Input: s = "babad" Output:"bab" Explanation:"aba" is also a valid answer.
 *
 * Example 2:
 *
 * Input: s = "cbbd" Output:"bb"
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
class Solution00005 {

  public String longestPalindrome(String s) {
    int len = s.length();
    if (len < 2) {
      return s;
    }
    int maxLen = 1;
    int begin = 0;
    char[] charArray = s.toCharArray();
    for (int i = 0; i < len - 1; i++) {
      int oddLen = expandAroundCenter(charArray, i, i);
      int evenLen = expandAroundCenter(charArray, i, i + 1);
      int curMaxLen = Math.max(oddLen, evenLen);
      if (curMaxLen > maxLen) {
        maxLen = curMaxLen;
        begin = i - (maxLen - 1) / 2;
      }
    }
    return s.substring(begin, begin + maxLen);
  }

  private int expandAroundCenter(char[] charArray, int i, int i2) {
    int len = charArray.length;
    int left = i;
    int right = i2;
    while (left >= 0 && right < len) {
      if (charArray[left] == charArray[right]) {
        left--;
        right++;
      } else {
        break;
      }
    }
    return right - left - 1;
  }

  public static void test_00005() {
    Solution00005 solution = new Solution00005();
    //
  }

  public static void main(String[] args) {
    test_00005();
  }
}
