package net.geekhour.problems.p00900.p00953;

/**
 * ID: 00953
 * Title: Verifying an Alien Dictionary
 * Difficulty: Easy
 * Description: In an alien language, surprisingly, they also use English
 * lowercase letters, but possibly in a different order. The order of the
 * alphabet is some permutation of lowercase letters.
 *
 * Given a sequence of words written in the alien language, and the order of the
 * alphabet, return true if and only if the given words are sorted
 * lexicographically in this alien language.
 *
 * Example 1:
 *
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true Explanation: As 'h' comes before 'l' in this language, then the
 * sequence is sorted.
 *
 * Example 2:
 *
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false Explanation: As 'd' comes after 'l' in this language, then
 * words[0] > words[1], hence the sequence is unsorted.
 *
 * Example 3:
 *
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz" Output:
 * false Explanation: The first three characters "app" match, and the second
 * string is shorter (in size.) According to lexicographical rules "apple" >
 * "app", because 'l' > '∅', where '∅' is defined as the blank character which
 * is less than any other character (More info).
 *
 * Constraints:
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * All characters in words[i] and order are English lowercase letters.
 */
class Solution00953 {

  public boolean isAlienSorted(String[] words, String order) {
    int[] orderMap = new int[26];
    for (int i = 0; i < order.length(); i++) {
      orderMap[order.charAt(i) - 'a'] = i;
    }
    for (int i = 0; i < words.length - 1; i++) {
      String word1 = words[i];
      String word2 = words[i + 1];
      int len = Math.min(word1.length(), word2.length());
      for (int j = 0; j < len; j++) {
        if (word1.charAt(j) != word2.charAt(j)) {
          if (orderMap[word1.charAt(j) - 'a'] > orderMap[word2.charAt(j) - 'a']) {
            return false;
          }
          break;
        }
        if (j == len - 1 && word1.length() > word2.length()) {
          return false;
        }
      }
    }
    return true;
  }

  public static void test_00953() {
    Solution00953 solution = new Solution00953();
    String[] words = { "hello", "leetcode" };
    String order = "hlabcdefgijkmnopqrstuvwxyz";
    boolean result = solution.isAlienSorted(words, order);
    System.out.println(result);
    String[] words2 = { "word", "world", "row" };
    String order2 = "worldabcefghijkmnpqstuvxyz";
    boolean result2 = solution.isAlienSorted(words2, order2);
    System.out.println(result2);
    String[] words3 = { "apple", "app" };
    String order3 = "abcdefghijklmnopqrstuvwxyz";
    boolean result3 = solution.isAlienSorted(words3, order3);
    System.out.println(result3);
  }

  public static void main(String[] args) {
    Solution00953.test_00953();
  }
}
