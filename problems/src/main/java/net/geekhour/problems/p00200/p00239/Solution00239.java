package net.geekhour.problems.p00200.p00239;

import java.util.*;

/**
 * ID: 00239
 * Title: Sliding Window Maximum
 * Difficulty: Hard
 * Description: You are given an array of integers nums, there is a sliding
 * window of size k which is moving from the very left of the array to the very
 * right. You can only see the k numbers in the window. Each time the sliding
 * window moves right by one position.
 *
 * Return the max sliding window.
 *
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3 Output: [3,3,5,5,6,7] Explanation:
 * Window position Max --------------- ----- [1 3 -1] -3 5 3 6 7 3 1 [3 -1 -3] 5
 * 3 6 7 3 1 3 [-1 -3 5] 3 6 7 5 1 3 -1 [-3 5 3] 6 7 5 1 3 -1 -3 [5 3 6] 7 6 1 3
 * -1 -3 5 [3 6 7] 7
 *
 * Example 2:
 *
 * Input: nums = [1], k = 1 Output: [1]
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10 5
 * -10 4 <= nums[i] <= 10 4
 * 1 <= k <= nums.length
 */
class Solution00239 {

  public int[] maxSlidingWindow(int[] nums, int k) {
    int[] result = new int[nums.length - k + 1];
    Deque<Integer> deque = new LinkedList<>();
    for (int i = 0; i < nums.length; i++) {
      while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
        deque.pollFirst();
      }
      while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
        deque.pollLast();
      }
      deque.offerLast(i);
      if (i >= k - 1) {
        result[i - k + 1] = nums[deque.peekFirst()];
      }
    }
    return result;

  }

  public static void test_00239() {
    Solution00239 solution = new Solution00239();
    int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
    int k = 3;
    int[] result = solution.maxSlidingWindow(nums, k);
    System.out.println(Arrays.toString(result));

    nums = new int[] { 1 };
    k = 1;
    result = solution.maxSlidingWindow(nums, k);
    System.out.println(Arrays.toString(result));
  }

  public static void main(String[] args) {
    test_00239();
  }
}
