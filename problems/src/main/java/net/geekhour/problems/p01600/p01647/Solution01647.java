package net.geekhour.problems.p01600.p01647;

import java.util.*;

/**
 * ID: 01647
 * Title: Minimum Deletions to Make Character Frequencies Unique
 * Difficulty: Medium
 * Description: A string s is called good if there are no two different
 * characters in s that have the same frequency.
 *
 * Given a string s, return the minimum number of characters you need to delete
 * to make s good.
 *
 * The frequency of a character in a string is the number of times it appears in
 * the string. For example, in the string "aab", the frequency of 'a' is 2,
 * while the frequency of 'b' is 1.
 *
 * Example 1:
 *
 * Input: s = "aab" Output: 0 Explanation: s is already good.
 *
 * Example 2:
 *
 * Input: s = "aaabbbcc" Output: 2 Explanation: You can delete two 'b's
 * resulting in the good string "aaabcc". Another way it to delete one 'b' and
 * one 'c' resulting in the good string "aaabbc".
 *
 * Example 3:
 *
 * Input: s = "ceabaacb" Output: 2 Explanation: You can delete both 'c's
 * resulting in the good string "eabaab". Note that we only care about
 * characters that are still in the string at the end (i.e. frequency of 0 is
 * ignored).
 *
 * Constraints:
 *
 * 1 <= s.length <= 10 5
 * s contains only lowercase English letters.
 */
class Solution01647 {

  public int minDeletions(String s) {
    int result = 0;
    int[] freq = new int[26];
    for (int i = 0; i < s.length(); i++) {
      freq[s.charAt(i) - 'a']++;
    }
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < freq.length; i++) {
      int f = freq[i];
      while (f > 0 && !set.add(f)) {
        f--;
        result++;
      }
    }
    return result;
  }

  public static void test_01647() {
    Solution01647 solution = new Solution01647();
    System.out.println(solution.minDeletions("aab"));
    System.out.println(solution.minDeletions("aaabbbcc"));
    System.out.println(solution.minDeletions("ceabaacb"));
  }

  public static void main(String[] args) {
    test_01647();
  }
}
