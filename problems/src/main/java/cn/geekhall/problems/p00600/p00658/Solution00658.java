package cn.geekhall.problems.p00600.p00658;

import java.util.ArrayList;
import java.util.List;

/**
 * ID:    00658
 * Title: Find K Closest Elements
 * Difficulty: Medium
 * Description: Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
 *
 * An integer a is closer to x than an integer b if:
 *
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 *
 * Example 1:
 *
 * Input: arr = [1,2,3,4,5], k = 4, x = 3 Output: [1,2,3,4]
 *
 * Example 2:
 *
 * Input: arr = [1,2,3,4,5], k = 4, x = -1 Output: [1,2,3,4]
 *
 * Constraints:
 *
 * 1 <= k <= arr.length
 * 1 <= arr.length <= 10 4
 * arr is sorted in ascending order.
 * -10 4 <= arr[i], x <= 10 4
 */
class Solution00658 {

  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    List<Integer> result = new ArrayList<>();
    int len = arr.length;
    int left = 0;
    int right = len - 1;
    while (left < right) {
      int mid = (left + right) / 2;
      if (arr[mid] > x) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    int index = left;
    int leftIndex = index - 1;
    int rightIndex = index;
    while (k > 0) {
      if (leftIndex < 0) {
        result.add(arr[rightIndex]);
        rightIndex++;
      } else if (rightIndex >= len) {
        result.add(arr[leftIndex]);
        leftIndex--;
      } else {
        if (Math.abs(arr[leftIndex] - x) <= Math.abs(arr[rightIndex] - x)) {
          result.add(arr[leftIndex]);
          leftIndex--;
        } else {
          result.add(arr[rightIndex]);
          rightIndex++;
        }
      }
      k--;
    }
    result.sort((a, b) -> a - b);
    return result;
  }

  public static void test_00658() {
    Solution00658 solution = new Solution00658();
    int[] arr = {1, 2, 3, 4, 5};
    int k = 4;
    int x = 3;
    List<Integer> result = solution.findClosestElements(arr, k, x);
    System.out.println(result);
    int[] arr2 = {1, 2, 3, 4, 5};
    k = 4;
    x = -1;
    result = solution.findClosestElements(arr2, k, x);
    System.out.println(result);
  }

  public static void main(String[] args) {
    Solution00658.test_00658();
  }
}

