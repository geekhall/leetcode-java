package net.geekhour.problems.p00100.p00118;

import java.util.*;

/**
 * ID: 00118
 * Title: Pascal's Triangle
 * Difficulty: Easy
 * Description: Given an integer numRows, return the first numRows of Pascal's
 * triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it as shown:
 *
 * Example 1:
 *
 * Input: numRows = 5 Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * Example 2:
 *
 * Input: numRows = 1 Output: [[1]]
 *
 * Constraints:
 *
 * 1 <= numRows <= 30
 */
class Solution00118 {

  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      List<Integer> row = new ArrayList<>();
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
          row.add(1);
        } else {
          row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
        }
      }
      result.add(row);
    }
    return result;
  }

  public static void test_00118() {
    Solution00118 solution = new Solution00118();
    System.out.println(solution.generate(5));
    System.out.println(solution.generate(1));
  }

  public static void main(String[] args) {
    test_00118();
  }
}
