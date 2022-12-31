package cn.geekhall.problems.p01900.p01901;

/**
 * ID:    01901
 * Title: Find a Peak Element II
 * Difficulty: Medium
 * Description: A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.
 *
 * Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].
 *
 * You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.
 *
 * You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.
 *
 * Example 1:
 *
 * Input: mat = [[1,4],[3,2]] Output: [0,1] Explanation: Both 3 and 4 are peak elements so [1,0] and [0,1] are both acceptable answers.
 *
 * Example 2:
 *
 * Input: mat = [[10,20,15],[21,30,14],[7,16,32]] Output: [1,1] Explanation: Both 30 and 32 are peak elements so [1,1] and [2,2] are both acceptable answers.
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 500
 * 1 <= mat[i][j] <= 10 5
 * No two adjacent cells are equal.
 */
class Solution01901 {

  public int[] findPeakGrid(int[][] mat) {
    int m = mat.length;
    int left = 0, right = m - 1;
    int[] res = new int[2];
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int[] max = getMax(mat[mid]);
      if (mid > 0 && mat[mid][max[1]] < mat[mid - 1][max[1]]) {
        right = mid - 1;
      } else if (mid < m - 1 && mat[mid][max[1]] < mat[mid + 1][max[1]]) {
        left = mid + 1;
      } else {
        res[0] = mid;
        res[1] = max[1];
        break;
      }
    }
    return res;
  }

  private int[] getMax(int[] is) {
    int max = Integer.MIN_VALUE;
    int[] res = new int[2];
    for (int i = 0; i < is.length; i++) {
      if (is[i] > max) {
        max = is[i];
        res[0] = max;
        res[1] = i;
      }
    }
    return res;
  }

  public static void test_01901() {
    Solution01901 solution = new Solution01901();
    int[][] mat = {{1, 4}, {3, 2}};
    int[] res = solution.findPeakGrid(mat);
    System.out.println(res[0] + ", " + res[1]);
    int[][] mat2 = {{10, 20, 15}, {21, 30, 14}, {7, 16, 32}};
    int[] res2 = solution.findPeakGrid(mat2);
    System.out.println(res2[0] + ", " + res2[1]);

  }

  public static void main(String[] args) {
    Solution01901.test_01901();
  }
}

