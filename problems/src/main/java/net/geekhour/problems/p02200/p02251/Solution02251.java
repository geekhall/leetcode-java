package net.geekhour.problems.p02200.p02251;

import java.util.*;

/**
 * ID: 02251
 * Title: Number of Flowers in Full Bloom
 * Difficulty: Hard
 * Description: You are given a 0-indexed 2D integer array flowers, where
 * flowers[i] = [start i, end i ] means the i th flower will be in full bloom
 * from start i to end i (inclusive). You are also given a 0-indexed integer
 * array people of size n, where people[i] is the time that the i th person will
 * arrive to see the flowers.
 *
 * Return an integer array answer of size n, where answer[i] is the number of
 * flowers that are in full bloom when the i th person arrives.
 *
 * Example 1:
 *
 * Input: flowers = [[1,6],[3,7],[9,12],[4,13]], poeple = [2,3,7,11] Output:
 * [1,2,2,2] Explanation: The figure above shows the times when the flowers are
 * in full bloom and when the people arrive. For each person, we return the
 * number of flowers in full bloom during their arrival.
 *
 * Example 2:
 *
 * Input: flowers = [[1,10],[3,3]], poeple = [3,3,2] Output: [2,2,1]
 * Explanation: The figure above shows the times when the flowers are in full
 * bloom and when the people arrive. For each person, we return the number of
 * flowers in full bloom during their arrival.
 *
 * Constraints:
 *
 * 1 <= flowers.length <= 5 * 10 4
 * flowers[i].length == 2
 * 1 <= start i <= end i <= 10 9
 * 1 <= people.length <= 5 * 10 4
 * 1 <= people[i] <= 10 9
 */
class Solution02251 {

  public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
    int n = flowers.length;
    int[] start = new int[n];
    int[] end = new int[n];

    for (int i = 0; i < n; i++) {
      start[i] = flowers[i][0];
      end[i] = flowers[i][1];
    }

    Arrays.sort(start);
    Arrays.sort(end);

    int[] res = new int[persons.length];

    for (int i = 0; i < persons.length; i++) {
      int t = persons[i];
      int started = binarySearchUpperBound(start, t);
      int ended = binarySearchLowerBound(end, t);
      res[i] = started - ended;
    }

    return res;
  }

  private int binarySearchUpperBound(int[] arr, int target) {
    int left = 0;
    int right = arr.length;

    while (left < right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] <= target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    return left;
  }

  private int binarySearchLowerBound(int[] arr, int target) {
    int left = 0;
    int right = arr.length;

    while (left < right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] < target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    return left;
  }

  public static void test_02251() {
    Solution02251 solution = new Solution02251();
    int[][] flowers = new int[][] { { 1, 6 }, { 3, 7 }, { 9, 12 }, { 4, 13 } };
    int[] people = new int[] { 2, 3, 7, 11 };
    int[] result = solution.fullBloomFlowers(flowers, people);
    System.out.println(Arrays.toString(result));
    flowers = new int[][] { { 1, 10 }, { 3, 3 } };
    people = new int[] { 3, 3, 2 };
    result = solution.fullBloomFlowers(flowers, people);
    System.out.println(Arrays.toString(result));
  }

  public static void main(String[] args) {
    test_02251();
  }
}
