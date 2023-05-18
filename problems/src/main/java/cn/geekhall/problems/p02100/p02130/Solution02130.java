package cn.geekhall.problems.p02100.p02130;

import java.util.*;
import cn.geekhall.utils.ListNode;

/**
 * ID: 02130
 * Title: Maximum Twin Sum of a Linked List
 * Difficulty: Medium
 * Description: In a linked list of size n, where n is even, the i th node
 * (0-indexed) of the linked list is known as the twin of the (n-1-i) th node,
 * if 0 <= i <= (n / 2) - 1.
 *
 * For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the
 * twin of node 2. These are the only nodes with twins for n = 4.
 *
 * The twin sum is defined as the sum of a node and its twin.
 *
 * Given the head of a linked list with even length, return the maximum twin sum
 * of the linked list.
 *
 * Example 1:
 *
 * Input: head = [5,4,2,1] Output: 6 Explanation: Nodes 0 and 1 are the twins of
 * nodes 3 and 2, respectively. All have twin sum = 6. There are no other nodes
 * with twins in the linked list. Thus, the maximum twin sum of the linked list
 * is 6.
 *
 * Example 2:
 *
 * Input: head = [4,2,2,3] Output: 7 Explanation: The nodes with twins present
 * in this linked list are: - Node 0 is the twin of node 3 having a twin sum of
 * 4 + 3 = 7. - Node 1 is the twin of node 2 having a twin sum of 2 + 2 = 4.
 * Thus, the maximum twin sum of the linked list is max(7, 4) = 7.
 *
 * Example 3:
 *
 * Input: head = [1,100000] Output: 100001 Explanation: There is only one node
 * with a twin in the linked list having twin sum of 1 + 100000 = 100001.
 *
 * Constraints:
 *
 * The number of nodes in the list is an even integer in the range [2, 10 5 ].
 * 1 <= Node.val <= 10 5
 */
class Solution02130 {

  public int pairSum(ListNode head) {
    ListNode slowPtr = head;
    ListNode fastPtr = head;
    ListNode prevPtr = null;

    // Reverse the first half of the linked list
    while (fastPtr != null && fastPtr.next != null) {
      fastPtr = fastPtr.next.next;
      ListNode nextNode = slowPtr.next;
      slowPtr.next = prevPtr;
      prevPtr = slowPtr;
      slowPtr = nextNode;
    }

    // Adjust pointers if the length of the linked list is odd
    if (fastPtr != null) {
      slowPtr = slowPtr.next;
    }

    int maxSum = Integer.MIN_VALUE;
    while (slowPtr != null) {
      maxSum = Math.max(maxSum, slowPtr.val + prevPtr.val);
      slowPtr = slowPtr.next;
      prevPtr = prevPtr.next;
    }
    return maxSum;
  }

  public static void test_02130() {
    Solution02130 solution = new Solution02130();
    ListNode head = ListNode.create(new Integer[] { 5, 4, 2, 1 });
    ListNode.print(head);
    int max = solution.pairSum(head);
    System.out.println("最大值：" + max);
    ListNode head2 = ListNode.create(new Integer[] { 4, 2, 2, 3 });
    ListNode.print(head2);
    int max2 = solution.pairSum(head2);
    System.out.println("最大值：" + max2);
    ListNode head3 = ListNode.create(new Integer[] { 1, 100000 });
    ListNode.print(head3);
    int max3 = solution.pairSum(head3);
    System.out.println("最大值：" + max3);
  }

  public static void main(String[] args) {
    Solution02130.test_02130();
  }
}
