package cn.geekhall.problems.p00600.p00652;

import java.util.*;

import cn.geekhall.utils.TreeNode;

/**
 * ID: 00652
 * Title: Find Duplicate Subtrees
 * Difficulty: Medium
 * Description: Given the root of a binary tree, return all duplicate subtrees.
 *
 * For each kind of duplicate subtrees, you only need to return the root node of
 * any one of them.
 *
 * Two trees are duplicate if they have the same structure with the same node
 * values.
 *
 * Example 1:
 *
 * Input: root = [1,2,3,4,null,2,4,null,null,4] Output: [[2,4],[4]]
 *
 * Example 2:
 *
 * Input: root = [2,1,1] Output: [[1]]
 *
 * Example 3:
 *
 * Input: root = [2,2,2,3,null,3,null] Output: [[2,3],[3]]
 *
 * Constraints:
 *
 * The number of the nodes in the tree will be in the range [1, 5000]
 * -200 <= Node.val <= 200
 */
class Solution00652 {

  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    List<TreeNode> result = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    traverse(root, map, result);
    return result;
  }

  private void traverse(TreeNode root, Map<String, Integer> map, List<TreeNode> result) {
    if (root == null) {
      return;
    }
    String key = serialize(root);
    map.put(key, map.getOrDefault(key, 0) + 1);
    if (map.get(key) == 2) {
      result.add(root);
    }
    traverse(root.left, map, result);
    traverse(root.right, map, result);
  }

  private String serialize(TreeNode root) {
    if (root == null) {
      return "#";
    }
    String left = serialize(root.left);
    String right = serialize(root.right);
    return root.val + "," + left + "," + right;
  }

  public static void test_00652() {
    System.out.println("test_00652");
    Solution00652 solution = new Solution00652();
    TreeNode root = TreeNode.create(new Integer[] { 1, 2, 3, 4, null, 2, 4, null, null, 4 });
    List<TreeNode> result = solution.findDuplicateSubtrees(root);
    System.out.println(result);
    TreeNode root2 = TreeNode.create(new Integer[] { 2, 1, 1 });
    List<TreeNode> result2 = solution.findDuplicateSubtrees(root2);
    System.out.println(result2);
    TreeNode root3 = TreeNode.create(new Integer[] { 2, 2, 2, 3, null, 3, null });
    List<TreeNode> result3 = solution.findDuplicateSubtrees(root3);
    System.out.println(result3);

  }

  public static void main(String[] args) {
    Solution00652.test_00652();
  }
}
