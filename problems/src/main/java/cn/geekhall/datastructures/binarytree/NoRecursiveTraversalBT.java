package cn.geekhall.datastructures.binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 */
public class NoRecursiveTraversalBT {

    /**
     * 非递归先序遍历二叉树
     * 1）弹出时打印
     * 2）如果有右孩子，压入右孩子
     * 3）如果有左孩子，压入左孩子
     * @param head
     */
    public static void pre(Node head) {
        System.out.print("pre-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.add(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                System.out.print(head.value + " ");
                if (head.right!=null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    /**
     * 非递归后序遍历二叉树
     * @param head
     */
    public static void pos(Node head){
        System.out.print("pos-order: ");
        if (head != null) {
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()) {
                System.out.print(s2.pop().value + " ");
            }
        }
        System.out.println();
    }

    /**
     * 非递归中序遍历二叉树。
     * @param head
     */
    public static void in(Node head) {
        System.out.print("in-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    /**
     * 非递归后续遍历二叉树（只使用一个stack）。
     * @param head
     */
    public static void pos1(Node head) {
        System.out.print("pos-order: ");
        Node lastPrint = head;
        if (lastPrint != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(lastPrint);
            Node c; // 当前节点
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null && lastPrint != c.left && lastPrint != c.right) { // 左子树没处理完
                    stack.push(c.left);
                } else if (c.right!= null && lastPrint != c.right) { // 右子树没处理完
                    stack.push(c.right);
                } else {
                    System.out.print( stack.pop().value + " "); // 弹出并打印
                    lastPrint = c;
                }
            }
        }
        System.out.println();
    }

    /**
     * 二叉树的广度优先遍历。
     * @param head
     */
    public static void bfs(Node head) {
        System.out.print("bfs: ");
        if (head == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();  // 移除并返回队列的头部元素。
            System.out.print(cur.value + " ");
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        System.out.println("");
    }

    /**
     * 获取二叉树的最大宽度。使用map的方式。
     * @param head
     */
    public static int getMaxWidth(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        HashMap<Node, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);
        int curLevel = 1; // 当前层
        int curLevelNodes = 0; // 当前层的宽度（节点数）
        int max = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int  curNodeLevel = levelMap.get(cur);
            if (cur.left != null) {
                levelMap.put(cur.left, curNodeLevel + 1);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                levelMap.put(cur.right, curNodeLevel + 1);
                queue.add(cur.right);
            }
            if (curNodeLevel == curLevel) {
                curLevelNodes++;
            } else {
                max = Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }
        }
        max = Math.max(max, curLevelNodes);
        return max;
    }

    /**
     * 获取二叉树的最大宽度。不使用map的方式。
     * @param head
     * @return
     */
    public static int getMaxWidth1(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node curEnd = head;     // 当前层最右侧节点
        Node nextEnd = null;    // 下一层最右侧节点
        int max = 0;
        int curLevelNodes = 0;  // 当前层的节点数
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextEnd = cur.right;
            }
            curLevelNodes++;
            if (cur == curEnd) { // 当前层是否处理完了
                max = Math.max(max, curLevelNodes);
                curLevelNodes = 0;
                curEnd = nextEnd;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Node n1 = TreeUtils.generateBasicTree();
        pre(n1);
        System.out.println("=========");
        pos(n1);
        System.out.println("=========");
        pos1(n1);
        System.out.println("=========");
        in(n1);
        System.out.println("=========");
        bfs(n1);
        System.out.println("=========");
        System.out.println(getMaxWidth(n1));
        System.out.println("=========");
        System.out.println(getMaxWidth1(n1));
    }
}
