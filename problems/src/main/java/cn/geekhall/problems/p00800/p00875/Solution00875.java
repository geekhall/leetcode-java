package cn.geekhall.problems.p00800.p00875;

/**
 * ID:    00875
 * Title: Koko Eating Bananas
 * Difficulty: Medium
 * Description: Koko loves to eat bananas. There are n piles of bananas, the i th pile has piles[i] bananas. The guards have gone and will come back in h hours.
 *
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 *
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 *
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 *
 * Example 1:
 *
 * Input: piles = [3,6,7,11], h = 8 Output: 4
 *
 * Example 2:
 *
 * Input: piles = [30,11,23,4,20], h = 5 Output: 30
 *
 * Example 3:
 *
 * Input: piles = [30,11,23,4,20], h = 6 Output: 23
 *
 * Constraints:
 *
 * 1 <= piles.length <= 10 4
 * piles.length <= h <= 10 9
 * 1 <= piles[i] <= 10 9
 */
class Solution00875 {

  public int minEatingSpeed(int[] piles, int h) {
    int left = 1, right = (int) 1e9;
    while (left < right) {
      int mid = left + right >> 1;
      int cnt = 0;
      for (int pile : piles) {
        cnt += (pile + mid - 1) / mid;
      }
      if (cnt > h) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }

  public static void test_00875() {
    Solution00875 solution = new Solution00875();
    int[] piles = {3, 6, 7, 11};
    int h = 8;
    int result = solution.minEatingSpeed(piles, h);
    System.out.println(result);
    int[] piles2 = {30, 11, 23, 4, 20};
    h = 5;
    result = solution.minEatingSpeed(piles2, h);
    System.out.println(result);
    int[] piles3 = {30, 11, 23, 4, 20};
    h = 6;
    result = solution.minEatingSpeed(piles3, h);
    System.out.println(result);
  }

  public static void main(String[] args) {
    Solution00875.test_00875();
  }
}

