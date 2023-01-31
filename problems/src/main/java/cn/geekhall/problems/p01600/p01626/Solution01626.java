package cn.geekhall.problems.p01600.p01626;

import java.util.Arrays;

/**
 * ID: 01626
 * Title: Best Team With No Conflicts
 * Difficulty: Medium
 * Description: You are the manager of a basketball team. For the upcoming
 * tournament, you want to choose the team with the highest overall score. The
 * score of the team is the sum of scores of all the players in the team.
 *
 * However, the basketball team is not allowed to have conflicts. A conflict
 * exists if a younger player has a strictly higher score than an older player.
 * A conflict does not occur between players of the same age.
 *
 * Given two lists, scores and ages, where each scores[i] and ages[i] represents
 * the score and age of the i th player, respectively, return the highest
 * overall score of all possible basketball teams.
 *
 * Example 1:
 *
 * Input: scores = [1,3,5,10,15], ages = [1,2,3,4,5] Output: 34 Explanation: You
 * can choose all the players.
 *
 * Example 2:
 *
 * Input: scores = [4,5,6,5], ages = [2,1,2,1] Output: 16 Explanation: It is
 * best to choose the last 3 players. Notice that you are allowed to choose
 * multiple people of the same age.
 *
 * Example 3:
 *
 * Input: scores = [1,2,3,5], ages = [8,9,10,1] Output: 6 Explanation: It is
 * best to choose the first 3 players.
 *
 * Constraints:
 *
 * 1 <= scores.length, ages.length <= 1000
 * scores.length == ages.length
 * 1 <= scores[i] <= 10 6
 * 1 <= ages[i] <= 1000
 */
class Solution01626 {

  public int bestTeamScore(int[] scores, int[] ages) {
    int n = scores.length;
    int[][] arr = new int[n][2];
    for (int i = 0; i < n; i++) {
      arr[i][0] = ages[i];
      arr[i][1] = scores[i];
    }
    // 按年龄升序，年龄相同按分数升序
    Arrays.sort(arr, (a, b) -> {
      if (a[0] == b[0]) {
        return a[1] - b[1];
      }
      return a[0] - b[0];
    });
    int[] dp = new int[n];
    for (int i = 0; i < n; i++) {
      dp[i] = arr[i][1];
      for (int j = 0; j < i; j++) {
        if (arr[i][1] >= arr[j][1]) {
          dp[i] = Math.max(dp[i], dp[j] + arr[i][1]);
        }
      }
    }
    int result = 0;
    for (int i = 0; i < n; i++) {
      result = Math.max(result, dp[i]);
    }
    return result;
  }

  public static void test_01626() {
    Solution01626 solution = new Solution01626();
    int[] scores = { 1, 3, 5, 10, 15 };
    int[] ages = { 1, 2, 3, 4, 5 };
    int result = solution.bestTeamScore(scores, ages);
    System.out.println(result);
    int[] scores2 = { 4, 5, 6, 5 };
    int[] ages2 = { 2, 1, 2, 1 };
    int result2 = solution.bestTeamScore(scores2, ages2);
    System.out.println(result2);
    int[] scores3 = { 1, 2, 3, 5 };
    int[] ages3 = { 8, 9, 10, 1 };
    int result3 = solution.bestTeamScore(scores3, ages3);
    System.out.println(result3);
  }

  public static void main(String[] args) {
    Solution01626.test_01626();
  }
}
