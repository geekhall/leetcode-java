package net.geekhour.problems.p00500.p00502;

import java.util.*;

/**
 * ID: 00502
 * Title: IPO
 * Difficulty: Hard
 * Description: Suppose LeetCode will start its IPO soon. In order to sell a
 * good price of its shares to Venture Capital, LeetCode would like to work on
 * some projects to increase its capital before the IPO. Since it has limited
 * resources, it can only finish at most k distinct projects before the IPO.
 * Help LeetCode design the best way to maximize its total capital after
 * finishing at most k distinct projects.
 *
 * You are given n projects where the i th project has a pure profit profits[i]
 * and a minimum capital of capital[i] is needed to start it.
 *
 * Initially, you have w capital. When you finish a project, you will obtain its
 * pure profit and the profit will be added to your total capital.
 *
 * Pick a list of at most k distinct projects from given projects to maximize
 * your final capital, and return the final maximized capital.
 *
 * The answer is guaranteed to fit in a 32-bit signed integer.
 *
 * Example 1:
 *
 * Input: k = 2, w = 0, profits = [1,2,3], capital = [0,1,1] Output: 4
 * Explanation: Since your initial capital is 0, you can only start the project
 * indexed 0. After finishing it you will obtain profit 1 and your capital
 * becomes 1. With capital 1, you can either start the project indexed 1 or the
 * project indexed 2. Since you can choose at most 2 projects, you need to
 * finish the project indexed 2 to get the maximum capital. Therefore, output
 * the final maximized capital, which is 0 + 1 + 3 = 4.
 *
 * Example 2:
 *
 * Input: k = 3, w = 0, profits = [1,2,3], capital = [0,1,2] Output: 6
 *
 * Constraints:
 *
 * 1 <= k <= 10 5
 * 0 <= w <= 10 9
 * n == profits.length
 * n == capital.length
 * 1 <= n <= 10 5
 * 0 <= profits[i] <= 10 4
 * 0 <= capital[i] <= 10 9
 */
class Solution00502 {

  public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
    int n = profits.length;
    int[][] projects = new int[n][2];
    for (int i = 0; i < n; i++) {
      projects[i][0] = capital[i];
      projects[i][1] = profits[i];
    }
    Arrays.sort(projects, (a, b) -> a[0] - b[0]);
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
    int i = 0;
    for (int j = 0; j < k; j++) {
      while (i < n && projects[i][0] <= w) {
        pq.offer(projects[i][1]);
        i++;
      }
      if (!pq.isEmpty()) {
        w += pq.poll();
      } else {
        break;
      }
    }
    return w;
  }

  public static void test_00502() {
    Solution00502 solution = new Solution00502();
    int k = 2;
    int w = 0;
    int[] profits = { 1, 2, 3 };
    int[] capital = { 0, 1, 1 };
    int result = solution.findMaximizedCapital(k, w, profits, capital);
    System.out.println(result);
    int k2 = 3;
    int w2 = 0;
    int[] profits2 = { 1, 2, 3 };
    int[] capital2 = { 0, 1, 2 };
    int result2 = solution.findMaximizedCapital(k2, w2, profits2, capital2);
    System.out.println(result2);
  }

  public static void main(String[] args) {
    Solution00502.test_00502();
  }
}
