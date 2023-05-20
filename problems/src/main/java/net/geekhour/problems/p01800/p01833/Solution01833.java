package net.geekhour.problems.p01800.p01833;

/**
 * ID: 01833
 * Title: Maximum Ice Cream Bars
 * Difficulty: Medium
 * Description: It is a sweltering summer day, and a boy wants to buy some ice
 * cream bars.
 *
 * At the store, there are n ice cream bars. You are given an array costs of
 * length n, where costs[i] is the price of the i th ice cream bar in coins. The
 * boy initially has coins coins to spend, and he wants to buy as many ice cream
 * bars as possible.
 *
 * Return the maximum number of ice cream bars the boy can buy with coins coins.
 *
 * Note: The boy can buy the ice cream bars in any order.
 *
 * Example 1:
 *
 * Input: costs = [1,3,2,4,1], coins = 7 Output: 4 Explanation: The boy can buy
 * ice cream bars at indices 0,1,2,4 for a total price of 1 + 3 + 2 + 1 = 7.
 *
 * Example 2:
 *
 * Input: costs = [10,6,8,7,7,8], coins = 5 Output: 0 Explanation: The boy
 * cannot afford any of the ice cream bars.
 *
 * Example 3:
 *
 * Input: costs = [1,6,3,1,2,5], coins = 20 Output: 6 Explanation: The boy can
 * buy all the ice cream bars for a total price of 1 + 6 + 3 + 1 + 2 + 5 = 18.
 *
 * Constraints:
 *
 * costs.length == n
 * 1 <= n <= 10 5
 * 1 <= costs[i] <= 10 5
 * 1 <= coins <= 10 8
 */
class Solution01833 {

  public int maxIceCream(int[] costs, int coins) {
    int result = 0;
    int[] count = new int[100001];
    for (int cost : costs) {
      count[cost]++;
    }
    for (int i = 1; i < count.length; i++) {
      if (count[i] > 0) {
        if (coins >= i) {
          int num = Math.min(count[i], coins / i);
          result += num;
          coins -= num * i;
        } else {
          break;
        }
      }
    }
    return result;
  }

  public static void test_01833() {
    Solution01833 solution = new Solution01833();
    int[] costs = { 1, 3, 2, 4, 1 };
    int coins = 7;
    int result = solution.maxIceCream(costs, coins);
    System.out.println(result);
    int[] costs1 = { 10, 6, 8, 7, 7, 8 };
    int coins1 = 5;
    int result1 = solution.maxIceCream(costs1, coins1);
    System.out.println(result1);
    int[] costs2 = { 1, 6, 3, 1, 2, 5 };
    int coins2 = 20;
    int result2 = solution.maxIceCream(costs2, coins2);
    System.out.println(result2);
  }

  public static void main(String[] args) {
    Solution01833.test_01833();
  }
}
