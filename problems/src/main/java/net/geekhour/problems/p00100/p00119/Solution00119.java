package net.geekhour.problems.p00100.p00119;

import java.util.*;

/**
 * ID: 00119
 * Title: Pascal's Triangle II
 * Difficulty: Easy
 * Description: Given an integer rowIndex, return the rowIndex th (0-indexed)
 * row of the Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it as shown:
 *
 * Example 1:
 *
 * Input: rowIndex = 3 Output: [1,3,3,1]
 *
 * Example 2:
 *
 * Input: rowIndex = 0 Output: [1]
 *
 * Example 3:
 *
 * Input: rowIndex = 1 Output: [1,1]
 *
 * Constraints:
 *
 * 0 <= rowIndex <= 33
 *
 * Follow up: Could you optimize your algorithm to use only O(rowIndex) extra
 * space?
 */
class Solution00119 {

  public List<Integer> getRow(int rowIndex) {
    List<Integer> result = new ArrayList<>();
    result.add(1);
    for (int i = 1; i <= rowIndex; i++) {
      result.add(1);
      for (int j = i - 1; j > 0; j--) {
        result.set(j, result.get(j) + result.get(j - 1));
      }
    }
    return result;
  }

  public static void test_00119() {
    Solution00119 solution = new Solution00119();
    System.out.println(solution.getRow(3));
    System.out.println(solution.getRow(0));
    System.out.println(solution.getRow(1));
  }

  public static void main(String[] args) {
    test_00119();
  }
}
