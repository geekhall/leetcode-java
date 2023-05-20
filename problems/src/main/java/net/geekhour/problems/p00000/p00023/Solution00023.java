package net.geekhour.problems.p00000.p00023;

import java.util.ArrayList;
import java.util.List;

import net.geekhour.utils.ListNode;

/**
 * ID: 00023
 * Title: Merge k Sorted Lists
 * Difficulty: Hard
 * Description: You are given an array of k linked-lists lists, each linked-list
 * is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * Example 1:
 *
 * Input: lists = [[1,4,5],[1,3,4],[2,6]] Output: [1,1,2,3,4,4,5,6] Explanation:
 * The linked-lists are: [ 1->4->5, 1->3->4, 2->6 ] merging them into one sorted
 * list: 1->1->2->3->4->4->5->6
 *
 * Example 2:
 *
 * Input: lists = [] Output: []
 *
 * Example 3:
 *
 * Input: lists = [[]] Output: []
 *
 * Constraints:
 *
 * k == lists.length
 * 0 <= k <= 10 4
 * 0 <= lists[i].length <= 500
 * -10 4 <= lists[i][j] <= 10 4
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length will not exceed 10 4.
 */
class Solution00023 {

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }
    return merge(lists, 0, lists.length - 1);
  }

  private ListNode merge(ListNode[] lists, int i, int j) {
    if (i == j) {
      return lists[i];
    }
    if (i > j) {
      return null;
    }
    int mid = (i + j) / 2;
    ListNode l1 = merge(lists, i, mid);
    ListNode l2 = merge(lists, mid + 1, j);
    return mergeTwoLists(l1, l2);
  }

  private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        cur.next = l1;
        l1 = l1.next;
      } else {
        cur.next = l2;
        l2 = l2.next;
      }
      cur = cur.next;
    }
    cur.next = l1 == null ? l2 : l1;
    return dummy.next;
  }

  public static void test_00023() {
    Solution00023 solution = new Solution00023();
    ListNode[] lists = new ListNode[3];
    lists[0] = ListNode.create(new Integer[] { 1, 4, 5 });
    lists[1] = ListNode.create(new Integer[] { 1, 3, 4 });
    lists[2] = ListNode.create(new Integer[] { 2, 6 });
    for (ListNode list : lists) {
      list.print();
    }
    ListNode result = solution.mergeKLists(lists);
    result.print();

  }

  public static void main(String[] args) {
    Solution00023.test_00023();
  }
}
