package cn.geekhall.problems.p00100.p00131;

import java.util.ArrayList;
import java.util.List;

/**
 * ID:    00131
 * Title: Palindrome Partitioning
 * Difficulty: Medium
 * Description: Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 *
 * Example 1:
 *
 * Input: s = "aab" Output: [["a","a","b"],["aa","b"]]
 *
 * Example 2:
 *
 * Input: s = "a" Output: [["a"]]
 *
 * Constraints:
 *
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 */
class Solution00131 {

  public List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();
    dfs(s, 0, path, result);
    return result;
  }

  private void dfs(String s, int i, List<String> path, List<List<String>> result) {
    if (i == s.length()) {
      result.add(new ArrayList<>(path));
      return;
    }
    for (int j = i; j < s.length(); j++) {
      if (isPalindrome(s, i, j)) {
        path.add(s.substring(i, j + 1));
        dfs(s, j + 1, path, result);
        path.remove(path.size() - 1);
      }
    }
  }

  private boolean isPalindrome(String s, int i, int j) {
    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

  public static void test_00131() {
    Solution00131 solution = new Solution00131();
    String s = "aab";
    List<List<String>> result = solution.partition(s);
    System.out.println(result);
    String s2 = "a";
    List<List<String>> result2 = solution.partition(s2);
    System.out.println(result2);
  }

  public static void main(String[] args) {
    Solution00131.test_00131();
  }
}

