package cn.geekhall.problems.p00100.p00106;

import cn.geekhall.utils.TreeNode;

/**
 * ID: 00106
 * Title: Construct Binary Tree from Inorder and Postorder Traversal
 * Difficulty: Medium
 * Description: Given two integer arrays inorder and postorder where inorder is
 * the inorder traversal of a binary tree and postorder is the postorder
 * traversal of the same tree, construct and return the binary tree.
 *
 * Example 1:
 *
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3] Output:
 * [3,9,20,null,null,15,7]
 *
 * Example 2:
 *
 * Input: inorder = [-1], postorder = [-1] Output: [-1]
 *
 * Constraints:
 *
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder and postorder consist of unique values.
 * Each value of postorder also appears in inorder.
 * inorder is guaranteed to be the inorder traversal of the tree.
 * postorder is guaranteed to be the postorder traversal of the tree.
 */
class Solution00106 {

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
  }

  private TreeNode buildTree(int[] inorder, int i, int j, int[] postorder, int k, int l) {
    if (i > j || k > l) {
      return null;
    }
    int rootVal = postorder[l];
    TreeNode root = new TreeNode(rootVal);
    int index = 0;
    for (int m = i; m <= j; m++) {
      if (inorder[m] == rootVal) {
        index = m;
        break;
      }
    }
    int leftSize = index - i;
    root.left = buildTree(inorder, i, index - 1, postorder, k, k + leftSize - 1);
    root.right = buildTree(inorder, index + 1, j, postorder, k + leftSize, l - 1);
    return root;
  }

  public static void test_00106() {
    Solution00106 solution = new Solution00106();
    int[] inorder = new int[] { 9, 3, 15, 20, 7 };
    int[] postorder = new int[] { 9, 15, 7, 20, 3 };
    TreeNode result = solution.buildTree(inorder, postorder);
    System.out.println(result);
    int[] inorder2 = new int[] { -1 };
    int[] postorder2 = new int[] { -1 };
    TreeNode result2 = solution.buildTree(inorder2, postorder2);
    System.out.println(result2);
  }

  public static void main(String[] args) {
    Solution00106.test_00106();
  }
}
