package cn.geekhall.problems.p00100.p00143;

import cn.geekhall.utils.ListNode;

/**
 * ID:    00143
 * Title: Reorder List
 * Difficulty: Medium
 * Description: You are given the head of a singly linked-list. The list can be represented as:
 *
 * L 0 → L 1 → … → L n - 1 → L n
 *
 * Reorder the list to be on the following form:
 *
 * L 0 → L n → L 1 → L n - 1 → L 2 → L n - 2 → …
 *
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4] Output: [1,4,2,3]
 *
 * Example 2:
 *
 * Input: head = [1,2,3,4,5] Output: [1,5,2,4,3]
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [1, 5 * 10 4 ].
 * 1 <= Node.val <= 1000
 */
class Solution00143 {

  public void reorderList(ListNode head) {
    if (head == null) {
      return;
    }
    ListNode slow = head, fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode l1 = head, l2 = slow.next;
    slow.next = null;
    l2 = reverse(l2);
    merge(l1, l2);
  }

  private void merge(ListNode l1, ListNode l2) {
    ListNode l1_tmp, l2_tmp;
    while (l1 != null && l2 != null) {
      l1_tmp = l1.next;
      l2_tmp = l2.next;
      l1.next = l2;
      l1 = l1_tmp;
      l2.next = l1;
      l2 = l2_tmp;
    }

  }

  private ListNode reverse(ListNode l2) {
    ListNode pre = null, cur = l2, next = l2;
    while (cur != null) {
      next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    return pre;
  }


  public static void test_00143() {
    Solution00143 solution = new Solution00143();
    ListNode head = new ListNode(1);
    ListNode node1 = new ListNode(2);
    ListNode node2 = new ListNode(3);
    ListNode node3 = new ListNode(4);
    ListNode node4 = new ListNode(5);
    head.next = node1;
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    solution.reorderList(head);
    head.print();
  }

  public static void main(String[] args) {
    Solution00143.test_00143();
  }
}

