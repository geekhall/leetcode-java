package net.geekhour.problems.p00400.p00491;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 00491
 * Title: Non-decreasing Subsequences
 * Difficulty: Medium
 * Description: Given an integer array nums, return all the different possible
 * non-decreasing subsequences of the given array with at least two elements.
 * You may return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [4,6,7,7] Output:
 * [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 *
 * Example 2:
 *
 * Input: nums = [4,4,3,2,1] Output: [[4,4]]
 *
 * Constraints:
 *
 * 1 <= nums.length <= 15
 * -100 <= nums[i] <= 100
 */
class Solution00491 {

  public List<List<Integer>> findSubsequences(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    dfs(nums, 0, path, result);
    return result;
  }

  private void dfs(int[] nums, int i, List<Integer> path, List<List<Integer>> result) {
    if (path.size() >= 2) {
      result.add(new ArrayList<>(path));
    }
    if (i >= nums.length) {
      return;
    }
    boolean[] used = new boolean[201];
    for (int j = i; j < nums.length; j++) {
      if (used[nums[j] + 100]) {
        continue;
      }
      if (path.size() == 0 || nums[j] >= path.get(path.size() - 1)) {
        path.add(nums[j]);
        used[nums[j] + 100] = true;
        dfs(nums, j + 1, path, result);
        path.remove(path.size() - 1);
      }
    }
  }

  public static void test_00491() {
    Solution00491 solution = new Solution00491();
    int[] nums = { 4, 6, 7, 7 };
    List<List<Integer>> result = solution.findSubsequences(nums);
    System.out.println(result);
    int[] nums2 = { 4, 4, 3, 2, 1 };
    List<List<Integer>> result2 = solution.findSubsequences(nums2);
    System.out.println(result2);
  }

  public static void main(String[] args) {
    Solution00491.test_00491();
  }
}
