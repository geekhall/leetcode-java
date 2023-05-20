package net.geekhour.problems.p00400.p00429;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ID: 00429
 * Title: N-ary Tree Level Order Traversal
 * Difficulty: Medium
 * Description: Given an n-ary tree, return the level order traversal of its
 * nodes' values.
 *
 * Nary-Tree input serialization is represented in their level order traversal,
 * each group of children is separated by the null value (See examples).
 *
 * Example 1:
 *
 * Input: root = [1,null,3,2,4,null,5,6] Output: [[1],[3,2,4],[5,6]]
 *
 * Example 2:
 *
 * Input: root =
 * [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 *
 * Constraints:
 *
 * The height of the n-ary tree is less than or equal to 1000
 * The total number of nodes is between [0, 10 4 ]
 */
class Solution00429 {

  public List<List<Integer>> levelOrder(Node root) {
    // level order traversal
    List<List<Integer>> result = new ArrayList<>();
    Queue<Node> queue = new LinkedList<>();
    if (root != null) {
      queue.add(root);
    }
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> level = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        Node node = queue.poll();
        level.add(node.val);
        queue.addAll(node.children);
      }
      result.add(level);
    }
    return result;
  }

  public static void test_00429() {
    System.out.println("test_00429");
    Solution00429 solution = new Solution00429();
    Node root = new Node(1, new ArrayList<>());
    Node node3 = new Node(3, new ArrayList<>());
    Node node2 = new Node(2, new ArrayList<>());
    Node node4 = new Node(4, new ArrayList<>());
    Node node5 = new Node(5, new ArrayList<>());
    Node node6 = new Node(6, new ArrayList<>());
    root.children.add(node3);
    root.children.add(node2);
    root.children.add(node4);
    node3.children.add(node5);
    node3.children.add(node6);
    List<List<Integer>> result = solution.levelOrder(root);
    System.out.println(result);
  }

  public static void main(String[] args) {
    Solution00429.test_00429();
  }
}
