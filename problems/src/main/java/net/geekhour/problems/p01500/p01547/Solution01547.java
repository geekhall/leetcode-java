package net.geekhour.problems.p01500.p01547;

import java.util.*;

/**
 * ID: 01547
 * Title: Minimum Cost to Cut a Stick
 * Difficulty: Hard
 * Description: Given a wooden stick of length n units. The stick is labelled
 * from 0 to n. For example, a stick of length 6 is labelled as follows:
 *
 * Given an integer array cuts where cuts[i] denotes a position you should
 * perform a cut at.
 *
 * You should perform the cuts in order, you can change the order of the cuts as
 * you wish.
 *
 * The cost of one cut is the length of the stick to be cut, the total cost is
 * the sum of costs of all cuts. When you cut a stick, it will be split into two
 * smaller sticks (i.e. the sum of their lengths is the length of the stick
 * before the cut). Please refer to the first example for a better explanation.
 *
 * Return the minimum total cost of the cuts.
 *
 * Example 1:
 *
 * Input: n = 7, cuts = [1,3,4,5] Output: 16 Explanation: Using cuts order = [1,
 * 3, 4, 5] as in the input leads to the following scenario: The first cut is
 * done to a rod of length 7 so the cost is 7. The second cut is done to a rod
 * of length 6 (i.e. the second part of the first cut), the third is done to a
 * rod of length 4 and the last cut is to a rod of length 3. The total cost is 7
 * + 6 + 4 + 3 = 20. Rearranging the cuts to be [3, 5, 1, 4] for example will
 * lead to a scenario with total cost = 16 (as shown in the example photo 7 + 4
 * + 3 + 2 = 16).
 *
 * Example 2:
 *
 * Input: n = 9, cuts = [5,6,1,4,2] Output: 22 Explanation: If you try the given
 * cuts ordering the cost will be 25. There are much ordering with total cost <=
 * 25, for example, the order [4, 6, 5, 2, 1] has total cost = 22 which is the
 * minimum possible.
 *
 * Constraints:
 *
 * 2 <= n <= 10 6
 * 1 <= cuts.length <= min(n - 1, 100)
 * 1 <= cuts[i] <= n - 1
 * All the integers in cuts array are distinct.
 */
class Solution01547 {

  public int minCost(int n, int[] cuts) {
    int[] cuts2 = new int[cuts.length + 2];
    System.arraycopy(cuts, 0, cuts2, 1, cuts.length);
    cuts2[0] = 0;
    cuts2[cuts2.length - 1] = n;
    Arrays.sort(cuts2);
    int[][] dp = new int[cuts2.length][cuts2.length];
    for (int i = 0; i < cuts2.length - 1; i++) {
      dp[i][i + 1] = 0;
    }
    for (int i = 2; i < cuts2.length; i++) {
      for (int j = 0; j < cuts2.length - i; j++) {
        int min = Integer.MAX_VALUE;
        for (int k = j + 1; k < j + i; k++) {
          min = Math.min(min, dp[j][k] + dp[k][j + i]);
        }
        dp[j][j + i] = min + cuts2[j + i] - cuts2[j];
      }
    }
    return dp[0][cuts2.length - 1];
  }

  public static void test_01547() {
    Solution01547 solution = new Solution01547();
    int n;
    int[] cuts;
    int expected;
    int actual;

    n = 7;
    cuts = new int[] { 1, 3, 4, 5 };
    expected = 16;
    actual = solution.minCost(n, cuts);
    System.out.printf("expected: %d, actual: %d\n", expected, actual);

    n = 9;
    cuts = new int[] { 5, 6, 1, 4, 2 };
    expected = 22;
    actual = solution.minCost(n, cuts);
    System.out.printf("expected: %d, actual: %d\n", expected, actual);
  }

  public static void main(String[] args) {
    Solution01547.test_01547();
  }
}
