package net.geekhour.problems.p00000.p00011;

import java.util.*;

/**
 * ID: 00011
 * Title: Container With Most Water
 * Difficulty: Medium
 * Description: You are given an integer array height of length n. There are n
 * vertical lines drawn such that the two endpoints of the i th line are (i, 0)
 * and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the
 * container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 * Example 1:
 *
 * Input: height = [1,8,6,2,5,4,8,3,7] Output: 49 Explanation: The above
 * vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case,
 * the max area of water (blue section) the container can contain is 49.
 *
 * Example 2:
 *
 * Input: height = [1,1] Output: 1
 *
 * Constraints:
 *
 * n == height.length
 * 2 <= n <= 10 5
 * 0 <= height[i] <= 10 4
 */
class Solution00011 {

  public int maxArea(int[] height) {
    int maxArea = 0;
    int left = 0;
    int right = height.length - 1;
    while (left < right) {
      int area = Math.min(height[left], height[right]) * (right - left);
      maxArea = Math.max(maxArea, area);
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }
    return maxArea;
  }

  public static void test_00011() {
    Solution00011 solution = new Solution00011();
    int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
    int expected = 49;
    int actual = solution.maxArea(height);
    System.out.println("Test case 00011: expected: " + expected + ", actual: " + actual);
    height = new int[] { 1, 1 };
    expected = 1;
    actual = solution.maxArea(height);
    System.out.println("Test case 00011: expected: " + expected + ", actual: " + actual);
    height = new int[] { 4, 3, 2, 1, 4 };
    expected = 16;
    actual = solution.maxArea(height);
    System.out.println("Test case 00011: expected: " + expected + ", actual: " + actual);
    height = new int[] { 1, 2, 1 };
    expected = 2;
    actual = solution.maxArea(height);
    System.out.println("Test case 00011: expected: " + expected + ", actual: " + actual);

  }

  public static void main(String[] args) {
    test_00011();
  }
}
