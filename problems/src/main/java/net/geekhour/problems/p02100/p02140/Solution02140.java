package net.geekhour.problems.p02100.p02140;

import java.util.*;

/**
 * ID: 02140
 * Title: Solving Questions With Brainpower
 * Difficulty: Medium
 * Description: You are given a 0-indexed 2D integer array questions where
 * questions[i] = [points i, brainpower i ].
 *
 * The array describes the questions of an exam, where you have to process the
 * questions in order (i.e., starting from question 0) and make a decision
 * whether to solve or skip each question. Solving question i will earn you
 * points i points but you will be unable to solve each of the next brainpower i
 * questions. If you skip question i, you get to make the decision on the next
 * question.
 *
 * For example, given questions = [[3, 2], [4, 3], [4, 4], [2, 5]]:
 *
 * If question 0 is solved, you will earn 3 points but you will be unable to
 * solve questions 1 and 2.
 * If instead, question 0 is skipped and question 1 is solved, you will earn 4
 * points but you will be unable to solve questions 2 and 3.
 *
 * Return the maximum points you can earn for the exam.
 *
 * Example 1:
 *
 * Input: questions = [[3,2],[4,3],[4,4],[2,5]] Output: 5 Explanation: The
 * maximum points can be earned by solving questions 0 and 3. - Solve question
 * 0: Earn 3 points, will be unable to solve the next 2 questions - Unable to
 * solve questions 1 and 2 - Solve question 3: Earn 2 points Total points
 * earned: 3 + 2 = 5. There is no other way to earn 5 or more points.
 *
 * Example 2:
 *
 * Input: questions = [[1,1],[2,2],[3,3],[4,4],[5,5]] Output: 7 Explanation: The
 * maximum points can be earned by solving questions 1 and 4. - Skip question 0
 * - Solve question 1: Earn 2 points, will be unable to solve the next 2
 * questions - Unable to solve questions 2 and 3 - Solve question 4: Earn 5
 * points Total points earned: 2 + 5 = 7. There is no other way to earn 7 or
 * more points.
 *
 * Constraints:
 *
 * 1 <= questions.length <= 10 5
 * questions[i].length == 2
 * 1 <= points i, brainpower i <= 10 5
 */
class Solution02140 {

  public long mostPoints(int[][] questions) {
    int n = questions.length;
    long[] dp = new long[n + 1];
    for (int i = n - 1; i >= 0; i--) {
      dp[i] = Math.max(dp[i + 1], questions[i][0] + (i + questions[i][1] < n ? dp[i + questions[i][1] + 1] : 0));
    }
    return dp[0];
  }

  public static void test_02140() {
    Solution02140 solution = new Solution02140();
    int[][] questions = { { 3, 2 }, { 4, 3 }, { 4, 4 }, { 2, 5 } };
    long result = solution.mostPoints(questions);
    System.out.println(result);

    questions = new int[][] { { 1, 1 }, { 2, 2 }, { 3, 3 }, { 4, 4 }, { 5, 5 } };
    result = solution.mostPoints(questions);
    System.out.println(result);
  }

  public static void main(String[] args) {
    Solution02140.test_02140();
  }
}
