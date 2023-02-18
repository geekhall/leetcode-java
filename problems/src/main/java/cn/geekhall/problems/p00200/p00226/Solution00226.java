package cn.geekhall.problems.p00200.p00226;

import cn.geekhall.utils.TreeNode;

/**
 * ID: 00226
 * Title: Invert Binary Tree
 * Difficulty: Easy
 * Description: Given the root of a binary tree, invert the tree, and return its
 * root.
 *
 * Example 1:
 *
 * Input: root = [4,2,7,1,3,6,9] Output: [4,7,2,9,6,3,1]
 *
 * Example 2:
 *
 * Input: root = [2,1,3] Output: [2,3,1]
 *
 * Example 3:
 *
 * Input: root = [] Output: []
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */
class Solution00226 {

  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);
    root.left = right;
    root.right = left;
    return root;
  }

  public static void test_00226() {
    Solution00226 solution = new Solution00226();
    TreeNode root = TreeNode.create(new Integer[] { 4, 2, 7, 1, 3, 6, 9 });
    TreeNode result = solution.invertTree(root);
    result.print();
    TreeNode root2 = TreeNode.create(new Integer[] { 2, 1, 3 });
    TreeNode result2 = solution.invertTree(root2);
    result2.print();
  }

  public static void main(String[] args) {
    Solution00226.test_00226();
  }
}
