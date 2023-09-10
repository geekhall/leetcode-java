package net.geekhour.problems.p01300.p01359;

import java.util.*;

/**
 * ID: 01359
 * Title: Count All Valid Pickup and Delivery Options
 * Difficulty: Hard
 * Description: Given n orders, each order consist in pickup and delivery
 * services.
 *
 * Count all valid pickup/delivery possible sequences such that delivery(i) is
 * always after of pickup(i).
 *
 * Since the answer may be too large, return it modulo 10^9 + 7.
 *
 * Example 1:
 *
 * Input: n = 1 Output: 1 Explanation: Unique order (P1, D1), Delivery 1 always
 * is after of Pickup 1.
 *
 * Example 2:
 *
 * Input: n = 2 Output: 6 Explanation: All possible orders: (P1,P2,D1,D2),
 * (P1,P2,D2,D1), (P1,D1,P2,D2), (P2,P1,D1,D2), (P2,P1,D2,D1) and (P2,D2,P1,D1).
 * This is an invalid order (P1,D2,P2,D1) because Pickup 2 is after of Delivery
 * 2.
 *
 * Example 3:
 *
 * Input: n = 3 Output: 90
 *
 * Constraints:
 *
 * 1 <= n <= 500
 */
class Solution01359 {

  public int countOrders(int n) {
    int MOD = 1000000007;
    long ans = 1;
    for (int i = 2; i <= n; i++) {
      // 2*i-1 is the number of ways to pick up the i-th order
      // i is the number of ways to deliver the i-th order
      // (2 * i - 1) * i is the number of w ays to pick up and deliver i-th order
      ans = ans * (2 * i - 1) * i % MOD;
    }
    return (int) ans;
  }

  public static void test_01359() {
    Solution01359 solution = new Solution01359();
    System.out.println(solution.countOrders(1));
    System.out.println(solution.countOrders(2));
    System.out.println(solution.countOrders(3));
  }

  public static void main(String[] args) {
    test_01359();
  }
}
