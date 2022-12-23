package cn.geekhall.problems.p00000.p00061;

import cn.geekhall.utils.ListNode;

/**
 * ID:    00061
 * Title: Rotate List
 * Difficulty: Medium
 * Description: Given the head of a linked list, rotate the list to the right by k places.
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4,5], k = 2 Output: [4,5,1,2,3]
 *
 * Example 2:
 *
 * Input: head = [0,1,2], k = 4 Output: [2,0,1]
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 500].
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 10 9
 */
class Solution00061 {

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode tail = head;
    int length = 1;
    while (tail.next != null) {
      tail = tail.next;
      length++;
    }
    tail.next = head;
    int step = length - k % length;
    for (int i = 0; i < step; i++) {
      tail = tail.next;
    }
    ListNode newHead = tail.next;
    tail.next = null;
    return newHead;
  }

  public static void test_00061() {
    Solution00061 solution = new Solution00061();
    ListNode list = ListNode.create(new Integer[]{1, 2, 3, 4, 5});
    list.print();
    System.out.println("==================================");
    ListNode result = solution.rotateRight(list, 2);
    result.print();

  }

  public static void main(String[] args) {
    Solution00061.test_00061();
  }
}

