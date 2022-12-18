package cn.geekhall.datastructures.linkedlist;

public class Problems {

    // 常见面试题
    // 给定两个可能又换也可能五环的单链表，头结点head1和head2
    // 请实现一个函数，如果两个链表香蕉，请返回相交的第一个节点，如果不相交，返回null。
    // 要求，时间复杂度O(N)，额外空间复杂度O(1)，其中，N为两个链表长度之和。

    public static class Node {
        public int value;
        public Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 找到链表第一个入环节点， 如果无环，返回null。
     * @param head
     * @return
     */
    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        Node slow = head.next;
        Node fast = head.next.next;
        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head; // fast pointer walk again from head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * 如果两个链表都无环，返回第一个相交的节点，如果不想交，返回null。
     * @param head1
     * @param head2
     * @return
     */
    public static Node noLoop(Node head1, Node head2) {
        if(head1 == null || head2 == null) {
            return null;
        }

        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) {
            return null;
        }

        // n : 链表1的长度减去链表2的长度的值
        cur1 = n > 0 ? head1: head2;            // 谁长，谁的头变成cur1
        cur2 = cur1 == head1 ? head2 : head1;   // 谁短，谁的头变成cur2
        n = Math.abs(n);
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    /**
     * 两个有环链表，返回第一个相交的节点，如果不相交返回null。
     * @param head1
     * @param loop1
     * @param head2
     * @param loop2
     * @return
     */
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0){
                n--;
                cur1 =cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }
}
