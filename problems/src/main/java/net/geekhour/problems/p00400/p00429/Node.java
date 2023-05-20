package net.geekhour.problems.p00400.p00429;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Node {
  public int val;
  public List<Node> children;

  public Node() {
  }

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, List<Node> _children) {
    val = _val;
    children = _children;
  }

  public static void createTreeFromList(List<Integer> list) {
    Node root = new Node(list.get(0));
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);
    int i = 1;
    while (!queue.isEmpty()) {
      Node node = queue.poll();
      int size = list.get(i++);
      for (int j = 0; j < size; j++) {
        Node child = new Node(list.get(i++));
        node.children.add(child);
        queue.add(child);
      }
    }
  }

  public void printTree() {
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(this);
    while (!queue.isEmpty()) {
      Node node = queue.poll();
      System.out.print(node.val + " ");
      for (Node child : node.children) {
        queue.add(child);
      }
    }
  }

}
