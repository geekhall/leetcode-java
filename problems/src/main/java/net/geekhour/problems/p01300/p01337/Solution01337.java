package net.geekhour.problems.p01300.p01337;

import java.util.*;

/**
 * ID: 01337
 * Title: The K Weakest Rows in a Matrix
 * Difficulty: Easy
 * Description: You are given an m x n binary matrix mat of 1 's (representing
 * soldiers) and 0 's (representing civilians). The soldiers are positioned in
 * front of the civilians. That is, all the 1 's will appear to the left of all
 * the 0 's in each row.
 *
 * A row i is weaker than a row j if one of the following is true:
 *
 * The number of soldiers in row i is less than the number of soldiers in row j.
 * Both rows have the same number of soldiers and i < j.
 *
 * Return the indices of the k weakest rows in the matrix ordered from weakest
 * to strongest.
 *
 * Example 1:
 *
 * Input: mat = [[1,1,0,0,0], [1,1,1,1,0], [1,0,0,0,0], [1,1,0,0,0],
 * [1,1,1,1,1]], k = 3 Output: [2,0,3] Explanation: The number of soldiers in
 * each row is: - Row 0: 2 - Row 1: 4 - Row 2: 1 - Row 3: 2 - Row 4: 5 The rows
 * ordered from weakest to strongest are [2,0,3,1,4].
 *
 * Example 2:
 *
 * Input: mat = [[1,0,0,0], [1,1,1,1], [1,0,0,0], [1,0,0,0]], k = 2 Output:
 * [0,2] Explanation: The number of soldiers in each row is: - Row 0: 1 - Row 1:
 * 4 - Row 2: 1 - Row 3: 1 The rows ordered from weakest to strongest are
 * [0,2,3,1].
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 2 <= n, m <= 100
 * 1 <= k <= m
 * matrix[i][j] is either 0 or 1.
 */
class Solution01337 {

  public int[] kWeakestRows(int[][] mat, int k) {
    int[] result = new int[k];
    int[] soldiers = new int[mat.length];
    for (int i = 0; i < mat.length; i++) {
      int[] row = mat[i];
      int count = 0;
      for (int j = 0; j < row.length; j++) {
        if (row[j] == 1) {
          count++;
        } else {
          break;
        }
      }
      soldiers[i] = count;
    }

    int[] sorted = Arrays.copyOf(soldiers, soldiers.length);
    Arrays.sort(sorted);

    Set<Integer> visited = new HashSet<>();
    for (int i = 0; i < k; i++) {
      int min = sorted[i];
      for (int j = 0; j < soldiers.length; j++) {
        if (soldiers[j] == min && !visited.contains(j)) {
          result[i] = j;
          visited.add(j);
          break;
        }
      }
    }

    return result;
  }

  public static void test_01337() {
    Solution01337 solution = new Solution01337();
    int[][] mat = new int[][] { { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 0 },
        { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 1 } };
    int k = 3;
    int[] expected = new int[] { 2, 0, 3 };

    int[] actual = solution.kWeakestRows(mat, k);
    System.out.println("expected: " + Arrays.toString(expected) + ", actual: " + Arrays.toString(actual));

    int[][] mat2 = new int[][] { { 1, 0, 0, 0 }, { 1, 1, 1, 1 },
        { 1, 0, 0, 0 }, { 1, 0, 0, 0 } };
    k = 2;
    expected = new int[] { 0, 2 };
    int[] actual2 = solution.kWeakestRows(mat2, k);
    System.out.println("expected: " + Arrays.toString(expected) + ", actual: " + Arrays.toString(actual2));
  }

  public static void main(String[] args) {
    test_01337();
  }
}
