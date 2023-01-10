package cn.geekhall.problems.p00100.p00100;

import cn.geekhall.utils.TreeNode;

/**
 * ID:    00100
 * Title: Same Tree
 * Difficulty: Easy
 * Description: Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 * Example 1:
 *
 * Input: p = [1,2,3], q = [1,2,3] Output: true
 *
 * Example 2:
 *
 * Input: p = [1,2], q = [1,null,2] Output: false
 *
 * Example 3:
 *
 * Input: p = [1,2,1], q = [1,1,2] Output: false
 *
 * Constraints:
 *
 * The number of nodes in both trees is in the range [0, 100].
 * -10 4 <= Node.val <= 10 4
 */
class Solution00100 {

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if (p == null || q == null) {
      return false;
    }
    if (p.val != q.val) {
      return false;
    }
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }

  public static void test_00100() {
    Solution00100 solution = new Solution00100();
    TreeNode p = new TreeNode(1);
    p.left = new TreeNode(2);
    p.right = new TreeNode(3);
    TreeNode q = new TreeNode(1);
    q.left = new TreeNode(2);
    q.right = new TreeNode(3);
    boolean result = solution.isSameTree(p, q);
    System.out.println(result);
  }

  public static void main(String[] args) {
    Solution00100.test_00100();
  }
}

