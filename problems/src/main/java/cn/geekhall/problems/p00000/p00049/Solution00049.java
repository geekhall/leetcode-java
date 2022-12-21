package cn.geekhall.problems.p00000.p00049;

import java.util.ArrayList;
import java.util.List;

/**
 * ID:    00049
 * Title: Group Anagrams
 * Difficulty: Medium
 * Description: Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"] Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Example 2:
 *
 * Input: strs = [""] Output: [[""]]
 *
 * Example 3:
 *
 * Input: strs = ["a"] Output: [["a"]]
 *
 * Constraints:
 *
 * 1 <= strs.length <= 10 4
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 */
class Solution00049 {

  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<>();
    for (String str : strs) {
      boolean isAnagram = false;
      for (List<String> list : result) {
        if (isAnagram(list.get(0), str)) {
          list.add(str);
          isAnagram = true;
          break;
        }
      }
      if (!isAnagram) {
        List<String> list = new ArrayList<>();
        list.add(str);
        result.add(list);
      }
    }
    return result;
  }



  private boolean isAnagram(String string, String str) {
    if (string.length() != str.length()) {
      return false;
    }
    int[] chars = new int[26];
    for (int i = 0; i < string.length(); i++) {
      chars[string.charAt(i) - 'a']++;
      chars[str.charAt(i) - 'a']--;
    }
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] != 0) {
        return false;
      }
    }
    return true;
  }



  public static void test_00049() {
    Solution00049 solution = new Solution00049();
    String[] strs = {"eat","tea","tan","ate","nat","bat"};
    List<List<String>> result = solution.groupAnagrams(strs);
    System.out.println(result);
  }

  public static void main(String[] args) {
    Solution00049.test_00049();
  }
}

