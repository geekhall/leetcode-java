package cn.geekhall.problems.p00900.p00958;

import cn.geekhall.utils.TreeNode;
import java.util.*;

/**
 * ID: 00958
 * Title: Check Completeness of a Binary Tree
 * Difficulty: Medium
 * Description: Given the root of a binary tree, determine if it is a complete
 * binary tree.
 *
 * In a complete binary tree, every level, except possibly the last, is
 * completely filled, and all nodes in the last level are as far left as
 * possible. It can have between 1 and 2 h nodes inclusive at the last level h.
 *
 * Example 1:
 *
 * Input: root = [1,2,3,4,5,6] Output: true Explanation: Every level before the
 * last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in
 * the last level ({4, 5, 6}) are as far left as possible.
 *
 * Example 2:
 *
 * Input: root = [1,2,3,4,5,null,7] Output: false Explanation: The node with
 * value 7 isn't as far left as possible.
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 100].
 * 1 <= Node.val <= 1000
 */
class Solution00958 {

  public boolean isCompleteTree(TreeNode root) {
    if (root == null) {
      return true;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    boolean flag = false;
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node == null) {
        flag = true;
      } else {
        if (flag) {
          return false;
        }
        queue.offer(node.left);
        queue.offer(node.right);
      }
    }
    return true;
  }

  public static void test_00958() {
    Solution00958 solution = new Solution00958();
    TreeNode root = TreeNode.create(new Integer[] { 1, 2, 3, 4, 5, 6 });
    boolean result = solution.isCompleteTree(root);
    System.out.println(result);
    TreeNode root2 = TreeNode.create(new Integer[] { 1, 2, 3, 4, 5, null, 7 });
    boolean result2 = solution.isCompleteTree(root2);
    System.out.println(result2);
  }

  public static void main(String[] args) {
    Solution00958.test_00958();
  }
}
