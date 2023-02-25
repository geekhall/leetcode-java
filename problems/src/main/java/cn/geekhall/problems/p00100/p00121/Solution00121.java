package cn.geekhall.problems.p00100.p00121;

/**
 * ID: 00121
 * Title: Best Time to Buy and Sell Stock
 * Difficulty: Easy
 * Description: You are given an array prices where prices[i] is the price of a
 * given stock on the i th day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you
 * cannot achieve any profit, return 0.
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4] Output: 5 Explanation: Buy on day 2 (price = 1)
 * and sell on day 5 (price = 6), profit = 6-1 = 5. Note that buying on day 2
 * and selling on day 1 is not allowed because you must buy before you sell.
 *
 * Example 2:
 *
 * Input: prices = [7,6,4,3,1] Output: 0 Explanation: In this case, no
 * transactions are done and the max profit = 0.
 *
 * Constraints:
 *
 * 1 <= prices.length <= 10 5
 * 0 <= prices[i] <= 10 4
 */
class Solution00121 {

  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    int minPrice = Integer.MAX_VALUE;
    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < minPrice) {
        minPrice = prices[i];
      } else if (prices[i] - minPrice > maxProfit) {
        maxProfit = prices[i] - minPrice;
      }
    }
    return maxProfit;
  }

  public static void test_00121() {
    Solution00121 solution = new Solution00121();
    int[] prices = { 7, 1, 5, 3, 6, 4 };
    int result = solution.maxProfit(prices);
    System.out.println(result);
    int[] prices2 = { 7, 6, 4, 3, 1 };
    int result2 = solution.maxProfit(prices2);
    System.out.println(result2);
  }

  public static void main(String[] args) {
    Solution00121.test_00121();
  }
}
