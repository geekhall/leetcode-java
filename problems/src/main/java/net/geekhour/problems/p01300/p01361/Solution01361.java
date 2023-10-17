package net.geekhour.problems.p01300.p01361;

import java.util.*;

/**
 * ID: 01361
 * Title: Validate Binary Tree Nodes
 * Difficulty: Medium
 * Description: You have n binary tree nodes numbered from 0 to n - 1 where node
 * i has two children leftChild[i] and rightChild[i], return true if and only if
 * all the given nodes form exactly one valid binary tree.
 *
 * If node i has no left child then leftChild[i] will equal -1, similarly for
 * the right child.
 *
 * Note that the nodes have no values and that we only use the node numbers in
 * this problem.
 *
 * Example 1:
 *
 * Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1] Output: true
 *
 * Example 2:
 *
 * Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1] Output: false
 *
 * Example 3:
 *
 * Input: n = 2, leftChild = [1,0], rightChild = [-1,-1] Output: false
 *
 * Constraints:
 *
 * n == leftChild.length == rightChild.length
 * 1 <= n <= 10 4
 * -1 <= leftChild[i], rightChild[i] <= n - 1
 */
class Solution01361 {

  public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
    int[] indegree = new int[n];
    for (int i = 0; i < n; i++) {
      if (leftChild[i] != -1)
        indegree[leftChild[i]]++;
      if (rightChild[i] != -1)
        indegree[rightChild[i]]++;
    }
    int root = -1;
    for (int i = 0; i < n; i++) {
      if (indegree[i] == 0) {
        if (root == -1)
          root = i;
        else
          return false;
      }
    }
    if (root == -1)
      return false;
    boolean[] visited = new boolean[n];
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int node = queue.poll();
      if (visited[node])
        return false;
      visited[node] = true;
      if (leftChild[node] != -1)
        queue.offer(leftChild[node]);
      if (rightChild[node] != -1)
        queue.offer(rightChild[node]);
    }
    int trueCount = 0;
    for (boolean b : visited) {
      if (b)
        trueCount++;
    }
    return trueCount == n;
  }

  public static void test_01361() {
    Solution01361 solution = new Solution01361();
    System.out.println(solution.validateBinaryTreeNodes(4, new int[] { 1, -1, 3, -1 }, new int[] { 2, -1, -1, -1 }));
    System.out.println(solution.validateBinaryTreeNodes(4, new int[] { 1, -1, 3, -1 }, new int[] { 2, 3, -1, -1 }));
    System.out.println(solution.validateBinaryTreeNodes(2, new int[] { 1, 0 }, new int[] { -1, -1 }));
  }

  public static void main(String[] args) {
    test_01361();
  }
}
