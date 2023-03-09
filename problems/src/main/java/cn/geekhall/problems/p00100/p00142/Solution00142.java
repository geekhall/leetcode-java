package cn.geekhall.problems.p00100.p00142;

import cn.geekhall.utils.ListNode;

/**
 * ID: 00142
 * Title: Linked List Cycle II
 * Difficulty: Medium
 * Description: Given the head of a linked list, return the node where the cycle
 * begins. If there is no cycle, return null.
 *
 * There is a cycle in a linked list if there is some node in the list that can
 * be reached again by continuously following the next pointer. Internally, pos
 * is used to denote the index of the node that tail's next pointer is connected
 * to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as
 * a parameter.
 *
 * Do not modify the linked list.
 *
 * Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1 Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the
 * second node.
 *
 * Example 2:
 *
 * Input: head = [1,2], pos = 0 Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the
 * first node.
 *
 * Example 3:
 *
 * Input: head = [1], pos = -1 Output: no cycle Explanation: There is no cycle
 * in the linked list.
 *
 * Constraints:
 *
 * The number of the nodes in the list is in the range [0, 10 4 ].
 * -10 5 <= Node.val <= 10 5
 * pos is -1 or a valid index in the linked-list.
 *
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */
class Solution00142 {

  public ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        ListNode ptr = head;
        while (ptr != slow) {
          ptr = ptr.next;
          slow = slow.next;
        }
        return ptr;
      }
    }
    return null;
  }

  public static void test_00142() {
    Solution00142 solution = new Solution00142();
    ListNode head = new ListNode(3);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(0);
    ListNode node4 = new ListNode(-4);
    head.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node2;
    ListNode result = solution.detectCycle(head);
    System.out.println(result);
    ListNode head2 = new ListNode(1);
    ListNode node22 = new ListNode(2);
    head2.next = node22;
    node22.next = head2;
    ListNode result2 = solution.detectCycle(head2);
    System.out.println(result2);
    ListNode head3 = new ListNode(1);
    ListNode result3 = solution.detectCycle(head3);
    System.out.println(result3);

  }

  public static void main(String[] args) {
    Solution00142.test_00142();
  }
}
