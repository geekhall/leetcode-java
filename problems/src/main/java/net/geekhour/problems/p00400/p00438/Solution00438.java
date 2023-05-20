package net.geekhour.problems.p00400.p00438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ID: 00438
 * Title: Find All Anagrams in a String
 * Difficulty: Medium
 * Description: Given two strings s and p, return an array of all the start
 * indices of p 's anagrams in s. You may return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 *
 * Example 1:
 *
 * Input: s = "cbaebabacd", p = "abc" Output: [0,6] Explanation: The substring
 * with start index = 0 is "cba", which is an anagram of "abc". The substring
 * with start index = 6 is "bac", which is an anagram of "abc".
 *
 * Example 2:
 *
 * Input: s = "abab", p = "ab" Output: [0,1,2] Explanation: The substring with
 * start index = 0 is "ab", which is an anagram of "ab". The substring with
 * start index = 1 is "ba", which is an anagram of "ab". The substring with
 * start index = 2 is "ab", which is an anagram of "ab".
 *
 * Constraints:
 *
 * 1 <= s.length, p.length <= 3 * 10 4
 * s and p consist of lowercase English letters.
 */
class Solution00438 {

  public List<Integer> findAnagrams(String s, String p) {
    int n = s.length(), m = p.length();
    if (n < m) {
      return new ArrayList<Integer>();
    }
    Map<Character, Integer> pCnt = new HashMap<>();
    Map<Character, Integer> sCnt = new HashMap<>();
    for (int i = 0; i < m; ++i) {
      char ch = p.charAt(i);
      pCnt.put(ch, pCnt.getOrDefault(ch, 0) + 1);
    }
    for (int i = 0; i < m - 1; ++i) {
      char ch = s.charAt(i);
      sCnt.put(ch, sCnt.getOrDefault(ch, 0) + 1);
    }
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < n - m + 1; ++i) {
      char ch = s.charAt(i + m - 1);
      sCnt.put(ch, sCnt.getOrDefault(ch, 0) + 1);
      if (sCnt.equals(pCnt)) {
        ans.add(i);
      }
      ch = s.charAt(i);
      sCnt.put(ch, sCnt.get(ch) - 1);
      if (sCnt.get(ch) == 0) {
        sCnt.remove(ch);
      }
    }
    return ans;
  }

  public static void test_00438() {
    Solution00438 solution = new Solution00438();
    String s = "cbaebabacd";
    String p = "abc";
    List<Integer> result = solution.findAnagrams(s, p);
    System.out.println(result);
  }

  public static void main(String[] args) {
    Solution00438.test_00438();
  }
}
