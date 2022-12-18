package cn.geekhall.datastructures.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Dijkstra算法
 */
public class DijkstraSample {
    /**
     * Dijkstra 算法
     * @param from 源点
     * @return 源点from到其他每个点的最小距离。
     */
    public static HashMap<Node, Integer> dijkstra(Node from) {

        // 存储from点到其余每个点的最小距离
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(from, 0);

        // 已经选择过的点
        HashSet<Node> selectedNodes = new HashSet<>();

        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        while (minNode != null) {
            //  原始点  ->  minNode(跳转点)   最小距离distance
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                if (!distanceMap.containsKey(toNode)) {
                    distanceMap.put(toNode, distance + edge.weight);
                } else {
                    distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance));
                }
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    private static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap, HashSet<Node> touchedNodes) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (!touchedNodes.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }

    /**
     * 使用自定义的小根堆改进后的Dijkstra算法
     * 从head出发，所有head能到达的节点，生成到达每个节点的最小路径记录并返回
     *
     * @param head
     * @param size
     * @return
     */
    public static HashMap<Node, Integer> improvedDijkstra(Node head, int size) {
        NodeHeap nodeHeap = new NodeHeap(size);
        nodeHeap.addorUpdateOrIgnore(head, 0);
        HashMap<Node, Integer> result = new HashMap<>();
        while (!nodeHeap.isEmpty()) {
            NodeRecord record = nodeHeap.pop();
            Node cur = record.node;
            int distance = record.distance;
            for (Edge edge : cur.edges) {
                nodeHeap.addorUpdateOrIgnore(edge.to, edge.weight + distance);
            }
        }
        return result;
    }

    public static class NodeRecord {
        public Node node;
        public int distance;
        public NodeRecord(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
    public static class NodeHeap {
        private Node[] nodes; // 实际的堆结构

        private HashMap<Node, Integer> heapIndexMap;

        private HashMap<Node, Integer> distanceMap;

        private int size;

        public NodeHeap(int size) {
            nodes = new Node[size];
            heapIndexMap = new HashMap<>();
            distanceMap = new HashMap<>();
            size = 0;
        }
        public boolean isEmpty() {
            return size == 0;
        }

        public NodeRecord pop(){
            NodeRecord nodeRecord = new NodeRecord(nodes[0], distanceMap.get(nodes[0]));
            swap(0, size - 1);
            heapIndexMap.put(nodes[size - 1], -1);
            distanceMap.remove(nodes[size - 1]);
            nodes[size - 1] = null;
            heapify(0, --size);
            return nodeRecord;
        }

        private boolean isEntered(Node node) {
            return heapIndexMap.containsKey(node);
        }
        private boolean inHeap(Node node) {
            return isEntered(node) && heapIndexMap.get(node) != -1;
        }

        private void swap(int index1, int index2) {
            heapIndexMap.put(nodes[index1], index2);
            heapIndexMap.put(nodes[index2], index1);
            Node tmp = nodes[index1];
            nodes[index1] = nodes[index2];
            nodes[index2] = tmp;
        }

        public void addorUpdateOrIgnore(Node node, int distance) {
            if (inHeap(node)) {
                distanceMap.put(node, Math.min(distanceMap.get(node), distance));
                insertHeapify(node, heapIndexMap.get(node));
            }
            if (!isEntered(node)) {
                nodes[size] = node;
                heapIndexMap.put(node, size);
                distanceMap.put(node, distance);
                insertHeapify(node, size++);
            }
        }
        private void insertHeapify(Node node, int index) {
            while (distanceMap.get(nodes[index]) < distanceMap.get(nodes[(index - 1) / 2])) {
                swap(index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }
        private void heapify(int index, int size) {
            int left = index * 2 + 1;
            while (left < size) {
                int smallest = left + 1 < size && distanceMap.get(nodes[left + 1]) < distanceMap.get(nodes[left])
                        ? left + 1
                        : left;
                smallest = distanceMap.get(nodes[smallest]) < distanceMap.get(nodes[index]) ? smallest : index;
                if (smallest == index) {
                    break;
                }
                swap(smallest, index);
                index = smallest;
                left = index * 2 + 1;
            }
        }

    }

}
