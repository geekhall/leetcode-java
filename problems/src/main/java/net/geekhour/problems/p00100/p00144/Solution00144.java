package net.geekhour.problems.p00100.p00144;

import java.util.ArrayList;
import java.util.List;

import net.geekhour.utils.TreeNode;

/**
 * ID: 00144
 * Title: Binary Tree Preorder Traversal
 * Difficulty: Easy
 * Description: Given the root of a binary tree, return the preorder traversal
 * of its nodes' values.
 *
 * Example 1:
 *
 * Input: root = [1,null,2,3] Output: [1,2,3]
 *
 * Example 2:
 *
 * Input: root = [] Output: []
 *
 * Example 3:
 *
 * Input: root = [1] Output: [1]
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
class Solution00144 {

  public List<Integer> preorderTraversal(TreeNode root) {
    // preorder traversal of binary tree
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    result.add(root.val);
    result.addAll(preorderTraversal(root.left));
    result.addAll(preorderTraversal(root.right));
    return result;
  }

  public static void test_00144() {
    Solution00144 solution = new Solution00144();
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);
    List<Integer> result = solution.preorderTraversal(root);
    System.out.println(result);
  }

  public static void main(String[] args) {
    Solution00144.test_00144();
  }
}
