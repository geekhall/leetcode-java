package cn.geekhall.problems.p00200.p00222;

import cn.geekhall.utils.TreeNode;

/**
 * ID:    00222
 * Title: Count Complete Tree Nodes
 * Difficulty: Medium
 * Description: Given the root of a complete binary tree, return the number of the nodes in the tree.
 *
 * According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2 h nodes inclusive at the last level h.
 *
 * Design an algorithm that runs in less than O(n) time complexity.
 *
 * Example 1:
 *
 * Input: root = [1,2,3,4,5,6] Output: 6
 *
 * Example 2:
 *
 * Input: root = [] Output: 0
 *
 * Example 3:
 *
 * Input: root = [1] Output: 1
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 5 * 10 4 ].
 * 0 <= Node.val <= 5 * 10 4
 * The tree is guaranteed to be complete.
 */
class Solution00222 {

  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = countLevel(root.left);
    int right = countLevel(root.right);
    if (left == right) {
      return countNodes(root.right) + (1 << left);
    } else {
      return countNodes(root.left) + (1 << right);
    }
  }

  private int countLevel(TreeNode left) {
    int level = 0;
    while (left != null) {
      level++;
      left = left.left;
    }
    return level;
  }

  public static void test_00222() {
    Solution00222 solution = new Solution00222();
    TreeNode root = TreeNode.create(new Integer[] {1, 2, 3, 4, 5, 6});
    System.out.println(solution.countNodes(root));
    TreeNode root2 = TreeNode.create(new Integer[] {});
    System.out.println(solution.countNodes(root2));
    TreeNode root3 = TreeNode.create(new Integer[] {1});
    System.out.println(solution.countNodes(root3));
  }

  public static void main(String[] args) {
    Solution00222.test_00222();
  }
}

