package cn.geekhall.problems.p00400.p00436;

import java.util.Arrays;

/**
 * ID:    00436
 * Title: Find Right Interval
 * Difficulty: Medium
 * Description: You are given an array of intervals, where intervals[i] = [start i, end i ] and each start i is unique.
 *
 * The right interval for an interval i is an interval j such that start j >= end i and start j is minimized. Note that i may equal j.
 *
 * Return an array of right interval indices for each interval i. If no right interval exists for interval i, then put -1 at index i.
 *
 * Example 1:
 *
 * Input: intervals = [[1,2]] Output: [-1] Explanation: There is only one interval in the collection, so it outputs -1.
 *
 * Example 2:
 *
 * Input: intervals = [[3,4],[2,3],[1,2]] Output: [-1,0,1] Explanation: There is no right interval for [3,4]. The right interval for [2,3] is [3,4] since start 0 = 3 is the smallest start that is >= end 1 = 3. The right interval for [1,2] is [2,3] since start 1 = 2 is the smallest start that is >= end 2 = 2.
 *
 * Example 3:
 *
 * Input: intervals = [[1,4],[2,3],[3,4]] Output: [-1,2,-1] Explanation: There is no right interval for [1,4] and [3,4]. The right interval for [2,3] is [3,4] since start 2 = 3 is the smallest start that is >= end 1 = 3.
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 2 * 10 4
 * intervals[i].length == 2
 * -10 6 <= start i <= end i <= 10 6
 * The start point of each interval is unique.
 */
class Solution00436 {

  // wrong answer when [[1,1],[3,4]]
  public int[] findRightInterval(int[][] intervals) {
    int[] result = new int[intervals.length];
    for (int i = 0; i < intervals.length; i++) {
      int[] interval = intervals[i];
      int min = Integer.MAX_VALUE;
      int minIndex = -1;
      for (int j = 0; j < intervals.length; j++) {
        if (i == j) {
          continue;
        }
        int[] interval2 = intervals[j];
        if (interval2[0] >= interval[1] && interval2[0] < min) {
          min = interval2[0];
          minIndex = j;
        }
      }
      result[i] = minIndex;
    }
    return result;
  }

  public static void test_00436() {
    Solution00436 solution = new Solution00436();
    int[][] intervals = {{1, 2}};
    int[] result = solution.findRightInterval(intervals);
    System.out.println(Arrays.toString(result));
    int[][] intervals2 = {{3, 4}, {2, 3}, {1, 2}};
    result = solution.findRightInterval(intervals2);
    System.out.println(Arrays.toString(result));
    int[][] intervals3 = {{1, 4}, {2, 3}, {3, 4}};
    result = solution.findRightInterval(intervals3);
    System.out.println(Arrays.toString(result));

  }

  public static void main(String[] args) {
    Solution00436.test_00436();
  }
}

