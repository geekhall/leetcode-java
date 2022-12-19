package cn.geekhall.problems.p00900.p00989;

import java.util.ArrayList;
import java.util.Arrays;
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

  /**
   * 从数组的最后一位开始，依次与k的个位相加，如果相加的结果大于10，则k进1，否则k不变。
   * 依次类推，直到k为0
   * 如果k还有剩余，则将剩余的k插入到数组的最前面
   * 最后将数组转换为List返回
   * 时间复杂度：O(n)
   * 空间复杂度：O(n)
   *
   *
   * @param num
   * @param k
   * @return
   */
  public List<Integer> addToArrayForm(int[] num, int k) {
    int len = num.length;

    // 从数组的最后一位开始，依次与k的个位相加，如果相加的结果大于10，则k进1，否则k不变。
    for (int i = len - 1; i >= 0; i--) {
      int sum = num[i] + k % 10;
      k /= 10;
      if (sum >= 10) {
        k++; // 进位
        sum -= 10;
      }
      num[i] = sum;
    }

    // 如果k还有剩余(k数值比num表示的数值更大/更长)，则将剩余的k插入到数组的最前面
    while (k > 0) {
      int[] newNum = new int[len + 1];
      newNum[0] = k % 10;
      k /= 10;
      System.arraycopy(num, 0, newNum, 1, len);
      num = newNum;
      len++;
    }
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < len; i++) {
      result.add(num[i]);
    }
    return result;
  }

  public static void test_00989() {
    Solution00989 solution = new Solution00989();
    int[] num = {1, 2, 6, 6};
    int k = 12345;
    List<Integer> result = solution.addToArrayForm(num, k);
    System.out.println(result);
  }

  public static void main(String[] args) {
    Solution00989.test_00989();
  }
}

