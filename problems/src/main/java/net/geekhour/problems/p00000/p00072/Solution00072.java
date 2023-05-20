package net.geekhour.problems.p00000.p00072;

/**
 * ID: 00072
 * Title: Edit Distance
 * Difficulty: Hard
 * Description: Given two strings word1 and word2, return the minimum number of
 * operations required to convert word1 to word2.
 *
 * You have the following three operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 *
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros" Output: 3 Explanation: horse -> rorse
 * (replace 'h' with 'r') rorse -> rose (remove 'r') rose -> ros (remove 'e')
 *
 * Example 2:
 *
 * Input: word1 = "intention", word2 = "execution" Output: 5 Explanation:
 * intention -> inention (remove 't') inention -> enention (replace 'i' with
 * 'e') enention -> exention (replace 'n' with 'x') exention -> exection
 * (replace 'n' with 'c') exection -> execution (insert 'u')
 *
 * Constraints:
 *
 * 0 <= word1.length, word2.length <= 500
 * word1 and word2 consist of lowercase English letters.
 */
class Solution00072 {

  public int minDistance(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i <= m; i++) {
      dp[i][0] = i;
    }
    for (int j = 0; j <= n; j++) {
      dp[0][j] = j;
    }
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
        }
      }
    }
    return dp[m][n];
  }

  public static void test_00072() {
    Solution00072 solution = new Solution00072();
    String word1 = "horse";
    String word2 = "ros";
    int result = solution.minDistance(word1, word2);
    System.out.println(result);
    String word3 = "intention";
    String word4 = "execution";
    int result2 = solution.minDistance(word3, word4);
    System.out.println(result2);
  }

  public static void main(String[] args) {
    Solution00072.test_00072();
  }
}
