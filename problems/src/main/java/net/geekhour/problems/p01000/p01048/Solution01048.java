package net.geekhour.problems.p01000.p01048;

import java.util.*;

/**
 * ID: 01048
 * Title: Longest String Chain
 * Difficulty: Medium
 * Description: You are given an array of words where each word consists of
 * lowercase English letters.
 *
 * word A is a predecessor of word B if and only if we can insert exactly one
 * letter anywhere in word A without changing the order of the other characters
 * to make it equal to word B.
 *
 * For example, "abc" is a predecessor of "ab a c", while "cba" is not a
 * predecessor of "bcad".
 *
 * A word chain is a sequence of words [word 1, word 2, ..., word k ] with k >=
 * 1, where word 1 is a predecessor of word 2, word 2 is a predecessor of word
 * 3, and so on. A single word is trivially a word chain with k == 1.
 *
 * Return the length of the longest possible word chain with words chosen from
 * the given list of words.
 *
 * Example 1:
 *
 * Input: words = ["a","b","ba","bca","bda","bdca"] Output: 4 Explanation: One
 * of the longest word chains is ["a"," b a","b d a","bd c a"].
 *
 * Example 2:
 *
 * Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"] Output: 5 Explanation:
 * All the words can be put in a word chain ["xb", "xb c", " c xbc", " p cxbc",
 * "pcxbc f"].
 *
 * Example 3:
 *
 * Input: words = ["abcd","dbqca"] Output: 1 Explanation: The trivial word chain
 * ["abcd"] is one of the longest word chains. ["abcd","dbqca"] is not a valid
 * word chain because the ordering of the letters is changed.
 *
 * Constraints:
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 16
 * words[i] only consists of lowercase English letters.
 */
class Solution01048 {

  public int longestStrChain(String[] words) {
    Arrays.sort(words, (a, b) -> a.length() - b.length());
    Map<String, Integer> dp = new HashMap<>();
    int max = 0;
    for (String word : words) {
      int len = word.length();
      int count = 1;
      for (int i = 0; i < len; i++) {
        String prev = word.substring(0, i) + word.substring(i + 1);
        count = Math.max(count, dp.getOrDefault(prev, 0) + 1);
      }
      dp.put(word, count);
      max = Math.max(max, count);
    }
    return max;
  }

  public static void test_01048() {
    Solution01048 solution = new Solution01048();
    String[] words = new String[] { "a", "b", "ba", "bca", "bda", "bdca" };
    int expected = 4;
    int actual = solution.longestStrChain(words);
    System.out.println("Test case 01048: expected: " + expected + ", actual: " + actual);
    words = new String[] { "xbc", "pcxbcf", "xb", "cxbc", "pcxbc" };
    expected = 5;
    actual = solution.longestStrChain(words);
    System.out.println("Test case 01048: expected: " + expected + ", actual: " + actual);
    words = new String[] { "abcd", "dbqca" };
    expected = 1;
    actual = solution.longestStrChain(words);
    System.out.println("Test case 01048: expected: " + expected + ", actual: " + actual);

  }

  public static void main(String[] args) {
    test_01048();
  }
}
