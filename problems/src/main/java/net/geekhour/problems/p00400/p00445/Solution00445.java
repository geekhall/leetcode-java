package net.geekhour.problems.p00400.p00445;

import net.geekhour.utils.ListNode;

/**
 * ID: 00445
 * Title: Add Two Numbers II
 * Difficulty: Medium
 * Description: You are given two non-empty linked lists representing two
 * non-negative integers. The most significant digit comes first and each of
 * their nodes contains a single digit. Add the two numbers and return the sum
 * as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 *
 * Example 1:
 *
 * Input: l1 = [7,2,4,3], l2 = [5,6,4] Output: [7,8,0,7]
 *
 * Example 2:
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4] Output: [8,0,7]
 *
 * Example 3:
 *
 * Input: l1 = [0], l2 = [0] Output: [0]
 *
 * Constraints:
 *
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading
 * zeros.
 *
 * Follow up: Could you solve it without reversing the input lists?
 */
class Solution00445 {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);
    ListNode p = reverse(l1), q = reverse(l2), cur = head;
    int carry = 0;
    while (p != null || q != null) {
      int x = (p != null) ? p.val : 0;
      int y = (q != null) ? q.val : 0;
      int sum = carry + x + y;
      carry = sum / 10;
      cur.next = new ListNode(sum % 10);
      cur = cur.next;
      if (p != null)
        p = p.next;
      if (q != null)
        q = q.next;
    }
    if (carry > 0) {
      cur.next = new ListNode(carry);
    }
    return reverse(head.next);
  }

  private ListNode reverse(ListNode next) {
    ListNode prev = null;
    ListNode cur = next;
    while (cur != null) {
      ListNode temp = cur.next;
      cur.next = prev;
      prev = cur;
      cur = temp;
    }
    return prev;
  }

  public static void test_00445() {
    Solution00445 solution = new Solution00445();
    ListNode l1 = ListNode.create(new Integer[] { 7, 2, 4, 3 });
    ListNode l2 = ListNode.create(new Integer[] { 5, 6, 4 });
    ListNode result = solution.addTwoNumbers(l1, l2);
    result.print();
  }

  public static void main(String[] args) {
    Solution00445.test_00445();
  }
}
