package cn.geekhall.problems.p00900.p00904;

/**
 * ID: 00904
 * Title: Fruit Into Baskets
 * Difficulty: Medium
 * Description: You are visiting a farm that has a single row of fruit trees
 * arranged from left to right. The trees are represented by an integer array
 * fruits where fruits[i] is the type of fruit the i th tree produces.
 *
 * You want to collect as much fruit as possible. However, the owner has some
 * strict rules that you must follow:
 *
 * You only have two baskets, and each basket can only hold a single type of
 * fruit. There is no limit on the amount of fruit each basket can hold.
 * Starting from any tree of your choice, you must pick exactly one fruit from
 * every tree (including the start tree) while moving to the right. The picked
 * fruits must fit in one of your baskets.
 * Once you reach a tree with fruit that cannot fit in your baskets, you must
 * stop.
 *
 * Given the integer array fruits, return the maximum number of fruits you can
 * pick.
 *
 * Example 1:
 *
 * Input: fruits = [ 1,2,1 ] Output: 3 Explanation: We can pick from all 3
 * trees.
 *
 * Example 2:
 *
 * Input: fruits = [0, 1,2,2 ] Output: 3 Explanation: We can pick from trees
 * [1,2,2]. If we had started at the first tree, we would only pick from trees
 * [0,1].
 *
 * Example 3:
 *
 * Input: fruits = [1, 2, 3, 2, 2 ] Output: 4 Explanation: We can pick from
 * trees
 * [2,3,2,2]. If we had started at the first tree, we would only pick from trees
 * [1,2].
 *
 * Constraints:
 *
 * 1 <= fruits.length <= 10 5
 * 0 <= fruits[i] < fruits.length
 */
class Solution00904 {

  // sliding window
  public int totalFruit(int[] fruits) {
    int max = 0;
    int left = 0;
    int right = 0;
    // basket[fruit] = count
    int[] basket = new int[fruits.length];
    int basketCount = 0;
    // 滑动窗口，
    // 右边界不断右移，直到窗口内水果种类超过2，
    // 左边界右移，直到窗口内水果种类小于等于2
    while (right < fruits.length) {
      int fruit = fruits[right];
      if (basket[fruit] == 0) {
        basketCount++;
      }
      basket[fruit]++;
      right++;
      while (basketCount > 2) {
        int fruit2 = fruits[left];
        basket[fruit2]--;
        if (basket[fruit2] == 0) {
          basketCount--;
        }
        left++;
      }
      max = Math.max(max, right - left);
    }
    return max;
  }

  public static void test_00904() {
    Solution00904 solution = new Solution00904();
    int[] fruits = { 1, 2, 1 };
    int result = solution.totalFruit(fruits);
    System.out.println(result);
    int[] fruits2 = { 0, 1, 2, 2 };
    int result2 = solution.totalFruit(fruits2);
    System.out.println(result2);
    int[] fruits3 = { 1, 2, 3, 2, 2 };
    int result3 = solution.totalFruit(fruits3);
    System.out.println(result3);
    int[] fruits4 = { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 };
    int result4 = solution.totalFruit(fruits4);
    System.out.println(result4); // 5
  }

  public static void main(String[] args) {
    Solution00904.test_00904();
  }
}
