package net.geekhour.problems.p00200.p00229;

import java.util.*;

/**
 * ID: 00229
 * Title: Majority Element II
 * Difficulty: Medium
 * Description: Given an integer array of size n, find all elements that appear
 * more than ⌊ n/3 ⌋ times.
 *
 * Example 1:
 *
 * Input: nums = [3,2,3] Output: [3]
 *
 * Example 2:
 *
 * Input: nums = [1] Output: [1]
 *
 * Example 3:
 *
 * Input: nums = [1,2] Output: [1,2]
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5 * 10 4
 * -10 9 <= nums[i] <= 10 9
 *
 * Follow up: Could you solve the problem in linear time and in O(1) space?
 */
class Solution00229 {

  public List<Integer> majorityElement(int[] nums) {
    int n = nums.length;
    int threshold = n / 3;
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      Integer count = map.get(num);
      if (count == null) {
        count = 0;
      }
      count++;
      map.put(num, count);
    }
    List<Integer> result = new ArrayList<>();
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() > threshold) {
        result.add(entry.getKey());
      }
    }
    return result;
  }

  public static void test_00229() {
    Solution00229 solution = new Solution00229();
    int[] nums = { 3, 2, 3 };
    System.out.println(solution.majorityElement(nums));
    nums = new int[] { 1 };
    System.out.println(solution.majorityElement(nums));
    nums = new int[] { 1, 2 };
    System.out.println(solution.majorityElement(nums));

  }

  public static void main(String[] args) {
    test_00229();
  }
}
