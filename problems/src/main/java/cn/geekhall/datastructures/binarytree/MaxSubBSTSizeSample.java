package cn.geekhall.datastructures.binarytree;

import java.util.ArrayList;

/**
 * 给定一棵二叉树的头结点head。
 * 返回这棵二叉树中最大的二叉搜索子树的头结点。
 */
public class MaxSubBSTSizeSample {
    public static int getBSTSize(Node head) {
        if (head == null) {
            return 0;
        }
        ArrayList<Node> arr = new ArrayList<>();
        in(head, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).value <= arr.get(i - 1).value) {
                return 0;
            }
        }
        return arr.size();
    }

    public static void in(Node head, ArrayList<Node> arr) {
        if (head == null) {
            return;
        }
        in(head.left, arr);
        arr.add(head);
        in(head.right, arr);
    }

    public static int maxSubBSTSize2(Node head) {
        if (head == null) {
            return 0;
        }
        return process(head).maxSubBSTSize;
    }

    public static class Info{
        public boolean isBST;
        public int maxSubBSTSize;
        public int min;
        public int max;
        public Info(boolean isBST, int maxSubBSTSize, int min, int max){
            this.isBST = isBST;
            this.maxSubBSTSize = maxSubBSTSize;
            this.min = min;
            this.max = max;
        }
    }

    public static Info process(Node head) {
        if (head == null) {
            return null;
        }
        Info left = process(head.left);
        Info right = process(head.right);
        int min = head.value;
        int max = head.value;
        int maxSubBSTSize = 0;
        if (left != null) {
            min = Math.min(min, left.min);
            max = Math.max(max, left.max);
            maxSubBSTSize = Math.max(maxSubBSTSize, left.maxSubBSTSize);
        }
        if (right != null) {
            min = Math.min(min, right.min);
            max = Math.max(max, right.max);
            maxSubBSTSize = Math.max(maxSubBSTSize, right.maxSubBSTSize);
        }
        boolean isBST = false;
        if (
                (left == null ? true : (left.isBST && left.max < head.value)) &&
                        (right == null ? true : (right.isBST && right.min > head.value))
//                (left == null ? true : left.isBST)
//                && (right == null ? true : right.isBST)
//                && (left == null ? true : left.max < head.value)
//                && (right == null ? true : right.min > head.value)
        ) {

            isBST = true;
            maxSubBSTSize = (left == null ? 0 : left.maxSubBSTSize) + (right == null ? 0 : right.maxSubBSTSize) + 1;
        }
        return new Info(isBST, maxSubBSTSize, min, max);
    }
}
