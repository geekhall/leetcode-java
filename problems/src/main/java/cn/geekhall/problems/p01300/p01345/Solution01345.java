package cn.geekhall.problems.p01300.p01345;

import java.util.*;

/**
 * ID: 01345
 * Title: Jump Game IV
 * Difficulty: Hard
 * Description: Given an array of integers arr, you are initially positioned at
 * the first index of the array.
 *
 * In one step you can jump from index i to index:
 *
 * i + 1 where: i + 1 < arr.length.
 * i - 1 where: i - 1 >= 0.
 * j where: arr[i] == arr[j] and i != j.
 *
 * Return the minimum number of steps to reach the last index of the array.
 *
 * Notice that you can not jump outside of the array at any time.
 *
 * Example 1:
 *
 * Input: arr = [100,-23,-23,404,100,23,23,23,3,404] Output: 3 Explanation: You
 * need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the
 * last index of the array.
 *
 * Example 2:
 *
 * Input: arr = [7] Output: 0 Explanation: Start index is the last index. You do
 * not need to jump.
 *
 * Example 3:
 *
 * Input: arr = [7,6,9,6,9,6,9,7] Output: 1 Explanation: You can jump directly
 * from index 0 to index 7 which is last index of the array.
 *
 * Constraints:
 *
 * 1 <= arr.length <= 5 * 10 4
 * -10 8 <= arr[i] <= 10 8
 */
class Solution01345 {

  public int minJumps(int[] arr) {
    int n = arr.length;
    if (n <= 1) {
      return 0;
    }
    Map<Integer, List<Integer>> index = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int x = arr[i];
      if (!index.containsKey(x)) {
        index.put(x, new ArrayList<>());
      }
      index.get(x).add(i);
    }
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(0);
    boolean[] used = new boolean[n];
    used[0] = true;
    int step = 0;
    while (!queue.isEmpty()) {
      int sz = queue.size();
      for (int i = 0; i < sz; i++) {
        int u = queue.poll();
        if (u == n - 1) {
          return step;
        }
        int x = arr[u];
        List<Integer> list = index.get(x);
        for (int v : list) {
          if (!used[v]) {
            queue.offer(v);
            used[v] = true;
          }
        }
        list.clear();
        if (u - 1 >= 0 && !used[u - 1]) {
          queue.offer(u - 1);
          used[u - 1] = true;
        }
        if (u + 1 < n && !used[u + 1]) {
          queue.offer(u + 1);
          used[u + 1] = true;
        }
      }
      step++;
    }
    return -1;
  }

  public static void test_01345() {
    Solution01345 solution = new Solution01345();
    int[] arr = { 100, -23, -23, 404, 100, 23, 23, 23, 3, 404 };
    int result = solution.minJumps(arr);
    System.out.println(result);
    int[] arr2 = { 7 };
    int result2 = solution.minJumps(arr2);
    System.out.println(result2);
    int[] arr3 = { 7, 6, 9, 6, 9, 6, 9, 7 };
    int result3 = solution.minJumps(arr3);
    System.out.println(result3);
  }

  public static void main(String[] args) {
    Solution01345.test_01345();
  }
}
