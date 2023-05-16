package cn.geekhall.problems.p00000.p00024;

import java.util.*;
import cn.geekhall.utils.ListNode;

/**
 * ID: 00024
 * Title: Swap Nodes in Pairs
 * Difficulty: Medium
 * Description: Given a linked list, swap every two adjacent nodes and return
 * its head. You must solve the problem without modifying the values in the
 * list's nodes (i.e., only nodes themselves may be changed.)
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4] Output: [2,1,4,3]
 *
 * Example 2:
 *
 * Input: head = [] Output: []
 *
 * Example 3:
 *
 * Input: head = [1] Output: [1]
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
 */
class Solution00024 {

  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode newHead = head.next;
    ListNode pre = null;
    ListNode cur = head;
    ListNode next = head.next;
    while (cur != null && next != null) {
      cur.next = next.next;
      next.next = cur;
      if (pre != null) {
        pre.next = next;
      }
      pre = cur;
      cur = cur.next;
      if (cur != null) {
        next = cur.next;
      }
    }
    return newHead;
  }

  public static void test_00024() {
    ListNode head = ListNode.create(new Integer[] { 1, 2, 3, 4 });
    System.out.println("原链表：");
    ListNode.print(head);

    Solution00024 solution = new Solution00024();
    ListNode newHead = solution.swapPairs(head);
    System.out.println("新链表：");
    ListNode.print(newHead);

    ListNode head2 = ListNode.create(new Integer[] {});
    System.out.println("原链表：");
    ListNode.print(head2);
    ListNode newHead2 = solution.swapPairs(head2);
    System.out.println("新链表：");
    ListNode.print(newHead2);
  }

  public static void main(String[] args) {
    Solution00024.test_00024();
  }
}
