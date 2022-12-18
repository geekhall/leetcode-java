package cn.geekhall.datastructures.binarytree;

/**
 * TestBST.java
 *
 * @author yiny
 */
public class TestBST {
    public static class Info {
        public boolean isBST;
        public int max;
        public int min;
        public Info(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }

    public static void pre(Node head){
        if (head == null) {
            return;
        }
        System.out.println(head.value + " ");
        pre(head.left);
        pre(head.right);
    }

    public static void in(Node head) {
        if (head == null) {
            return;
        }
        pre(head.left);
        System.out.println(head.value + " ");
        pre(head.right);
    }

    public static void pos(Node head) {
        if (head == null) {
            return;
        }
        pre(head.left);
        pre(head.right);
        System.out.println(head.value + " ");
    }
    public static Info process(Node node) {
        if (node == null) {
            return new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        return null;
    }


}
