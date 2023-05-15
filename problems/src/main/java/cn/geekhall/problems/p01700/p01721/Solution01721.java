package cn.geekhall.problems.p01700.p01721;

import java.util.*;
import cn.geekhall.utils.ListNode;

/**
 * ID: 01721
 * Title: Swapping Nodes in a Linked List
 * Difficulty: Medium
 * Description: You are given the head of a linked list, and an integer k.
 *
 * Return the head of the linked list after swapping the values of the k th node
 * from the beginning and the k th node from the end (the list is 1-indexed).
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4,5], k = 2 Output: [1,4,3,2,5]
 *
 * Example 2:
 *
 * Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5 Output: [7,9,6,6,8,7,3,0,9,5]
 *
 * Constraints:
 *
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 10 5
 * 0 <= Node.val <= 100
 */

class Solution01721 {

  public ListNode swapNodes(ListNode head, int k) {
    ListNode dummy = new ListNode(0, head);
    ListNode fast = dummy;
    ListNode slow = dummy;
    ListNode first = dummy;
    ListNode second = dummy;
    for (int i = 0; i < k; i++) {
      fast = fast.next;
    }
    first = fast;
    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }
    second = slow;
    int temp = first.val;
    first.val = second.val;
    second.val = temp;
    return dummy.next;
  }

  public static void test_01721() {
    Solution01721 solution = new Solution01721();
    ListNode head = ListNode.create(new Integer[] { 1, 2, 3, 4, 5 });
    int k = 2;
    ListNode result = solution.swapNodes(head, k);
    result.print();
    Solution01721 solution2 = new Solution01721();
    ListNode head2 = ListNode.create(new Integer[] { 7, 9, 6, 6, 7, 8, 3, 0, 9, 5 });
    int k2 = 5;
    ListNode result2 = solution2.swapNodes(head2, k2);
    result2.print();
  }

  public static void main(String[] args) {
    Solution01721.test_01721();
  }
}
