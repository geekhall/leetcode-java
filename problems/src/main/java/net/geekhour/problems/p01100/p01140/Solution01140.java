package net.geekhour.problems.p01100.p01140;

import java.util.*;

/**
 * ID: 01140
 * Title: Stone Game II
 * Difficulty: Medium
 * Description: Alice and Bob continue their games with piles of stones. There
 * are a number of piles arranged in a row, and each pile has a positive integer
 * number of stones piles[i]. The objective of the game is to end with the most
 * stones.
 *
 * Alice and Bob take turns, with Alice starting first. Initially, M = 1.
 *
 * On each player's turn, that player can take all the stones in the first X
 * remaining piles, where 1 <= X <= 2M. Then, we set M = max(M, X).
 *
 * The game continues until all the stones have been taken.
 *
 * Assuming Alice and Bob play optimally, return the maximum number of stones
 * Alice can get.
 *
 * Example 1:
 *
 * Input: piles = [2,7,9,4,4] Output: 10 Explanation: If Alice takes one pile at
 * the beginning, Bob takes two piles, then Alice takes 2 piles again. Alice can
 * get 2 + 4 + 4 = 10 piles in total. If Alice takes two piles at the beginning,
 * then Bob can take all three piles left. In this case, Alice get 2 + 7 = 9
 * piles in total. So we return 10 since it's larger.
 *
 * Example 2:
 *
 * Input: piles = [1,2,3,4,5,100] Output: 104
 *
 * Constraints:
 *
 * 1 <= piles.length <= 100
 * 1 <= piles[i] <= 10 4
 */
class Solution01140 {

  public int helper(int[] piles, int[][] dp, int[] suffixSum, int i, int M) {
    if (i == piles.length)
      return 0;
    if (i + 2 * M >= piles.length)
      return suffixSum[i];

    if (dp[i][M] != 0)
      return dp[i][M];

    int result = 0;
    for (int x = 1; x <= 2 * M; ++x) {
      result = Math.max(result, suffixSum[i] - helper(piles, dp, suffixSum, i + x, Math.max(M, x)));
    }

    dp[i][M] = result;
    return result;
  }

  public int stoneGameII(int[] piles) {
    if (piles.length == 0)
      return 0;
    int[][] dp = new int[piles.length][piles.length];

    int[] suffixSum = new int[piles.length];
    suffixSum[suffixSum.length - 1] = piles[piles.length - 1];
    for (int i = piles.length - 2; i >= 0; --i)
      suffixSum[i] = piles[i] + suffixSum[i + 1];

    return helper(piles, dp, suffixSum, 0, 1);
  }

  public static void test_01140() {
    Solution01140 solution = new Solution01140();
    int[] piles = { 2, 7, 9, 4, 4 };
    int expected = 10;
    int actual = solution.stoneGameII(piles);
    System.out.println("expected: " + expected + ", actual: " + actual);
    int[] piles2 = { 1, 2, 3, 4, 5, 100 };
    int expected2 = 104;
    int actual2 = solution.stoneGameII(piles2);
    System.out.println("expected: " + expected2 + ", actual: " + actual2);

  }

  public static void main(String[] args) {
    Solution01140.test_01140();
  }
}
