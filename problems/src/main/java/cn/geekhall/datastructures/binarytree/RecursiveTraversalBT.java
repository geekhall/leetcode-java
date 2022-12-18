package cn.geekhall.datastructures.binarytree;

/**
 * 递归序：先序中序后序都可以在递归序的基础上加工出来。
 *        第一次到打一个节点就打印就是先序，第二次打印就是中序，第三次再打印就是后序。
 *
 * 二叉树的先序中序后序遍历：
 * 先序：任何子树的处理顺序都是：头结点 => 左子树 => 右子树
 * 中序：任何子树的处理顺序都是：左子树 => 头结点 => 右子树
 * 后序：任何子树的处理顺序都是：左子树 => 右子树 => 头结点
 *
 * 任何递归函数都可以改成非递归，自己设计压栈来实现。
 */
public class RecursiveTraversalBT {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    public static void f(Node head) {
        if (head == null){
            return;
        }
        // 1
        f(head.left);
        // 2
        f(head.right);
        // 3
    }

    /**
     * 先序遍历
     * @param head
     */
    public static void pre(Node head) {
        if (head == null)
            return;

        System.out.println(head.value);
        pre(head.left);
        pre(head.right);
    }

    /**
     * 中序遍历
     * @param head
     */
    public static void in(Node head) {
        if (head == null)
            return;
        in(head.left);
        System.out.println(head.value);
        in(head.right);
    }

    /**
     * 后序遍历
     * @param head
     */
    public static void pos(Node head) {
        if (head == null)
            return;
        pos(head.left);
        pos(head.right);
        System.out.println(head.value);
    }

}
