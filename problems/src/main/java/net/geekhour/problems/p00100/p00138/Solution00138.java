package net.geekhour.problems.p00100.p00138;

/**
 * ID: 00138
 * Title: Copy List with Random Pointer
 * Difficulty: Medium
 * Description: A linked list of length n is given such that each node contains
 * an additional random pointer, which could point to any node in the list, or
 * null.
 *
 * Construct a deep copy of the list. The deep copy should consist of exactly n
 * brand new nodes, where each new node has its value set to the value of its
 * corresponding original node. Both the next and random pointer of the new
 * nodes should point to new nodes in the copied list such that the pointers in
 * the original list and copied list represent the same list state. None of the
 * pointers in the new list should point to nodes in the original list.
 *
 * For example, if there are two nodes X and Y in the original list, where
 * X.random --> Y, then for the corresponding two nodes x and y in the copied
 * list, x.random --> y.
 *
 * Return the head of the copied linked list.
 *
 * The linked list is represented in the input/output as a list of n nodes. Each
 * node is represented as a pair of [val, random_index] where:
 *
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) that the random
 * pointer points to, or null if it does not point to any node.
 *
 * Your code will only be given the head of the original linked list.
 *
 * Example 1:
 *
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]] Output:
 * [[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * Example 2:
 *
 * Input: head = [[1,1],[2,1]] Output: [[1,1],[2,1]]
 *
 * Example 3:
 *
 * Input: head = [[3,null],[3,0],[3,null]] Output: [[3,null],[3,0],[3,null]]
 *
 * Constraints:
 *
 * 0 <= n <= 1000
 * -10 4 <= Node.val <= 10 4
 * Node.random is null or is pointing to some node in the linked list.
 */
class Solution00138 {

  public Node copyRandomList(Node head) {
    if (head == null) {
      return null;
    }
    Node cur = head;
    while (cur != null) {
      Node node = new Node(cur.val);
      node.next = cur.next;
      cur.next = node;
      cur = node.next;
    }
    cur = head;
    while (cur != null) {
      cur.next.random = cur.random != null ? cur.random.next : null;
      cur = cur.next.next;
    }
    cur = head.next;
    Node pre = head, res = head.next;
    while (cur.next != null) {
      pre.next = pre.next.next;
      cur.next = cur.next.next;
      pre = pre.next;
      cur = cur.next;
    }
    pre.next = null;
    return res;
  }

  public static void test_00138() {
    Solution00138 solution = new Solution00138();
    Node head = new Node(7);
    Node node1 = new Node(13);
    Node node2 = new Node(11);
    Node node3 = new Node(10);
    Node node4 = new Node(1);
    head.next = node1;
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node1.random = head;
    node2.random = node4;
    node3.random = node2;
    node4.random = head;
    Node res = solution.copyRandomList(head);
    Node.print(res);
  }

  public static void main(String[] args) {
    Solution00138.test_00138();
  }
}
