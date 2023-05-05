package cn.geekhall.problems.p01400.p01456;

import java.util.*;

/**
 * ID: 01456
 * Title: Maximum Number of Vowels in a Substring of Given Length
 * Difficulty: Medium
 * Description: Given a string s and an integer k, return the maximum number of
 * vowel letters in any substring of s with length k.
 *
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 *
 * Example 1:
 *
 * Input: s = "abciiidef", k = 3 Output: 3 Explanation: The substring "iii"
 * contains 3 vowel letters.
 *
 * Example 2:
 *
 * Input: s = "aeiou", k = 2 Output: 2 Explanation: Any substring of length 2
 * contains 2 vowels.
 *
 * Example 3:
 *
 * Input: s = "leetcode", k = 3 Output: 2 Explanation:"lee", "eet" and "ode"
 * contain 2 vowels.
 *
 * Constraints:
 *
 * 1 <= s.length <= 10 5
 * s consists of lowercase English letters.
 * 1 <= k <= s.length
 */
class Solution01456 {

  public int maxVowels(String s, int k) {
    int max = 0;
    int count = 0;
    int left = 0;
    int right = 0;
    while (right < s.length()) {
      char c = s.charAt(right);
      if (isVowel(c)) {
        count++;
      }
      right++;
      if (right - left == k) {
        max = Math.max(max, count);
        char c2 = s.charAt(left);
        if (isVowel(c2)) {
          count--;
        }
        left++;
      }
    }
    return max;
  }

  private boolean isVowel(char c2) {
    return c2 == 'a' || c2 == 'e' || c2 == 'i' || c2 == 'o' || c2 == 'u';
  }

  public static void test_01456() {
    Solution01456 solution = new Solution01456();
    String s = "abciiidef";
    int k = 3;
    int result = solution.maxVowels(s, k);
    System.out.println("result = " + result);
    String s2 = "aeiou";
    int k2 = 2;
    int result2 = solution.maxVowels(s2, k2);
    System.out.println("result2 = " + result2);
    String s3 = "leetcode";
    int k3 = 3;
    int result3 = solution.maxVowels(s3, k3);
    System.out.println("result3 = " + result3);
  }

  public static void main(String[] args) {
    Solution01456.test_01456();
  }
}
