package cn.geekhall.utils;

/**
 * ListNode
 * @author yiny
 * @date 2022/12/19 20:12
 */
public class ListNode {
    public int val;
    public ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    /**
     * create a ListNode by array.
     */
    public static ListNode create(Integer[] listHead) {
        ListNode head = new ListNode(listHead[0]);
        ListNode current = head;
        for (int i = 1; i < listHead.length; i++) {
            current.next = new ListNode(listHead[i]);
            current = current.next;
        }
        return head;
    }
}

