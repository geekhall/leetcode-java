package net.geekhour.problems.p00300.p00352;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * ID: 00352
 * Title: Data Stream as Disjoint Intervals
 * Difficulty: Hard
 * Description: Given a data stream input of non-negative integers a 1, a 2,
 * ..., a n, summarize the numbers seen so far as a list of disjoint intervals.
 *
 * Implement the SummaryRanges class:
 *
 * SummaryRanges() Initializes the object with an empty stream.
 * void addNum(int value) Adds the integer value to the stream.
 * int[][] getIntervals() Returns a summary of the integers in the stream
 * currently as a list of disjoint intervals [start i, end i ]. The answer
 * should be sorted by start i.
 *
 * Example 1:
 *
 * Input ["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals",
 * "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
 * [[], [1], [], [3], [], [7], [], [2], [], [6], []] Output [null, null, [[1,
 * 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3],
 * [7, 7]], null, [[1, 3], [6, 7]]] Explanation SummaryRanges summaryRanges =
 * new SummaryRanges(); summaryRanges.addNum(1); // arr = [1]
 * summaryRanges.getIntervals(); // return [[1, 1]] summaryRanges.addNum(3); //
 * arr = [1, 3] summaryRanges.getIntervals(); // return [[1, 1], [3, 3]]
 * summaryRanges.addNum(7); // arr = [1, 3, 7] summaryRanges.getIntervals(); //
 * return [[1, 1], [3, 3], [7, 7]] summaryRanges.addNum(2); // arr = [1, 2, 3,
 * 7] summaryRanges.getIntervals(); // return [[1, 3], [7, 7]]
 * summaryRanges.addNum(6); // arr = [1, 2, 3, 6, 7]
 * summaryRanges.getIntervals(); // return [[1, 3], [6, 7]]
 *
 * Constraints:
 *
 * 0 <= value <= 10 4
 * At most 3 * 10 4 calls will be made to addNum and getIntervals.
 *
 * Follow up: What if there are lots of merges and the number of disjoint
 * intervals is small compared to the size of the data stream?
 */
class SummaryRanges {

  // {start: {start, end}}
  private TreeMap<Integer, int[]> map = new TreeMap<>();

  public SummaryRanges() {
  }

  public void addNum(int value) {
    if (map.containsKey(value))
      return;

    final Integer lo = map.lowerKey(value); // Maximum in map < key
    final Integer hi = map.higherKey(value); // Minimum in map > key

    // {lo, map.get(lo)[1]} + val + {hi, map.get(hi)[1]} = {lo, map.get(hi)[1]}
    if (lo != null && hi != null && map.get(lo)[1] + 1 == value && value + 1 == hi) {
      map.get(lo)[1] = map.get(hi)[1];
      map.remove(hi);
      // {lo, map.get(lo)[1]} + val = {lo, val}
      // (prevent adding duplicate entry by using '>=' instead of '==')
    } else if (lo != null && map.get(lo)[1] + 1 >= value) {
      map.get(lo)[1] = Math.max(map.get(lo)[1], value);
      // Val + {hi, map.get(hi)[1]} = {val, map.get(hi)[1]}
    } else if (hi != null && value + 1 == hi) {
      map.put(value, new int[] { value, map.get(hi)[1] });
      map.remove(hi);
    } else {
      map.put(value, new int[] { value, value });
    }
  }

  public int[][] getIntervals() {
    List<int[]> intervals = new ArrayList<>(map.values());
    return intervals.toArray(new int[intervals.size()][]);
  }

  public static void test_00352() {
    SummaryRanges summaryRanges = new SummaryRanges();
    summaryRanges.addNum(1); // arr = [1]
    System.out.println(Arrays.deepToString(summaryRanges.getIntervals())); // return [[1, 1]]
    summaryRanges.addNum(3); // arr = [1, 3]
    System.out.println(Arrays.deepToString(summaryRanges.getIntervals())); // return [[1, 1], [3, 3]]
    summaryRanges.addNum(7); // arr = [1, 3, 7]
    System.out.println(Arrays.deepToString(summaryRanges.getIntervals())); // return [[1, 1], [3, 3], [7, 7]]
    summaryRanges.addNum(2); // arr = [1, 2, 3, 7]
    System.out.println(Arrays.deepToString(summaryRanges.getIntervals())); // return [[1, 3], [7, 7]]
    summaryRanges.addNum(6); // arr = [1, 2, 3, 6, 7]
    System.out.println(Arrays.deepToString(summaryRanges.getIntervals())); // return [[1, 3], [6, 7]]
  }

  public static void main(String[] args) {
    SummaryRanges.test_00352();
  }
}
