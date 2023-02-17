package cn.geekhall.problems.p00700.p00783;

import cn.geekhall.utils.TreeNode;

/**
 * ID: 00783
 * Title: Minimum Distance Between BST Nodes
 * Difficulty: Easy
 * Description: Given the root of a Binary Search Tree (BST), return the minimum
 * difference between the values of any two different nodes in the tree.
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
 * The number of nodes in the tree is in the range [2, 100].
 * 0 <= Node.val <= 10 5
 *
 * Note: This question is the same as 530:
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 */
class Solution00783 {

  public int minDiffInBST(TreeNode root) {
    int res = Integer.MAX_VALUE;
    TreeNode pre = null;
    TreeNode cur = root;
    while (cur != null) {
      if (cur.left == null) {
        if (pre != null) {
          res = Math.min(res, cur.val - pre.val);
        }
        pre = cur;
        cur = cur.right;
      } else {
        TreeNode node = cur.left;
        while (node.right != null && node.right != cur) {
          node = node.right;
        }
        if (node.right == null) {
          node.right = cur;
          cur = cur.left;
        } else {
          node.right = null;
          res = Math.min(res, cur.val - pre.val);
          pre = cur;
          cur = cur.right;
        }
      }
    }
    return res;
  }

  public static void test_00783() {
    Solution00783 solution = new Solution00783();
    TreeNode root = TreeNode.create(new Integer[] { 4, 2, 6, 1, 3 });
    int result = solution.minDiffInBST(root);
    System.out.println(result);
    TreeNode root2 = TreeNode.create(new Integer[] { 1, 0, 48, null, null, 12, 49 });
    int result2 = solution.minDiffInBST(root2);
    System.out.println(result2);
  }

  public static void main(String[] args) {
    Solution00783.test_00783();
  }
}
