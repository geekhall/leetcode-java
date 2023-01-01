package cn.geekhall.problems.p00200.p00290;

import java.util.HashMap;
import java.util.Map;

/**
 * ID:    00290
 * Title: Word Pattern
 * Difficulty: Easy
 * Description: Given a pattern and a string s, find if s follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 *
 * Example 1:
 *
 * Input: pattern = "abba", s = "dog cat cat dog" Output: true
 *
 * Example 2:
 *
 * Input: pattern = "abba", s = "dog cat cat fish" Output: false
 *
 * Example 3:
 *
 * Input: pattern = "aaaa", s = "dog cat cat dog" Output: false
 *
 * Constraints:
 *
 * 1 <= pattern.length <= 300
 * pattern contains only lower-case English letters.
 * 1 <= s.length <= 3000
 * s contains only lowercase English letters and spaces ' '.
 * s does not contain any leading or trailing spaces.
 * All the words in s are separated by a single space.
 */
class Solution00290 {

  public boolean wordPattern(String pattern, String s) {
    String[] words = s.split(" ");
    if (words.length != pattern.length()) {
      return false;
    }
    Map<Character, String> map = new HashMap<>();
    for (int i = 0; i < pattern.length(); i++) {
      char c = pattern.charAt(i);
      if (map.containsKey(c)) {
        if (!map.get(c).equals(words[i])) {
          return false;
        }
      } else {
        if (map.containsValue(words[i])) {
          return false;
        }
        map.put(c, words[i]);
      }
    }
    return true;
  }

  public static void test_00290() {
    Solution00290 solution = new Solution00290();
    String pattern = "abba";
    String s = "dog cat cat dog";
    boolean result = solution.wordPattern(pattern, s);
    System.out.println(result);
    String pattern2 = "abba";
    String s2 = "dog cat cat fish";
    boolean result2 = solution.wordPattern(pattern2, s2);
    System.out.println(result2);
  }

  public static void main(String[] args) {
    Solution00290.test_00290();
  }
}

