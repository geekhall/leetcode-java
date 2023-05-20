package net.geekhour.problems.p00100.p00104;

import net.geekhour.utils.TreeNode;

/**
 * ID: 00104
 * Title: Maximum Depth of Binary Tree
 * Difficulty: Easy
 * Description: Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 *
 * Example 1:
 *
 * Input: root = [3,9,20,null,null,15,7] Output: 3
 *
 * Example 2:
 *
 * Input: root = [1,null,2] Output: 2
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 10 4 ].
 * -100 <= Node.val <= 100
 */
class Solution00104 {

  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }

  public static void test_00104() {
    Solution00104 solution = new Solution00104();
    TreeNode root = TreeNode.create(new Integer[] { 3, 9, 20, null, null, 15, 7 });
    int result = solution.maxDepth(root);
    System.out.println(result);
    TreeNode root2 = TreeNode.create(new Integer[] { 1, null, 2 });
    int result2 = solution.maxDepth(root2);
    System.out.println(result2);
  }

  public static void main(String[] args) {
    Solution00104.test_00104();
  }
}
