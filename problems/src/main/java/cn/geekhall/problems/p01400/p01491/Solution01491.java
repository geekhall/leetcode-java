package cn.geekhall.problems.p01400.p01491;

import java.util.*;

/**
 * ID: 01491
 * Title: Average Salary Excluding the Minimum and Maximum Salary
 * Difficulty: Easy
 * Description: You are given an array of unique integers salary where salary[i]
 * is the salary of the i th employee.
 *
 * Return the average salary of employees excluding the minimum and maximum
 * salary. Answers within 10 -5 of the actual answer will be accepted.
 *
 * Example 1:
 *
 * Input: salary = [4000,3000,1000,2000] Output: 2500.00000 Explanation: Minimum
 * salary and maximum salary are 1000 and 4000 respectively. Average salary
 * excluding minimum and maximum salary is (2000+3000) / 2 = 2500
 *
 * Example 2:
 *
 * Input: salary = [1000,2000,3000] Output: 2000.00000 Explanation: Minimum
 * salary and maximum salary are 1000 and 3000 respectively. Average salary
 * excluding minimum and maximum salary is (2000) / 1 = 2000
 *
 * Constraints:
 *
 * 3 <= salary.length <= 100
 * 1000 <= salary[i] <= 10 6
 * All the integers of salary are unique.
 */
class Solution01491 {

  public double average(int[] salary) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int sum = 0;
    for (int s : salary) {
      min = Math.min(min, s);
      max = Math.max(max, s);
      sum += s;
    }
    return (double) (sum - min - max) / (salary.length - 2);
  }

  public static void test_01491() {
    Solution01491 solution = new Solution01491();
    int[] salary = { 4000, 3000, 1000, 2000 };
    double average = solution.average(salary);
    System.out.println(average);
    int[] salary2 = { 1000, 2000, 3000 };
    double average2 = solution.average(salary2);
    System.out.println(average2);
  }

  public static void main(String[] args) {
    Solution01491.test_01491();
  }
}
