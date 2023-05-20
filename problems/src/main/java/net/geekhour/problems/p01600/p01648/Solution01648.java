package net.geekhour.problems.p01600.p01648;

import java.util.Arrays;

/**
 * ID: 01648
 * Title: Sell Diminishing-Valued Colored Balls
 * Difficulty: Medium
 * Description: You have an inventory of different colored balls, and there is a
 * customer that wants orders balls of any color.
 *
 * The customer weirdly values the colored balls. Each colored ball's value is
 * the number of balls of that color you currently have in your inventory. For
 * example, if you own 6 yellow balls, the customer would pay 6 for the first
 * yellow ball. After the transaction, there are only 5 yellow balls left, so
 * the next yellow ball is then valued at 5 (i.e., the value of the balls
 * decreases as you sell more to the customer).
 *
 * You are given an integer array, inventory, where inventory[i] represents the
 * number of balls of the i th color that you initially own. You are also given
 * an integer orders, which represents the total number of balls that the
 * customer wants. You can sell the balls in any order.
 *
 * Return the maximum total value that you can attain after selling orders
 * colored balls. As the answer may be too large, return it modulo 10 9 + 7.
 *
 * Example 1:
 *
 * Input: inventory = [2,5], orders = 4 Output: 14 Explanation: Sell the 1st
 * color 1 time (2) and the 2nd color 3 times (5 + 4 + 3). The maximum total
 * value is 2 + 5 + 4 + 3 = 14.
 *
 * Example 2:
 *
 * Input: inventory = [3,5], orders = 6 Output: 19 Explanation: Sell the 1st
 * color 2 times (3 + 2) and the 2nd color 4 times (5 + 4 + 3 + 2). The maximum
 * total value is 3 + 2 + 5 + 4 + 3 + 2 = 19.
 *
 * Constraints:
 *
 * 1 <= inventory.length <= 10 5
 * 1 <= inventory[i] <= 10 9
 * 1 <= orders <= min(sum(inventory[i]), 10 9)
 */
class Solution01648 {

  public int maxProfit(int[] inventory, int orders) {
    Arrays.sort(inventory);
    long ans = 0;
    int n = inventory.length - 1;
    long count = 1;
    while (orders > 0) {
      if (n > 0 && inventory[n] - inventory[n - 1] > 0 && orders >= count * (inventory[n] - inventory[n - 1])) {
        ans += count * sumFromNtoX(inventory[n], inventory[n - 1]);
        orders -= count * (inventory[n] - inventory[n - 1]);
      } else if (n == 0 || inventory[n] - inventory[n - 1] > 0) {
        long a = orders / count;
        ans += count * sumFromNtoX(inventory[n], inventory[n] - a);
        long b = orders % count;
        ans += b * (inventory[n] - a);
        orders = 0;
      }
      ans %= 1000000007;
      n--;
      count++;
    }
    return (int) ans;
  }

  private long sumFromNtoX(long n, long x) {
    return (n * (n + 1)) / 2 - (x * (x + 1)) / 2;
  }

  public static void test_01648() {
    Solution01648 solution = new Solution01648();
    int[] inventory = { 2, 5 };
    int orders = 4;
    int result = solution.maxProfit(inventory, orders);
    System.out.println(result);
    int[] inventory2 = { 3, 5 };
    int orders2 = 6;
    int result2 = solution.maxProfit(inventory2, orders2);
    System.out.println(result2);
    int[] inventory3 = { 565259708, 715164401, 716563713, 958255469, 844600740, 823949511, 180479359, 287829385,
        164248818, 73361150, 230686692, 322986846, 598720034, 338241127, 748922260, 181241085, 833659853, 509571179,
        250093451, 690995620, 703292727, 595636202 };
    int orders3 = 650114768;
    int result3 = solution.maxProfit(inventory3, orders3);
    System.out.println(result3); // Expected: 997286992
    int[] inventory4 = { 1000000000, 1000000000, 1000000000 };
    int orders4 = 1000000000;
    int result4 = solution.maxProfit(inventory4, orders4);
    System.out.println(result4); // Expected: 37

  }

  public static void main(String[] args) {
    Solution01648.test_01648();
  }
}
