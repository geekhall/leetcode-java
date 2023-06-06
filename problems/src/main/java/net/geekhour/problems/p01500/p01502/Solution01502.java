package net.geekhour.problems.p01500.p01502;

import java.util.*;

/**
 * ID: 01502
 * Title: Can Make Arithmetic Progression From Sequence
 * Difficulty: Easy
 * Description: A sequence of numbers is called an arithmetic progression if the
 * difference between any two consecutive elements is the same.
 *
 * Given an array of numbers arr, return true if the array can be rearranged to
 * form an arithmetic progression. Otherwise, return false.
 *
 * Example 1:
 *
 * Input: arr = [3,5,1] Output: true Explanation: We can reorder the elements as
 * [1,3,5] or [5,3,1] with differences 2 and -2 respectively, between each
 * consecutive elements.
 *
 * Example 2:
 *
 * Input: arr = [1,2,4] Output: false Explanation: There is no way to reorder
 * the elements to obtain an arithmetic progression.
 *
 * Constraints:
 *
 * 2 <= arr.length <= 1000
 * -10 6 <= arr[i] <= 10 6
 */
class Solution01502 {

  public boolean canMakeArithmeticProgression(int[] arr) {
    int n = arr.length;
    if (n == 2) {
      return true;
    }
    Arrays.sort(arr);
    int d = arr[1] - arr[0];
    for (int i = 2; i < n; i++) {
      if (arr[i] - arr[i - 1] != d) {
        return false;
      }
    }
    return true;
  }

  public static void test_01502() {
    Solution01502 solution = new Solution01502();
    int[] arr = { 3, 5, 1 };
    boolean expected = true;
    boolean actual = solution.canMakeArithmeticProgression(arr);
    System.out.println("expected: " + expected + ", actual: " + actual);
    int[] arr2 = { 1, 2, 4 };
    boolean expected2 = false;
    boolean actual2 = solution.canMakeArithmeticProgression(arr2);
    System.out.println("expected: " + expected2 + ", actual: " + actual2);
  }

  public static void main(String[] args) {
    Solution01502.test_01502();
  }
}
