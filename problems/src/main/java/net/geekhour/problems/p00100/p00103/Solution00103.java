package net.geekhour.problems.p00100.p00103;

import java.util.*;

import net.geekhour.utils.TreeNode;

/**
 * ID: 00103
 * Title: Binary Tree Zigzag Level Order Traversal
 * Difficulty: Medium
 * Description: Given the root of a binary tree, return the zigzag level order
 * traversal of its nodes' values. (i.e., from left to right, then right to left
 * for the next level and alternate between).
 *
 * Example 1:
 *
 * Input: root = [3,9,20,null,null,15,7] Output: [[3],[20,9],[15,7]]
 *
 * Example 2:
 *
 * Input: root = [1] Output: [[1]]
 *
 * Example 3:
 *
 * Input: root = [] Output: []
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 2000].
 * -100 <= Node.val <= 100
 */
class Solution00103 {

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    boolean isOrderLeft = true;
    while (!queue.isEmpty()) {
      Deque<Integer> levelList = new LinkedList<>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (isOrderLeft) {
          levelList.offerLast(node.val);
        } else {
          levelList.offerFirst(node.val);
        }
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
      result.add(new ArrayList<>(levelList));
      isOrderLeft = !isOrderLeft;
    }
    return result;
  }

  public static void test_00103() {
    Solution00103 solution = new Solution00103();
    TreeNode root = TreeNode.create(new Integer[] { 3, 9, 20, null, null, 15, 7 });
    List<List<Integer>> result = solution.zigzagLevelOrder(root);
    System.out.println(result);
    TreeNode root2 = TreeNode.create(new Integer[] { 1 });
    List<List<Integer>> result2 = solution.zigzagLevelOrder(root2);
    System.out.println(result2);

  }

  public static void main(String[] args) {
    Solution00103.test_00103();
  }
}
