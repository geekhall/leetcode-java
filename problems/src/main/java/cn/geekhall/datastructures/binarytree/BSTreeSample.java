package cn.geekhall.datastructures.binarytree;

/**
 *
 */
public class BSTreeSample {

    public static class Info{
        public boolean isBalanced;
        public int height;
        public Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static Info process(Node node) {
        if (node == null) {
            return new Info(true, 0);
        }
        Info left = process(node.left);
        Info right = process(node.right);

        int height = Math.max(left.height, right.height) + 1;
        boolean isBalanced = true;
        if ( !left.isBalanced || !right.isBalanced || Math.abs(left.height - right.height)>1) {
            isBalanced = false;
        }
        return new Info(isBalanced, height);
    }

    public static boolean isBalanced(Node head) {
        return process(head).isBalanced;
    }

    public static Node generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    public static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node head = new Node((int)(Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }
}
