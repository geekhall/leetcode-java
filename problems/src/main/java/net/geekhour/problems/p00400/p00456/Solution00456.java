package net.geekhour.problems.p00400.p00456;

import java.util.*;

/**
 * ID: 00456
 * Title: 132 Pattern
 * Difficulty: Medium
 * Description: Given an array of n integers nums, a 132 pattern is a
 * subsequence of three integers nums[i], nums[j] and nums[k] such that i < j <
 * k and nums[i] < nums[k] < nums[j].
 *
 * Return true if there is a 132 pattern in nums, otherwise, return false.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4] Output: false Explanation: There is no 132 pattern in
 * the sequence.
 *
 * Example 2:
 *
 * Input: nums = [3,1,4,2] Output: true Explanation: There is a 132 pattern in
 * the sequence: [1, 4, 2].
 *
 * Example 3:
 *
 * Input: nums = [-1,3,2,0] Output: true Explanation: There are three 132
 * patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 2 * 10 5
 * -10 9 <= nums[i] <= 10 9
 */
class Solution00456 {

  public boolean find132pattern(int[] nums) {
    int n = nums.length;
    if (n < 3) {
      return false;
    }
    int[] min = new int[n];
    min[0] = nums[0];
    for (int i = 1; i < n; i++) {
      min[i] = Math.min(min[i - 1], nums[i]);
    }
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = n - 1; i >= 0; i--) {
      if (nums[i] > min[i]) {
        while (!stack.isEmpty() && stack.peek() <= min[i]) {
          stack.pop();
        }
        if (!stack.isEmpty() && stack.peek() < nums[i]) {
          return true;
        }
        stack.push(nums[i]);
      }
    }
    return false;
  }

  public static void test_00456() {
    Solution00456 solution = new Solution00456();
    System.out.println(solution.find132pattern(new int[] { 1, 2, 3, 4 }));
    System.out.println(solution.find132pattern(new int[] { 3, 1, 4, 2 }));
    System.out.println(solution.find132pattern(new int[] { -1, 3, 2, 0 }));
  }

  public static void main(String[] args) {
    test_00456();
  }
}
