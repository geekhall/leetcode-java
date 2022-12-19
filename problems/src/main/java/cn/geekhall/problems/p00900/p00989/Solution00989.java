package cn.geekhall.problems.p00900.p00989;

import java.util.List;

/**
 * ID:    00989
 * Title: Add to Array-Form of Integer
 * Difficulty: Easy
 * Description: The array-form of an integer num is an array representing its digits in left to right order.
 *
 * For example, for num = 1321, the array form is [1,3,2,1].
 *
 * Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.
 *
 * Example 1:
 *
 * Input: num = [1,2,0,0], k = 34 Output: [1,2,3,4] Explanation: 1200 + 34 = 1234
 *
 * Example 2:
 *
 * Input: num = [2,7,4], k = 181 Output: [4,5,5] Explanation: 274 + 181 = 455
 *
 * Example 3:
 *
 * Input: num = [2,1,5], k = 806 Output: [1,0,2,1] Explanation: 215 + 806 = 1021
 *
 * Constraints:
 *
 * 1 <= num.length <= 10 4
 * 0 <= num[i] <= 9
 * num does not contain any leading zeros except for the zero itself.
 * 1 <= k <= 10 4
 */
class Solution00989 {

  public List<Integer> addToArrayForm(int[] num, int k) {
    int len = num.length;
    for (int i = len - 1; i >= 0; i--) {

    }
    return null;
  }

  public static void test_00989() {
    Solution00989 solution = new Solution00989();
    int[] num = {1, 2, 0, 0};
    int k = 34;
    List<Integer> result = solution.addToArrayForm(num, k);
    System.out.println(result);
  }

  public static void main(String[] args) {
    Solution00989.test_00989();
  }
}

