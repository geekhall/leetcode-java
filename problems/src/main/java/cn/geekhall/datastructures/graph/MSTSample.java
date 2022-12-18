package cn.geekhall.datastructures.graph;

import java.util.*;

/**
 * 最小生成树算法
 * 主要是Kruskal和Prim算法
 *
 */
public class MSTSample {
    public static class UnionFind {

        private HashMap<Node, Node> fatherMap;
        private HashMap<Node, Integer> sizeMap;

        public UnionFind(){
            fatherMap = new HashMap<Node, Node>();
            sizeMap = new HashMap<Node, Integer>();
        }

        public void makeSets(Collection<Node> nodes) {
            fatherMap.clear();
            sizeMap.clear();
            for( Node node: nodes) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        private Node findFather(Node node) {
            Stack<Node> path = new Stack<>();
            while (node != fatherMap.get(node)) {
                path.add(node);
                node = fatherMap.get(node);
            }
            while (!path.isEmpty()) {
                fatherMap.put(path.pop(), node);
            }
            return node;
        }

        public boolean isSameSet(Node a, Node b) {
            return findFather(a) == findFather(b);
        }

        public void union(Node a, Node b) {
            if (a == null || b == null) return;
            Node headA = findFather(a);
            Node headB = findFather(b);
            if (headA != headB) {
                int setSizeA = sizeMap.get(headA);
                int setSizeB = sizeMap.get(headB);
                if (setSizeA <= setSizeB) {
                    fatherMap.put(headA, headB);
                    sizeMap.put(headA, setSizeA + setSizeB);
                    sizeMap.remove(headB);
                }
            }
        }
    }

    public static class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    /**
     * Kruskal最小生成树算法。
     * @param graph 无环有向图
     * @return 最小生成树
     */
    public static Set<Edge> kruskalMST(Graph graph) {
        UnionFind unionFind = new UnionFind();
        unionFind.makeSets(graph.nodes.values());

        // 把所有的边加入到小根堆中。按照权重从小到大的顺序。
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        priorityQueue.addAll(graph.edges);

        Set<Edge> result = new HashSet<>();
        while (!priorityQueue.isEmpty()) { // 遍历所有边
            Edge edge = priorityQueue.poll(); // 弹出一条边
            if (!unionFind.isSameSet(edge.from, edge.to)){ // 若边的两端不在同一个集合中
                result.add(edge);   // 将这条边加入到结果集中。
                unionFind.union(edge.from, edge.to);     // 合并
            }
        }
        return result;
    }

    public static Set<Edge> primMST(Graph graph) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());

        // 哪些点被解锁出来了。
        HashSet<Node> nodeSet = new HashSet<>();
        HashSet<Edge> edgeSet = new HashSet<>();

        Set<Edge> result = new HashSet<>(); // 依次挑选的边在result中

        for (Node node : graph.nodes.values()) { // 随便挑了一个点（当给定题目为森林时使用本行的for循环，否则不需要）
            if(!nodeSet.contains(node)) {
                nodeSet.add(node);
                for (Edge edge : node.edges) { // 由一个点解锁所有相连的边。
                    if (!edgeSet.contains(edge)) {
                        edgeSet.add(edge);
                        priorityQueue.add(edge);
                    }
                }
                while (!priorityQueue.isEmpty()) {
                    Edge edge = priorityQueue.poll();   // 弹出解锁的边中，最小的彼岸
                    Node toNode = edge.to;              // 可能的一个新的点
                    if (!nodeSet.contains(toNode)) {        // set中不包含，表示是新的点
                        nodeSet.add(toNode);
                        result.add(edge);
                        priorityQueue.addAll(toNode.edges);
                    }
                }
            }
            break;
        }
        return result;
    }
}
