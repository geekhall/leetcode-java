package net.geekhour.problems.p00500.p00503;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * ID: 00503
 * Title: Next Greater Element II
 * Difficulty: Medium
 * Description: Given a circular integer array nums (i.e., the next element of
 * nums[nums.length - 1] is nums[0]), return the next greater number for every
 * element in nums.
 *
 * The next greater number of a number x is the first greater number to its
 * traversing-order next in the array, which means you could search circularly
 * to find its next greater number. If it doesn't exist, return -1 for this
 * number.
 *
 * Example 1:
 *
 * Input: nums = [1,2,1] Output: [2,-1,2] Explanation: The first 1's next
 * greater number is 2; The number 2 can't find next greater number. The second
 * 1's next greater number needs to search circularly, which is also 2.
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,4,3] Output: [2,3,4,-1,4]
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10 4
 * -10 9 <= nums[i] <= 10 9
 */
class Solution00503 {

  // More efficient solution.
  public int[] nextGreaterElements(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    Arrays.fill(result, -1);
    Deque<Integer> stack = new LinkedList<>();
    for (int i = 0; i < n * 2 - 1; i++) {
      while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
        result[stack.pop()] = nums[i % n];
      }
      stack.push(i % n);
    }
    return result;
  }

  public static void test_00503() {
    Solution00503 solution = new Solution00503();
    int[] nums = { 1, 2, 1 };
    int[] result = solution.nextGreaterElements(nums);
    System.out.println(Arrays.toString(result));
  }

  public static void main(String[] args) {
    Solution00503.test_00503();
  }
}
