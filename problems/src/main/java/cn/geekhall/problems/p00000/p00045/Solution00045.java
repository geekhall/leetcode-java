package cn.geekhall.problems.p00000.p00045;

/**
 * ID: 00045
 * Title: Jump Game II
 * Difficulty: Medium
 * Description: You are given a 0-indexed array of integers nums of length n.
 * You are initially positioned at nums[0].
 *
 * Each element nums[i] represents the maximum length of a forward jump from
 * index i. In other words, if you are at nums[i], you can jump to any nums[i +
 * j] where:
 *
 * 0 <= j <= nums[i] and
 * i + j < n
 *
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are
 * generated such that you can reach nums[n - 1].
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4] Output: 2 Explanation: The minimum number of jumps
 * to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to
 * the last index.
 *
 * Example 2:
 *
 * Input: nums = [2,3,0,1,4] Output: 2
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10 4
 * 0 <= nums[i] <= 1000
 */
class Solution00045 {

  public int jump(int[] nums) {
    int n = nums.length;
    int end = 0;
    int maxPosition = 0;
    int steps = 0;
    for (int i = 0; i < n - 1; i++) {
      maxPosition = Math.max(maxPosition, i + nums[i]);
      if (i == end) {
        end = maxPosition;
        steps++;
      }
    }
    return steps;
  }

  public static void test_00045() {
    Solution00045 solution = new Solution00045();
    int[] nums = { 2, 3, 1, 1, 4 };
    int result = solution.jump(nums);
    System.out.println(result);
    int[] nums2 = { 2, 3, 0, 1, 4 };
    result = solution.jump(nums2);
    System.out.println(result);
  }

  public static void main(String[] args) {
    Solution00045.test_00045();
  }
}
