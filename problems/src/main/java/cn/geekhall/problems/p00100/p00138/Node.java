package cn.geekhall.problems.p00100.p00138;

public class Node {
  int val;
  Node next;
  Node random;

  public Node(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
  }

  public static Node create(Integer[] arr) {
    Node head = new Node(arr[0]);
    Node cur = head;
    for (int i = 1; i < arr.length; i++) {
      cur.next = new Node(arr[i]);
      cur = cur.next;
    }
    return head;
  }

  public static void print(Node head) {
    Node cur = head;
    while (cur != null) {
      System.out.print(cur.val + " ");
      cur = cur.next;
    }
    System.out.println();
  }
}
