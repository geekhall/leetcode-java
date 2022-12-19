package cn.geekhall.problems.p00700.p00739;

import java.util.Arrays;

/**
 * ID:    00739
 * Title: Daily Temperatures
 * Difficulty: Medium
 * Description: Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the i th day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 * Example 1:
 *
 * Input: temperatures = [73,74,75,71,69,72,76,73] Output: [1,1,4,2,1,1,0,0]
 *
 * Example 2:
 *
 * Input: temperatures = [30,40,50,60] Output: [1,1,1,0]
 *
 * Example 3:
 *
 * Input: temperatures = [30,60,90] Output: [1,1,0]
 *
 * Constraints:
 *
 * 1 <= temperatures.length <= 10 5
 * 30 <= temperatures[i] <= 100
 */
class Solution00739 {

  // Time Limit Exceeded
  public int[] dailyTemperatures1(int[] temperatures) {
    int[] result = new int[temperatures.length];
    for (int i = 0; i < temperatures.length; i++) {
      int j = i + 1;
      while (j < temperatures.length) {
        if (temperatures[j] > temperatures[i]) {
          result[i] = j - i;
          break;
        }
        j++;
      }
    }
    return result;
  }

  // Monotonic Stack
  public int[] dailyTemperatures(int[] temperatures) {
    int[] result = new int[temperatures.length];
    int[] stack = new int[temperatures.length];
    int top = -1;
    for (int i = 0; i < temperatures.length; i++) {
      while (top != -1 && temperatures[i] > temperatures[stack[top]]) {
        int prevIndex = stack[top--];
        result[prevIndex] = i - prevIndex;
      }
      stack[++top] = i;
    }
    return result;
  }

  public static void test_00739() {
    Solution00739 solution = new Solution00739();
    int[] temperatures = {73,74,75,71,69,72,76,73};
    int[] result = solution.dailyTemperatures(temperatures);
    System.out.println(Arrays.toString(result));
    int [] temperatures2 = {30,40,50,60};
    int[] result2 = solution.dailyTemperatures(temperatures2);
    System.out.println(Arrays.toString(result2));
    int [] temperatures3 = {30,60,90};
    int[] result3 = solution.dailyTemperatures(temperatures3);
    System.out.println(Arrays.toString(result3));

  }

  public static void main(String[] args) {
    Solution00739.test_00739();
  }
}

