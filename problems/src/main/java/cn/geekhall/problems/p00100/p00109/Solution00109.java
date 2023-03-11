package cn.geekhall.problems.p00100.p00109;

import cn.geekhall.utils.ListNode;
import cn.geekhall.utils.TreeNode;

/**
 * ID: 00109
 * Title: Convert Sorted List to Binary Search Tree
 * Difficulty: Medium
 * Description: Given the head of a singly linked list where elements are sorted
 * in ascending order, convert it to a height-balanced binary search tree.
 *
 * Example 1:
 *
 * Input: head = [-10,-3,0,5,9] Output: [0,-3,9,-10,null,5] Explanation: One
 * possible answer is [0,-3,9,-10,null,5], which represents the shown height
 * balanced BST.
 *
 * Example 2:
 *
 * Input: head = [] Output: []
 *
 * Constraints:
 *
 * The number of nodes in head is in the range [0, 2 * 10 4 ].
 * -10 5 <= Node.val <= 10 5
 */
class Solution00109 {

  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) {
      return null;
    }
    if (head.next == null) {
      return new TreeNode(head.val);
    }
    ListNode slow = head;
    ListNode fast = head;
    ListNode pre = null;
    while (fast != null && fast.next != null) {
      pre = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    pre.next = null;
    TreeNode root = new TreeNode(slow.val);
    root.left = sortedListToBST(head);
    root.right = sortedListToBST(slow.next);
    return root;
  }

  public static void test_00109() {
    Solution00109 solution = new Solution00109();
    ListNode head = ListNode.create(new Integer[] { -10, -3, 0, 5, 9 });
    head.print();
    TreeNode root = solution.sortedListToBST(head);
    root.print();
    ListNode head2 = ListNode.create(new Integer[] {});
    TreeNode root2 = solution.sortedListToBST(head2);
    // root2.print();
  }

  public static void main(String[] args) {
    Solution00109.test_00109();
  }
}
