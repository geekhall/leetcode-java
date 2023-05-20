package net.geekhour.problems.p01800.p01898;

/**
 * ID: 01898
 * Title: Maximum Number of Removable Characters
 * Difficulty: Medium
 * Description: You are given two strings s and p where p is a subsequence of s.
 * You are also given a distinct 0-indexed integer array removable containing a
 * subset of indices of s (s is also 0-indexed).
 *
 * You want to choose an integer k (0 <= k <= removable.length) such that, after
 * removing k characters from s using the first k indices in removable, p is
 * still a subsequence of s. More formally, you will mark the character at
 * s[removable[i]] for each 0 <= i < k, then remove all marked characters and
 * check if p is still a subsequence.
 *
 * Return the maximum k you can choose such that p is still a subsequence of s
 * after the removals.
 *
 * A subsequence of a string is a new string generated from the original string
 * with some characters (can be none) deleted without changing the relative
 * order of the remaining characters.
 *
 * Example 1:
 *
 * Input: s = "abcacb", p = "ab", removable = [3,1,0] Output: 2 Explanation:
 * After removing the characters at indices 3 and 1, "a b c a cb" becomes
 * "accb". "ab" is a subsequence of " a cc b". If we remove the characters at
 * indices 3, 1, and 0, " ab c a cb" becomes "ccb", and "ab" is no longer a
 * subsequence. Hence, the maximum k is 2.
 *
 * Example 2:
 *
 * Input: s = "abcbddddd", p = "abcd", removable = [3,2,1,4,5,6] Output: 1
 * Explanation: After removing the character at index 3, "abc b ddddd" becomes
 * "abcddddd". "abcd" is a subsequence of " abcd dddd".
 *
 * Example 3:
 *
 * Input: s = "abcab", p = "abc", removable = [0,1,2,3,4] Output: 0 Explanation:
 * If you remove the first index in the array removable, "abc" is no longer a
 * subsequence.
 *
 * Constraints:
 *
 * 1 <= p.length <= s.length <= 10 5
 * 0 <= removable.length < s.length
 * 0 <= removable[i] < s.length
 * p is a subsequence of s.
 * s and p both consist of lowercase English letters.
 * The elements in removable are distinct.
 */
class Solution01898 {

  public int maximumRemovals(String s, String p, int[] removable) {
    int left = 0;
    int right = removable.length;
    while (left < right) {
      int mid = (left + right + 1) / 2;
      if (check(s, p, removable, mid)) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }

  private boolean check(String s, String p, int[] removable, int mid) {
    boolean[] marked = new boolean[s.length()];
    for (int i = 0; i < mid; i++) {
      marked[removable[i]] = true;
    }
    int i = 0;
    int j = 0;
    while (i < s.length() && j < p.length()) {
      if (!marked[i] && s.charAt(i) == p.charAt(j)) {
        j++;
      }
      i++;
    }
    return j == p.length();
  }

  public static void test_01898() {
    Solution01898 solution = new Solution01898();
    String s = "abcacb";
    String p = "ab";
    int[] removable = { 3, 1, 0 };
    int result = solution.maximumRemovals(s, p, removable);
    System.out.println(result);
    String s2 = "abcbddddd";
    String p2 = "abcd";
    int[] removable2 = { 3, 2, 1, 4, 5, 6 };
    int result2 = solution.maximumRemovals(s2, p2, removable2);
    System.out.println(result2);
    String s3 = "abcab";
    String p3 = "abc";
    int[] removable3 = { 0, 1, 2, 3, 4 };
    int result3 = solution.maximumRemovals(s3, p3, removable3);
    System.out.println(result3);

  }

  public static void main(String[] args) {
    Solution01898.test_01898();
  }
}
