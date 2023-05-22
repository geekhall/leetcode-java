package net.geekhour.problems.p00300.p00347;

import java.util.*;

/**
 * ID: 00347
 * Title: Top K Frequent Elements
 * Difficulty: Medium
 * Description: Given an integer array nums and an integer k, return the k most
 * frequent elements. You may return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2 Output: [1,2]
 *
 * Example 2:
 *
 * Input: nums = [1], k = 1 Output: [1]
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10 5
 * -10 4 <= nums[i] <= 10 4
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 *
 * Follow up: Your algorithm's time complexity must be better than O(n log n),
 * where n is the array's size.
 */
class Solution00347 {

  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      Integer count = map.get(num);
      if (count == null) {
        count = 0;
      }
      map.put(num, count + 1);
    }
    PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
        (a, b) -> a.getValue() - b.getValue());
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      queue.add(entry);
      if (queue.size() > k) {
        queue.poll();
      }
    }
    int[] result = new int[k];
    int i = 0;
    while (!queue.isEmpty()) {
      result[i++] = queue.poll().getKey();
    }
    return result;
  }

  public static void test_00347() {
    Solution00347 solution = new Solution00347();
    int[] nums = { 1, 1, 1, 2, 2, 3 };
    int k = 2;
    int[] result = solution.topKFrequent(nums, k);
    for (int i = 0; i < result.length; i++) {
      System.out.println(result[i]);
    }
    int[] nums2 = { 1 };
    int k2 = 1;
    int[] result2 = solution.topKFrequent(nums2, k2);
    for (int i = 0; i < result2.length; i++) {
      System.out.println(result2[i]);
    }
  }

  public static void main(String[] args) {
    Solution00347.test_00347();
  }
}
