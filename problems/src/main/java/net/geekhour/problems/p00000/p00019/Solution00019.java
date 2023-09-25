package net.geekhour.problems.p00000.p00019;

import java.util.*;
import net.geetkhour.utils.ListNode;

/**
 * ID: 00019
 * Title: Remove Nth Node From End of List
 * Difficulty: Medium
 * Description: Given the head of a linked list, remove the n th node from the
 * end of the list and return its head.
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4,5], n = 2 Output: [1,2,3,5]
 *
 * Example 2:
 *
 * Input: head = [1], n = 1 Output: []
 *
 * Example 3:
 *
 * Input: head = [1,2], n = 1 Output: [1]
 *
 * Constraints:
 *
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 * Follow up: Could you do this in one pass?
 */
class Solution00019 {

  /**
   * Definition for singly-linked list.
   * public class ListNode {
   * int val;
   * ListNode next;
   * ListNode() {}
   * ListNode(int val) { this.val = val; }
   * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   * }
   */
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0, head);
    ListNode first = dummy;
    ListNode second = dummy;
    for (int i = 0; i <= n; i++) {
      first = first.next;
    }
    while (first != null) {
      first = first.next;
      second = second.next;
    }
    second.next = second.next.next;
    return dummy.next;
  }

  public static void test_00019() {
    Solution00019 solution = new Solution00019();
    //
  }

  public static void main(String[] args) {
    test_00019();
  }
}
