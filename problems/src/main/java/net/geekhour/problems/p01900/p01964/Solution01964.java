package net.geekhour.problems.p01900.p01964;

import java.util.*;

/**
 * ID: 01964
 * Title: Find the Longest Valid Obstacle Course at Each Position
 * Difficulty: Hard
 * Description: You want to build some obstacle courses. You are given a
 * 0-indexed integer array obstacles of length n, where obstacles[i] describes
 * the height of the i th obstacle.
 *
 * For every index i between 0 and n - 1 (inclusive), find the length of the
 * longest obstacle course in obstacles such that:
 *
 * You choose any number of obstacles between 0 and i inclusive.
 * You must include the i th obstacle in the course.
 * You must put the chosen obstacles in the same order as they appear in
 * obstacles.
 * Every obstacle (except the first) is taller than or the same height as the
 * obstacle immediately before it.
 *
 * Return an array ans of length n, where ans[i] is the length of the longest
 * obstacle course for index i as described above.
 *
 * Example 1:
 *
 * Input: obstacles = [1,2,3,2] Output: [1,2,3,3] Explanation: The longest valid
 * obstacle course at each position is: - i = 0: [ 1 ], [1] has length 1. - i =
 * 1: [ 1, 2 ], [1,2] has length 2. - i = 2: [ 1, 2, 3 ], [1,2,3] has length 3.
 * - i = 3: [ 1, 2,3, 2 ], [1,2,2] has length 3.
 *
 * Example 2:
 *
 * Input: obstacles = [2,2,1] Output: [1,2,1] Explanation: The longest valid
 * obstacle course at each position is: - i = 0: [ 2 ], [2] has length 1. - i =
 * 1: [ 2, 2 ], [2,2] has length 2. - i = 2: [2,2, 1 ], [1] has length 1.
 *
 * Example 3:
 *
 * Input: obstacles = [3,1,5,6,4,2] Output: [1,1,2,3,2,2] Explanation: The
 * longest valid obstacle course at each position is: - i = 0: [ 3 ], [3] has
 * length 1. - i = 1: [3, 1 ], [1] has length 1. - i = 2: [ 3,1, 5 ], [3,5] has
 * length 2. [1,5] is also valid. - i = 3: [ 3,1, 5, 6 ], [3,5,6] has length 3.
 * [1,5,6] is also valid. - i = 4: [ 3,1,5,6, 4 ], [3,4] has length 2. [1,4] is
 * also valid. - i = 5: [3, 1,5,6,4, 2 ], [1,2] has length 2.
 *
 * Constraints:
 *
 * n == obstacles.length
 * 1 <= n <= 10 5
 * 1 <= obstacles[i] <= 10 7
 */
class Solution01964 {

  public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
    int n = obstacles.length;
    int[] ans = new int[n];
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int obstacle = obstacles[i];
      if (list.size() == 0 || list.get(list.size() - 1) <= obstacle) {
        list.add(obstacle);
        ans[i] = list.size();
      } else {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
          int mid = left + (right - left) / 2;
          if (list.get(mid) <= obstacle) {
            left = mid + 1;
          } else {
            right = mid;
          }
        }
        list.set(left, obstacle);
        ans[i] = left + 1;
      }
    }
    return ans;
  }

  public static void test_01964() {
    Solution01964 solution = new Solution01964();
    int[] obstacles = { 1, 2, 3, 2 };
    int[] ans = solution.longestObstacleCourseAtEachPosition(obstacles);
    System.out.println(Arrays.toString(ans));
    int[] obstacles2 = { 2, 2, 1 };
    int[] ans2 = solution.longestObstacleCourseAtEachPosition(obstacles2);
    System.out.println(Arrays.toString(ans2));
    int[] obstacles3 = { 3, 1, 5, 6, 4, 2 };
    int[] ans3 = solution.longestObstacleCourseAtEachPosition(obstacles3);
    System.out.println(Arrays.toString(ans3));
  }

  public static void main(String[] args) {
    Solution01964.test_01964();
  }
}
