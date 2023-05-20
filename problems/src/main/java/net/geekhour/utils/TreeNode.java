package net.geekhour.utils;

import java.util.*;

/**
 * TreeNode
 *
 * @author yiny
 * @date 2022/12/18 10:17
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void print() {
        System.out.println("this.val = " + this.val);
        if (left != null) {
            System.out.print("left: ");
            left.print();
        }
        if (right != null) {
            System.out.print("right: ");
            right.print();
        }
    }

    /**
     * 通过数组构建二叉树
     *
     * @param arr 数组
     * @return 二叉树
     */
    public static TreeNode create(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        Queue<Integer> numberQueue = new LinkedList<>(Arrays.asList(arr));
        TreeNode root = new TreeNode(numberQueue.poll());
        treeNodeQueue.add(root);
        while (numberQueue.size() > 0) {
            Integer leftValue = numberQueue.poll();
            Integer rightValue = numberQueue.poll();
            TreeNode currentNode = treeNodeQueue.poll();
            if (leftValue != null) {
                TreeNode leftNode = new TreeNode(leftValue, null, null);
                assert currentNode != null;
                currentNode.left = leftNode;
                treeNodeQueue.add(leftNode);
            }
            if (rightValue != null) {
                TreeNode rightNode = new TreeNode(rightValue, null, null);
                assert currentNode != null;
                currentNode.right = rightNode;
                treeNodeQueue.add(rightNode);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode tree1 = TreeNode.create(new Integer[] { 3, 9, 20, null, null, 15, 7 });
        tree1.print();
    }

}
