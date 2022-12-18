package cn.geekhall.datastructures.linkedlist;

import java.util.ArrayList;
import java.util.Stack;

public class LinkedListSample {
    public static class Node {
        public int value;
        public Node next;
        public Node(int v) {
            this.value = v;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    /**
     * 快慢指针获取链表中点。
     * @param head  链表头结点
     * @return 链表元素个数为奇数个时返回中点元素；链表元素个数为偶数个时返回上中点。
     */
    public static Node getMidNode1(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        // 链表有三个点或以上元素
        Node slow = head.next;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 快慢指针获取链表中点。
     * @param head  链表头结点
     * @return 链表元素个数为奇数个时返回中点元素；链表元素个数为偶数个时返回下中点。
     */
    public static Node getMidNode2(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head.next;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 快慢指针获取链表中点。
     * @param head  链表头结点
     * @return 链表元素个数为奇数个时返回中点的前一个元素；链表元素个数为偶数个时返回上中点的前一个元素。
     */
    public static Node getMidNode3(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node slow = head;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 快慢指针获取链表中点。
     * @param head  链表头结点
     * @return 链表元素个数为奇数个时返回中点的前一个元素；链表元素个数为偶数个时返回下中点的前一个元素。
     */
    public static Node getMidNode4(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        if (head.next.next == null) {
            return head;
        }

        Node slow = head;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 快慢指针获取链表中点。
     * @param node  链表头结点
     * @return 链表元素个数为奇数个时返回中点元素；链表元素个数为偶数个时返回上中点。
     */
    public static Node right1(Node node) {
        if (node == null) {
            return null;
        }
        Node cur = node;
        ArrayList<Node> arr = new ArrayList<>();
        while (cur != null) {
            arr.add(cur);
            cur = cur.next;
        }

        return arr.get((arr.size() - 1) / 2);
    }
    public static Node right2(Node node) {
        if (node == null) {
            return null;
        }
        Node cur = node;
        ArrayList<Node> arr = new ArrayList<>();
        while (cur != null) {
            arr.add(cur);
            cur = cur.next;
        }

        return arr.get(arr.size() / 2);
    }

    public static Node right3(Node node) {
        if (node == null || node.next == null || node.next.next == null) {
            return null;
        }
        Node cur = node;
        ArrayList<Node> arr = new ArrayList<>();
        while (cur != null) {
            arr.add(cur);
            cur = cur.next;
        }

        return arr.get((arr.size() - 1) / 2 - 1);
    }
    public static Node right4(Node node) {
        if (node == null || node.next == null || node.next.next == null) {
            return null;
        }
        Node cur = node;
        ArrayList<Node> arr = new ArrayList<>();
        while (cur != null) {
            arr.add(cur);
            cur = cur.next;
        }

        return arr.get(arr.size() / 2 - 1);
    }

    /**
     * 判断链表中的元素是否是回文。
     * @param head
     * @return
     */
    public static boolean isPalindrome(Node head){
        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node right = head.next;
        Node cur = head;
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> stack = new Stack<Node>();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }
        while(!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * O(1) extra space.
     * 倒置中点右侧的链表。
     * @param head
     * @return
     */
    public static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;       // n1 -> mid
            n2 = n2.next.next;  // n2 -> end
        }
        n2 = n1.next;   // n2 -> right part first node
        n1.next = null; // mid.next -> null
        Node n3 = null;
        while (n2 != null) {    // right part convert
            n3 = n2.next;       // n3 -> save next node
            n2.next = n1;       // next of right node convert
            n1 = n2;            // n1 move
            n2 = n3;            // n2 move
        }
        n3 = n1;                // n3 => save last node
        n2 = head;              // n2 => left first node
        boolean res = true;
        while (n1 != null && n2 != null) {
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            n1 = n1.next;   // left to mid
            n2 = n2.next;   // right to mid
        }
        n1 = n3.next;
        n3.next = null;
        while ( n1 != null) { // recover list.
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }

    public static Node listPartition1(Node head, int pivot) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }

        Node[] nodeArr = new Node[i];
        i = 0;
        cur = head;
        for (i = 0; i != nodeArr.length; i++){
            nodeArr[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodeArr, pivot);
        for (i = 1; i != nodeArr.length; i++) {
            nodeArr[i - 1].next = nodeArr[i];
        }
        nodeArr[i - 1].next = null;
        return nodeArr[0];
    }

    public static void arrPartition(Node[] nodeArr, int pivot) {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index != big) {
            if (nodeArr[index].value < pivot) {
                swap(nodeArr, ++small, index++);
            } else if (nodeArr[index].value == pivot) {
                index++;
            } else {
                swap(nodeArr, --big, index);
            }
        }
    }

    /**
     * 交换数组arr的i和j位置的值。
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(Node[] arr, int i, int j) {
        Node temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static Node listPartition2(Node head, int pivot) {
        Node sH = null; // small head
        Node sT = null; // small tail
        Node eH = null; // equal head
        Node eT = null; // equal tail
        Node mH = null; // big head
        Node mT = null; // big tail
        Node next = null; // save next node

        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.value == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (mH == null) {
                    mH = head;
                    mT = head;
                } else {
                    mT.next = head;
                    mT = head;
                }
            }
            head = next;
        }
        // small and equal reconnect.
        if (sT != null) { // 如果有小于区域
            sT.next = eH;
            eT = eT == null ? sT : eT;  // 下一步，谁去连大于区域的头，谁就变成eT
        }
        // 上面的if，不管跑了没有，et
        // all reconnect
        if (eT != null) { //如果小于区域和等于区域，不是都没有
            eT.next = mH;
        }
        return sH != null ? sH : (eH != null ? eH : mH);
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        System.out.println(getMidNode1(n1));
        System.out.println(right1(n1));
        System.out.println(getMidNode2(n1));
        System.out.println(right2(n1));
        System.out.println(getMidNode3(n1));
        System.out.println(right3(n1));
        System.out.println(getMidNode4(n1));
        System.out.println(right4(n1));
    }
}
