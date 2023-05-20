package net.geekhour.problems.p00400.p00472;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ID: 00472
 * Title: Concatenated Words
 * Difficulty: Hard
 * Description: Given an array of strings words (without duplicates), return all
 * the concatenated words in the given list of words.
 *
 * A concatenated word is defined as a string that is comprised entirely of at
 * least two shorter words in the given array.
 *
 * Example 1:
 *
 * Input: words =
 * ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * Output: ["catsdogcats","dogcatsdog","ratcatdogcat"] Explanation:"catsdogcats"
 * can be concatenated by "cats", "dog" and "cats"; "dogcatsdog" can be
 * concatenated by "dog", "cats" and "dog"; "ratcatdogcat" can be concatenated
 * by "rat", "cat", "dog" and "cat".
 *
 * Example 2:
 *
 * Input: words = ["cat","dog","catdog"] Output: ["catdog"]
 *
 * Constraints:
 *
 * 1 <= words.length <= 10 4
 * 1 <= words[i].length <= 30
 * words[i] consists of only lowercase English letters.
 * All the strings of words are unique.
 * 1 <= sum(words[i].length) <= 10 5
 */
class Solution00472 {

  public List<String> findAllConcatenatedWordsInADict(String[] words) {
    List<String> result = new ArrayList<>();
    Map<String, Integer> wordMap = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      wordMap.put(words[i], i);
    }
    for (int i = 0; i < words.length; i++) {
      if (dfs(words[i], wordMap, 0, 0)) {
        result.add(words[i]);
      }
    }
    return result;
  }

  private boolean dfs(String string, Map<String, Integer> wordMap, int i, int j) {
    if (i == string.length()) {
      return j >= 2;
    }
    for (int k = i; k < string.length(); k++) {
      String sub = string.substring(i, k + 1);
      if (wordMap.containsKey(sub)) {
        if (dfs(string, wordMap, k + 1, j + 1)) {
          return true;
        }
      }
    }
    return false;
  }

  public static void test_00472() {
    Solution00472 solution = new Solution00472();
    String[] words = { "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat" };
    List<String> result = solution.findAllConcatenatedWordsInADict(words);
    System.out.println(result);
    String[] words2 = { "cat", "dog", "catdog" };
    List<String> result2 = solution.findAllConcatenatedWordsInADict(words2);
    System.out.println(result2);

  }

  public static void main(String[] args) {
    Solution00472.test_00472();
  }
}
