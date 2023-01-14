package cn.geekhall.problems.p02200.p02244;

import java.util.HashMap;
import java.util.Map;

/**
 * ID:    02244
 * Title: Minimum Rounds to Complete All Tasks
 * Difficulty: Medium
 * Description: You are given a 0-indexed integer array tasks, where tasks[i] represents the difficulty level of a task. In each round, you can complete either 2 or 3 tasks of the same difficulty level.
 *
 * Return the minimum rounds required to complete all the tasks, or -1 if it is not possible to complete all the tasks.
 *
 * Example 1:
 *
 * Input: tasks = [2,2,3,3,2,4,4,4,4,4] Output: 4 Explanation: To complete all the tasks, a possible plan is: - In the first round, you complete 3 tasks of difficulty level 2. - In the second round, you complete 2 tasks of difficulty level 3. - In the third round, you complete 3 tasks of difficulty level 4. - In the fourth round, you complete 2 tasks of difficulty level 4. It can be shown that all the tasks cannot be completed in fewer than 4 rounds, so the answer is 4.
 *
 * Example 2:
 *
 * Input: tasks = [2,3,3] Output: -1 Explanation: There is only 1 task of difficulty level 2, but in each round, you can only complete either 2 or 3 tasks of the same difficulty level. Hence, you cannot complete all the tasks, and the answer is -1.
 *
 * Constraints:
 *
 * 1 <= tasks.length <= 10 5
 * 1 <= tasks[i] <= 10 9
 */
class Solution02244 {

  public int minimumRounds(int[] tasks) {
    Map<Integer, Integer> count = new HashMap<>();
    for (int task : tasks) {
      count.put(task, count.getOrDefault(task, 0) + 1);
    }

    int result = 0;
    for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
      int taskCount = entry.getValue();
      if (taskCount == 1) {
        return -1;
      }
      result += taskCount / 3;
      if (taskCount % 3 > 0) {
        result++;
      }
    }
    return result;
  }

  public static void test_02244() {
    Solution02244 solution = new Solution02244();
    int[] tasks = {2,2,3,3,2,4,4,4,4,4};
    int result = solution.minimumRounds(tasks);
    System.out.println(result);
    int[] tasks2 = {2,3,3};
    int result2 = solution.minimumRounds(tasks2);
    System.out.println(result2);
    int[] tasks3 = {1,1000000000};
    int result3 = solution.minimumRounds(tasks3);
    System.out.println(result3);
  }

  public static void main(String[] args) {
    Solution02244.test_02244();
  }
}

