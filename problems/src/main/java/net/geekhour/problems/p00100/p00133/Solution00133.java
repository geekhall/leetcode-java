package net.geekhour.problems.p00100.p00133;

import java.util.*;

/**
 * ID: 00133
 * Title: Clone Graph
 * Difficulty: Medium
 * Description: Given a reference of a node in a connected undirected graph.
 *
 * Return a deep copy (clone) of the graph.
 *
 * Each node in the graph contains a value (int) and a list (List[Node]) of its
 * neighbors.
 *
 * class Node { public int val; public List<Node> neighbors; }
 *
 * Test case format:
 *
 * For simplicity, each node's value is the same as the node's index
 * (1-indexed). For example, the first node with val == 1, the second node with
 * val == 2, and so on. The graph is represented in the test case using an
 * adjacency list.
 *
 * An adjacency list is a collection of unordered lists used to represent a
 * finite graph. Each list describes the set of neighbors of a node in the
 * graph.
 *
 * The given node will always be the first node with val = 1. You must return
 * the copy of the given node as a reference to the cloned graph.
 *
 * Example 1:
 *
 * Input: adjList = [[2,4],[1,3],[2,4],[1,3]] Output: [[2,4],[1,3],[2,4],[1,3]]
 * Explanation: There are 4 nodes in the graph. 1st node (val = 1)'s neighbors
 * are 2nd node (val = 2) and 4th node (val = 4). 2nd node (val = 2)'s neighbors
 * are 1st node (val = 1) and 3rd node (val = 3). 3rd node (val = 3)'s neighbors
 * are 2nd node (val = 2) and 4th node (val = 4). 4th node (val = 4)'s neighbors
 * are 1st node (val = 1) and 3rd node (val = 3).
 *
 * Example 2:
 *
 * Input: adjList = [[]] Output: [[]] Explanation: Note that the input contains
 * one empty list. The graph consists of only one node with val = 1 and it does
 * not have any neighbors.
 *
 * Example 3:
 *
 * Input: adjList = [] Output: [] Explanation: This an empty graph, it does not
 * have any nodes.
 *
 * Constraints:
 *
 * The number of nodes in the graph is in the range [0, 100].
 * 1 <= Node.val <= 100
 * Node.val is unique for each node.
 * There are no repeated edges and no self-loops in the graph.
 * The Graph is connected and all nodes can be visited starting from the given
 * node.
 */
class Node {
  public int val;
  public List<Node> neighbors;

  public Node() {
    val = 0;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val) {
    val = _val;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val, ArrayList<Node> _neighbors) {
    val = _val;
    neighbors = _neighbors;
  }
}

class Solution00133 {

  public Node cloneGraph(Node node) {
    if (node == null) {
      return node;
    }

    Map<Node, Node> visited = new HashMap<>();

    // 将题目给定的节点添加到队列
    LinkedList<Node> queue = new LinkedList<Node>();
    queue.add(node);
    // 克隆第一个节点并存储到哈希表中
    visited.put(node, new Node(node.val, new ArrayList<>()));

    // 广度优先搜索
    while (!queue.isEmpty()) {
      // 取出队列的头节点
      Node n = queue.remove();
      // 遍历该节点的邻居
      for (Node neighbor : n.neighbors) {
        if (!visited.containsKey(neighbor)) {
          // 如果没有被访问过，就克隆并存储在哈希表中
          visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
          // 将邻居节点加入队列中
          queue.add(neighbor);
        }
        // 更新当前节点的邻居列表
        visited.get(n).neighbors.add(visited.get(neighbor));
      }
    }

    return visited.get(node);
  }

  public static void test_00133() {
    Solution00133 solution = new Solution00133();
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);
    node1.neighbors.add(node2);
    node1.neighbors.add(node4);
    node2.neighbors.add(node1);
    node2.neighbors.add(node3);
    node3.neighbors.add(node2);
    node3.neighbors.add(node4);
    node4.neighbors.add(node1);
    node4.neighbors.add(node3);
    Node node = solution.cloneGraph(node1);
    System.out.println(node);
  }

  public static void main(String[] args) {
    Solution00133.test_00133();
  }
}
