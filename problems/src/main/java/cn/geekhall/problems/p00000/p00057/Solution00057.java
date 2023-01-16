package cn.geekhall.problems.p00000.p00057;

import java.util.Arrays;

/**
 * ID:    00057
 * Title: Insert Interval
 * Difficulty: Medium
 * Description: You are given an array of non-overlapping intervals intervals where intervals[i] = [start i, end i ] represent the start and the end of the i th interval and intervals is sorted in ascending order by start i. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by start i and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 *
 * Return intervals after the insertion.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5] Output: [[1,5],[6,9]]
 *
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8] Output: [[1,2],[3,10],[12,16]] Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *
 * Constraints:
 *
 * 0 <= intervals.length <= 10 4
 * intervals[i].length == 2
 * 0 <= start i <= end i <= 10 5
 * intervals is sorted by start i in ascending order.
 * newInterval.length == 2
 * 0 <= start <= end <= 10 5
 */
class Solution00057 {

  public int[][] insert(int[][] intervals, int[] newInterval) {
    int[][] result = new int[intervals.length + 1][2];
    int i = 0;
    int j = 0;
    while (i < intervals.length && intervals[i][1] < newInterval[0]) {
      result[j++] = intervals[i++];
    }

    while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
      newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
      newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
      i++;
    }

    result[j++] = newInterval;
    while (i < intervals.length) {
      result[j++] = intervals[i++];
    }

    return Arrays.copyOf(result, j);
  }

  public static void test_00057() {
    Solution00057 solution = new Solution00057();
    int[][] intervals = {{1,3},{6,9}};
    int[] newInterval = {2,5};
    int[][] result = solution.insert(intervals, newInterval);
    System.out.println(Arrays.deepToString(result));
    int[][] intervals2 = {{1,2},{3,5},{6,7},{8,10},{12,16}};
    int[] newInterval2 = {4,8};
    int[][] result2 = solution.insert(intervals2, newInterval2);
    System.out.println(Arrays.deepToString(result2));
  }

  public static void main(String[] args) {
    Solution00057.test_00057();
  }
}

