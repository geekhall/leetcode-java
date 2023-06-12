package net.geekhour.problems.p00200.p00228;

import java.util.*;

/**
 * ID: 00228
 * Title: Summary Ranges
 * Difficulty: Easy
 * Description: You are given a sorted unique integer array nums.
 *
 * A range [a,b] is the set of all integers from a to b (inclusive).
 *
 * Return the smallest sorted list of ranges that cover all the numbers in the
 * array exactly. That is, each element of nums is covered by exactly one of the
 * ranges, and there is no integer x such that x is in one of the ranges but not
 * in nums.
 *
 * Each range [a,b] in the list should be output as:
 *
 * "a->b" if a != b
 * "a" if a == b
 *
 * Example 1:
 *
 * Input: nums = [0,1,2,4,5,7] Output: ["0->2","4->5","7"] Explanation: The
 * ranges are: [0,2] --> "0->2" [4,5] --> "4->5" [7,7] --> "7"
 *
 * Example 2:
 *
 * Input: nums = [0,2,3,4,6,8,9] Output: ["0","2->4","6","8->9"] Explanation:
 * The ranges are: [0,0] --> "0" [2,4] --> "2->4" [6,6] --> "6" [8,9] --> "8->9"
 *
 * Constraints:
 *
 * 0 <= nums.length <= 20
 * -2 31 <= nums[i] <= 2 31 - 1
 * All the values of nums are unique.
 * nums is sorted in ascending order.
 */
class Solution00228 {

  public List<String> summaryRanges(int[] nums) {
    List<String> result = new ArrayList<>();
    if (nums.length == 0) {
      return result;
    }
    int start = nums[0];
    int end = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == end + 1) {
        end = nums[i];
      } else {
        if (start == end) {
          result.add(String.valueOf(start));
        } else {
          result.add(start + "->" + end);
        }
        start = nums[i];
        end = nums[i];
      }
    }
    if (start == end) {
      result.add(String.valueOf(start));
    } else {
      result.add(start + "->" + end);
    }
    return result;
  }

  public static void test_00228() {
    Solution00228 solution = new Solution00228();
    //
  }

  public static void main(String[] args) {
    test_00228();
  }
}
