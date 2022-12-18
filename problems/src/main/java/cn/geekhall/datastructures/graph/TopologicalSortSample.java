package cn.geekhall.datastructures.graph;

import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * 拓扑排序
 */
public class TopologicalSortSample {

    /**
     * 拓扑排序
     * @param graph 拓扑排序有向无环图
     * @return 排序结果
     */
    public List<Node> topologicalSort(Graph graph) {

        // 图中的点和其入度的映射
        HashMap<Node, Integer> inMap = new HashMap<>();

        // 入度为0的点的队列
        Queue<Node> zeroInQueue = new LinkedList<>();

        for (Node node : graph.nodes.values()) { // 遍历图中的所有节点
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }

        // 拓扑排序的结果依次加入result
        List<Node> result = new ArrayList<>();
        while(!zeroInQueue.isEmpty()){
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }


}
