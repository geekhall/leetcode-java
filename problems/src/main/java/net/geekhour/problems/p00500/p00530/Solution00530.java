package net.geekhour.problems.p00500.p00530;

import java.util.*;

/**
 * ID: 00530
 * Title: Minimum Absolute Difference in BST
 * Difficulty: Easy
 * Description: Given the root of a Binary Search Tree (BST), return the minimum
 * absolute difference between the values of any two different nodes in the
 * tree.
 *
 * Example 1:
 *
 * Input: root = [4,2,6,1,3] Output: 1
 *
 * Example 2:
 *
 * Input: root = [1,0,48,null,null,12,49] Output: 1
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 10 4 ].
 * 0 <= Node.val <= 10 5
 *
 * Note: This question is the same as 783:
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 */
class Solution00530 {

  /**
   * Definition for a binary tree node.
   * public class TreeNode {
   * int val;
   * TreeNode left;
   * TreeNode right;
   * TreeNode() {}
   * TreeNode(int val) { this.val = val; }
   * TreeNode(int val, TreeNode left, TreeNode right) {
   * this.val = val;
   * this.left = left;
   * this.right = right;
   * }
   * }
   */
  public int getMinimumDifference(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    inorder(root, list);
    int min = Integer.MAX_VALUE;
    for (int i = 1; i < list.size(); i++) {
      min = Math.min(min, list.get(i) - list.get(i - 1));
    }
    return min;
  }

  public static void test_00530() {
    Solution00530 solution = new Solution00530();
    TreeNode root = new TreeNode(4);

  }

  public static void main(String[] args) {
    test_00530();
  }
}
