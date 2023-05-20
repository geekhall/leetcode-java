package net.geekhour.problems.p00600.p00605;

import java.util.*;

/**
 * ID: 00605
 * Title: Can Place Flowers
 * Difficulty: Easy
 * Description: You have a long flowerbed in which some of the plots are
 * planted, and some are not. However, flowers cannot be planted in adjacent
 * plots.
 *
 * Given an integer array flowerbed containing 0 's and 1 's, where 0 means
 * empty and 1 means not empty, and an integer n, return if n new flowers can be
 * planted in the flowerbed without violating the no-adjacent-flowers rule.
 *
 * Example 1:
 *
 * Input: flowerbed = [1,0,0,0,1], n = 1 Output: true
 *
 * Example 2:
 *
 * Input: flowerbed = [1,0,0,0,1], n = 2 Output: false
 *
 * Constraints:
 *
 * 1 <= flowerbed.length <= 2 * 10 4
 * flowerbed[i] is 0 or 1.
 * There are no two adjacent flowers in flowerbed.
 * 0 <= n <= flowerbed.length
 */
class Solution00605 {

  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int count = 0;
    int len = flowerbed.length;
    for (int i = 0; i < len; i++) {
      if (flowerbed[i] == 0) {
        if (i == 0) {
          if (len == 1 || flowerbed[i + 1] == 0) { // 只有一个元素，或者第二个元素为0
            count++;
            flowerbed[i] = 1;
          }
        } else if (i == len - 1) { // 最后一个元素
          if (flowerbed[i - 1] == 0) { // 倒数第二个元素为0
            count++;
            flowerbed[i] = 1;
          }
        } else { // 中间元素
          if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
            count++;
            flowerbed[i] = 1;
          }
        }
      }
    }
    return count >= n;
  }

  public static void test_00605() {
    Solution00605 solution00605 = new Solution00605();
    int[] flowerbed = { 1, 0, 0, 0, 1 };
    int n = 1;
    System.out.println(solution00605.canPlaceFlowers(flowerbed, n));
    int[] flowerbed2 = { 1, 0, 0, 0, 1 };
    int n2 = 2;
    System.out.println(solution00605.canPlaceFlowers(flowerbed2, n2));

  }

  public static void main(String[] args) {
    Solution00605.test_00605();
  }
}
