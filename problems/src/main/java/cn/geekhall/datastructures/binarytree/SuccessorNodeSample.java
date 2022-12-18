package cn.geekhall.datastructures.binarytree;

/**
 * SuccessorNodeSample.java
 *
 * @author yiny
 */
public class SuccessorNodeSample {
    public static class NodeWithParentPointer{
        public int value;
        public NodeWithParentPointer left;
        public NodeWithParentPointer right;
        public NodeWithParentPointer parent;
        public NodeWithParentPointer(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "NodeWithParentPointer{" +
                    "value=" + value +
                    '}';
        }
    }

    public static NodeWithParentPointer getSuccessorNode(NodeWithParentPointer node) {
        if (node == null) {
            return node;
        }

        if (node.right != null) {
            return getLeftMost(node.right);
        } else { // 无右子树
            NodeWithParentPointer parent = node.parent;
            while (parent != null && parent.left != node) { // 当前节点是其父节点的右孩子。
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static NodeWithParentPointer getLeftMost(NodeWithParentPointer node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        NodeWithParentPointer n1 = new NodeWithParentPointer(1);
        NodeWithParentPointer n2 = new NodeWithParentPointer(2);
        NodeWithParentPointer n3 = new NodeWithParentPointer(3);
        NodeWithParentPointer n4 = new NodeWithParentPointer(4);
        NodeWithParentPointer n5 = new NodeWithParentPointer(5);
        NodeWithParentPointer n6 = new NodeWithParentPointer(6);
        NodeWithParentPointer n7 = new NodeWithParentPointer(7);

        n1.left = n2;
        n1.right = n3;
        n1.parent = null;

        n2.left = n4;
        n2.right = n5;
        n2.parent = n1;
        n3.left = n6;
        n3.right = n7;
        n3.parent = n1;

        n4.parent = n2;
        n5.parent = n2;
        n6.parent = n3;
        n7.parent = n3;
        System.out.println("====================");
        System.out.println(getSuccessorNode(n2));
        System.out.println("====================");
        System.out.println(getSuccessorNode(n5));
        System.out.println("====================");

    }
}
