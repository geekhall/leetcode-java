package net.geekhour.problems.p00100;

import net.geekhour.utils.TreeNode;

/**
 * Solution110
 * ID: 00110
 * Title: Balanced Binary Tree
 * Difficulty: Easy
 * Description: Given a binary tree, determine if it is height-balanced.
 *
 * Example 1:
 *
 * Input: root = [3,9,20,null,null,15,7] Output: true
 *
 * Example 2:
 *
 * Input: root = [1,2,2,3,3,null,null,4,4] Output: false
 *
 * Example 3:
 *
 * Input: root = [] Output: true
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 5000].
 * -10 4 <= Node.val <= 10 4
 *
 * @author yiny
 * @date 2022/12/18 10:29
 */

public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
