package cn.geekhall.datastructures.graph;

/**
 * Edge.java
 * 边
 *
 * @author yiny
 */
public class Edge {

    // 权重
    public int weight;

    public Node from;

    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }

}
