package cn.geekhall.datastructures.linkedlist;

import java.util.HashMap;

/**
 * 深拷贝一个带有random指针的链表。
 */
public class CopyListWithRandom {
    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node (int value) {
            this.value = value;
        }
    }

    /**
     * 深拷贝一个带有random指针的链表。(使用map)
     * @param head
     * @return
     */
    public static Node copyListWithRand(Node head) {
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            // cur 老
            // map.get(cur) 新
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    /**
     * 打印链表
     * @param head
     */
    public static void printList(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.value);
            if (cur.rand != null){
                System.out.print(" -> ");
                System.out.print(cur.rand.value);
            }
            System.out.print(", ");
            cur = cur.next;
        }
        System.out.println("");
    }

    /**
     * 深拷贝一个带有random指针的链表。（不使用map方式）
     * 1 -> 1' -> 2 -> 2' -> 3 -> 3' ...
     * @param head
     * @return
     */
    public static Node copyListWithRand2(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next = null;

        // 复制节点并且插入链接到每一个节点后。
        // 1 -> 2
        // 1 -> 1' -> 2
        while (cur != null) {
            // cur 老
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node curCopy = null;

        // 1 -> 1' -> 2 -> 2'
        while (cur != null) {
            // cur : 老节点
            // cur.next : 拷贝出来的新节点
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }

        Node res = head.next;
        cur = head;
        // split
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        n1.rand = n3;
        n2.rand = n4;
        n5.rand = n1;

        Node newHead = copyListWithRand(n1);
        Node newHead2 = copyListWithRand2(n1);
        printList(n1);
        System.out.println("=======================");
        printList(newHead);
        System.out.println("=======================");
        printList(newHead2);
    }
}
