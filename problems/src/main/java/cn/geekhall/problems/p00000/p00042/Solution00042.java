package cn.geekhall.problems.p00000.p00042;

/**
 * ID:    00042
 * Title: Trapping Rain Water
 * Difficulty: Hard
 * Description: Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 * Example 1:
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1] Output: 6 Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 *
 * Example 2:
 *
 * Input: height = [4,2,0,3,2,5] Output: 9
 *
 * Constraints:
 *
 * n == height.length
 * 1 <= n <= 2 * 10 4
 * 0 <= height[i] <= 10 5
 */
class Solution00042 {

  public int trap(int[] height) {
    int result = 0;
    int left = 0;
    int right = height.length - 1;
    int leftMax = 0;
    int rightMax = 0;

    while (left < right) {
      if (height[left] < height[right]) {
        if (height[left] >= leftMax) {
          leftMax = height[left];
        } else {
          result += (leftMax - height[left]);
        }
        left++;
      } else {
        if (height[right] >= rightMax) {
          rightMax = height[right];
        } else {
          result += (rightMax - height[right]);
        }
        right--;
      }
    }
    return result;
  }

  /**
   * swap two elements in array
   */
  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
  /**
   * add two numbers
   */
  public int add(int a, int b) {
    return a + b;
  }

  public static void test_00042() {
    Solution00042 solution = new Solution00042();
    int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
    int result = solution.trap(height);
    System.out.println(result);
    int[] height2 = {4,2,0,3,2,5};
    result = solution.trap(height2);
    System.out.println(result);

  }

  public static void main(String[] args) {
    Solution00042.test_00042();
  }
}

