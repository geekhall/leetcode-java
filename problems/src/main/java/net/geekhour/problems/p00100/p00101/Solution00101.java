package net.geekhour.problems.p00100.p00101;

import net.geekhour.utils.TreeNode;

/**
 * ID: 00101
 * Title: Symmetric Tree
 * Difficulty: Easy
 * Description: Given the root of a binary tree, check whether it is a mirror of
 * itself (i.e., symmetric around its center).
 *
 * Example 1:
 *
 * Input: root = [1,2,2,3,4,4,3] Output: true
 *
 * Example 2:
 *
 * Input: root = [1,2,2,null,3,null,3] Output: false
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 *
 * Follow up: Could you solve it both recursively and iteratively?
 */
class Solution00101 {

  public boolean isSymmetric(TreeNode root) {
    return isMirror(root, root);
  }

  private boolean isMirror(TreeNode root, TreeNode root2) {
    if (root == null && root2 == null) {
      return true;
    }
    if (root == null || root2 == null) {
      return false;
    }
    return (root.val == root2.val) && isMirror(root.left, root2.right) && isMirror(root.right, root2.left);
  }

  public static void test_00101() {
    Solution00101 solution = new Solution00101();
    TreeNode root = TreeNode.create(new Integer[] { 1, 2, 2, 3, 4, 4, 3 });
    boolean result = solution.isSymmetric(root);
    System.out.println(result);
    TreeNode root2 = TreeNode.create(new Integer[] { 1, 2, 2, null, 3, null, 3 });
    boolean result2 = solution.isSymmetric(root2);
    System.out.println(result2);

  }

  public static void main(String[] args) {
    Solution00101.test_00101();
  }
}
